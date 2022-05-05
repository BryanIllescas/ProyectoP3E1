/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.controlador;


/**
 *
 * @author visitante
 */
public class clsMarcas {
    int marid;
    String marnombre;
    String marstatus;

    public clsMarcas() {
    }

    public clsMarcas(int marid) {
        this.marid= marid;
    }

    public clsMarcas(String marnombre, String marstatus) {
        this.marnombre = marnombre;
        this.marstatus = marstatus;
    }

    public int getMarid() {
        return marid;
    }

    public void setMarid(int marid) {
        this.marid = marid;
    }

    public String getMarnombre() {
        return marnombre;
    }

    public void setMarnombre(String marnombre) {
        this.marnombre = marnombre;
    }

    public String getMarstatus() {
        return marstatus;
    }

    public void setMarstatus(String marstatus) {
        this.marstatus = marstatus;
    }

    @Override
    public String toString() {
        return "tbl_marcas{" + "marid=" + marid + ", marnombre=" + marnombre + ", marstatus=" + marstatus + '}';
    }
    
}
