package br.com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inventario.connection.ConnectionFactory;
import br.com.inventario.model.Inventario;

public class InventarioDAO {

	private Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	
	public InventarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrarInventario(Inventario inventario){
		String sql = "insert into inventario(modelo, ram, so, processador, gestor, colaborador)values(?,?,?,?,?,?)";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, inventario.getModelo());
			pstm.setString(2, inventario.getRam());
			pstm.setString(3, inventario.getSo());
			pstm.setString(4, inventario.getProcessador());
			pstm.setString(5, inventario.getGestor());
			pstm.setString(6, inventario.getColaborador());
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
	
	
	public List<Inventario> getLista(){
		try {
			List<Inventario>inventarios = new ArrayList<Inventario>();
			pstm = this.connection.prepareStatement("select * from inventario");
			rs = pstm.executeQuery();
			
			while(rs.next()){
				inventarios.add(populaInventario(rs));
			}
			
			return inventarios;
			
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

	private Inventario populaInventario(ResultSet rs) throws SQLException {
		Inventario inventario = new Inventario();
		inventario.setIdInventario(rs.getInt("id_inventario"));
		inventario.setModelo(rs.getString("modelo"));
		inventario.setRam(rs.getString("ram"));
		inventario.setSo(rs.getString("so"));
		inventario.setProcessador(rs.getString("processador"));
		inventario.setGestor(rs.getString("gestor"));
		inventario.setColaborador(rs.getString("colaborador"));

		return inventario;
	}
	
	public void excluirInventario(Inventario inventario){
		String sql = "delete from inventario where id_inventario = ?";
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, inventario.getIdInventario());
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
