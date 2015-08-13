package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.ProcessadorDAO;
import br.com.inventario.model.Processador;

@Controller
public class ProcessadorController {

	@RequestMapping("telaCadastroProcessador")
	public String telaCadastroProcessador(){
		return "perifericos/form_cadastro_processador";
	}
	
	@RequestMapping("cadastroProcessador")
	public String cadastroProcessador(Processador processador){
		ProcessadorDAO dao = new ProcessadorDAO();
		dao.cadastrarProcessador(processador);
		return "redirect:listaProcessador";
	}
	
	
	@RequestMapping("listaProcessador")
	public String listarProcessador(Model model){
	ProcessadorDAO dao = new ProcessadorDAO();
	model.addAttribute("processadores", dao.getLista());
	return "perifericos/lista_processador";
	}
	
	
	@RequestMapping("excluirProcessador")
	public String excluirProcessador(Processador processador){
		ProcessadorDAO dao = new ProcessadorDAO();
		dao.excluirProcessador(processador);
		return "redirect:listaProcessador";
	}
}
