package com.dezhi.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dezhi.action.UserEntity;
import com.dezhi.services.IUserService;

@Controller
@RequestMapping(value = "/**")
// 控制器


/**
 * 以/demo  开头
 * 
 *	配置示例  
 * @RequestMapping(value = "/user/**")
 * @RequestMapping(value = "/plug/**")
 * @author dezhi1231
 *
 */
public class HomeAction {

	@Autowired()
	private IUserService userService;
	
	
	/**
	 * 用户登录
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserEntity user, Model model) {

		UserEntity s_user = userService.findUserByUserName(user.getUsername());
			
		if (s_user != null) {
			
			if (s_user.getUserpwd().equals(user.getUserpwd())) {
				
				List<UserEntity> userlist = userService.findUserList(null);

				model.addAttribute("userlist",userlist);

				return "user";

			}
		}

		model.addAttribute("message", "用户名或者密码错误");

		return "message";
	}

	/**
	 * 添加用户信息
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(UserEntity user,Model model) {

		boolean s = userService.addUser(user);

		if (s) {

			List<UserEntity> userlist = userService.findUserList(null);

			model.addAttribute("userlist",userlist);

			return "user";
			
		}
		
		model.addAttribute("message","添加失败");	
		
		return "message";
	}
	
	/**
	 * 转到添加用户信息界面
	 * @return
	 */
	@RequestMapping(value = "/inputUser", method = RequestMethod.GET)
	public String inputUser() {
		//redirect:
		return "addUser";
	}
	
	/**
	 * 查询所有用户信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delUser/{id}", method = RequestMethod.GET)
	public String userlist(@PathVariable String id,Model model) {

		boolean s = userService.delUser(Integer.valueOf(id));
		
		if(s){
			
			List<UserEntity> userlist = userService.findUserList(null);

			model.addAttribute("userlist",userlist);

			return "user";
		}
		
		model.addAttribute("message","删除失败");	
		
		return "message";
	}
	
	

}
