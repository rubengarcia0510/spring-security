package com.frankmoley.lil.adminweb.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class WebErrorController implements ErrorController{
	
	@GetMapping
	public String getErrorPage(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status!=null) {
			int statusCode=Integer.parseInt(status.toString());
			String text="";
			int notFound=HttpStatus.NOT_FOUND.value();
			switch(statusCode){
			  case 400:
				  text="page not found";
				  break;
			  case 401:
				  text="Unauthorized";
				  break;
			  case 403:
				  text="Forbidden";
				  break;
			  default:
				  text="Something went wrong";
			}
			model.addAttribute("errorText",text);
			model.addAttribute("errorCode", statusCode);
			
			
		}else {
			model.addAttribute("errorText","Unknown error");
			model.addAttribute("errorCode", "unkknown");
		}
		
		return "error";
	}
	

}
