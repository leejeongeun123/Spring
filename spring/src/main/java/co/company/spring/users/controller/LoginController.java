package co.company.spring.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login") //로그인 페이지로이동  url이 같지만 get/post로 구분
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("/login") //로그인처리
	public String login(HttpSession session) {
		//로그인처리
		session.setAttribute("loginId", "user");
		return "redirect:/empSelect";
	}
	
	@GetMapping("/logout") //로그아웃
	public String logout(HttpSession session) {
		session.invalidate(); //세션무효화
		return "user/login";
	}
	
}
