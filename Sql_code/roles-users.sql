
-------------- ROLES----------------------

CREATE ROLE rol_admin;

CREATE ROLE rol_empleado_at;

CREATE ROLE rol_empleado_mant;


------------Usuarios---------------

-- Usuario administrador
CREATE USER enzo_admin WITH LOGIN PASSWORD 'clave_fuerte';
GRANT rol_admin TO enzo_admin;

-- Empleado atención al cliente
CREATE USER pepe_at WITH LOGIN PASSWORD 'clave1';
GRANT rol_empleado_at TO pepe_at;

-- Empleado mantenimiento
CREATE USER zulema_mant WITH LOGIN PASSWORD 'clave2';
GRANT rol_empleado_mant TO zulema_mant;


------------Permisos----------------

GRANT CONNECT ON DATABASE BIKENZO TO rol_admin;
GRANT USAGE ON SCHEMA productos, empleados, alquileres, clientes TO rol_admin;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA productos TO rol_admin;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA empleados TO rol_admin;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA alquileres TO rol_admin;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA clientes TO rol_admin;



GRANT CONNECT ON DATABASE BIKENZO TO rol_empleado_at;
GRANT USAGE ON SCHEMA alquileres TO rol_empleado_at;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA alquileres TO rol_empleado_at;


GRANT CONNECT ON DATABASE BIKENZO TO rol_empleado_mant;
GRANT USAGE ON SCHEMA empleados TO rol_empleado_mant;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA empleados TO rol_empleado_mant;


-------------------------------------------------
ALTER ROLE enzo_admin INHERIT;
ALTER ROLE pepe_at INHERIT;
ALTER ROLE zulema_mant INHERIT;
--ALTER ROLE dmartinez INHERIT;