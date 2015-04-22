package br.ufc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufc.model.Classificado;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

public class ClassificadoDAO {
	private Connection conn;

	public ClassificadoDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Classificado classificado) {
		// contruindo o SQL de inserção
		String sql = "INSERT INTO noticia "
				+ "(titulo,texto,preco,telefone, melhor_oferta, data_oferta, autor_oferta)"
				+ "values (?,?,?,?,?,?,?)";
		// e o id da seção ?
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, classificado.getTitulo());
			stmt.setString(2, classificado.getTexto());
			stmt.setFloat(3, classificado.getPreco());
			stmt.setString(4, classificado.getTelefone());
			stmt.setFloat(5, classificado.getMelhor_oferta());
			Timestamp ts = new Timestamp(classificado.getData_oferta()
					.getTime());
			stmt.setTimestamp(6, ts);
			stmt.setString(7, classificado.getAutor_oferta());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
