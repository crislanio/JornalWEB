package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Secao;
@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	private SecaoDAO secaoDAO;
	
	
	@RequestMapping("formularioSecao")
	/*private String formularioSecao(HttpSession session){
	*/
	private String formularioSecao(){
			
		// verificar se o cara é Editor
	//	Role role = (Role) session.getAttribute("role");
	//	System.out.println("papel "+role.getPapel());
		
		/*if (role != null && role.getPapel().equals("editor"))
			return "secao/cadastrar_secao";
		else
			return "redirect:formularioLogin";*/
		return "secao/cadastrar_secao";
	}
	@RequestMapping("formListarSecao")
	private String formListarSecao(){
		return "secao/listar_secao";
	}
	
	@RequestMapping("cadastrarSecao")
	private String addSecao(Secao secao){
		System.out.println("titulo secao " +secao.getTitulo());
		System.out.println("descricao "+secao.getDescricao());
		
		secaoDAO.add(secao);
		return "secao/secao_adicionado";
	}
	@RequestMapping("listarSecao")
	public String listarSecao(Model model) {

		List<Secao> secoes = secaoDAO.listar();
		model.addAttribute("secoes", secoes);
		model.addAttribute("tamanho", secoes.size());
		System.out.println("seções tam : "+ secoes.size());
		System.out.println("seções controller : "+ secoes);
		
		return "secao/listar_secao";
	}
	
	@RequestMapping("deletarSecao")
	public String removerSecao(Secao s) {

		secaoDAO.deletar(s); 
		
		return "redirect:listarSecao";
	}
}
