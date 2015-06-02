package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.model.Editor;
import br.ufc.model.Jornalista;
import br.ufc.model.Leitor;
import br.ufc.model.Usuario;

public class EditorDAO {
	private Connection conn;

	public EditorDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Editor editor) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO editor " + "(nome,login,senha,email)"
				+ "values (?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, editor.getNome());
			stmt.setString(2, editor.getLogin());
			stmt.setString(3, editor.getSenha());
			stmt.setString(4, editor.getEmail());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_editor(Editor editor) {

		String sql = "delete from editor where login = ?";

		try {

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, editor.getLogin());
			stm.executeUpdate();

			stm.close();

			System.out.println("Deletado com Sucesso!!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Editor> getListar() {
		ArrayList<Editor> editores = new ArrayList<Editor>();

		String sql = "SELECT nome,login,senha,email FROM editor";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Editor u = new Editor();
				u.setNome(rs.getString(1));
				u.setLogin(rs.getString(2));
				u.setSenha(rs.getString(3));
				u.setEmail(rs.getString(4));
				editores.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return editores;
	}

}
