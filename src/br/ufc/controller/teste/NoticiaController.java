package br.ufc.controller.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.teste.FabricaDeConexoes;
import br.ufc.dao.teste.NoticiaDAO;
import br.ufc.dao.teste.SecaoDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Role;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Controller
public class NoticiaController {
	// notícia

	@RequestMapping("verNoticia")
	public String lerNoticia(Noticia noticia,Model model){
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		NoticiaDAO uDAO = new NoticiaDAO(conn);
		
		noticia = uDAO.getNoticia(noticia);
		model.addAttribute("noticia",noticia);
		return "noticia/noticias";
	}
	
	@RequestMapping("formularioNoticia")
	public String formularioNoticia(Model model, HttpSession session) {
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		SecaoDAO uDAO = new SecaoDAO(conn);
		List<Secao> secoes = uDAO.getListar();
		
		/*model.addAttribute("secoes",secoes);
		return "formularioNoticia";
		*/
		
		  Usuario usuario = (Usuario) session.getAttribute("usuario");
		Role role = (Role) session.getAttribute("role");
		if (usuario != null
				&& (role.getRole().equals("Jornalista") || role.getRole()
						.equals("Editor"))) {

			model.addAttribute("categoriaNoticias", secoes);

		}
		return "noticia/inserir_noticia";
		
	}

	@RequestMapping("adicionarNoticia")
	public String adicionarNoticia(Noticia noticia, BindingResult result) {

		if (result.hasErrors()) {
			return "noticia/inserir_noticia";
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

		return "listarNoticia";
	}
	@RequestMapping("listarNoticia")
	public String listaNoticia(Model model){
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		NoticiaDAO cDAO = new NoticiaDAO(conn);
		

		List<Noticia> c = cDAO.getListar();
		model.addAttribute("noticias", c);
		return "noticia/noticia";
	}
	
	}