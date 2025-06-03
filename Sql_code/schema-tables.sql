------ESQUEMAS-----------------------------------
CREATE SCHEMA empleados;
CREATE SCHEMA productos;
CREATE SCHEMA alquileres;
CREATE SCHEMA clientes;

---------------------- PRODUCTOS---------------------------------------------------
CREATE TABLE productos.producto (
    ID_producto SERIAL PRIMARY KEY,
    tipo VARCHAR(40) NOT NULL,
    necesita_mantener BOOLEAN DEFAULT FALSE
);

------CLIENTES----------------------------------
CREATE TABLE clientes.genero (
    ID_genero SERIAL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE clientes.cliente (
    ID_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    cod_postal VARCHAR(10),
    ID_genero INTEGER REFERENCES clientes.genero(ID_genero)
);

------------ EMPLEADOS------------------
CREATE TABLE empleados.empleado (
    ID_empleado SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE empleados.mantenimiento (
    nro_mantenimiento SERIAL PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL
);

CREATE TABLE empleados.repuesto (
    ID_repuesto SERIAL PRIMARY KEY,
    nombre_rep VARCHAR(100) NOT NULL
);

CREATE TABLE empleados.mantenimiento_realizado (
    nro_mantenimiento INTEGER REFERENCES empleados.mantenimiento(nro_mantenimiento) ON DELETE CASCADE,
    ID_repuesto INTEGER REFERENCES empleados.repuesto(ID_repuesto) ON DELETE CASCADE,
	ID_producto INTEGER REFERENCES productos.producto(ID_producto),
    PRIMARY KEY (nro_mantenimiento, ID_repuesto)
);

CREATE TABLE empleados.empleado_mantenimiento (
	nro_mantenimiento INTEGER REFERENCES empleados.mantenimiento(nro_mantenimiento) ON DELETE CASCADE,
	ID_empleado INTEGER REFERENCES empleados.empleado(ID_empleado),
	PRIMARY KEY (nro_mantenimiento, ID_empleado)
);
-------------------- ALQUILERES-------------------------------------
CREATE TABLE alquileres.alquiler (
    ID_alquiler SERIAL PRIMARY KEY,
    metodo_pago VARCHAR(50) NOT NULL,
    fecha_desde DATE NOT NULL,
    fecha_hasta DATE NOT NULL,
    fecha_devolucion DATE,
    importe NUMERIC(10,2),
    nro_comprobante VARCHAR(50),
    ID_cliente INTEGER REFERENCES clientes.cliente(ID_cliente),
    ID_empleado INTEGER REFERENCES empleados.empleado(ID_empleado)
);

CREATE TABLE alquileres.infraccion (
    ID_infraccion SERIAL PRIMARY KEY,
    recargo NUMERIC(10,2),
    descripcion TEXT,
    ID_alquiler INTEGER REFERENCES alquileres.alquiler(ID_alquiler) ON DELETE CASCADE
);

CREATE TABLE alquileres.alquiler_producto (
    ID_alquiler INTEGER REFERENCES alquileres.alquiler(ID_alquiler) ON DELETE CASCADE,
    ID_producto INTEGER REFERENCES productos.producto(ID_producto) ON DELETE CASCADE,
    PRIMARY KEY (ID_alquiler, ID_producto)
);

