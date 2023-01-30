package controllers;



import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.ClienteDAO;
import DAO.PassagemDAO;
import models.Cliente;
import models.Passagem;

@Controller
public class PassagensCreateAndFind {
	

	@GetMapping("/todas_passagens")
	protected ModelAndView doGet() {
		List<Passagem> passagens = PassagemDAO.find(); 
		ModelAndView mvget = new ModelAndView();
		mvget.addObject("passagem", passagens);
		mvget.setViewName("pages/adm/passagens");
		return mvget;
	}

	@PostMapping("/Passagens")
	protected ModelAndView doPost(Passagem passagem, Cliente cliente){
		int clienteid = ClienteDAO.findIdByEmail(cliente.getEmail());
		passagem.setFk_Cliente_cliente_id(clienteid);
		passagem.setStatus_compra("aguardando pagamento");
		long millis=System.currentTimeMillis();  
		Date now = new Date(millis);
		passagem.setData_compra(now);
		PassagemDAO.criarPassagem(passagem);
		ModelAndView mv = new ModelAndView();
		mv.addObject("passagem", passagem);
		mv.setViewName("pages/usuario/menu/conta_usuario");
		return mv;
	}

}
