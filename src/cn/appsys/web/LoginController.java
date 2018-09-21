 package cn.appsys.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.backend.BackendUserService;
import cn.appsys.service.devuser.DevUserService;

@Controller
public class LoginController {
	
	@Resource 
	private DevUserService devUserService;
	
	@Resource
	private BackendUserService backendUserService ;
	
	
	/**
	 * 去管理员后台首页
	 * @return
	 */
	@RequestMapping("/manager/main")
	public String toBackendMain() {
		return "backend/main";
	}
	
	
	/**
	 * 管理员注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/manager/logout")
	public String doBacklogout(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/login";
	}
	
	/**
	 * 管理员者登录
	 * @param request
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	@RequestMapping("/dev/dobackendlogin")
	public String doBackendlogin(HttpServletRequest request,@RequestParam String userCode,@RequestParam String userPassword) {
		BackendUser loginUser = backendUserService.backendlogin(userCode,userPassword);
		if (loginUser==null) {
			request.setAttribute("error", "开发者用户名或密码错误");
			return "backendlogin";
		}
		request.getSession().setAttribute("backendUser", loginUser);
		return "redirect:/manager/main";
	}
	
	
	
	/**
	 * 开发者注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/dev/logout")
	public String doDevlogout(HttpSession session) {
		session.invalidate();
		return "redirect:/dev/login";
	}
	/**
	 * 去开发者后台首页
	 * @return
	 */
	@RequestMapping("/dev/main")
	public String toDevMain() {
		return "developer/main";
	}
	/**
	 * 开发者登录
	 * @param request
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	@RequestMapping("/dev/dologin")
	public String doDevLogin(HttpServletRequest request,@RequestParam String devCode,@RequestParam String devPassword) {
		DevUser loginUser = devUserService.login(devCode,devPassword);
		if (loginUser==null) {
			request.setAttribute("error", "开发者用户名或密码错误");
			return "devlogin";
		}
		request.getSession().setAttribute("devLoginUser", loginUser);
		return "redirect:/dev/main";
	}
	
	//后台管理和开发者平台登录入口跳转
	@RequestMapping("/manager/login")//后台管理登录
	public String toManagerLogin() {
		return "backendlogin";
	}
	
	@RequestMapping("/dev/login")//去开发者登录
	public String toDevLogin() {
		return "devlogin";
	}
}
