package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import model.Cliente;


@WebServlet("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteCreateAndFind() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cliente> clientes = ClienteDAO.find(); 
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/adm/clientes.jsp");
		despachar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setIdade(Integer.parseInt(request.getParameter("idade")));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		ClienteDAO.criarCliente(cliente);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/usuario/login.jsp");
		despachar.forward(request, response);
		doGet(request, response);
	}
}