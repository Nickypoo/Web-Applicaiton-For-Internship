package com.Project.Presentation;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import net.rithms.riot.api.RiotApiException;

import com.Project.Logic.SummonerModel;




@Controller
public class MainController {
	

	@Autowired
	private SummonerModel Summoner;


	@RequestMapping(value="/index", method=RequestMethod.GET)
	    public String Home(Model model) {
	        model.addAttribute("Summoner", new SummonerModel());
	        return "index";
	    }
	 
	
	 @RequestMapping(value="/Summoner", method=RequestMethod.POST)
	    public String SummonerSubmit(@ModelAttribute SummonerModel Summoner, Model model) throws RiotApiException  {
		 	model.addAttribute("Summoner", new SummonerModel());
		 	Summoner.setConfig();
	        model.addAttribute("username",Summoner.getUsername());
	        model.addAttribute("id",Summoner.getAccountID());
	        model.addAttribute("level",Summoner.getSummonerLevel());
	        model.addAttribute("solo",Summoner.getSoloStats());
	        return "result";
	    }
	 
	 
	 
	 @RequestMapping(value="/about" , method=RequestMethod.GET)
		public String about (Model model) {
		 model.addAttribute("Summoner", new SummonerModel());
			return "about";
		}
	 
	 
	 
	 
	 @RequestMapping(value="/contact" , method=RequestMethod.GET)
		public String contact(Model model) {
		 model.addAttribute("Summoner", new SummonerModel());
			return "contact";
		}
	 
	 
	 @ResponseStatus(value=HttpStatus.CONFLICT,reason="No summoner Name") 
		@ExceptionHandler(RiotApiException.class)
		public String error(Model model) {
		 return "error";
	 	}
	 
	 
	 @RequestMapping("/")
	 public RedirectView localRedirect() {
	     RedirectView redirectView = new RedirectView();
	     redirectView.setUrl("/index.html");
	     return redirectView;
	 	}
	
}
