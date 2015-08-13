package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.Setor;

public class SetorDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	
	public SetorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrarSetor(Setor setor){
		String sql = "insert into setor(setor)values(?)";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, setor.getSetor());
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
	
	public List<Setor>getLista(){
		try {
			List<Setor>setores = new ArrayList<Setor>();
			pstm = this.connection.prepareStatement("select * from setor");
			rs = pstm.executeQuery();
			
			while(rs.next()){
				setores.add(populaSetor(rs));
			}
			
			return setores;
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

	private Setor populaSetor(ResultSet rs) throws SQLException {
		Setor setor = new Setor();
		setor.setIdSetor(rs.getInt("id_setor"));
		setor.setSetor(rs.getString("setor"));
		
		return setor;
	}
	
	public void excluirSetor(Setor setor){
		String sql = "delete from setor where id_setor = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, setor.getIdSetor());
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
