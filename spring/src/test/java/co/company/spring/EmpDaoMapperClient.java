package co.company.spring;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.config.MybatisConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class, MybatisConfiguration.class } )
public class EmpDaoMapperClient {
	@Autowired EmpMapper empDAO;
	 
	@Test
	public void getStatTest() {
		List<Map<String, Object>> list = empDAO.getStatDept();
		System.out.println(list.get(0));
		System.out.println(list.get(0).get("deptName"));
		
	}
	
	
	
	//@Test
	public void getCountTest() {
		Emp emp = new Emp();
		System.out.println(empDAO.getCount(emp));
	}
	
	//@Test
	public void InsertProcTest() {
		Emp emp = new Emp();

		emp.setLastName("choi");
		emp.setJobId("IT_PROG");
		emp.setEmail("a@a.nn");

		empDAO.insertEmpProc(emp);
		System.out.println(emp.getEmployeeId()
				+" : " + emp.getMsg());
	}
	
	//@Test
	public void InsertTest() {
		Emp emp = new Emp();
		emp.setFirstName("길동");
		emp.setLastName("choi");
		emp.setJobId("IT_PROG");
		emp.setEmail("a@a.a");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		empDAO.insertEmp(emp);
		System.out.println(emp.getEmployeeId());
	}
	
	//@Test
	public void deleteMultiTest() {
		EmpSearch emp = new EmpSearch();
		emp.setList(new String[] {"207"});
		empDAO.deleteMultiEmp(emp);
	}
	
	
	
	
	
	//@Test
	public void updateTest() {
		Emp emp = new Emp();
		emp.setEmployeeId("102");
		System.out.println(empDAO.getEmp(emp));
		
		
		emp.setFirstName("hong");
		empDAO.updateEmp(emp);
		
		System.out.println(empDAO.getEmp(emp));
	}
	
	
	
	
	//@Test
	public void empdaoTest() {
		EmpSearch empvo = new EmpSearch();
//		empvo.setFirstName("pat");
//		empvo.setDepartmentId("20");
//		empvo.setSalary(10000);
		empvo.setMinSalary(5000);
		empvo.setMaxSalary(10000);
		List<Emp> list = empDAO.getEmpList(empvo);
		for(Emp emp : list) {
		System.out.println(	emp.getEmployeeId() +" : "
				    +emp.getFirstName() + " : "
					+ emp.getLastName() + " : "
					+ emp.getDepartmentId() + " : "
					+ emp.getJobId() + " : "
					+ emp.getSalary()
					);
			
		}
	}
	

}
