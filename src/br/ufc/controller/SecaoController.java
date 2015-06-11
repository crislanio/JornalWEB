package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Role;
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
	
	
	@RequestMapping("cadastrarSecao")
	private String addSecao(Secao secao){
		System.out.println(secao.getTitulo());
		System.out.println(secao.getDescricao());
		secaoDAO.add(secao);
		return "secao/secao_adicionado";
	}
	@RequestMapping("listarSecao")
	public String listarSecao(Model model) {

		List<Secao> secoes = secaoDAO.listar();
		model.addAttribute("secoes", secoes);
		model.addAttribute("tamanho", secoes.size());

		return "usuario/listar_secao";
	}
	
	@RequestMapping("deletarSecao")
	public String removerSecao(Secao s) {

		secaoDAO.deletar(s); 
		
		return "redirect:listarSecao";
	}
}
