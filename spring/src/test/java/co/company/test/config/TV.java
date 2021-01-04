package co.company.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component//@Controller, @Service, @Repository
public class TV {
	@Autowired 
	@Qualifier ("apple")
	//@Resource(name = "apple")
	Speaker speaker;
	
	public void volumeup() {
		speaker.volumeup();
	}
	//생성자 생성
	public TV() {
		System.out.println("TV생성됨.");
	}
	public void init() {
		System.out.println("init 생성됨.");
	}
	public void destroy() {
		System.out.println("객체 소멸됨.");
	}
}
