package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DestinoControllers {

	@GetMapping("/destinos")
	public String destinosPage() {
		return "destinos";
	}
}
