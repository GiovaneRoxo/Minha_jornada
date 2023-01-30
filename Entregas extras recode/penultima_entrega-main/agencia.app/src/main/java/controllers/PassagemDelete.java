package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.PassagemDAO;


@Controller 
public class PassagemDelete {

	@GetMapping("/Destroy")
	protected ModelAndView doGet(int passagemId) {
		PassagemDAO.delete(passagemId);
		ModelAndView mvget = new ModelAndView();
		mvget.setViewName("pages/adm/menu");
		return mvget;
	}
}
