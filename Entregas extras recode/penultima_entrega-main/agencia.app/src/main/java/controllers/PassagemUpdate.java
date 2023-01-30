package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PassagemDAO;
import models.Passagem;

@WebServlet("/UpdatePassagem")
public class PassagemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PassagemUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int passagemId = Integer.parseInt(request.getParameter("passagemId"));
		Passagem passagem = PassagemDAO.findByPk(passagemId);
		request.setAttribute("passagem", passagem);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/adm/AtualizarPassagem.jsp");
		despachar.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Passagem passagem = new Passagem();
		passagem.setPassagem_id(Integer.parseInt(request.getParameter("passagem_id")));
		passagem.setData_viagem(request.getParameter("data_viagem"));
		passagem.setDestino(request.getParameter("destino"));
		passagem.setOrigem(request.getParameter("origem"));
		PassagemDAO.update(passagem);
		
		PassagensCreateAndFind passagemCreateAndFind = new PassagensCreateAndFind();
		
	}

}
