package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AdmDAO;

@WebServlet("/Adm")
public class Adm extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	public String emailLogado;
	public String senhaLogado;
  
    public Adm() {
        super();  
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			model.Adm login = new model.Adm();
			login.setUser(username);
			login.setSenha(senha);
			
			if(AdmDAO.validar(login) == true){
				System.out.println("--sucess login");
				RequestDispatcher despachar = request.getRequestDispatcher("/pages/adm/menu.jsp");
				despachar.forward(request, response);
				emailLogado = username;
				senhaLogado = senha;
			} else {
				System.out.println("--erro: senha ou email incorreto");
				RequestDispatcher despachar = request.getRequestDispatcher("/pages/usuario/login.jsp");
				despachar.forward(request, response);
		}
	}
}
