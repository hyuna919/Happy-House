package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssafy.happyhouse.model.dto.DongCode;

public class dongParsing {



	public static void register(DongCode dongCode) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =  DBConnection.getConnection();
			String sql = "insert into dongcode (dongcode, city, gugun, dong)\r\n"
					+ "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode.getDongcode());
			pstmt.setString(2,dongCode.getCity());
			pstmt.setString(3, dongCode.getGugun());
			pstmt.setString(4, dongCode.getDong());

			
			
			pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
	public static void main(String[] args) throws IOException, SQLException {

	
		
		
		List<DongCode> arrays = new ArrayList<DongCode>(); 

		BufferedReader in = new BufferedReader(new FileReader("법정동코드 전체자료.txt"));
		String str;
		while ((str = in.readLine()) != null) {
			String arr[] = str.replaceAll("[\\t\\s ]",",").split(",");
			if (arr.length==5 && arr[4].equals("존재")) {
				DongCode tmp = new DongCode(arr[0],arr[1],arr[2],arr[3]);
				arrays.add(tmp);
			}
		}
		
		

	
		
		for (DongCode dongCode : arrays) {
			register(dongCode);
			
		}
		
		
		in.close();
		
		

	}

}
