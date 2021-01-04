package co.company.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //<bean>등록
@Aspect		//<aop:aspect>
public class AfterAdvice { //클래스이름.pointcut 으로 사용가능 
	@Pointcut("execution(*  co.company.spring..*Impl.get*(..))")	
	public void getpointcut() {}
	
	@AfterReturning(pointcut = "getpointcut()",
					returning="returnObj")
					//returning이 나와야함. 
	
	public void afterLog(JoinPoint jp, Object returnObj) {
			String method = jp.getSignature().getName(); //실행되는서비스
			System.out.println("[공통로그] after"
								+ method 
								+ "\n"
								+ returnObj);
		//리턴되는 값을 보기위함
	}
}
