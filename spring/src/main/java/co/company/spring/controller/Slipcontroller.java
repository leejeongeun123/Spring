package co.company.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Slipcontroller {

	@RequestMapping("/slip")
	public ResponseEntity slip(@RequestBody List<SlipVO> list){
		System.out.println(list);
		if(list.size()<1) {
			return ResponseEntity 
					.status(HttpStatus.BAD_REQUEST)
					.body(null);
		} else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("process", true);
		map.put("tcount", list.size());
		map.put("pcount", list.size());
		map.put("list", list);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(map);
		}
		
	}
	@RequestMapping("/slip2")
	@ResponseBody
	public Map<String, Object> slip2(@RequestBody List<SlipVO> list, HttpServletResponse response, HttpServletRequest request){
		System.out.println(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("process", true);
		map.put("tcount", list.size());
		map.put("pcount", list.size());
		map.put("list", list);
		
		return map;
		
	}
	@RequestMapping("/slip3")
	public void slip3() {
		//HttpClient 
		//HttpUrlConnection
		//RestTemplete
		
		//java객체 -> json String : Jackson
		 
		
	}
}