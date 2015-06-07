package br.ufc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FabricaDeConexoes;
import br.ufc.dao.RoleDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Usuario;

@Controller
public class UsuarioController {
	@RequestMapping("formularioUsuario")
	public String formularioUsuario() {
		return "inserir_usuario";
	}
	@RequestMapping("adicionarUsuario")
	public String adicionarUsuario(@Valid Usuario usuario, BindingResult result, Role role) {

		if (result.hasErrors()) {
			return "inserir_usuario";
		}

		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO aDAO = new UsuarioDAO(conn);
		RoleDAO papelDAO = new RoleDAO(conn);
		
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(role.getId()); // tá vindo null
		
		Role papel = papelDAO.getRole(role); // retorna um ROLE
		List<Role> papeis = new ArrayList<Role>(); 
		papeis.add(papel);
		
		usuario.setRoles(papeis);
	
		//Adcionar usuario com o papel 
		aDAO.inserir(usuario);
				
		return "usuario_adicionado";
	
		/*Role role = new Role();
		
//		role.setId(1); // obs: pedindo pra mudar pra int de long

		List<Role> papeis = new ArrayList<Role>();

		System.out.println("teste aqui!");
		papeis.add(papelDAO.getRole(role)); // addAll tava add, 
		System.out.println("teste 2!");
		
		usuario.setListaPapeis(papeis);
		System.out.println("teste 3!");
		
		aDAO.inserir(usuario);
		System.out.println("teste 4!");
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "usuario_adicionado";
*/	

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
	public String removerUsuario(Usuario u) {

		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO uDAO = new UsuarioDAO(conn);

		uDAO.delete_usuario(u);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:listarUsuario";
	}

}
