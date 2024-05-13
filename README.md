Hola esta es mi resolucion de una prueba tecnica de creacion de api rest con java.

Cree los metodos HTTP para el mantenimiento de las ordenes de ventas registro , update y busqueda
ademas cree las  2 entidades que tienen dependecia con ordenes que son employee y customers tambien les cree su endpoint de busqueda.

Ademas se añadio spring security JWT
dandole solo permisos para realizar operacion para la entidad Orders.


AYUDAS :

una ayuda para poder ver el usuario los roles y que permisos tiene cada uno :

select u.username ,u.password as contrasenia ,r.role_name , rsion.*, p.nombre from usuario u inner join user_roles rp on u.id = rp.usuario_id inner join rol r on rp.rol_id = r.id inner join rol_permision rsion on rsion.rol_id = r.id inner join permisions p on p.id = rsion.permisions_id

////////////////////////

METODOS PARA AGREGAR USUARIOS ,ROL :

Agregar usuario POST: http://localhost:8080/user/crear

{ "username":"Miguel", "password":"1234", "rol":[ ] }

/////////////////////////////

Agregar el rol al usuario creado: PUT : http://localhost:8080/user/actualizar/usuario/{idUsuario}/rol/{idRol}

//////////////////////////

Asociar permisos a un rol: ( ADMINISTRADOR, DEVELOPER , USUARIO , VISITANTE ) POST : http://localhost:8080/user/crear/rol/{idRol}

{ "role_name":"ADMINISTRADOR", "permisions":[ { "id":1, "nombre":"CREATE" }, { "id":2, "nombre":"READ" }, { "id":3, "nombre":"UPDATE" }, { "id":4, "nombre":"DELETE" } ] }
