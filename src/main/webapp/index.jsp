<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!--  fontawesome -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

	<!-- custom css -->
	<link rel="stylesheet" href="css/styles.css">
	

    <title>Hello, world!</title>
  </head>
  <body>
  
  <!-- navbar -->
	  <nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#"><i class="fa fa-shopping-bag icono-inicio"></i></a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    
		    <form method="get" action="inicio" class="form-inline my-2 my-lg-0">	    
		      <input class="redondeado form-control mr-sm-2" type="text" name="nombre" id="nombre" placeholder="introduzca un nombre" value="${formulario.nombre }"/>
		      <input class="redondeado form-control mr-sm-2" type="hidden" id="pmin" name="pmin" placeholder="introduzca precio minimo" value="${formulario.pMin }"/>
		      <input class="redondeado form-control mr-sm-2" type="hidden" name="pmax" id="pmax" placeholder="introduzca precio maximo" value="${formulario.pMax }"/>
		      <button type="button" class="redondeado btn btn-primary" data-toggle="modal" data-target="#precioModal">
				  Precio
			  </button>
		      <select name="fabricante" class="redondeado custom-select mx-2">
					<option value="0">-- seleccione un fabricante --</option>
					<c:forEach items="${fabricantes}" var="fab">
						<option value="${fab.id }" ${(formulario.idFabricante eq fab.id)?"selected":"" }>${fab.nombre }</option>
					</c:forEach>
			  </select>	      
		      <button class="redondeado btn btn-success my-2 my-sm-0  mx-2" type="submit">enviar</button>
		    </form>
			<!-- Reset -->
			  <a class="redondeado btn btn-success my-2 my-sm-0 mx-2" href="inicio?nombre=&pmin=0&pmax=0&fabricante=0">Reset</a>    
			  
		  </div>
	 </nav>
  
<main class="container">

	
	<div class="fila">
		<c:forEach items="${productos }" var="p">
			<div class="card card-custom" >
			  <img src="https://picsum.photos/200" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">${p.nombre}</h5>
			    <p class="card-text">Fabricante <b>${p.fabricante.nombre}</b></p>
			    <p class="card-text">Descripcion <b>${p.descripcion}</b></p>
			    <a href="#" class="btn btn-outline-primary">comprar <b>${p.precio}€</b></a>
			  </div>
			</div>
		</c:forEach>
	</div>
	
		
		

</main>


<!-- modal precio -->
	<div class="modal fade" id="precioModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Precio</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       		<form method="get" action="inicio" class="form-inline my-2 my-lg-0">	    
			      <input class="redondeado form-control mr-sm-2" type="hidden" name="nombre" id="nombre" placeholder="introduzca un nombre" value="${formulario.nombre }"/>
			      <input class="redondeado form-control mr-sm-2" type="text" id="pmin" name="pmin" placeholder="introduzca precio minimo" value="${formulario.pMin }"/>
			      <input class="redondeado form-control mr-sm-2" type="text" name="pmax" id="pmax" placeholder="introduzca precio maximo" value="${formulario.pMax }"/>
			      <select hidden name="fabricante" class="redondeado custom-select">
						<option value="0">-- seleccione un fabricante --</option>
						<c:forEach items="${fabricantes}" var="fab">
							<option value="${fab.id }" ${(formulario.idFabricante eq fab.id)?"selected":"" }>${fab.nombre }</option>
						</c:forEach>
				  </select>
				  <div class="modal-footer">	      
			      	<button class="redondeado btn btn-success my-2 my-sm-0" type="submit">enviar</button>
			      </div>
			    </form>
	      </div>
	    </div>
	  </div>
	</div>


	
 	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>