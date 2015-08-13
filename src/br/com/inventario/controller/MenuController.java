package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	@RequestMapping("inicio")
	public String inicio(){
		return "principal/principal";
	}
	
	@RequestMapping("telaPerifericos")
	public String telaPerifericos(){
		return "menu/menu_perifericos";
	}
	
	@RequestMapping("telaGestao")
	public String telaGestao(){
		return "menu/menu_gestao";
	}
	
	@RequestMapping("telaSobre")
	public String sobre(){
		return "menu/sobre";
	}
}
