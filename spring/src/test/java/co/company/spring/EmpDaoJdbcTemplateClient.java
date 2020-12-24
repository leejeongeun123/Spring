package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpDAOJdbcTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class } )
public class EmpDaoJdbcTemplateClient {

	@Autowired EmpDAOJdbcTemplate empDAO;
	@Test
	public void empdaoTest() {
		//EmpDAO dao = new EmpDAO(); 를 자동으로 생성하기 위해 EmpDAO.java파일에 @Component 해주고
		//@Autowired EmpDAO empDAO; 등록해주면 new 생성하지 않아도 된다. 
		System.out.println(empDAO.getListMap());
		
	}
	
	@Test
	public void insertTest() {
		Emp emp = new Emp(); //emp 생성 값 담기.
		emp.setEmployeeId("1000");
		emp.setLastName("aaaa");
		emp.setEmail("a@a.a");
		empDAO.insert(emp);
		System.out.println(empDAO.getListMap());
		
	}
	

}
