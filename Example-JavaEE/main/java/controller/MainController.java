package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class MainController {

	
	@GET
	public String homePage() {
		//model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}

	@GET
	@Path(value = "main")
	public String main() {
		//model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "main";
	}

//	@GetMapping(value = "/admin")
//	public String adminPage(ModelMap model) {
//		model.addAttribute("user", getPrincipal());
//		return "admin";
//	}
//
//	@GetMapping(value = "/db")
//	public String dbaPage(ModelMap model) {
//		model.addAttribute("user", getPrincipal());
//		return "dba";
//	}
//
//	@GetMapping(value = "/Access_Denied")
//	public String accessDeniedPage(ModelMap model) {
//		model.addAttribute("user", getPrincipal());
//		return "accessDenied";
//	}
//
//	@GetMapping(value = "/login")
//	public String loginPage() {
//		return "login";
//	}
//
//	@GetMapping(value="/logout")
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null){
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/login?logout";
//	}
//
//	private String getPrincipal(){
//		String userName = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails) {
//			userName = ((UserDetails)principal).getUsername();
//		} else {
//			userName = principal.toString();
//		}
//		return userName;
//	}


}