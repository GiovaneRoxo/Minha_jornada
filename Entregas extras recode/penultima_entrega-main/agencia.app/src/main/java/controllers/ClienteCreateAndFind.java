package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.ClienteDAO;
import models.Cliente;


@Controller
public class ClienteCreateAndFind {

	@GetMapping("/todos_clientes")
	protected ModelAndView doGet(Cliente cliente) {
		
		ModelAndView mvget = new ModelAndView();
		List<Cliente> clientes = ClienteDAO.find(); 
		
		mvget.addObject("clientes", clientes);
		mvget.setViewName("pages/adm/clientes");
		return mvget;
	}

	@PostMapping("/Cadastrando")
	protected ModelAndView doPost(Cliente cliente) {
		ModelAndView mvpost = new ModelAndView();	
		ClienteDAO.criarCliente(cliente);
		mvpost.setViewName("pages/usuario/login.html");
		return mvpost;
	}
}