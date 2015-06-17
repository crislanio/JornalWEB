package br.ufc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NoticiaController {
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private NoticiaDAO noticiaDAO;
	@Autowired
	private SecaoDAO secaoDAO;

	@RequestMapping("verNoticia")
	public String Noticia(Model model) {

		List<Noticia> noticias = noticiaDAO.listar();
		model.addAttribute("noticias", noticias);
		model.addAttribute("tamanho", noticias.size());
		System.out.println("Ver Noticia>>> " + noticias.toString());
		return "noticia/noticia";

	}

	@RequestMapping("formularioNoticia")
	public String formularioNoticia(Model model) {

		List<Secao> categoriaNoticias = secaoDAO.listar();
		model.addAttribute("categoriaNoticias", categoriaNoticias);
		return "noticia/inserir_noticia";

	}

	@RequestMapping("adicionarNoticia")
	public String addNoticia(Noticia noticia, long id_autor, long id_secao) {
		System.err.println("chegou porra");
		
		// Search Author
		Usuario usuario = new Usuario();
		usuario.setId_usuario(id_autor);
		System.out.println("id user> " + id_autor);

		usuario = usuarioDAO.buscar(usuario);

		// Searche Section
		Secao secao = new Secao();
		secao.setId_secao(id_secao);
		System.out.println("id secao> " + id_secao);

		secao = secaoDAO.buscar(secao);

		noticia.setAutor(usuario);
		noticia.setSecao(secao);
		noticia.setData_noticia(new Date());
		noticiaDAO.add(noticia);

		// teste
		System.err.println("noticia  " + noticia.getId_noticia());
		System.err.println("titulo  " + noticia.getTitulo());
		System.err.println("autor  " + noticia.getAutor());
		System.err.println("secao  " + secao.getTitulo());

		return "usuario/noticia_adicionado";
	}

	@RequestMapping("listarNoticia")
	public String listaNoticias(Model model) {
		List<Noticia> noticias = noticiaDAO.listar();
		model.addAttribute("noticias", noticias);
		model.addAttribute("tamanho", noticias.size());

		return "noticia/listar_noticia";
	}

	@RequestMapping("deletarNoticia")
	public String apagarNoticias(Noticia noticia) {
		System.err.println(noticia.getId_noticia());

		noticiaDAO.deletar(noticia);
		return "redirect:listar_noticia";
	}

	@RequestMapping("ler_noticia")
	public String lerNoticia(Noticia noticia, Model model) {
		noticia = noticiaDAO.buscar(noticia);
		model.addAttribute("noticia", noticia);
		return "noticia/noticia";
	}

}
