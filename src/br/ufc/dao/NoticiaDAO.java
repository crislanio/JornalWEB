package br.ufc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.model.Classificado;
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
	public ArrayList<Noticia> getListar() {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();

		String sql = "SELECT titulo, subtitulo,texto , autor, data_noticia, id_secao FROM noticia";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Noticia u = new Noticia();
				u.setTitulo(rs.getString(1));
				u.setSubtitulo(rs.getString(2));
				u.setTexto(rs.getString(3));
				u.setAutor(rs.getString(4));
				
				Date ts = new Date(u.getData_noticia().getTime());
				
				stmt.setDate(5, ts);
				u.setId_secao(rs.getLong(6));
				
				noticias.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noticias;
	}
	
}
