package com.ssafy.ws;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.UserServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private ResourceLoader resLoader;

	@GetMapping({"/", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("error/404")
	public String errorPage() {
		return "error/404";
	}
	
	@GetMapping("list")
	public String doList(Model model) {
		model.addAttribute("users", userServiceImpl.getAll());
		return "list";
	}
	
	@GetMapping("regist")
	public String registForm() {
		return "regist";
	}
	
	@PostMapping("regist")
	public String regist(Model model, User user, @RequestPart(required = false) MultipartFile file) throws IOException {
		if(userServiceImpl.getById(user.getUserId()) != null) {
			model.addAttribute("msg", "아이디가 중복됩니다.");
			return "/regist";
		}
		
		Resource res = resLoader.getResource("/resources/upload");
		
		if(res.getFile().exists())
			res.getFile().mkdir();
		
		user.setOrgImg(file.getOriginalFilename());
		
		// 필요없는 과정이긴한데,, 기존에 있던 SQL 변경하기 귀찮아서 파일명 짧게 만듦..
		int idx = file.getOriginalFilename().lastIndexOf('.');
		String tmp = file.getOriginalFilename().substring(idx);
		String shortUUID = UUID.randomUUID().toString().substring(0, 4);
		user.setImg(shortUUID + tmp);
				
		
		file.transferTo(new File(res.getFile(), user.getImg()));
		
		return "regist_result";
	}
	
	@GetMapping("result")
	public String result(Model model, String userId) {
		User user = userServiceImpl.getById(userId);
		
		model.addAttribute("user", user);
		
		return "regist_result";
	}
	
	@GetMapping("download")
	public String download(Model model, String fileName) {
		Map<String, Object> fileInfo = new HashMap<>();
		
	    fileInfo.put("fileName", fileName);
	    model.addAttribute("downloadFile", fileInfo);
	    
	    return "fileDownLoadView";
	}
	
	@PostMapping("login")
	public String login(HttpSession session, User user) {
	    User loginUser = userServiceImpl.getById(user.getUserId());
	    if(loginUser != null && loginUser.getUserPass().equals(user.getUserPass())) {
	        session.setAttribute("loginUser", loginUser);
	    }
	    return "redirect:/home"; // 수정된 부분
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:/home";
	}
	
	

}
