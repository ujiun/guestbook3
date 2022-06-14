package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	// 필드
	@Autowired
	private GuestbookService GuestbookService;
	
	// 생성자

	// 메소드-gs

	// 메소드-일반
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController>list");
		
		List<GuestbookVo> gList = GuestbookService.getList();
		
		model.addAttribute("gList", gList);
		return "addList";
	}
	
	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>add");
		
		int count = GuestbookService.insert(vo);
		
		System.out.println(count);
		return "redirect:list";
	}
	
	
	@RequestMapping(value="/deleteForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("GuestbookController>deleteForm");
		System.out.println(no);
		
		model.addAttribute("no", no);
		return "deleteForm";
	}
	
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>delete");
		
		System.out.println(vo);
		
		int count = GuestbookService.delete(vo);
		
		System.out.println(count);
		
		return "redirect:list";
		
	}
	
	
	
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST} )
	public String test() {
		System.out.println("GuestbookController>test");

		return "";
	}

}
