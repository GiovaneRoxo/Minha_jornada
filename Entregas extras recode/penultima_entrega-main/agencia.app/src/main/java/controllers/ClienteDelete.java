package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.ClienteDAO;

@Controller
public class ClienteDelete{

    @GetMapping("/ClienteDestroy")
	protected ModelAndView doGet(int clienteId) {
		ClienteDAO.delete(clienteId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/adm/menu");
		return mv;
	}
}
