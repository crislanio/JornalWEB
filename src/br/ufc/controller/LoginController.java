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
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Usuario;

@Controller
public class LoginController {
	@RequestMapping("Login")
	public String realizaLogin(Model model) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		RoleDAO papelDAO = new RoleDAO(conn);
		List<Role> roles = papelDAO.getListar();
		model.addAttribute("papeis", roles);

		System.out.println("logado no sistema teste");
		return "login";
	}

	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, Role role, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();

		UsuarioDAO uDAO = new UsuarioDAO(conn);
		RoleDAO papelDAO = new RoleDAO(conn);

		String senha = usuario.getSenha();
		usuario = uDAO.getUsuarioSql(usuario.getLogin()); // aqui tá sobrescrito
		for (int i = 0; i < 5; i++) {
			System.out.println(" lista login: " + usuario); // nao imprime
	}
	
		role = papelDAO.getRole(role.getId()); // spbrescrito
		for (int i = 0; i < 5; i++) {
			System.out.println("login:" +role);
		}

		System.out
				.println("efetuar login role = papelDAO.getRole(role.getId())");

		if (usuario.verifica(role.getRole()) && usuario != null
				&& usuario.getSenha().equals(senha)) {
			session.setAttribute("usuario", usuario);
			session.setAttribute("role", role);

			System.out.println("nao chega aqui");

			return "index";
		} else
			return "redirect:Login";
	}

	// da dando erros
	@RequestMapping("autenticacaoLogin")
	public String verificaLogin(Usuario usu, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO aDAO = new UsuarioDAO(conn);
		RoleDAO papelDAO = new RoleDAO(conn);

		System.out.println("Aqui porra");
		if (aDAO.getUsuario(usu) != null) {
			if (usu.getLogin().equals(aDAO.getUsuario(usu).getLogin())
					&& usu.getSenha().equals(aDAO.getUsuario(usu).getSenha())) {

				session.setAttribute("usuario_logado", aDAO.getUsuario(usu));
				System.out.println("nome >" + usu.getNome());
				System.out.println("nome >>" + aDAO.getUsuario(usu).getNome());
				return "index";
			} else {
				System.out.println("veio aqui");

				// Retornar mensagem de erro
				return "redirect:login";
			}
		} else {
			System.out.println("ate aqui");

			// Retornar mensagem de erro
			return "redirect:Login";
		}
	}
}
