package br.ufc.dao.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

public class ComentarioDAO {
	private Connection conn;

	public ComentarioDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Comentario comentario) {
		// contruindo o SQL de inserção
		String sql = "INSERT INTO comentario " + "(noticia,autor,texto)"
				+ "values (?,?,?)";
		// e o id da seção ?
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, comentario.getNoticia()); // como eu falei é int?
			stmt.setString(2, comentario.getAutor());
			stmt.setString(3, comentario.getTexto());

			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
