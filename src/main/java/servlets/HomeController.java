package servlets;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		System.out.println("am trecut pe aici");
		return "index";
	}
	
//	@RequestParam("username") User username, 
//	@RequestParam("password") String password
	
	@RequestMapping(value="/userLogged", method = RequestMethod.GET)
	public ModelAndView login() {
//		User u = new User();
//		u.setUsername(username);
//		u.setPassword(password);
		return new ModelAndView("userLogged");
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home2() {
		System.out.println("ma duc spre home");
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/invalidLogin", method = RequestMethod.GET)
	public ModelAndView invalidLogin() {
		System.out.println("user nu exista");
		return new ModelAndView("invalidlogin");
	}

}
