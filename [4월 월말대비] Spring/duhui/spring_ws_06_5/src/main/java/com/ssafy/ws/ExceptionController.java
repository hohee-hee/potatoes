package com.ssafy.ws;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model, Exception e) {
		
		model.addAttribute("msg", e.getMessage());
				
		return "error/errorpage";
	}
}
