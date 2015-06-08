package br.ufc.controller.teste;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.teste.FabricaDeConexoes;
import br.ufc.dao.teste.UsuarioDAO;
import br.ufc.model.Usuario;

@Controller
public class LoginController2 {
	@RequestMapping("form_login")
	public String formLogin() {
		return "login/tela_login";
	}

	@RequestMapping("fazerLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO uDAO = new UsuarioDAO(conn);

		Usuario usu = uDAO.getUsuario(usuario);

		if (usuario.getSenha().equals(usu.getSenha())
				&& usuario.getLogin().equals(usu.getLogin())) {
			session.setAttribute("usuario", usu);

			return "redirect:form_login";
		}

		return "redirect:form_login";
	}
}
