package com.projectbru.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectbru.demo.dao.AdminDao;
import com.projectbru.demo.model.AdminBean;


@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao ;
	
	@RequestMapping("/1234")
	public String login(Model model) {
		model.addAttribute("messessError","");
		return "adminlogin";
	}
	
	@RequestMapping("/adminlogin")
	public String outhenlogin( String username ,String password, Model model ,HttpServletRequest request, String status  ) {
		String outhen ="";
		AdminBean bean = new AdminBean();
		List<AdminBean> findAll = new ArrayList<AdminBean>();
		try {
			bean = adminDao.admin(username, password);
			findAll = adminDao.findAll();
			if(bean.getAdminUsername()!=null){
				request.getSession().setAttribute("LoginMember", bean);
				request.getSession().setAttribute("listMember", findAll);
			outhen = "welcome";
			}else {
		 model.addAttribute("messessError", "F");
		       outhen ="adminlogin";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return outhen;
	}
	//End Class
}


