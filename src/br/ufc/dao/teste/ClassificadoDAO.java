package br.ufc.dao.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.ufc.model.Classificado;

public class ClassificadoDAO {
	private Connection conn;

	public ClassificadoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void inserir(Classificado classificado) {
		// contruindo o SQL de inserção
		String sql = "INSERT INTO classificado "
				+ "(id, titulo, texto ,preco , telefone, melhor_oferta, data_oferta, autor_oferta)"
				+ "values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, classificado.getId());
			
			stmt.setString(2, classificado.getTitulo());
			stmt.setString(3, classificado.getTexto());
			stmt.setFloat(4, classificado.getPreco());
			stmt.setString(5, classificado.getTelefone());
			stmt.setFloat(6, classificado.getMelhor_oferta());
			Timestamp ts = new Timestamp(classificado.getData_oferta()
					.getTime());
			stmt.setTimestamp(7, ts);
			stmt.setString(8, classificado.getAutor_oferta());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Classificado> getListar() {
		ArrayList<Classificado> classificados = new ArrayList<Classificado>();

		String sql = "SELECT id, titulo, texto ,preco , telefone, melhor_oferta, data_oferta, autor_oferta FROM classificado";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Classificado u = new Classificado();
				u.setId(rs.getLong(1));
				u.setTitulo(rs.getString(2));
				u.setTexto(rs.getString(3));
				u.setPreco(rs.getFloat(4));
				u.setTelefone(rs.getString(5));
				u.setMelhor_oferta(rs.getFloat(6));
				Date ts = new Date(u.getData_oferta().getTime());
				
				stmt.setDate(7, ts);
				u.setAutor_oferta(rs.getString(8));
				
				classificados.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classificados;
	}
}
