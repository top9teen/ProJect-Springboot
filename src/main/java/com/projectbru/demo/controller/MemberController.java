package com.projectbru.demo.controller;

import java.util.ArrayList;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectbru.demo.dao.MemberDao;
import com.projectbru.demo.model.MemberBean;

@Controller
public class MemberController {

	@Autowired
	 MemberDao memberDao;
	
	@RequestMapping("/")
	public String login(Model model) {
		model.addAttribute("messessError","");
		return "login";
	}
	@RequestMapping("/11")
	public String test() {
		return "welcomeMember";
	}
	// goto register
	@RequestMapping("/gotoregister")
	public String gotoInsert(Model model) {	
		model.addAttribute("messes", "");
		return "register";
	}
	
	// Loging Member
	@RequestMapping("/login")
	public String outhenlogin( String username ,String password, Model model ,HttpServletRequest request, String status  ) {
		String outhen ="";
		MemberBean bean = new MemberBean();
		List<MemberBean> findAll = new ArrayList<MemberBean>();
		try {
			bean = memberDao.meber(username, password);
			findAll = memberDao.findAll();
			if(bean.getMemUsername()!=null){
				request.getSession().setAttribute("LoginMember", bean);
				request.getSession().setAttribute("listMember", findAll);
				 model.addAttribute("messessError","L");
			outhen = "welcomeMember";
			}else {
		 model.addAttribute("messessError", "F");
		       outhen ="login";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return outhen;
	}
	
	@RequestMapping("/logout")
	public String Loout(HttpServletRequest request , Model model) {
		request.getSession().removeAttribute("LoginMember");
		request.getSession().removeAttribute("listMember");
		 model.addAttribute("messessError","L");
		 return  "login";
	}
	
	//Register  Not SEC
	@RequestMapping("/register")
	public String insert(Model model,@ModelAttribute("SpringWeb")MemberBean memberBean,String password) {	
		MemberBean bean = new MemberBean();
		bean.setMemUsername(memberBean.getMemUsername());
		bean.setMemPassword(password);
		try {
			memberDao.insert(memberBean);
			model.addAttribute("messes", "S");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("messes", "F");
		}
		return "register";
	}
	// End Class
}
