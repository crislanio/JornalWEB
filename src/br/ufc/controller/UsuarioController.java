package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String formularioUsuario(){
		return "usuario/inserir_usuario";
	}
	@RequestMapping("cadastrar_jornalista")
	public String formularioJornalista(){
		return "usuario/formularioJornalista";
	}
	
	@RequestMapping("adicionarUsuario")
	public String addLeitor(Usuario usuario,Role role){
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(role.getId_role());
		
		Role papel = roleDAO.buscar(role);
		List<Role> papeis = new ArrayList<Role>(); 
		papeis.add(papel);
		usuario.setRoles(papeis);
		
		
		usuarioDAO.add(usuario);
				
		return "usuario/usuario_adicionado";
	}
	
	
}
