package co.company.spring.dao;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	public List<Emp>/*//리턴타입 */ getEmpList(EmpSearch emp);
	public List<Map<String, Object>> getStatDept(); // 부서별 사원 부서번호, 부서명, 사원수 조회
	public Emp getEmp(Emp emp); //조회
	public int updateEmp(Emp emp); //업데이트
	public int insertEmp(Emp emp); 
	public void insertEmpProc(Emp emp); 
	public void deleteEmp(Emp emp);
	public void deleteMultiEmp(EmpSearch emp);
	public int getCount(Emp emp); //건수조회
	public List<Jobs> jobSelect();
	public List<departments> departmentSelect();
	
//void = return값 x
}
