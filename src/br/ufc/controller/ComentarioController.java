package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Comentario;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ComentarioController {
	
	@Autowired
	private ComentarioDAO cDAO;
	@Autowired
	private NoticiaDAO nDAO;
	@Autowired
	private UsuarioDAO uDAO;
	
	@RequestMapping("Comments")
	public String Comments(String texto, long id_noticia, HttpSession session, Model model ){
		Usuario autor = (Usuario) session.getAttribute("usuario");

		Noticia noticia = nDAO.getNoticiaId(id_noticia);

		if (autor != null && autor.getRole("leitor")){
			Comentario comentario = new Comentario();
			comentario.setAutor(uDAO.buscarPorLogin(autor));
			comentario.setNoticia(nDAO.buscar(noticia));	
			comentario.setTexto(texto);
			
			this.cDAO.add(comentario);
			List <Comentario> c = noticia.getComentarios(); // setando comentarios da noticia
			c.add(comentario); // adicionando os comentarios a lista
			noticia.setComentarios(c);
			
			model.addAttribute("noticia",noticia);
			//model.addAttribute("comentarios",noticia.getComentarios()); // pegando os comentarios da notica
			model.addAttribute("comentarios", cDAO.comentarios(id_noticia));
			
			return "noticia/noticia_comentada"; 
				
		} 		
		return "redirect:Error";
	}
	
	
}
