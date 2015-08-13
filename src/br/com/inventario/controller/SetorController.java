package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.SetorDAO;
import br.com.inventario.model.Setor;

@Controller
public class SetorController {

	@RequestMapping("telaCadastroSetor")
	public String telaCadastroSetor(){
		return "gestao/form_cadastro_setor";
	}
	
	@RequestMapping("cadastroSetor")
	public String cadastrarSetor(Setor setor){
		SetorDAO dao = new SetorDAO();
		dao.cadastrarSetor(setor);
		return "redirect: listaSetor";
	}
	
	@RequestMapping("listaSetor")
	public String listaSetor(Model model){
		SetorDAO dao = new SetorDAO();
		model.addAttribute("setores", dao.getLista());
		return "gestao/lista_setor";
	}
	
	@RequestMapping("excluirSetor")
	public String excluirSetor(Setor setor){
		SetorDAO dao = new SetorDAO();
		dao.excluirSetor(setor);
		return "redirect: listaSetor";
	}
}
