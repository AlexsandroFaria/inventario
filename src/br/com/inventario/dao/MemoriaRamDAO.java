package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.MemoriaRam;

public class MemoriaRamDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet resultSet;
	
	public MemoriaRamDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrarMemoriaRam(MemoriaRam memoriaRam){
		String sql = "insert into memoriaram(quantidade, tamanho)values(?,?)";
		
		try {
		pstm = connection.prepareStatement(sql);
			
			pstm.setInt(1, memoriaRam.getQuantidade());
			pstm.setString(2, memoriaRam.getTamanho());
			
			pstm.execute();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}
	
	public List<MemoriaRam> getLista(){
		try {
			List<MemoriaRam>memoriasRam = new ArrayList<MemoriaRam>();
			pstm = this.connection.prepareStatement("select * from memoriaram");
			resultSet = pstm.executeQuery();
			
			while(resultSet.next()){
				memoriasRam.add(populaMemoriaRam(resultSet));
			}
			
			return memoriasRam;
				
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally{
			try {
				pstm.close();
				connection.close();
				resultSet.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}

	private MemoriaRam populaMemoriaRam(ResultSet resultSet) throws SQLException {
		
		MemoriaRam memoriaRam = new MemoriaRam();
		memoriaRam.setIdMemoriaRam(resultSet.getLong("id_memoriaRam"));
		memoriaRam.setQuantidade(resultSet.getInt("quantidade"));
		memoriaRam.setTamanho(resultSet.getString("tamanho"));
		
		return memoriaRam;
	}

	public void excluirMemoriaRam(MemoriaRam memoriaRam) {
		String sql="delete from memoriaram where id_memoriaRam = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setLong(1, memoriaRam.getIdMemoriaRam());
			pstm.execute();
			
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (SQLException SQLe2) {
				SQLe2.printStackTrace();
			}
		}
		
	}
	
	
	
}
