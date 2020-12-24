package co.company.spring;

import co.company.spring.controller.Member;

public class LombokTest {

	
	public static void main(String[] args) {
		
		
	Member member =	Member.builder()
			  .id("아이디")
			  .name("이름")
			  .build();
		
		
	}
}
