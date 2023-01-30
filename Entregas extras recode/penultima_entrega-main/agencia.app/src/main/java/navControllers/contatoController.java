package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class contatoController {

	@GetMapping("/contato")
	public String getContato() {
		return "contato";
	}
}
