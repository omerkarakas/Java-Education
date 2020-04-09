package com.omer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {

	@RequestMapping("/sayfa1")
	public String sayfa1() {
		
		return "sayfa1";
	}
}
