/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos.modelo;

import prototipos.controlador.clsBodegas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoBodegas {

    private static final String SQL_SELECT = "SELECT bodid, prodid, bodnombre, bodubicacion, bidingresos, bodegresos, bodstatus FROM tbl_bodegas";
    private static final String SQL_INSERT = "INSERT INTO tbl_bodegas(bodnombre, bodubicacion, bidingresos, bodegresos, bodstatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodegas SET bodnombre=?,  bodubicacion = ?, bidingresos = ?, bodegresos = ?, bodstatus = ? WHERE bodid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bod WHERE bodid=?";
    private static final String SQL_QUERY = "SELECT bodid, prodid, bodnombre, bodubicacion, bidingresos, bodegresos, bodstatus FROM tbl_bodegas WHERE bodid=?";
    private static final String SQL_QUERYN = "SELECT bodid, prodid, bodnombre, bodubicacion, bidingresos, bodegresos, bodstatus FROM tbl_bodegas WHERE bodnombre=?";    

    public List<clsBodegas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBodegas bodegas = null;
        List<clsBodegas> bodegas = new ArrayList<clsBodegas>();
        
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodid");
                String nombre = rs.getString("bodnombre");
                String direccion = rs.getString("bodubicacion");
                String ingresos = rs.getString("bodingresos");
                String egresos = rs.getString("bodegresos");
                String estatus = rs.getString("bodstatus");

                bodegas = new clsBodegas();
                bodegas.setBodid(id);
                bodegas.setBodnombre(nombre);
                bodegas.setBodubicacion(direccion);
                bodegas.setBodingresos(ingresos);
                bodegas.setBodegresos(egresos);
                bodegas.setBodstatus(estatus);
                bodegas.add(bodegas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return bodegas;
    }

    public int insert(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bodegas.getBodnombre());
            stmt.setString(2, bodegas.getBodubicacion());
            stmt.setString(3, bodegas.getBodingresos());
            stmt.setString(4, bodegas.getBodegresos());
            stmt.setString(5, bodegas.getBodstatus());            

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

    public int update(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bodegas.getBodnombre());
            stmt.setString(2, bodegas.getBodubicacion());
            stmt.setString(3, bodegas.getBodingresos());
            stmt.setString(4, bodegas.getBodegresos());
            stmt.setString(5, bodegas.getBodstatus());

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

    public int delete(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodegas.getBodid());
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

    public clsBodegas query(clsBodegas bodegas) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bodegas.getBodid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodid");
                String nombre = rs.getString("bodnombre");
                String direccion = rs.getString("bodubicacion");
                String ingresos = rs.getString("bodingresos");
                String egresos = rs.getString("bodegresos");
                String estatus = rs.getString("bodstatus");

                bodegas = new clsBodegas();
                bodegas.setBodid(id);
                bodegas.setBodnombre(nombre);
                bodegas.setBodubicacion(direccion);
                bodegas.setBodingresos(ingresos);
                bodegas.setBodegresos(egresos);
                bodegas.setBodstatus(estatus);
                bodegas.add(bodegas);
            }
            
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return bodegas;
    }
public clsBodegas queryn(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, bodegas.getBodnombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodid");
                String nombre = rs.getString("bodnombre");
                String direccion = rs.getString("bodubicacion");
                String ingresos = rs.getString("bodingresos");
                String egresos = rs.getString("bodegresos");
                String estatus = rs.getString("bodstatus");

                bodegas = new clsBodegas();
                bodegas.setBodid(id);
                bodegas.setBodnombre(nombre);
                bodegas.setBodubicacion(direccion);
                bodegas.setBodingresos(ingresos);
                bodegas.setBodegresos(egresos);
                bodegas.setBodstatus(estatus);
                bodegas.add(bodegas);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return bodegas;
    }
    
}
