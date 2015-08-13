package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.Colaborador;

public class ColaboradorDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	
	public ColaboradorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrarColaborador(Colaborador colaborador){
		String sql = "insert into colaborador(nome, cpf, gestor, setor)values(?,?,?,?)";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, colaborador.getNome());
			pstm.setString(2, colaborador.getCpf());
			pstm.setString(3, colaborador.getGestor());
			pstm.setString(4, colaborador.getSetor());
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
	
	public List<Colaborador> getLista(){
		try {
			List<Colaborador>colaboradores = new ArrayList<Colaborador>();
			pstm = this.connection.prepareStatement("select * from colaborador");
			rs = pstm.executeQuery();
			
			while(rs.next()){
				colaboradores.add(populaColaborador(rs));
			}
			
			return colaboradores;
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

	private Colaborador populaColaborador(ResultSet rs) throws SQLException {
		Colaborador colaborador = new Colaborador();
		colaborador.setIdColaborador(rs.getInt("id_colaborador"));
		colaborador.setNome(rs.getString("nome"));
		colaborador.setCpf(rs.getString("cpf"));
		colaborador.setGestor(rs.getString("gestor"));
		colaborador.setSetor(rs.getString("setor"));
		
		return colaborador;
	}
	
	public void excluirColaborador(Colaborador colaborador){
		String sql = "delete from colaborador where id_colaborador = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, colaborador.getIdColaborador());
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
