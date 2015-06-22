package br.ufc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	private UsuarioDAO uDAO;
	@Autowired
	private NoticiaDAO nDAO;
	@Autowired
	private SecaoDAO sDAO;

	@RequestMapping("lerNoticia")
	public String lerNoticia(Noticia noticia, Model model) {

		Noticia n = nDAO.buscar(noticia);
		System.out.println("noticia> " + n.getTitulo());

		model.addAttribute("noticia", n);
		return "noticia/noticia_detalhada";
	}

	@RequestMapping("verNoticia")
	public String Noticia(Model model) {

		List<Noticia> noticias = nDAO.listar();
		model.addAttribute("noticias", noticias);
		model.addAttribute("tamanho", noticias.size());
		System.out.println("Ver Noticia>>> " + noticias.toString());
		return "noticia/noticia";

	}

	@RequestMapping("formularioNoticia")
	public String formularioNoticia(Model model) {

		List<Secao> categoriaNoticias = sDAO.listar();
		model.addAttribute("categoriaNoticias", categoriaNoticias);
		return "noticia/inserir_noticia";

	}

	@RequestMapping("adicionarNoticia")
	public String adicionarNoticia(Noticia noticia, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		System.err.println(usuario);

		if (usuario == null) {
			return "redirect:formularioNoticia";
		}
		System.err.println("idsec " + noticia.getId_sec());
		noticia.setAutor(uDAO.getUserId(usuario.getId_usuario()));
		noticia.setSecao(sDAO.getSecao(noticia.getId_sec()));

		this.nDAO.add(noticia);
		return "noticia/noticia_adicionado";
	}

	@RequestMapping(value = "add_noticia", method = RequestMethod.POST)
	public String addNoticia(Noticia noticia, HttpSession session, Secao secao,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {

				String nomeImg = new Date().getTime() + "-"
						+ file.getOriginalFilename();
				String imagem = "/home/ufc/JornalSapereAude/imagens/imagens_noticia/" + nomeImg;

				System.out.println("aqui !!!");
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(imagem)));
				stream.write(bytes);
				stream.close();

				System.out.println("name image: "+nomeImg);
				// Set imagem
				noticia.setCaminho_imagem(nomeImg);
				System.out.println("deu certo!");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		System.err.println(usuario);

		if (usuario == null) {
			return "redirect:formularioNoticia";
		}
		System.err.println("idsec " + noticia.getId_sec());
		noticia.setAutor(uDAO.getUserId(usuario.getId_usuario()));
		noticia.setSecao(sDAO.getSecao(noticia.getId_sec()));

		this.nDAO.add(noticia);
		return "noticia/noticia_adicionado";
	}

	@RequestMapping("listarNoticia")
	public String listaNoticias(Model model) {
		List<Noticia> noticias = nDAO.listar();
		model.addAttribute("noticias", noticias);
		model.addAttribute("tamanho", noticias.size());

		return "noticia/listar_noticia";
	}

	@RequestMapping("deletarNoticia")
	public String deletarNoticia(Noticia noticia) {

		nDAO.deletar(noticia);
		return "noticia/listar_noticia";
	}

	@RequestMapping("deletarNoticiaGeral")
	public String deletarNoticiaGeral(Noticia noticia) {

		nDAO.deletar(noticia);
		return "noticia/noticia";
	}

}
