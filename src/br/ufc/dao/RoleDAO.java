package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.model.Role;

public class RoleDAO {
	private Connection conn;

	public RoleDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Role role) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO role " + "(login,role)" + "values (?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, role.getLogin());
			stmt.setString(2, role.getRole());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
