INSERT INTO clientes.genero (descripcion) VALUES
  ('Indefinido'),
  ('Masculino'),
  ('Femenino'),
  ('Otro');

INSERT INTO clientes.cliente (nombre, apellido, dni, telefono, email, cod_postal, id_genero) VALUES
  ('Feliciana', 'Cantón', 3356886, '+34643321819', 'andresciro@gmail.com', '89083', 3),
  ('Lilia', 'Rivas', 29587039, '+34729402654', 'maria-carmennavarro@bru.com', '59407', 1),
  ('Brunilda', 'Casanovas', 50806024, '+34738495931', 'maria-teresamancebo@guerrero.es', '75255', 1),
  ('Hugo', 'Lasa', 94196727, '+34711928327', 'angela83@hotmail.com', '03056', 3),
  ('Julio', 'Batalla', 28317637, '+34725376724', 'marcelajodar@romero.net', '87101', 2),
  ('Ezequiel', 'Cuesta', 91332642, '+34719166978', 'carboisabel@hotmail.com', '51462', 1),
  ('Wilfredo', 'Acero', 96917555, '+34744828148', 'raulcuellar@abascal.com', '54303', 1),
  ('Selena', 'Bermúdez', 11496211, '+34747182278', 'belen96@font.org', '57871', 1),
  ('Jose Miguel', 'Gomila', 8593410, '+34730983930', 'granadosborja@murillo.net', '73829', 3),
  ('Corona', 'Suárez', 32614537, '+34746311656', 'rbalaguer@hotmail.com', '06513', 1);

INSERT INTO empleados.empleado (nombre, apellido, dni, telefono, email, rol) VALUES
  ('Enzo', 'Ferrari', 71979055, '+34722624731', 'ef@hotmail.com', 'Admin'),
  ('Zulema', 'Zur', 12517517, '+34626773602', 'zzur@yahoo.com', 'Mantenimiento'),
  ('Pepe', 'Rodrigez', 93494928, '+34748723430', 'prod@valverde-criado.com', 'Atencion'),
  ('Dilma', 'Martinez', 32035886, '+34962475107', 'dilam@cazorla-oller.com', 'Marketing');

INSERT INTO productos.producto (tipo, necesita_mantener) VALUES
  ('Casco', TRUE),
  ('Patinete largo alcance', FALSE),
  ('Bicicleta urbana', TRUE),
  ('Bicicleta urbana', TRUE),
  ('Bicicleta montaña', TRUE),
  ('Patinete largo alcance', TRUE),
  ('Casco', FALSE),
  ('Bicicleta montaña', FALSE),
  ('Patinete largo alcance', FALSE),
  ('Canasto', TRUE),
  ('Canasto', TRUE),
  ('Casco', FALSE),
  ('Bicicleta plegable', FALSE),
  ('Bicicleta montaña', TRUE),
  ('Canasto', FALSE);

INSERT INTO empleados.repuesto (nombre_rep) VALUES
  ('Cubierta'),
  ('Batería'),
  ('Freno'),
  ('Cadena'),
  ('Luz LED'),
  ('Motor');

INSERT INTO empleados.mantenimiento (tipo, fecha) VALUES
  ('Cubierta', '2025-05-14'),
  ('Freno', '2025-05-13'),
  ('Freno', '2025-04-19'),
  ('Motor', '2025-04-27'),
  ('Cadena', '2025-04-21');

INSERT INTO empleados.mantenimiento_realizado (nro_mantenimiento, id_repuesto, id_producto) VALUES
  (1, 2, 12),
  (2, 5, 9),
  (3, 3, 12),
  (4, 5, 7),
  (5, 5, 7);

INSERT INTO empleados.empleado_mantenimiento (nro_mantenimiento, id_empleado) VALUES
  (1, 3),
  (2, 2),
  (3, 2),
  (4, 4),
  (5, 4);

INSERT INTO alquileres.alquiler (metodo_pago, fecha_desde, fecha_hasta, fecha_devolucion, importe, nro_comprobante, id_cliente, id_empleado) VALUES
  ('Transferencia', '2025-05-06', '2025-05-07', '2025-05-07', 1873.78, 'COMP-5427', 7, 1),
  ('Transferencia', '2025-05-14', '2025-05-17', '2025-05-17', 5329.64, 'COMP-4980', 6, 3),
  ('Efectivo', '2025-05-14', '2025-05-15', '2025-05-15', 5628.84, 'COMP-4124', 5, 3),
  ('Tarjeta', '2025-05-03', '2025-05-04', '2025-05-04', 2945.82, 'COMP-1824', 6, 3),
  ('Transferencia', '2025-05-07', '2025-05-09', '2025-05-09', 2868.84, 'COMP-9353', 2, 3),
  ('Transferencia', '2025-05-07', '2025-05-10', NULL, 2713.68, 'COMP-8740', 8, 3),
  ('Transferencia', '2025-05-03', '2025-05-05', '2025-05-05', 5817.13, 'COMP-6400', 4, 3),
  ('Efectivo', '2025-05-09', '2025-05-10', '2025-05-10', 6635.32, 'COMP-2427', 7, 3);

INSERT INTO alquileres.infraccion (recargo, descripcion, id_alquiler) VALUES
  (566.19, 'Demora.', 6),
  (712.63, 'Rotura', 8),
  (895.63, 'Demora', 8),
  (642.87, 'Demora', 3);

INSERT INTO alquileres.alquiler_producto (id_alquiler, id_producto) VALUES
  (1, 13),
  (2, 14),
  (3, 3),
  (4, 3),
  (4, 13),
  (4, 11),
  (5, 10),
  (5, 2),
  (6, 7),
  (6, 10),
  (7, 9),
  (7, 5),
  (8, 14),
  (8, 1),
  (8, 11);
