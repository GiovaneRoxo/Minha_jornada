package br.com.agencia.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agencia.dao.AdmDAO;
import br.com.agencia.dao.ClienteDAO;
import br.com.agencia.dao.PassagemDAO;
import br.com.agencia.model.Cliente;
import br.com.agencia.model.Passagem;

public class Main {

	public static void main(String[] args){

		Scanner ler = new Scanner(System.in);
		int opc;
		int opcc;
		boolean loop = true;
		boolean sair = true;

		while(loop == true) {
		System.out.println("------------------------");
		System.out.println("---------AGENCIA--------");
		System.out.println("------------------------");
		System.out.println("1 - L O G I N");
		System.out.println("2 - C A D A S T R A R");
		System.out.println("3 - A D M I N I S T R A D O R");
		System.out.println("4 - S A I R");
		opc = ler.nextInt();
		
		switch(opc) {
		  case 1:
					System.out.println("------------------------");
					System.out.println("---------LOGIN----------");
					System.out.println("------------------------");
					System.out.println("Digite o usuario: ");
					String usuario = ler.next();
					System.out.println("Digite a senha: ");
					String senha = ler.next();
					if(ClienteDAO.login(usuario, senha) != false) {
						while(sair == true) {
							System.out.println("------------------------");
							System.out.println("------BEM-VINDO(A)------");
							System.out.println("------------------------");
							System.out.println("1 - Listar passagens disponiveis");
							System.out.println("2 - Listar minhas passagens");
							System.out.println("3 - Comprar passagens");
							System.out.println("4 - Cancelar passagens");
							System.out.println("5 - Deletar conta");
							System.out.println("6 - Alterar dados");
							System.out.println("7 - Sair");
							opcc = ler.nextInt();
							switch(opcc) {
								case 1:
										System.out.println("------------------------");
										System.out.println("-----LISTAR-PASSAGENS---");
										System.out.println("------------------------");
										for(Passagem p : PassagemDAO.listarPassagensById(0)) {
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
											System.out.println("ID DA PASSAGEM: " + p.getPassagemId());
											System.out.println("DATA DA VIAGEM: você decide ");
											System.out.println("ORIGEM: " + p.getOrigem());
											System.out.println("DESTINO: " + p.getDestino());
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
										}
									break;	
								case 2:
										System.out.println("------------------------");
										System.out.println("-----LISTAR-PASSAGENS---");
										System.out.println("------------------------");
										for(Passagem p : PassagemDAO.listarPassagensById(ClienteDAO.getIdByUsuario(usuario))) {
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
											System.out.println("ID DA PASSAGEM: " + p.getPassagemId());
											System.out.println("DATA DA VIAGEM: " + p.getDiaViagem() + "/" + p.getMesViagem() + "/" + p.getAnoViagem());
											System.out.println("DATA DA COMPRA: " + p.getData_compra());
											System.out.println("ORIGEM: " + p.getOrigem());
											System.out.println("DESTINO: " + p.getDestino());
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
										}
									break;
								case 3:
										System.out.println("------------------------");
										System.out.println("-----COMPRAR-PASSAGEM---");
										System.out.println("------------------------");
										System.out.println("volte ao meno e selecione `1` para listar as passagens");
										System.out.println("Digite o ID da passagem desejada: ");
										int idPassagem = ler.nextInt();
										System.out.println("Digite o dia da viagem: ");
										int diaViagem = ler.nextInt();
										System.out.println("Digite o mes da viagem: ");
										int mesViagem = ler.nextInt();
										System.out.println("Digite o ano da viagem: ");
										int anoViagem = ler.nextInt();
										System.out.println("Digite sua senha: ");
										String senhaCompra = ler.next();
										if(ClienteDAO.validaSenha(senhaCompra)){
											Passagem comprada = new Passagem();
											comprada.setDataViagem(diaViagem, mesViagem, anoViagem);
											comprada.setCliente_id(ClienteDAO.getIdByUsuario(usuario));
											comprada.setData_compra(new Date());
											comprada.setStatus_compra("Aguardando pagamento");	
											PassagemDAO.atualizarPassagem(comprada, idPassagem);;
										}else {
											System.out.println("ERRO: Senha incorreta");
										}
									break;
								case 4:
										System.out.println("------------------------");
										System.out.println("-----CANCELAR-PASSAGEM--");
										System.out.println("------------------------");
										System.out.println("Digite o usuario: ");
										String user = ler.next();
										System.out.println("Digite a senha: ");
										String pass = ler.next();
										Boolean test = ClienteDAO.login(user, pass);
										if(test != false) {
											System.out.println("Digite o id da sua passagem que deseja cancelar: ");
											int id_passagem = ler.nextInt();
											PassagemDAO.deletarPassagem(id_passagem, ClienteDAO.getIdByUsuario(user));
										}else{
											System.out.println("Usuario ou senha incorretos!");
										}
									break;
								case 5:
										System.out.println("------------------------");
										System.out.println("---------DADOS----------");
										System.out.println("------------------------");
										System.out.println("Digite a senha: ");
										String senhaTest = ler.next();
										if(ClienteDAO.validaSenha(senhaTest) == true){
											ClienteDAO.deleteByID(ClienteDAO.getIdByUsuario(usuario));
											sair = false;
										}else{
											System.out.println("Senha incorreta");
										}
									break;
								case 6:
										int id_atual = ClienteDAO.getIdByUsuario(usuario);
										System.out.println("------------------------");
										System.out.println("---------DADOS----------");
										System.out.println("------------------------");
										System.out.println("QUAL DADO DESEJA ALTERAR?");
										System.out.println("1 - Nome");
										System.out.println("2 - Sobrenome");
										System.out.println("3 - Idade");
										System.out.println("4 - Usuario");
										System.out.println("5 - Senha");
										System.out.println("6 - Sair");
										opcc = ler.nextInt();
										switch(opcc) {
											case 1:
													System.out.println("Digite sua senha: ");
													String senhaTest2 = ler.next();
													if(ClienteDAO.validaSenha(senhaTest2) == true){
														System.out.println("Digite o novo nome: ");
														String nome = ler.next();
														ClienteDAO.updateNome(nome, id_atual);
													}else{
														System.out.println("Senha incorreta");
													}
												break;
											case 2:
													System.out.println("Digite sua senha: ");
													String senhaTest3 = ler.next();
													if(ClienteDAO.validaSenha(senhaTest3) == true){
														System.out.println("Digite o seu sobrenome do meio (sem espaço): ");
														String nome_meio = ler.next();
														System.out.println("Digite o seu ultimo sobrenome (sem espaço): ");
														String nome_final = ler.next();
														ClienteDAO.updateSobrenome(nome_meio, nome_final, id_atual);
													}
												break;
											case 3:
													System.out.println("Digite sua senha: ");
													String senhaTest4 = ler.next();
													if(ClienteDAO.validaSenha(senhaTest4) == true){
														System.out.println("Digite a sua idade: ");
														int idade = ler.nextInt();
														ClienteDAO.updateIdade(idade, id_atual);
													}else{
														System.out.println("Senha incorreta");
													}
												break;
											case 4:
													System.out.println("Digite sua senha: ");
													String senhaTest5 = ler.next();
													if(ClienteDAO.validaSenha(senhaTest5) == true){
														System.out.println("Digite o novo usuario: ");
														String novo_usuario = ler.next();
														if(ClienteDAO.validaUsuarios(novo_usuario) == false){
															ClienteDAO.updateUsuario(novo_usuario, id_atual);
														}else{
															System.out.println("Usuario indisponivel");
														}	
													}else{
														System.out.println("Senha incorreta");
													}
												break;
											case 5:
													System.out.println("------------------------");
													System.out.println("---------SENHA----------");
													System.out.println("------------------------");
													System.out.println("Digite a antiga senha: ");
													String antiga = ler.next();
													if(ClienteDAO.validaSenha(antiga) == true){
														System.out.println("Digite a nova senha: ");
														String nova = ler.next();
														ClienteDAO.updateSenha(nova, antiga);
													}else{
													System.out.println("Senha incorreta");
													}
												break;
											case 6:
												break;	
											default:
													System.out.println("Opcao invalida");
												break;									
										}
									break;
								case 7:
									  loop = false;
										sair = false;
									break;
								default:
										System.out.println("Opcao invalida");
									break;
							}
						}
					}else{
						System.out.println("Usuario ou senha invalidos");
					}
				break;

		  case 2:
					System.out.println("------------------------");
					System.out.println("---------CADASTRO-------");
					System.out.println("------------------------");
					System.out.println("Digite o seu primeiro nome (sem espaço): ");
					Cliente cliente = new Cliente();
					String nome = ler.next();
					System.out.println("Digite o seu segundo nome (sem espaço): ");
					System.out.println("-----SE NAO POSSUIR, DIGITE n E DEPOIS ENTER-----");
					String segundo_nome = ler.next();
					if(segundo_nome.equals("n")) {
						segundo_nome = null;
					}else{
						nome = nome + " " + segundo_nome;
					}
					cliente.setNome(nome);
					System.out.println("Digite o seu sobrenome do meio (sem espaço): ");
					String nome_meio = ler.next();
					cliente.setNomeMeio(nome_meio);
					System.out.println("Digite o seu ultimo sobrenome (sem espaço): ");
					String nome_final = ler.next();
					cliente.setNomeFinal(nome_final);
					System.out.println("Digite o sua idade (sem espaço): ");
					int idade = ler.nextInt();
					cliente.setIdade(idade);
					cliente.setDataCadastro(new Date());
					boolean loop2 = true;
					while(loop2 == true) {
						System.out.println("Digite o seu nome de usuario: ");
						String usuarioCadastro = ler.next();
						if(ClienteDAO.validaUsuarios(usuarioCadastro) == true){
							System.out.println("Usuario ja existe, digite outro");
						}else{
							cliente.setUsuario(usuarioCadastro);
							loop2 = false;
						}
					}
					System.out.println("Digite a sua senha: ");
					String senhaCadastro = ler.next();
					cliente.setSenha(senhaCadastro);
					ClienteDAO.save(cliente);
				break;
			case 3:
					System.out.println("Digite o seu usuario: ");
					String user = ler.next();
					System.out.println("Digite a sua senha: ");
					String pass = ler.next();
					if(AdmDAO.validarAdmin(user, pass) == true){
						boolean loop3 = true;
						while(loop3 == true){
							System.out.println("------------------------");
							System.out.println("-----------ADM----------");
							System.out.println("------------------------");
							System.out.println("1 - Listar clientes");
							System.out.println("2 - Listar passagens");
							System.out.println("3 - Adicionar passagens");
							System.out.println("4 - Cadastrar administrador");
							System.out.println("5 - Deletar administrador");
							System.out.println("6 - atualizar senha do administrador");
							System.out.println("7 - Sair");
							int opcao2 = ler.nextInt();
							switch(opcao2){
								case 1:
										for(Cliente c : ClienteDAO.getClientes()) {
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
											System.out.println("nome: " + c.getNome() + ' ' + c.getNomeMeio() + ' ' + c.getNomeFinal());
											System.out.println("idade: " + c.getIdade());
											System.out.println("data de cadastro: " + c.getDataCadastro());
											System.out.println("usuario: " + c.getUsuario());
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
										}
									break;
								case 2:
										System.out.println("------------------------");
										System.out.println("-----LISTAR-PASSAGENS---");
										System.out.println("------------------------");
										for(Passagem p : PassagemDAO.listarPassagens()) {
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
											System.out.println("ID DA PASSAGEM: " + p.getPassagemId());
											System.out.println("DATA DA VIAGEM: " + p.getDiaViagem() + "/" + p.getMesViagem() + "/" + p.getAnoViagem());
											System.out.println("DATA DA COMPRA: " + p.getData_compra());
											System.out.println("ORIGEM: " + p.getOrigem());
											System.out.println("DESTINO: " + p.getDestino());
											System.out.println("--------------------------------------------");
											System.out.println("--------------------------------------------");
										}
									break;
								case 3:
										System.out.println("------------------------");
										System.out.println("---ADICIONAR-PASSAGEM---");
										System.out.println("------------------------");
										System.out.println("Digite o dia da viagem: ");
										int dia_Viagem = ler.nextInt();
										System.out.println("Digite o mes da viagem: ");
										int mes_Viagem = ler.nextInt();
										System.out.println("Digite o ano da viagem: ");
										int ano_Viagem = ler.nextInt();
										System.out.println("Digite a origem (Cidade/Estado/País): ");
										ler.nextLine();
										String origem = ler.nextLine();
										System.out.println("Digite o destino (Cidade/Estado/País): ");
										String destino = ler.nextLine();
										Passagem passagem = new Passagem();
										passagem.setDataViagem(dia_Viagem, mes_Viagem, ano_Viagem);
										passagem.setOrigem(origem);
										passagem.setDestino(destino);
										passagem.setCliente_id(0);
										passagem.setStatus_compra("Disponivel");
										passagem.setData_compra(new Date());
										PassagemDAO.inserir(passagem);
									break;
								case 4:
									System.out.println("Digite o usuario do administrador: ");
									String usuarioAdm = ler.next();
									System.out.println("Digite a senha do administrador: ");
									String senhaAdm = ler.next();
									AdmDAO.cadastrarAdmin(usuarioAdm, senhaAdm);
									break;
								case 5:
										System.out.println("Digite o usuario do administrador: ");
										String usuarioAdm2 = ler.next();
										System.out.println("Digite a senha do administrador: ");
										String senhaAdm2 = ler.next();
										if(AdmDAO.validarAdmin(usuarioAdm2, senhaAdm2) == true && usuarioAdm2 == user && senhaAdm2 == pass){
											AdmDAO.deletarAdmin(senhaAdm2);
										}else{
											System.out.println("Usuario ou senha invalidos");
										}
									break;
								case 6:
									System.out.println("Digite o usuario do administrador: ");
									String usuarioAdm3 = ler.next();
									System.out.println("Digite a nova senha: ");
									String senhaAdm3 = ler.next();
									AdmDAO.updateSenhaAdm(usuarioAdm3, senhaAdm3);
									break;
								case 7:
										loop3 = false;
									break;
							}
						}
					}else{
						System.out.println("Usuario ou senha invalidos");
					}
				break;
		  case 4:
					loop = false;
				break;
			default:
					System.out.println("Opcao invalida");
				break;   
	  }
	}ler.close();
}	       
}
