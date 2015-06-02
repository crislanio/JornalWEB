package br.ufc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
	public String adicionarUsuario(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			return "inserir_usuario";
		}

		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO aDAO = new UsuarioDAO(conn);
		RoleDAO papelDAO = new RoleDAO(conn);
		Role role = new Role();
		
//		role.setId(1); // obs: pedindo pra mudar pra int de long

		List<Role> papeis = new ArrayList<Role>();

		System.out.println("teste!");
		papeis.add(papelDAO.getRole(role)); // addAll tava add, 

		usuario.setListaPapeis(papeis);

		aDAO.inserir(usuario);

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "usuario_adicionado";
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

	@RequestMapping("login")
	public String realizaLogin(){
		System.out.println("logado");
		return "login";
	}

	@RequestMapping("autenticacao_login")
	public String verificaLogin(Usuario usu, HttpSession session){
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		UsuarioDAO aDAO = new UsuarioDAO(conn);
		RoleDAO papelDAO = new RoleDAO(conn);
		
		System.out.println("Aqui");
		if(aDAO.getUsuario(usu) != null){
			if(usu.getLogin().equals(aDAO.getUsuario(usu).getLogin()) 
					&& usu.getSenha().equals(aDAO.getUsuario(usu).getSenha()) ){
				session.setAttribute("usuario_logado", aDAO.getUsuario(usu));

				System.out.println("nome >"+usu.getNome());
				System.out.println("nome >>"+aDAO.getUsuario(usu).getNome());
				return "sessao/principal";
			}
			else{
				System.out.println("veio aqui");

				//Retornar mensagem de erro
				return "redirect:login";
			}
		}
		else{
			System.out.println("ate aqui");

			//Retornar mensagem de erro
			return "redirect:login";
		}	
	}
}