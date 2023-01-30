package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.ClienteDAO;
import models.Cliente;


@Controller
public class ClienteLogin {

    @PostMapping("/ClienteLogin")
	protected ModelAndView doPost(Cliente login){
		
			ModelAndView mv = new ModelAndView();
			
			if(ClienteDAO.validar(login) == true){
				System.out.println("--sucess login");
				mv.addObject("login", login);
				mv.setViewName("pages/usuario/menu/cliente");
			} else {
				System.out.println("--erro na senha ou email");
				mv.setViewName("pages/usuario/login");
		}
		return mv;
	}
}
