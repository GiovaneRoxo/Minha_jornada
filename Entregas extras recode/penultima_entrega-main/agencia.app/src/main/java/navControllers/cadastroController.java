package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cadastroController {

	@GetMapping("/cadastro")
	public String getCadastrar() {
		return "pages/usuario/cadastro.html";
	}
}
