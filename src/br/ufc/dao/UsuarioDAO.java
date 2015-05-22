package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.model.Usuario;

public class UsuarioDAO {
	private Connection conn;

	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Usuario usuario) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO usuario " + "(nome,login,senha,email)"
				+ "values (?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getEmail());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_usuario(Usuario usuario) {

		String sql = "delete from usuario where login = ?";

		try {

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.executeUpdate();

			stm.close();

			System.out.println("Deletado com Sucesso!!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usuario> getListar() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "SELECT nome,login,senha,email FROM usuario";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString(1));
				u.setLogin(rs.getString(2));
				u.setSenha(rs.getString(3));
				u.setEmail(rs.getString(4));
				usuarios.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}

}
