package apiRest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apiRest.entities.PropertyRent;

public class PropertyRentJDBCDAO implements PropertyRentDAO{

	@Override
	public void save(PropertyRent entity) {
		Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into propertyrent (titulo, endereco, metrosTerreno, metrosConstruido, quantQuartos, quantBanheiros, quantGaragem, preco) values (?, ?, ?, ?, ?, ?, ?, ?)";
            String update_sql = "update propertyrent set titulo = ?, endereco = ?, metrosTerreno = ?, metrosConstruido = ?, quantQuartos = ?, quantBanheiros = ?, quantGaragem = ?, preco = ? where id = ?";
            PreparedStatement pst;
            if (entity.getId() == 0) {
                pst = con.prepareStatement(insert_sql);
            } else {
                pst = con.prepareStatement(update_sql);
                pst.setInt(9, entity.getId());
            }
            pst.setString(1, entity.getTitulo());
            pst.setString(2, entity.getEndereco());
            pst.setString(3, entity.getMetrosTerreno());
            pst.setString(4, entity.getMetrosContruido());
            pst.setInt(5, entity.getQuantQuartos());
            pst.setInt(6, entity.getQuantBanheiros());
            pst.setInt(7, entity.getQuantGaragem());
            pst.setDouble(8, entity.getPreco());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
		

	@Override
	public void delete(int id) {
	 Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from propertyrent where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	


	
	@Override
	public PropertyRent find(int id) {
        Connection con = null;
        PropertyRent p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from propertyrent where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

	

	@Override
	public List<PropertyRent> findAll() {
		Connection con = null;
        List<PropertyRent> result = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from propertyrent";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<PropertyRent>();
            while (rs.next()) {
                PropertyRent cl = map(rs);
                result.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
        


	@Override
	public PropertyRent findByName(String str) {
		Connection con = null;
        PropertyRent p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from propertyrent where titulo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, str);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
	

	@Override
	public List<PropertyRent> findAllByName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	private PropertyRent map(ResultSet rs) throws SQLException {
        PropertyRent p = new PropertyRent();
        p.setId(rs.getInt("id"));
        p.setTitulo(rs.getString("titulo"));
        p.setEndereco(rs.getString("endereco"));
        p.setMetrosTerreno(rs.getString("metrosTerreno"));
        p.setMetrosContruido(rs.getString("metrosConstruido"));
        p.setQuantQuartos(rs.getInt("quantQuartos"));
        p.setQuantBanheiros(rs.getInt("quantBanheiros"));
        p.setQuantGaragem(rs.getInt("quantGaragem"));
        p.setPreco(rs.getDouble("preco"));
        return p;
    }
}
