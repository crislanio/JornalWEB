package br.ufc.controller.teste;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.teste.FabricaDeConexoes;
import br.ufc.dao.teste.SecaoDAO;
import br.ufc.model.Role;
import br.ufc.model.Secao;

@Controller
public class SecaoController {
	@RequestMapping("formularioSecao")
	public String secaoForm(HttpSession session) {
		Role role = (Role) session.getAttribute("role");
		if (role != null && role.getRole().equals("editor"))
			return "secao/cadastrar_secao";
		else
			return "redirect:efetuarLogin";
	}

	@RequestMapping("cadastrarSecao")
	public String cadastrarSecao(Secao secao, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		SecaoDAO uDAO = new SecaoDAO(conn);
		
		/*	
		  if (session != null) {
			System.out.println("teste 1");

			Role role = (Role) session.getAttribute("role");
			if (role.getRole().equals("Editor")) {
				System.out.println("teste 2");

				uDAO.inserir(secao);
				System.out.println("teste 3");

				return "secao_adicionado";
			}
		}
		return "redirect:efetuarLogin";
*/
		System.out.println(secao.getTitulo());
		System.out.println(secao.getDescricao());
		uDAO.inserir(secao);
		return "secao/secao_adicionado";
	}
}
