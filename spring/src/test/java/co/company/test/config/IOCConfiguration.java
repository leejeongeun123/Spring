package co.company.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"co.company.test"})	//bean 등록할 필요가 사라짐. 
public class IOCConfiguration {

//	@Bean(initMethod = "init", destroyMethod = "destroy") //리턴타입을 TV로 설정 ID는 TV (메소드명.)class=""해서return 넘겨주면됨.
//	@Scope("prototype") //singleton(기본), request, session //prototype=> 요청 Autowired할때마다 객체생성
//	public TV tv() {
//		return new TV();
//	}

}
