Algoritmo "sistema agencia de viagens"
// Disciplina   : [Linguagem e L�gica de Programa��o] 
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Cadastra clientes e destinos e possui sistema
//               de consulta dos clientes e destinos
// Autor(a)    : Giovane Serafim Roxo
// Data atual  : 12/06/22

Var
// Se��o de Declara��es das vari�veis

 clientes:vetor[1..10, 0..5] de caractere    // matriz de clientes
 x, j: inteiro                               // variaveis da matriz de clientes
 destinos:vetor[1..10, 0..2] de caractere    // matriz de destinos
 z, y: inteiro                               // variaveis da matriz de destinos
 clientex: inteiro                           // Numero de clientes adicionados
 destinox: inteiro                           // numero de destinos adicionados
 opcaoEscolhida: inteiro                     // op��o escolhida pelo usuario
 numeroc:inteiro                             // guarda nro do cliente
 msg:vetor[0..5] de caractere                // guarda mensagens cliente
 msgDestino:vetor[0..2] de caractere         // guarda mensagens desino

Inicio

msg[0] <- "--Nome:"
msg[1] <- "--Sobrenome:"
msg[2] <- "--CPF:"
msg[3] <- "--Cidade:"
msg[4] <- "--Estado:"
msg[5] <- "--Destino desejado:"

msgDestino[0] <- "--Cidade:"
msgDestino[1] <- "--Estado:"
msgDestino[2] <- "--Pa�s:"

enquanto verdadeiro fa�a
    escreval("===== MENU DE OP��ES =====:")
    escreval("1- Cadastrar clientes")
    escreval("2- Cadastrar destinos")
    escreval("3- Consultar todos os clientes")
    escreval("4- Consultar todos os destinos")
    escreval("5- Consultar cliente especifico")
    escreval("ESC- Sair")
    leia(opcaoEscolhida)

    escolha opcaoEscolhida
       caso 1
          limpatela
           escreval("===== CADASTRO DE CLIENTE =====:")
           escreval(" Quantos clientes vai adicionar? ")
           leia(clientex)
               limpatela
                   para x de 1 at� clientex fa�a
                   escreval("=====Digite os dados do cliente=====")
                   escreval("/-/clente: ", x)
                   escreval(" ")
                       para j de 0 at� 5 fa�a
                           escreva(msg[j])
                           leia(clientes[x,j])
                       fimpara
                   limpatela
                   fimpara
       caso 2
           limpatela
           escreval("===== CADASTRO DE DESTINO =====:")
           escreval(" Quantos destinos vai adicionar? ")
           leia(destinox)
               limpatela
               escreval("--Digite os dados do destinos: ")
               escreval(" ")
                   para z de 1 at� destinox fa�a
                   escreval("/-/destinos ", z)
                       para y de 0 at� 2 fa�a
                           escreva(msgDestino[y])
                           leia(destinos[z,y])
                       fimpara
                       limpatela
                   fimpara

       caso 3
          limpatela
          escreval("Clientes: ")
          para x de 1 at� clientex fa�a
                      escreva("id=", x)
                      escreva(" - ")
                      escreva(clientes[x,0])
                      escreva(" ")
                      escreva(clientes[x,1])
                      escreval()
          fimpara
          escreval()
       caso 4
          limpatela
          escreval("Destinos: ")
          para z de 1 at� destinox fa�a
                      escreva(z)
                      escreva(" - ")
                      escreva(destinos[z,0])
                      escreva(", ")
                      escreva(destinos[z,1])
                      escreva(", ")
                      escreva(destinos[z,2])
                      escreval()
                      escreval()
          fimpara
          
          caso 5
          limpatela
          escreval("Digite o id do cliente")
          leia(numeroc)
          limpatela
          para j de 0 at� 5 fa�a
               escreva(msg[j])
               escreva("  ")
               escreval(clientes[numeroc, j])
          fimpara
          escreval(" ")
       fimescolha
fimenquanto

limpatela
escreval("finalizado")

Fimalgoritmo