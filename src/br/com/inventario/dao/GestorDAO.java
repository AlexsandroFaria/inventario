package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.Gestor;

public class GestorDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	
	public GestorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrarGestor(Gestor gestor){
		String sql = "insert into gestor (nome, setor) values(?,?)";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, gestor.getNome());
			pstm.setString(2, gestor.getSetor());
			
			pstm.execute();
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}
	
	public List<Gestor> getLista(){
		try {
			List<Gestor>gestores = new ArrayList<Gestor>();
			pstm = this.connection.prepareStatement("select * from gestor");
			rs = pstm.executeQuery();
			
			while (rs.next()){
				gestores.add(populaGestor(rs));
			}
			
			return gestores;
			
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally{
			try {
				pstm.close();
				rs.close();
				connection.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			
		}
	}

	private Gestor populaGestor(ResultSet rs) throws SQLException {
		Gestor gestor = new Gestor();
		gestor.setIdGestor(rs.getInt("id_gestor"));
		gestor.setNome(rs.getString("nome"));
		gestor.setSetor(rs.getString("setor"));
		
		return gestor;
	}
	
	public void excluirGestor(Gestor gestor){
		String sql = "delete from gestor where id_gestor = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, gestor.getIdGestor());
			pstm.execute();
			
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}
	
}
