package navControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

	@GetMapping("/login")
	public ModelAndView getLogin() {	
		return new ModelAndView("pages/usuario/login");
	}
}
