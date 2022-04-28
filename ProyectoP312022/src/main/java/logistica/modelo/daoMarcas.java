/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logistica.controlador.clsMarcas;
import seguridad.controlador.clsAplicacion;

/**
 *
 * @author visitante
 */
public class daoMarcas {

    private static final String SQL_SELECT = "SELECT marid, marnombre, marstatus FROM tbl_marcas";
    private static final String SQL_INSERT = "INSERT INTO tbl_marcas(marnombre, marstatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marcas SET marnombre=?, marstatus=? WHERE marid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marcas WHERE marid=?";
    private static final String SQL_QUERY = "SELECT marid, marnombre, marstatus FROM tbl_marcas WHERE marid = ?";

    public List<clsMarcas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMarcas marcas = null;
        List<clsMarcas> marcas = new ArrayList<clsMarcas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int marid = rs.getInt("marid");
                String nombre = rs.getString("marnombre");
                String estado = rs.getString("marstatus");
                
                marcas = new clsMarcas();
                marcas.setMarid(marid);
                marcas.setMarnombre(nombre);
                marcas.setMarstatus(estado);
                
                marcas.add((clsMarcas) marcas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return marcas;
    }

    public int insert(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marcas.getMarnombre());
            stmt.setString(2, marcas.getMarstatus());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marcas.getMarnombre());
            stmt.setString(2, marcas.getMarstatus());
            stmt.setInt(3, marcas.getMarid());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, marcas.getMarid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public List<clsMarcas> query(clsMarcas marcas) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsMarcas> marcas = new ArrayList<clsMarcas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, marcas.getMarid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Marid = rs.getInt("marid");
                String nombre = rs.getString("marnombre");
                String estado = rs.getString("marstatus");
                
                marcas = new clsMarcas();
                marcas.setMarid(marid);
                marcas.setMarnombre(nombre);
                marcas.setMarstatus(estado);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return marcas;
    }

    public void insert(clsAplicacion marcasAInsertar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
