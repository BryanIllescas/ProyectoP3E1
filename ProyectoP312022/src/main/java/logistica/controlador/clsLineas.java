package logistica.controlador;

public class clsLineas {
 private int linid, marid; 
 private String linnombre, linstatus;

    public clsLineas() {
    }

    public clsLineas(int linid, int marid, String linnombre, String linstatus) {
        this.linid = linid; 
        this.marid = marid;
        this.linnombre = linnombre;
        this.linstatus= linstatus;
    }

    public int getLinid() {
        return linid;
    }

    public void setLinid(int linid) {
        this.linid = linid;
    } 

    public int getMarid() {
        return marid;
    }

    public void setMarid(int marid) {
        this.marid = marid;
    } 

    public String getLinnombre() {
        return linnombre;
    }

    public void setLinnombre(String linnombre) {
        this.linnombre = linnombre;
    }

    public String getLinstatus() {
        return linstatus;
    }

    public void setLinstatus(String linstatus) {
        this.linstatus = linstatus;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
<<<<<<< HEAD
        return "tbl_lineas{" + "linid=" + linid ", marid=" + marid + ", linnombre=" + linnombre + ", linstatus=" + linstatus + '}';
=======
        return "tbl_lineas{" + " linid = " + linid + ", linnombre=" + linnombre + ", linstatus=" + linstatus + '}';
>>>>>>> parent of d6cb2c7 (Merge branch 'main' of https://github.com/BryanIllescas/ProyectoP3E1)
=======
        return "tbl_lineas{" + " linid = " + linid + ", linnombre=" + linnombre + ", linstatus=" + linstatus + '}';
>>>>>>> parent of d6cb2c7 (Merge branch 'main' of https://github.com/BryanIllescas/ProyectoP3E1)
    }
 }
