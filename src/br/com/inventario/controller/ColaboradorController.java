package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.ColaboradorDAO;
import br.com.inventario.model.Colaborador;

@Controller
public class ColaboradorController {

	@RequestMapping("telaCadastroColaborador")
	public String telaCadastroColaborador(){
		return "gestao/form_cadastro_colaborador";
	}
	
	@RequestMapping("cadastroColaborador")
	public String cadastroColaborador(Colaborador colaborador){
		ColaboradorDAO dao = new ColaboradorDAO();
		dao.cadastrarColaborador(colaborador);
		return "redirect: listaColaborador";
	}
	
	@RequestMapping("listaColaborador")
	public String listaColaborador(Model model){
		ColaboradorDAO dao = new ColaboradorDAO();
		model.addAttribute("colaboradores", dao.getLista());
		return "gestao/lista_colaborador";
	}
	
	@RequestMapping("excluirColaborador")
	public String excluirColaborador(Colaborador colaborador){
		ColaboradorDAO dao = new ColaboradorDAO();
		dao.excluirColaborador(colaborador);
		return "redirect: listaColaborador";
	}
}
