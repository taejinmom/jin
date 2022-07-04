package ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaoImple implements DaoInter{

	@Override
	public void first() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i+" ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End!");
	}

	@Override
	public String second() {
		StringBuffer sb = new StringBuffer();
		sb.append("--------------------").append("\n");
		sb.append("김길동").append("\n");
		sb.append("--------------------").append("\n");
		return sb.toString();
	}

	@Override
	public void third() {
		String[] ar = {"메세지1", "메세지2", "메세지3", "메세지4", "메세지5"};
		for(int i=0; i<=ar.length; i++) {
			System.out.println("비지니스 로직의 "+ar[i]);
		}
	}

	@Override
	public String firstStateMentTest(int num) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into speedtest values(");
		sql.append(num).append(",'").append("xman"+num).append("',");
		sql.append("sysdate)");
		String path = "insert into speedtest values(?,?,sysdate)";
		
		try (Connection con = MyConn.getDs();
				Statement stmt = con.createStatement()){
			if(num == 1) {
			for(int i =1; i<=1000; i++) {
				stmt.executeUpdate(sql.toString());
					
			}
			}else if(num ==2) {
				try (Connection con1 = MyConn.getDs();
						PreparedStatement ps = con.prepareStatement(path)){
					
					for(int i =1; i<=1000; i++) {
						ps.setInt(1, i);
						ps.setString(2, "xman"+i);
						ps.executeUpdate();
					}
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sql.toString();
	}

	@Override
	public String todayMethod() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(new Date());
	}

	
}
