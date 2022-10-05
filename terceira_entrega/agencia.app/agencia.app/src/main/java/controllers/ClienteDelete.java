package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;

@WebServlet("/ClienteDestroy")
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		ClienteDAO.delete(clienteId);
		
		ClienteCreateAndFind clienteCAndFind = new ClienteCreateAndFind();
		clienteCAndFind.doGet(request, response);	
	}
}
