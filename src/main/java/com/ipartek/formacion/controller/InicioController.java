package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.Formulario;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(InicioController.class);
	private static final  ProductoDAO dao=ProductoDAO.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Producto>productos=new ArrayList<Producto>();
		
		String nombre=request.getParameter("nombre");
		String pMin=request.getParameter("pmin");
		String pMax=request.getParameter("pmax");
		String idFabricante=request.getParameter("fabricante");
		Formulario form=new Formulario(nombre, pMin, pMax, idFabricante);
		
		
		
		try {
			LOG.debug(String.format("nombre=%s pmin=%s pmax=%s fabricante=%s", nombre,pMin,pMax,idFabricante));
			
						
			
			LOG.trace("Entrar a InicioController");
			productos=dao.buscar(form);
			
		} catch (Exception e) {
			LOG.error(e);
		}finally {
			request.setAttribute("fabricantes", dao.getAllFabricantes());
			request.setAttribute("formulario", form);
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			LOG.trace("Salir de InicioController");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



}
