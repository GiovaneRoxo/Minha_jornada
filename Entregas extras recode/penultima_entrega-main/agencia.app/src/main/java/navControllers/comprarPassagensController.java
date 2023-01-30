package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import models.Cliente;

@Controller
public class comprarPassagensController {

	@GetMapping("/comprar_passagens")
	protected String getComprarPassagens(Cliente cliente) {
		return "pages/usuario/menu/comprar_passagens";
	}
}
