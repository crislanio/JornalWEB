package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.model.Secao;
import br.ufc.model.Usuario;

public class SecaoDAO {
	private Connection conn;

	public SecaoDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Secao secao) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO secao " + "(titulo,descricao)"
				+ "values (?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, secao.getTitulo());
			stmt.setString(2, secao.getDescricao());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Secao> getListar() {
		ArrayList<Secao> secoes = new ArrayList<Secao>();

		String sql = "SELECT titulo,descricao FROM secao";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Secao u = new Secao();
				u.setTitulo(rs.getString(1));
				u.setDescricao(rs.getString(2));
				secoes.add(u);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secoes;
	}

}
