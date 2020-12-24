package co.company.spring.users.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.company.spring.users.service.UserVO;

@Repository
public class UserDAO {
	//public interface UserDAO 
	//인터페이스 하면 리턴값 모두 지우고 public List<UserVO> getUserList(UserVO user); 가능
	
	@Autowired
	private SqlSessionTemplate mybatis;
	

	//전체조회
	public List<UserVO> getUserList(UserVO user) {
		return mybatis.selectList("UserDAO.getUserList", user);
	}
	
	//단건조회
	public UserVO getUser(UserVO user) {
		return mybatis.selectOne("UserDAO.getUser", user);
	}

	public List<Map> getUserListMap(UserVO user) {
		return mybatis.selectList("UserDAO.getUserListMap", user);
	}

	// 등록
	public int insertUser(UserVO dto) {
		System.out.println("mybatis 사용자 등록");
		return mybatis.insert("UserDAO.insertUser", dto);
	}

	// 수정
	public int updateUser(UserVO dto) {
		System.out.println("mybatis 사용자 수정");
		return mybatis.update("UserDAO.updateUser", dto);
	}

	// 삭제
	public int deleteUser(UserVO dto) {
		System.out.println("mybatis 사용자 삭제");
		return mybatis.delete("UserDAO.deleteUser", dto);
	}
}
