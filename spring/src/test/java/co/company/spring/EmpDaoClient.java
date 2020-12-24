package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class } )
public class EmpDaoClient {
	
	@Autowired EmpDAO empDAO; 
	@Test
	public void empdaoTest() {
		//EmpDAO dao = new EmpDAO(); 를 자동으로 생성하기 위해 EmpDAO.java파일에 @Component 해주고
		//@Autowired EmpDAO empDAO; 등록해주면 new 생성하지 않아도 된다. 
		System.out.println(empDAO.getList());
		
	}
}
