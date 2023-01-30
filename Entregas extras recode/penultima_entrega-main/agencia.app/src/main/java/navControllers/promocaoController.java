package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class promocaoController {

	@GetMapping("/promoções")
	public String promocao() {
		return "promoções";
	}
}
