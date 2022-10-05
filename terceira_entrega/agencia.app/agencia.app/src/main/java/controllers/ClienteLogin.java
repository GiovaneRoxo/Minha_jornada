package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import model.Cliente;


@WebServlet("/ClienteLogin")
public class ClienteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	
    public ClienteLogin() {
        super();  
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Cliente login = new Cliente();
			login.setEmail(username);
			login.setSenha(senha);
			
			
			
			if(ClienteDAO.validar(login) == true){
				System.out.println("--sucess login");
				RequestDispatcher despachar = request.getRequestDispatcher("/pages/usuario/menu/cliente.jsp");
				request.setAttribute("login", login);
				despachar.forward(request, response);
			} else {
				System.out.println("--erro na senha ou email");
				RequestDispatcher despachar = request.getRequestDispatcher("/pages/usuario/login.html");
				despachar.forward(request, response);
		}
	}
}
