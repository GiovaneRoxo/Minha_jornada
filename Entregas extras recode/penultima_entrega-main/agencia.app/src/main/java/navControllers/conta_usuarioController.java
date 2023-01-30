package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class conta_usuarioController {

	@GetMapping("/conta_usuario")
	public String getConta_usuario() {
		return "pages/usuario/menu/conta_usuario";
	}
}
