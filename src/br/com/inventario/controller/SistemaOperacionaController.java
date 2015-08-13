package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.SistemaOperacionalDAO;
import br.com.inventario.model.SistemaOperacional;

@Controller
public class SistemaOperacionaController {

	@RequestMapping("telaCadastroSo")
	public String telaCadastroSo() {
		return "perifericos/form_cadastro_so";
	}

	@RequestMapping("cadastroSistemaOperacional")
	public String cadastroSistemaOperacional(SistemaOperacional so) {
		SistemaOperacionalDAO dao = new SistemaOperacionalDAO();
		dao.cadastrarSistemaOperacional(so);
		return "redirect:listaSistemaOperacional";
	}
	
	@RequestMapping("listaSistemaOperacional")
	public String listaSo(Model model){
		SistemaOperacionalDAO dao = new SistemaOperacionalDAO();
		model.addAttribute("sistemasOperacionais", dao.getLista());
		return "perifericos/lista_so";
	}
	
	@RequestMapping("excluirSo")
	public String excluirSo(SistemaOperacional so){
		SistemaOperacionalDAO dao = new SistemaOperacionalDAO();
		dao.excluirSo(so);
		return "redirect:listaSistemaOperacional";
	}
}
