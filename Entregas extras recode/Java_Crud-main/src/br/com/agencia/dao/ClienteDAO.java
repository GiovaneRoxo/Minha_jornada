 package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Cliente;

public class ClienteDAO {
	
	// CREATE
		// metodo para cadastrar cliente = C
	public static void save(Cliente cliente ) {
		
			
			String sql = "INSERT INTO clientes(nome, sobrenome_meio, sobrenome_final, idade, datacadastro, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			
			try {
				//cria conexão com banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql); 
				
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getNomeMeio());
				pstm.setString(3, cliente.getNomeFinal());
				pstm.setInt(4, cliente.getIdade());
				pstm.setDate(5, new Date(cliente.getDataCadastro().getTime()));
				pstm.setString(6, cliente.getUsuario());
				pstm.setString(7, cliente.getSenha());
				
				pstm.execute();
				System.out.println("Contato salvo!!");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	// READ
		// metodo para listar todos os clientes 
	public static List<Cliente> getClientes(){
		
			String sql = "SELECT * FROM clientes";
			
				List<Cliente> clientes = new ArrayList<Cliente>();
			
				Connection conn = null;
				PreparedStatement pstm = null;
				//recurperar dados do banco
				ResultSet rset = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);
				
					rset = pstm.executeQuery();
				
						while(rset.next()) {
							Cliente cliente = new Cliente();
								
							cliente.setId(rset.getInt("cliente_id"));
							cliente.setNome(rset.getString("nome"));
							cliente.setNomeMeio(rset.getString("sobrenome_meio"));
							cliente.setNomeFinal(rset.getString("sobrenome_final"));
							cliente.setIdade(rset.getInt("idade"));
							cliente.setDataCadastro(rset.getDate("datacadastro"));
							cliente.setUsuario(rset.getString("usuario"));

							clientes.add(cliente);
						}
						
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rset!=null) {
							rset.close();
						}if(pstm!=null) {
							pstm.close();
						}if(conn!=null) {
							conn.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				return clientes;
		}


	// UPDATES
		// metodo para atualizar nome de usuario do cliente
	public static void updateUsuario(String usuario, int id) {

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
	
				String sql = "UPDATE agencia.clientes SET Usuario = ? WHERE CLIENTE_ID = ? ;";
	
				pstm = conn.prepareStatement(sql);	
				pstm.setString(1, usuario);
				pstm.setInt(2, id);
				pstm.executeUpdate();		
				System.out.println("Usuario atualizado com sucesso!");
	
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rset!=null) {
							rset.close();
						}if(pstm!=null) {
							pstm.close();
						}if(conn!=null) {
							conn.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		}
		// metodo para atualizar senha do cliente
	public static void updateSenha(String novaSenha, String antigaSenha) {
				
				String sql = "UPDATE clientes SET Senha = ? WHERE Senha = ? ;";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = (PreparedStatement) conn.prepareStatement(sql);
				
					pstm.setString(1, novaSenha);			
					pstm.setString(2, antigaSenha);
					pstm.execute();
					System.out.println("Senha atualizada!!");
	
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("Erro ao atualizar senha!!");
				}finally {
					try {
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			} 
		// metodo para atualizar nome do cliente
	public static void updateNome(String nome, int id) {
			
			String sql = "UPDATE agencia.clientes SET Nome = ? WHERE CLIENTE_ID = ? ;";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
			
				pstm.setString(1, nome);			
				pstm.setInt(2, id);
				pstm.execute();
				System.out.println("Nome atualizado!!");
	
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao atualizar nome!!");
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// metodo para atualizar sobrenome do meio do cliente
	public static void updateSobrenome(String sobrenome_meio, String sobrenome_final, int id) {
	
			String sql = "UPDATE agencia.clientes SET Sobrenome_meio = ? AND Sobrenome_final = ? WHERE CLIENTE_ID = ? ;";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
			
				pstm.setString(1, sobrenome_meio);			
				pstm.setString(2, sobrenome_final);
				pstm.setInt(3, id);
				pstm.execute();
				System.out.println("Sobrenome do meio atualizado!!");
	
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao atualizar sobrenome do meio!!");
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	
		}
		// metodo para atualizar ultimo sobrenome do cliente
	public static void updateIdade(int idade, int id) {
			
			String sql = "UPDATE agencia.clientes SET Idade = ? WHERE CLIENTE_ID = ? ;";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
			
				pstm.setInt(1, idade);			
				pstm.setInt(2, id);
				pstm.execute();
				System.out.println("Idade atualizada!!");
	
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao atualizar idade!!");
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	// DELETE
		// metodo para deletar o cliente pela id 
	public static void deleteByID(int id) {
			
			String sql = "DELETE FROM `agencia`.`clientes` WHERE (`cliente_id` = ?);";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				pstm.execute();
				System.out.println("Conta deletada com sucesso!!");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}


	// SEGURANÇA
		// metodo para autenticar cliente na tela de login
	public static boolean login(String login, String senha) {

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			

			try {
				conn = ConnectionFactory.createConnectionToMySQL();

				String sql = "SELECT * FROM agencia.clientes WHERE Usuario = ? AND Senha = ? ;";

				pstm = conn.prepareStatement(sql);	
				pstm.setString(1, login);
				pstm.setString(2, senha);	
				rset = pstm.executeQuery();		
				
				return rset.next() ? true : false;

			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}if(pstm!=null) {
					pstm.close();
					}if(conn!=null) {
					conn.close();
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
		// metodo para verificar se o usuario ja existe durante o cadastro
	public static Boolean validaUsuarios(String usuario) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Boolean returno = false;
		

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			String sql = "SELECT Usuario FROM agencia.clientes WHERE Usuario = ? ;";

			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, usuario);
			rset = pstm.executeQuery();		

			if(rset.next()) {
				if(rset.getString("Usuario").equals(usuario)) {
					returno = true;
				}
			}
					
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}if(pstm!=null) {
						pstm.close();
					}if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return returno;
	}
		// metodo para verificar se a senha ja existe durante o cadastro 
	public static Boolean validaSenha(String senha) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Boolean returno = false;
		

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			String sql = "SELECT Senha FROM agencia.clientes WHERE Senha = ? ;";

			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, senha);
			rset = pstm.executeQuery();		

			if(rset.next()) {
				if(rset.getString("Senha").equals(senha)) {
					returno = true;
				}
			}
					
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}if(pstm!=null) {
						pstm.close();
					}if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return returno;
	}

		// metodo para pegar o id do cliente pelo usuario
	public static int getIdByUsuario(String usuario) {
	
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int id = 0;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			String sql = "SELECT CLIENTE_ID FROM agencia.clientes WHERE Usuario = ? ;";

			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, usuario);
			rset = pstm.executeQuery();		
			
			if(rset.next()) {
				id = rset.getInt("CLIENTE_ID");
			}
					
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}if(pstm!=null) {
						pstm.close();
					}if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return id;
	}
}

