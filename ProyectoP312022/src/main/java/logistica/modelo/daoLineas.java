/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logistica.controlador.clsLineas;
<<<<<<< HEAD

=======
import seguridad.modelo.clsConexion;
import seguridad.vista.mdiGeneral;
>>>>>>> parent of d6cb2c7 (Merge branch 'main' of https://github.com/BryanIllescas/ProyectoP3E1)
/**
 *
 * @author visitante
 */
public class daoLineas {

    private static final String SQL_SELECT = "SELECT linid, marid, linnombre,linstatus FROM tbl_Lineas";
    private static final String SQL_INSERT = "INSERT INTO tbl_lineas ( linnombre,linstatus ) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_lineas SET linnombre = ?, linstatus = ? WHERE tbl_lineas.linid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_lineas WHERE tbl_lineas.linid = ?";
    private static final String SQL_QUERY = "SELECT linid, marid, linnombre,linstatus FROM tbl_lineas WHERE linid=?";

    public ArrayList<clsLineas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsLin producto = null;
        ArrayList<clsLineas> product = new ArrayList<clsLineas>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int linid = rs.getInt("linid");
                String linnombre = rs.getString("linnombre");
                String linstatus= rs.getString("linstatus");
                

                producto = new clsLineas();
                producto.setLinid(linid);
                producto.setLinnombre(linnombre);
                producto.setLinstatus(linstatus);
                

                product.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return product;
    }

   public int insert(clsLineas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getLinnombre());
            stmt.setString(3, producto.getLinstatus());

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


    public int update(clsLineas producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getLinnombre());
            stmt.setString(3, producto.getLinstatus());
            stmt.setInt(4, producto.getLinid());
            

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

    public int delete(clsLineas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getMarid());
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

    public clsLinea query(clsLinea producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getLinid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String linnombre = rs.getString("linnombre");
               String linstatus= rs.getString("linstatus");

                producto = new clsLinea();
              
                producto.setLinnombre(linnombre);
                producto.setLinstatus(linstatus);
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
        return producto;
    }
}
