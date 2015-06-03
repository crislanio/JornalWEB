package br.ufc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FabricaDeConexoes;
import br.ufc.dao.RoleDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Controller
public class SecaoController {
	@RequestMapping("formularioSecao")
	public String secaoForm(HttpSession session) {
		Role role = (Role) session.getAttribute("role");
		if (role != null && role.getRole().equals("Editor"))
			return "cadastrar_secao";
		else
			return "redirect:efetuarLogin";
	}

	@RequestMapping("cadastrarSecao")
	public String cadastrarSecao(Secao secao, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		SecaoDAO uDAO = new SecaoDAO(conn);
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
	}

}
