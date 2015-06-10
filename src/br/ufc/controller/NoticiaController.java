package br.ufc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping("formularioNoticia")
	public String formularioNoticia(Model model){
		
		List<Secao> categoriaNoticias = secaoDAO.listar();
		model.addAttribute("categoriaNoticias",categoriaNoticias);
		return "noticia/inserir_noticia";
		
	}
	
	@RequestMapping("adicionarNoticia")
	public String addNoticia(BindingResult result, Noticia noticia,long id_autor,long id_secao){
		if (result.hasErrors()) {
			return "inserir_noticia";
		}
		//Buscar usuário autor
		Usuario usuario = new Usuario();
		usuario.setId_usuario(id_autor);
		usuario = usuarioDAO.buscar(usuario);
		//Buscar Seção
		Secao secao = new Secao();
		secao.setId_secao(id_secao);
		secao = secaoDAO.buscar(secao);
		
		noticia.setAutor(usuario);
		noticia.setSecao(secao);
		noticia.setData_noticia(new Date());
		noticiaDAO.add(noticia);
		
		return "redirect:formularioNoticia";
	} 
	
	@RequestMapping("listarNoticia")
	public String listaNoticias(Model model){
		List<Noticia> noticias = noticiaDAO.listar();
		model.addAttribute("noticias", noticias);
		model.addAttribute("tamanho", noticias.size());
		
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("deletarNoticia")
	public String apagarNoticias(Noticia noticia){
		System.err.println(noticia.getId_noticia());
		
		noticiaDAO.deletar(noticia);
		return "redirect:listar_noticia";
	}

	
	@RequestMapping("ler_noticia")
	public String lerNoticia(Noticia noticia,Model model){
		noticia = noticiaDAO.buscar(noticia);
		model.addAttribute("noticia",noticia);
		return "noticia/noticia";
	}
	
	
	
	
	
	@RequestMapping("manchete")
	public String manchete(Secao secao,Model model){
		secao = secaoDAO.buscar(secao);
		List<Noticia> noticias = secao.getNoticias();
		System.out.println("AQUIIIIIIIIIIIIIIIIIIIII");
		for (Noticia noticia : noticias) {
			System.out.println(noticia.getSubtitulo()+"");
		}
		System.out.println("AQUIIIIIIIIIIIIIIIIIIIII");
		model.addAttribute("noticias",noticias);
		return "noticia/manchete";
	}
	
	
	@RequestMapping("lita_secoes")
	public String listaSecoes(Model model){
		List<Secao> secoes = secaoDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/secoes";
	}
	

}
