package org.judy.manager.controller;

import java.util.List;

import org.judy.common.util.PageDTO;
import org.judy.common.util.PageMaker;
import org.judy.manager.dto.ManagerDTO;
import org.judy.manager.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
@Log4j
public class ManagerController {

	private final ManagerService service;
	
	
	
	@GetMapping("/list")
	public void getList(PageDTO pageDTO, Model model ) {
//		log.info("getList...............");
		PageDTO dto = PageDTO.builder().page(pageDTO.getPage()).perSheet(pageDTO.getPerSheet()).type(pageDTO.getType()).keyword(pageDTO.getKeyword()).build();
		
		PageMaker pageMaker= new PageMaker(pageDTO, service.totalMan(dto));
		
		List<ManagerDTO> listMan = service.getManagerList(pageDTO);
		
//		model.addAttribute("pageDTO" , dto);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list" , listMan);
		
	}
	
	@GetMapping("/read")
	public void getRead(Model model) {
//		log.info("getList...............");
//		model.addAttribute("list" , service.getMemberList());
	}
}
