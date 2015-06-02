package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import br.ufc.model.Role;
import br.ufc.model.Usuario;

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
			stmt.setString(1, role.getId());
			stmt.setString(2, role.getRole());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete_role(Role role) {

		String sql = "delete from role where id = ?";

		try {

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, role.getId());
			stm.executeUpdate();

			stm.close();

			System.out.println("Deletado com Sucesso!!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ArrayList<Role> getListar() {
		ArrayList<Role> roles = new ArrayList<Role>();

		String sql = "SELECT id,role FROM usuario";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Role u = new Role();
				u.setId(rs.getString(1));
				u.setRole(rs.getString(2));
				roles.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}
	public Vector<Role> getBuscar(Role role) {
		Vector<Role> resultados = new Vector<Role>();
		String sql = ("SELECT * FROM role WHERE role LIKE '" + role + "%';");
		ResultSet rs;
		try {
			PreparedStatement comando = conn.prepareStatement(sql);

			rs = comando.executeQuery();

			while (rs.next()) {
				Role temp = new Role();
				// pega todos os atributos do Role
				temp.setId(rs.getString("login"));
				temp.setRole(rs.getString("role"));
				resultados.add(temp);
			}
			rs.close();
			comando.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultados;
	}
	public Role getRole(Role role) {
		String sql = "SELECT * FROM role WHERE id = " + role.getId();
		Role temp = new Role();
		ResultSet rs;
		try {

			PreparedStatement comando = conn.prepareStatement(sql);

			rs = comando.executeQuery();

			while (rs.next()) {
				temp.setId(rs.getString(1));
				temp.setRole(rs.getString(2));
			}
			rs.close();
			comando.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return temp;
	}

	
}
