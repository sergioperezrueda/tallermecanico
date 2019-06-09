$(document)
		.ready(
				function() {
					var tableCoche = $('#tablacoche')
							.DataTable(
									{
										"language" : {
											"url" : "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json"
										},
										"sAjaxSource" : "/admin/coche",
										"bInfo" : false,
										"sAjaxDataProp" : "",
										"order" : [ [ 0, "asc" ] ],
										"aoColumns" : [
												{
													"mData" : "id_coche"
												},
												{
													"mData" : "matricula"
												},
												{
													"mData" : "marca"
												},
												{
													"mData" : "modelo"
												},
												{
													"mData" : "id_coche",
													"render" : function(data,
															type, row, meta) {
														return "<a href='/admin/modificarcoche/"
																+ row.id_coche
																+ "'>Modificar</a>"
													}
												} ]
									});
					var tableIndexUsuario = $('#tablafacturausuarios')
							.DataTable(
									{
										"language" : {
											"url" : "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json"
										},
										"sAjaxSource" : "/usuario/usuario",
										"bInfo" : false,
										"sAjaxDataProp" : "",
										"order" : [ [ 0, "asc" ] ],
										"aoColumns" : [
												{
													"mData" : "fecha"
												},
												{
													"mData" : "importe"
												},
												{
													"mData" : "pagada"
												},
												{
													"mData" : "id_coche.matricula"
												},
												{
													"mData" : "id_factura",
													"render" : function(data,
															type, row, meta) {
														return "<a href='/usuario/verfactura/"
																+ row.id_factura
																+ "'>Detalles</a>"
													}
												} ]
									});

					var tableIndexFacturas = $('#tablatodaslasfacturas')
							.DataTable(
									{
										"language" : {
											"url" : "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json"
										},
										"sAjaxSource" : "/admin/factura",
										"bInfo" : false,
										"sAjaxDataProp" : "",
										"order" : [ [ 0, "asc" ] ],
										"aoColumns" : [
												{
													"mData" : "fecha"
												},
												{
													"mData" : "descripcion"
												},
												{
													"mData" : "importe"
												},
												{
													"mData" : "pagada"
												},
												{
													"mData" : "id_coche.matricula"
												},
												{
													"mData" : "id_usuario.nombre"
												},
												{
													"mData" : "id_factura",
													"render" : function(data,
															type, row, meta) {
														return "<a href='/admin/modificarfactura/"
																+ row.id_factura
																+ "'>Modificar</a>"
																+ "<br>"
																+ "<a href='/admin/borrarfactura/"
																+ row.id_factura
																+ "'>Borrar</a>"
													}
												} ]
									});

					var tableUsuarios = $('#tablatodoslosusuarios')
							.DataTable(
									{
										"language" : {
											"url" : "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json"
										},
										"sAjaxSource" : "/admin/usuario",
										"bInfo" : false,
										"sAjaxDataProp" : "",
										"order" : [ [ 0, "asc" ] ],
										"aoColumns" : [
												{
													"mData" : "id_usuario"
												},
												{
													"mData" : "nombre"
												},
												{
													"mData" : "apellidos"
												},
												{
													"mData" : "email"
												},
												{
													"mData" : "permisos"
												},
												{
													"mData" : "id_usuario",
													"render" : function(data,
															type, row, meta) {
														return "<a href='/admin/modificarusuario/"
																+ row.id_usuario
																+ "'>Modificar</a>"
													}
												} ]
									});
				});