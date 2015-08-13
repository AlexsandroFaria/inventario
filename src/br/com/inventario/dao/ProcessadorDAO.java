package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.Processador;

public class ProcessadorDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	
	public ProcessadorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrarProcessador(Processador processador){
		String sql = "insert into processador(processador)values(?)";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, processador.getProcessador());
			
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
	
	public List<Processador> getLista(){
		try {
			List<Processador>processadores = new ArrayList<Processador>();
			pstm = this.connection.prepareStatement("select * from processador");
			rs = pstm.executeQuery();
			
			while(rs.next()){
				processadores.add(populaProcessador(rs));
			}
			
			return processadores;
			
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

	private Processador populaProcessador(ResultSet rs) throws SQLException {
		Processador processador = new Processador();
		processador.setIdProcessador(rs.getInt("id_processador"));
		processador.setProcessador(rs.getString("processador"));
		
		return processador;
	}
	
	public void excluirProcessador(Processador processador){
		String sql = "delete from processador where id_processador = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, processador.getIdProcessador());
			pstm.execute();
			
		} catch (SQLException sqle) {
			throw new RuntimeException();
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (Exception sqle2) {
				sqle2.printStackTrace();
			}
		}
	}
	
}
