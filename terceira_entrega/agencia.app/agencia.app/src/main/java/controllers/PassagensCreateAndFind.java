package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.PassagemDAO;
import model.Passagem;

@WebServlet("/Passagens")
public class PassagensCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	java.util.Date data = new java.util.Date();
	public Date data_atual = new Date(data.getTime());
       
    public PassagensCreateAndFind() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Passagem> passagens = PassagemDAO.find(); 
		
		request.setAttribute("passagens", passagens);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/adm/passagens.jsp");
		despachar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		int clienteid = ClienteDAO.findIdByEmail(email);
		Passagem passagem = new Passagem();
		passagem.setFk_Cliente_cliente_id(clienteid);
		passagem.setData_viagem(request.getParameter("dataViagem"));
		passagem.setDestino(request.getParameter("Destinos"));
		passagem.setOrigem(request.getParameter("Origem"));
		passagem.setStatus_compra("aguardando pagamento");
		passagem.setData_compra(data_atual);
		PassagemDAO.criarPassagem(passagem);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/usuario/menu/minhas_passagens.jsp");
		despachar.forward(request, response);
		doGet(request, response);
	}

}
