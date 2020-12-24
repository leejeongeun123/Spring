package co.company.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*@Setter
@Getter
*/
@AllArgsConstructor 
@NoArgsConstructor

@Data //통합해주는것 
@Builder //객체생성자
public class Member {

	String id;
	String name;
	String password;
	
}
