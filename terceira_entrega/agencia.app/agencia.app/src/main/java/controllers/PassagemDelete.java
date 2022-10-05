package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PassagemDAO;


@WebServlet("/Destroy")
public class PassagemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PassagemDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int passagemId = Integer.parseInt(request.getParameter("passagemId"));
		PassagemDAO.delete(passagemId);
		
		PassagensCreateAndFind passagemCreateAndFind = new PassagensCreateAndFind();
		passagemCreateAndFind.doGet(request, response);	
	}
}
