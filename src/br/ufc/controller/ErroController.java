package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
@Transactional
@Controller
public class ErroController {
	
	@RequestMapping("Error")
	public String Error(){
		return "erro/pagina_erro";
	}
	
	
}
