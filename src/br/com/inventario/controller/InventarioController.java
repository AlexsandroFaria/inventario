package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.InventarioDAO;
import br.com.inventario.model.Inventario;

@Controller
public class InventarioController {

	@RequestMapping("telaCadastroInventario")
	public String telaCadastroInventário() {
		return "inventario/form_cadastro_inventario";
	}

	@RequestMapping("cadastroInventario")
	public String cadastroInventario(Inventario inventario) {
		InventarioDAO dao = new InventarioDAO();
		dao.cadastrarInventario(inventario);
		return "redirect: listaInventario";
	}

	@RequestMapping("listaInventario")
	public String listarInventario(Model model) {
		InventarioDAO dao = new InventarioDAO();
		model.addAttribute("inventarios", dao.getLista());
		return "inventario/lista_inventario";
	}
	
	@RequestMapping("excluirInventario")
	public String excluirInventario(Inventario inventario){
		InventarioDAO dao = new InventarioDAO();
		dao.excluirInventario(inventario);
		return "redirect: listaInventario";
	}
}
