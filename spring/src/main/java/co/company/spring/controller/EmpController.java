package co.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.dao.departments;
import co.company.spring.emp.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	//EmpMapper dao; //DAO
	
	@RequestMapping("/ajax/jobSelect")
	@ResponseBody
	public List<Jobs> jobSelect() {
		return service.jobSelect();
	}
			
	
	
	@RequestMapping(value="/empSelect",
			method = RequestMethod.GET)
	public ModelAndView select(EmpSearch emp) {
		//DB에서 전체사원조회
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.getEmpList(emp));
		mav.setViewName("emp/select");
		
		return mav;
	}
	
	@GetMapping("/empUpdateForm")
	public String updateForm(Model model, Emp emp) {
		model.addAttribute("emp", service.getEmp(emp));
		/*
		 * model.addAttribute("jobs", dao.jobSelect());
		 * model.addAttribute("departments", dao.departmentSelect());
		 */
		//등록페이지로이동
		return "emp/insert"; //foward
	}
	
	@ModelAttribute("jobs")
	public List<Jobs> jobs(){
		return service.jobSelect();
	}
	@ModelAttribute("departments")
	public List<departments> departments(){
		return service.departmentSelect();
	}
	
	@GetMapping("/empinsertForm")
	public String insertForm(Model model,Emp emp) {
		/*
		 * model.addAttribute("jobs", dao.jobSelect());
		 * model.addAttribute("departments", dao.departmentSelect());
		 */
		//등록페이지로이동
		return "emp/insert"; //foward
	}
	
	@PostMapping("/empInsert")
	 public String insert(Model model,Emp emp, Errors errors
	 					  ) {
		new EmpValidator().validate(emp, errors);
		if(errors.hasErrors()) {
			return "emp/insert";
		}
			if(emp.getEmployeeId() == null)
				service.insertEmp(emp);
			else
				service.updateEmp(emp);
			//request.setAttribute("emp", emp);
			return "emp/insertOutput";
	}
	
	/*
	 * @PostMapping("/empInsert") public String insert(HttpServletRequest request,
	 * 
	 * @RequestParam(value="lastName", required = false, defaultValue = "noname")
	 * String lName,
	 * 
	 * @RequestParam(required = false) int salary, Emp emp) { //파라미터 String fName =
	 * request.getParameter("firstName"); System.out.println(lName + " : " + fName +
	 * " : " + salary); System.out.println("emp\n" + emp);
	 * 
	 * //등록처리 후 조회페이지로이동 //redirect return "redirect:/empSelect"; }
	 */
}
