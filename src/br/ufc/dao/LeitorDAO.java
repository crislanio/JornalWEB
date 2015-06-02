package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.model.Leitor;
import br.ufc.model.Usuario;

public class LeitorDAO {
	private Connection conn;

	public LeitorDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Leitor leitor) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO leitor " + "(nome,login,senha,email)"
				+ "values (?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, leitor.getNome());
			stmt.setString(2, leitor.getLogin());
			stmt.setString(3, leitor.getSenha());
			stmt.setString(4, leitor.getEmail());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_leitor(Leitor leitor) {

		String sql = "delete from leitor where login = ?";

		try {

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, leitor.getLogin());
			stm.executeUpdate();

			stm.close();

			System.out.println("Deletado com Sucesso!!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Leitor> getListar() {
		ArrayList<Leitor> leitores = new ArrayList<Leitor>();

		String sql = "SELECT nome,login,senha,email FROM leitor";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Leitor u = new Leitor();
				u.setNome(rs.getString(1));
				u.setLogin(rs.getString(2));
				u.setSenha(rs.getString(3));
				u.setEmail(rs.getString(4));
				leitores.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leitores;
	}

}
