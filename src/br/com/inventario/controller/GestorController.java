package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.GestorDAO;
import br.com.inventario.model.Gestor;

@Controller
public class GestorController {

	@RequestMapping("telaCadastroGestor")
	public String telaCadastroGestor(){
		return "gestao/form_cadastro_gestor";
	}
	
	@RequestMapping("cadastroGestor")
	public String cadastroGestor(Gestor gestor){
		GestorDAO dao = new GestorDAO();
		dao.cadastrarGestor(gestor);
		return "redirect: listaGestor";
	}

	@RequestMapping("listaGestor")
	public String listaGestor(Model model){
		GestorDAO dao = new GestorDAO();
		model.addAttribute("gestores", dao.getLista());
		return "gestao/lista_gestor";
	}
	
	@RequestMapping("excluirGestor")
	public String excluirGestor(Gestor gestor){
		GestorDAO dao = new GestorDAO();
		dao.excluirGestor(gestor);
		return "redirect: listaGestor";
	}
}
