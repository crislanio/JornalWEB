package br.ufc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO uDAO;

	@RequestMapping("formularioLogin")
	public String formularioLogin() {
		return "login/login";
	}

	@RequestMapping("fazerLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {

		Usuario usu2 = uDAO.buscarPorLogin(usuario);
		if (usuario.getSenha().equals(usu2.getSenha())
				&& usuario.getLogin().equals(usu2.getLogin())) {
			session.setAttribute("usuario", usu2);

			return "redirect:formularioLogin";
		}

		return "redirect:formularioLogin";
	}

}
