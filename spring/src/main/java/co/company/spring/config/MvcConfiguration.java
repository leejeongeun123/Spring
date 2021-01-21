package co.company.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import co.company.spring.common.AuthCheckInterceptor;
import co.company.spring.controller.Greeter;

@EnableWebMvc //(annotation-driven)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages="co.company")
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = 
				new ResourceBundleMessageSource();
		ms.setBasenames("message.label");//폴더명과 파일명을 적어준다. 
		ms.setDefaultEncoding("utf-8");
		//ms.setCacheSeconds(10);
	return ms;	
	}
	/**
	 * 언어 변경을 위한 인터셉터를 생성한다.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	    interceptor.setParamName("lang");
	    return interceptor;
	}

	/**
	 * 변경된 언어 정보를 기억할 로케일 리졸퍼를 생성한다.
	 * 여기서는 세션에 저장하는 방식을 사용한다.
	 * @return
	 */
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}

	/**
	 * 인터셉터를 등록한다.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor
	    (localeChangeInterceptor());
	    registry.addInterceptor
	    (authCheckInterceptor())
	    .addPathPatterns("/emp*");
	    
	}
	
	
	
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(3);
		return resolver;
	}
	
	@Bean	// 컨테이너의 객체를 생성해서 등록
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setformat("%s, 하이");
		return g;
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	}
	
	
	@Bean
	public AuthCheckInterceptor
	authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
	@Bean CommonsMultipartResolver multipartResolver(){ 
		//클래스파일의 객체를 생성해서 아이디 이름은 multipartResolver
		CommonsMultipartResolver multi = new CommonsMultipartResolver();
		multi.setMaxInMemorySize(1024*10000);
		return multi;
	}
	@Bean
	BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver bean = new BeanNameViewResolver();
		bean.setOrder(1);
		return bean;
	}
}
