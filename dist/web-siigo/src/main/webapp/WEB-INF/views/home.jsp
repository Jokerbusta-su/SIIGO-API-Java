<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Test Services Siigo</title>
</head>
<body>
	<div class="container">
		<h2>Desarrolladores Aplicación</h2>
		<table class="table" id="table-desarrolladores">
			<thead>
				<tr>
					<th>Primer Nombre</th>
					<th>Apellidos</th>
					<th>Activo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="desarrollo" items="${developers}">
					<tr>
						<td>${desarrollo.firstName}</td>
						<td>${desarrollo.lastName}</td>
						<td>${(desarrollo.isActivate == 1) ? 'Activo' : 'No Activo'}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<h2>Productos</h2>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal">Crear Producto</button>
		<table class="table" id="table-productos">
			<thead>
				<tr>
					<th>Identificación</th>
					<th>Codigo</th>
					<th>Descripción</th>
					<th>Costo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${products}">
					<tr>
						<td>${producto.id}</td>
						<td>${producto.code}</td>
						<td>${producto.description}</td>
						<td>${producto.cost}</td>
						<td><a href="/deleteProduct/${producto.id}" class="btn btn-primary" role="button" aria-pressed="true">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Crear Producto</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form class="needs-validation" novalidate method="post" action="/crearProducto">
						<div class="modal-body">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="text-codigo">Codigo</label> <input type="text"
										class="form-control" id="text-codigo" name="code"
										placeholder="Codigo del producto">
								</div>
								<div class="form-group col-md-6">
									<label for="text-descripcion">Descripción</label> <input
										type="text" class="form-control" id="text-descripcion"
										name="description"
										placeholder="Descripcion del producto">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="text-referencia">Referencia</label> <input
										type="text" class="form-control" id="text-referencia"
										name="referenceManufactures"
										placeholder="Referencia del producto">
								</div>
								<div class="form-group col-md-6">
									<label for="text-tipo-producto">Tipo producto</label> <select
										class="form-control" id="text-tipo-producto" name="productTypeKey">
										<option value="" selected>Seleccione</option>
										<option value="ProductType_Consumer">ProductType_Consumer</option>
										<option value="ProductType_Product">ProductType_Product</option>
										<option value="ProductType_Service">ProductType_Service</option>
									</select>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="text-unidad-medida">Unidad Medida</label> <select
										class="form-control" id="text-unidad-medida"
										name="measureUnit">
										<option value="" selected>Seleccione</option>
										<option value="Unidades">Unidad</option>
										<option value="Kg">Kg</option>
										<option value="Litros">Litros</option>
									</select>
								</div>
								<div class="form-group col-md-6">
									<label for="text-codigo-producto">Codigo Barras</label> <input
										name="codeBars"
										type="text" class="form-control" id="text-codigo-producto"
										placeholder="Codigo Barras">
								</div>
							</div>
							<div class="form-group">
								<label for="text-comentarios">Comentarios</label> <input
									name="comments"
									type="text" class="form-control" id="text-comentarios"
									placeholder="Comentario producto">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="text-costo-producto">Costo</label> <input
										type="number" class="form-control" id="text-costo-producto"
										name="cost"
										placeholder="Costo producto">
								</div>
								<div class="form-group col-md-6">
									<label for="text-estado-producto">Estado</label> <select
										name="state"
										class="form-control" id="text-estado-producto">
										<option value="" selected>Seleccione</option>
										<option value=0>No Habilitado</option>
										<option value=1>Habilitado</option>
									</select>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button id="btn-guardar-producto" type="submit"
								class="btn btn-primary">Guardar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Modal -->



		<!-- Modal Out Put -->
		<div class="modal fade" id="modal-out-put" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="titulo-mensaje-salida"></h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div id="mensaje-salida"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Out Put -->
	</div>
</body>
</html>