USE `preparcial`;

CALL `preparcial`.`spCreateProducto`('Arroz', 20, 15);
CALL `preparcial`.`spCreateProducto`('Azucar', 10, 20);
CALL `preparcial`.`spCreateProducto`('Lentejas', 15, 8);
CALL `preparcial`.`spCreateProducto`('Gelatina', 5, 15);
CALL `preparcial`.`spCreateProducto`('Fideos', 18, 17);
CALL `preparcial`.`spCreateProducto`('Atun', 24, 3);
CALL `preparcial`.`spCreateProducto`('Detergente', 21, 25);

CALL `preparcial`.`spCreateProveedor`('Don Victorio');
CALL `preparcial`.`spCreateProveedor`('Tottus');
CALL `preparcial`.`spCreateProveedor`('Alejandrina');
CALL `preparcial`.`spCreateProveedor`('Precio Uno');
CALL `preparcial`.`spCreateProveedor`('Bells');

CALL `preparcial`.`spDeleteProveedor`(5);
CALL `preparcial`.`spDeleteProducto`(7);

CALL `preparcial`.`spReadProductos`();
CALL `preparcial`.`spReadProveedores`();