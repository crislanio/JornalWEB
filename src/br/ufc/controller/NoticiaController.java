package br.ufc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FabricaDeConexoes;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Role;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Controller
public class NoticiaController {
	// notícia

	@RequestMapping("formularioNoticia")
	public String formularioNoticia(Model model, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		SecaoDAO uDAO = new SecaoDAO(conn);
		List<Secao> secoes = uDAO.getListar();

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Role role = (Role) session.getAttribute("role");
		if (usuario != null
				&& (role.getRole().equals("Jornalista") || role.getRole()
						.equals("Editor"))) {

			model.addAttribute("categoriaNoticias", secoes);

		}
		return "inserir_noticia";
	}

	@RequestMapping("adicionarNoticia")
	public String adicionarNoticia(Noticia noticia, BindingResult result) {

		if (result.hasErrors()) {
			return "inserir_noticia";
		}

		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		NoticiaDAO nDAO = new NoticiaDAO(conn);

		nDAO.inserir(noticia);

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "noticia_adicionado";
	}

}
