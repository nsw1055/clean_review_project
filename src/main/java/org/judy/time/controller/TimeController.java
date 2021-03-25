package org.judy.time.controller;

import org.judy.time.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/time")
@RequiredArgsConstructor
public class TimeController {
	
	private final TimeService service;
	
	@GetMapping("/now")
	public void getTime(Model model) {
		service.getTime();
		model.addAttribute("now" , service.getTime());
	}
}
