package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.AdmDAO;
import models.Adm;



@Controller
public class AdmLogin {

	@PostMapping("/admLogin")
	public ModelAndView doPost(Adm adm) {
		
			ModelAndView mv = new ModelAndView();
		
			if(AdmDAO.validar(adm) == true){
				System.out.println("--sucess login");
				mv.addObject("adm", adm);
				mv.setViewName("pages/adm/menu");
			} else {
				System.out.println("--erro: senha ou email incorreto");
				mv.setViewName("pages/adm/login");
		}
		return mv;
	}
}
