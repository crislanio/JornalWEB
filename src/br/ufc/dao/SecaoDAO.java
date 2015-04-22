package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
