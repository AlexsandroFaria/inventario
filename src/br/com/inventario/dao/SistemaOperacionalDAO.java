package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.SistemaOperacional;

public class SistemaOperacionalDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet rs;

	public SistemaOperacionalDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarSistemaOperacional(SistemaOperacional so) {
		String sql = "insert into sistemaoperacional(sistemaoperacional)values(?)";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, so.getSistemaOperacional());
			pstm.execute();

		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		} finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}
	
	public List<SistemaOperacional> getLista(){
		try {
			List<SistemaOperacional>sistemasOperacionais = new ArrayList<SistemaOperacional>();
			pstm = this.connection.prepareStatement("select * from sistemaoperacional");
			rs = pstm.executeQuery();
			
			while(rs.next()){
				sistemasOperacionais.add(populaSo(rs));
			}
			
			return sistemasOperacionais;
				
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally{
			try {
				pstm.close();
				connection.close();
				rs.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}

	private SistemaOperacional populaSo(ResultSet rs) throws SQLException {
		SistemaOperacional so = new SistemaOperacional();
		
		so.setIdSistemaOperacional(rs.getInt("id_sistemaOperacional"));
		so.setSistemaOperacional(rs.getString("sistemaoperacional"));
		
		return so;
	}

	public void excluirSo(SistemaOperacional so){
		String sql = "delete from sistemaoperacional where id_sistemaOperacional = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, so.getIdSistemaOperacional());
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