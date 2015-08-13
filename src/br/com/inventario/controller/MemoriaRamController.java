package br.com.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.inventario.dao.MemoriaRamDAO;
import br.com.inventario.model.MemoriaRam;

@Controller
public class MemoriaRamController {

	@RequestMapping("telaCadastroRam")
	public String cadastroRam(){
		return "perifericos/form_cadastro_ram";
	}
	
	@RequestMapping("cadastroMemoriaRam")
	public String CadastroMemoriaRam(MemoriaRam memoriaRam){
		MemoriaRamDAO dao = new MemoriaRamDAO();
		dao.cadastrarMemoriaRam(memoriaRam);
		return "redirect:listaMemoriaRam";
	}
	
	@RequestMapping("listaMemoriaRam")
	public String listaDeMemoriaRam(Model model){
		MemoriaRamDAO dao = new MemoriaRamDAO();
		model.addAttribute("memoriasRam", dao.getLista());
		return "perifericos/lista_memoria_ram";
	}
	
	@RequestMapping("excluirMemoriaRam")
	public String excluirMemoriaRam(MemoriaRam memoriaRam){
		MemoriaRamDAO dao = new MemoriaRamDAO();
		dao.excluirMemoriaRam(memoriaRam);
		return "redirect:listaMemoriaRam";
	}
}
