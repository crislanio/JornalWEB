package br.ufc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FabricaDeConexoes;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Controller
public class JornalController {
	@RequestMapping("formularioUsuario")
	public String formularioUsuario() {
		return "inserir_usuario";
	}

	@RequestMapping("adicionarUsuario")
	public String adicionarUsuario(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			return "inserir_usuario";
		}

		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO aDAO = new UsuarioDAO(conn);

		aDAO.inserir(usuario);

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "usuario_adicionado";
	}
// notícia
	@RequestMapping("formularioNoticia")
	public String formularioNoticia() {
		return "inserir_noticia";
	}

	@RequestMapping("adicionarNoticia")
	public String adicionarNoticia(@Valid Noticia noticia, BindingResult result) {

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

	@RequestMapping("listarUsuario")
	public String listarUsuario(Model model) {

		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO uDAO = new UsuarioDAO(conn);

		List<Usuario> usuarios = uDAO.getListar();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tamanho", usuarios.size());

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listar_usuarios";
	}
	
	@RequestMapping("deletarUsuario")
	public String removerAluno(Usuario u) {
		
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO uDAO = new UsuarioDAO(conn);

		uDAO.delete_aluno(u);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:listarUsuario";
	}
}
