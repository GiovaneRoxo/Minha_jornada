package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginAdmController {

	@GetMapping("/loginAdm")
	public String getLoginAdm() {
		return "pages/adm/login";
	}
}
