package br.ufc.dao.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.model.Jornalista;
import br.ufc.model.Leitor;
import br.ufc.model.Usuario;

public class JornalistaDAO {
	private Connection conn;

	public JornalistaDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Jornalista jornalista) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO jornalista " + "(nome,login,senha,email)"
				+ "values (?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, jornalista.getNome());
			stmt.setString(2, jornalista.getLogin());
			stmt.setString(3, jornalista.getSenha());
			stmt.setString(4, jornalista.getEmail());
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_jornalista(Jornalista jornalista) {

		String sql = "delete from jornalista where login = ?";

		try {

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, jornalista.getLogin());
			stm.executeUpdate();

			stm.close();

			System.out.println("Deletado com Sucesso!!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Jornalista> getListar() {
		ArrayList<Jornalista> jornalistas = new ArrayList<Jornalista>();

		String sql = "SELECT nome,login,senha,email FROM jornalista";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Jornalista u = new Jornalista();
				u.setNome(rs.getString(1));
				u.setLogin(rs.getString(2));
				u.setSenha(rs.getString(3));
				u.setEmail(rs.getString(4));
				jornalistas.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jornalistas;
	}

}
