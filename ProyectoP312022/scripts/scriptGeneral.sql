CREATE SCHEMA IF NOT EXISTS `bdproyectop312022` DEFAULT CHARACTER SET utf8 ;
USE `bdproyectop312022` ;

CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	usuultimasesion DATE,
	usuestatus VARCHAR(1) NOT NULL,
	usunombrereal VARCHAR(60),
	usucorreoe VARCHAR(60),
	usutelefono VARCHAR(25),
	usudireccion VARCHAR(80),
	PRIMARY KEY (usuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_perfil (
    perid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pernombre VARCHAR(30) NOT NULL,
    perestatus VARCHAR (30) NOT NULL
)ENGINE=InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_aplicacion (
	aplid int NOT NULL AUTO_INCREMENT,
	aplnombre VARCHAR(50),
	aplestatus VARCHAR(50),
	PRIMARY KEY (aplid)
) ENGINE=InnoDB CHARACTER SET = latin1;    

CREATE TABLE IF NOT EXISTS tbl_modulo (
	modid INT NOT NULL AUTO_INCREMENT,
	modnombre VARCHAR(60) NOT NULL,
	modestatus VARCHAR(60) NOT NULL,
	PRIMARY KEY (modid) )
ENGINE = InnoDB CHARACTER SET = latin1;

    
 CREATE TABLE IF NOT EXISTS tbl_aplicacionPerfil(
	aplid INT NOT NULL,
    perid INT NOT NULL,
    PRIMARY KEY(aplid, perid),
    FOREIGN KEY (aplid) REFERENCES tbl_aplicacion (aplid),     
    FOREIGN KEY (perid) REFERENCES tbl_perfil (perid)
 ) ENGINE=InnoDB CHARACTER SET = latin1;     

CREATE TABLE IF NOT EXISTS tbl_aplicacionusuario (
	aplid INT NOT NULL,
	usuid INT NOT NULL,
	PRIMARY KEY (aplid, usuid), 
	FOREIGN KEY (aplid) references tbl_aplicacion (aplid),
	FOREIGN KEY (usuid) references tbl_usuario (usuid)
) ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_perfilusuario (
	perid int NOT NULL,
	usuid int NOT NULL,
	PRIMARY KEY (perid, usuid),
	FOREIGN KEY (perid) REFERENCES tbl_perfil (perid),
	FOREIGN KEY (usuid) REFERENCES tbl_usuario (usuid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS tbl_bitacora (
    bitid int auto_increment PRIMARY KEY,
    bitfecha datetime NULL, 
	bitaccion VARCHAR(10) NOT NULL,
    usuid INT NOT NULL,
    aplid INT NOT NULL,
	FOREIGN KEY (aplid) references tbl_aplicacion (aplid),
	FOREIGN KEY (usuid) references tbl_usuario (usuid)    
) ENGINE=InnoDB DEFAULT CHARSET=latin1;	


-- Inventario
CREATE TABLE IF NOT EXISTS tbl_proveedores (
	provid INT NOT NULL AUTO_INCREMENT,
	provnombre VARCHAR(60) NOT NULL,
	provstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (provid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_marcas (
	marid INT NOT NULL AUTO_INCREMENT,
	marnombre VARCHAR(60) NOT NULL,
	marstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (marid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_lineas (
	linid INT NOT NULL AUTO_INCREMENT,
    marid INT NOT NULL,
	linnombre VARCHAR(60) NOT NULL,
	linstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (linid),
    FOREIGN KEY (marid) references tbl_marcas (marid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_productos (
	proid INT NOT NULL AUTO_INCREMENT,
    marid INT NOT NULL,
    linid INT NOT NULL,
	pronombre VARCHAR(60) NOT NULL,
    procantidad INT NOT NULL,
    proprecio INT NOT NULL,
	proestatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (proid),
    FOREIGN KEY (marid) references tbl_marcas (marid),
    FOREIGN KEY (linid) references tbl_lineas (linid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_bodegas (
	bodid INT NOT NULL AUTO_INCREMENT,
    proid INT NOT NULL,
	bodnombre VARCHAR(60) NOT NULL,
    bodubicacion VARCHAR(100) NOT NULL,
    bodingresos DATETIME,
    bodegresos DATETIME,
	bodstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (bodid),
    FOREIGN KEY (proid) references tbl_productos (proid))
    ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_bodegas_existencias (
	exisid INT NOT NULL AUTO_INCREMENT,
    proid INT NOT NULL,
    bodid INT NOT NULL,
    PRIMARY KEY (exisid),
    FOREIGN KEY (proid) references tbl_productos (proid),
    FOREIGN KEY (bodid) references tbl_bodegas (bodid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_traslados (
	trasid INT NOT NULL AUTO_INCREMENT,
    proid INT NOT NULL,
    bodid INT NOT NULL,
    trascantidad INT NOT NULL,
    trasdireccion VARCHAR(70) NOT NULL,
	trasstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (trasid),
    FOREIGN KEY (proid) references tbl_productos (proid),
    FOREIGN KEY (bodid) references tbl_bodegas (bodid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_inventario (
	invid INT NOT NULL AUTO_INCREMENT,
    provid INT NOT NULL,
    marid INT NOT NULL,
    linid INT NOT NULL,
    proid INT NOT NULL,
    bodid INT NOT NULL,
    invstatus VARCHAR(1),
    PRIMARY KEY (invid),
    FOREIGN KEY (provid) references tbl_proveedores (provid),
    FOREIGN KEY (marid) references tbl_marcas (marid),
    FOREIGN KEY (linid) references tbl_lineas (linid),
    FOREIGN KEY (proid) references tbl_productos (proid),
    FOREIGN KEY (bodid) references tbl_bodegas (bodid))
    ENGINE = InnoDB CHARACTER SET = latin1;

