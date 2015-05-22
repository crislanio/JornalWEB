package br.ufc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.model.Noticia;

public class NoticiaDAO {
	private Connection conn;

	public NoticiaDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserir(Noticia noticia) {

		// contruindo o SQL de inserção
		String sql = "INSERT INTO noticia "
				+ "(titulo,subtitulo,texto,autor, data_noticia, id_secao)"
				+ "values (?,?,?,?,?,?)";
		// e o id da seção ?
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, noticia.getTitulo());
			stmt.setString(2, noticia.getSubtitulo());
			stmt.setString(3, noticia.getTexto());
			stmt.setString(4, noticia.getAutor());
			Date ts = new Date(noticia.getData_noticia().getTime());
	
			stmt.setDate(5, ts);
			stmt.setLong(6, noticia.getId_secao());
			
			
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
