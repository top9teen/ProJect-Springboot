package com.projectbru.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.projectbru.demo.model.AdminBean;
import com.projectbru.demo.model.MemberBean;
import com.projectbru.demo.util.ConnectDB;


@Repository
public class AdminDao {

	public AdminBean admin(String adminUsername, String adminPassword ) {
		AdminBean bean = new AdminBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			sql.append(" SELECT * FROM admin WHERE admin_username = ? AND admin_password = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1,adminUsername);
			prepared.setString(2,adminPassword);
			
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setAdminUsername(rs.getString("admin_username"));
				bean.setAdminPassword(rs.getString("admin_password"));
			}
		
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bean ;
}
	// select member
	public 	MemberBean select () throws SQLException {
		MemberBean bean = new MemberBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		

		try {
			sql.append(" SELECT * FROM member");
			prepared = con.openConnect().prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();
			
			while (rs.next()) {
				bean.setMemId(rs.getInt("mem_id"));
				bean.setMemUsername(rs.getString("mem_username"));
				bean.setMemPassword(rs.getString("mem_password"));
				bean.setMemName(rs.getString("mem_name"));
				bean.setMemAdd(rs.getString("mem_add"));
				bean.setMemPhone(rs.getString("mem_phone"));
				bean.setMemCreateDate(rs.getString("mem_createDate"));
				bean.setMemEditdata(rs.getString("mem_editdata"));
				bean.setMemStatusdelete(rs.getInt("mem_statusdelete"));
			
				
			}
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		finally {
			if(con !=null) {
				con.openConnect().close();
			}
		}
	return bean;
	}

	  public List<AdminBean> findAll(){
		   List<AdminBean> list = new ArrayList<>();
		   ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();

			try {
				sql.append(" SELECT * FROM admin ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				ResultSet rs = prepared.executeQuery();

				while (rs.next()) {
					AdminBean bean = new AdminBean();
					bean.setAdminId(rs.getInt("admin_id"));
					bean.setAdminUsername(rs.getString("admin_username"));
					bean.setAdminPassword(rs.getString("admin_password"));
					bean.setAdminName(rs.getString("admin_name"));
	
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	   }
	
	// End Class
}