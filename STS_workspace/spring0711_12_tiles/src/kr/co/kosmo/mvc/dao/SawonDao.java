package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

@Repository
	public class SawonDao {
		@Autowired
		private SqlSessionTemplate ss;
		
		public List<SawonVO> getSawonPhoneList(){
			return ss.selectList("ksawon.sawonlist");
		}
		
		public DeptVO getDeptList(int num){
			return ss.selectOne("ksawon.deptList", num);
		}
	

}
