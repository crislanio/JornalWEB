package br.ufc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.criptografia.Criptografia;
import br.ufc.dao.RoleDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping("formularioUsuario")
	public String formularioUsuario() {
		return "usuario/inserir_usuario";
	}

	@RequestMapping("formularioJornalista")
	public String formularioJornalista() {
		return "usuario/inserir_jornalista";
	}

	@RequestMapping("formularioEditor")
	public String formularioEditor() {
		return "usuario/inserir_editor";
	}

	@RequestMapping(value = "adicionarUsuarioJornalista", method = RequestMethod.POST)
	public String cadastrarJornalista(@Valid Usuario usuario, Role role,
			BindingResult result, @RequestParam("file") MultipartFile file) {

		Criptografia cs = new Criptografia();
		usuario.setSenha(cs.criptografar(usuario.getSenha()));
		Role papel = roleDAO.buscar(role);
		List<Role> papeis = new ArrayList<Role>();

		papeis.add(papel);
		usuario.setRoles(papeis);

		if (!file.isEmpty()) {
			try {
				String nomeImg = new Date().getTime() + "-"
						+ file.getOriginalFilename();
				String imagem = "/home/ufc/JornalSapereAude/imagens/imagens_jornalista/"
						+ nomeImg;

				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(imagem)));
				stream.write(bytes);
				stream.close();
				usuario.setCaminho_imagem(nomeImg);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.usuarioDAO.add(usuario);

		return "usuario/usuario_adicionado";
	}

	@RequestMapping("adicionarUsuario")
	public String addUsuario(@Valid Usuario usuario, BindingResult result,
			Role role) {
		Criptografia cs = new Criptografia();
		usuario.setSenha(cs.criptografar(usuario.getSenha()));
		if (result.hasErrors()) {
			return "usuario/inserir_usuario";
		}

		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(role.getId_role());

		Role papel = roleDAO.buscar(role);
		List<Role> papeis = new ArrayList<Role>();
		papeis.add(papel);
		usuario.setRoles(papeis);
		System.err.println("Papel user : " + usuario.getRoles());

		this.usuarioDAO.add(usuario);

		return "usuario/usuario_adicionado";
	}

	@RequestMapping("listarUsuario")
	public String listarUsuario(Model model) {

		List<Usuario> usuarios = usuarioDAO.listar();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tamanho", usuarios.size());

		System.out.println("teste vazia " + usuarios.size());

		return "usuario/listar_usuarios";
	}

	@RequestMapping("deletarUsuario")
	public String removerUsuario(Usuario u) {

		usuarioDAO.deletar(u);

		return "redirect:listarUsuario";
	}
}
