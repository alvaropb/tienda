package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class ProductoDAO {
	private static final Logger LOG = Logger.getLogger(ProductoDAO.class);
	private static ProductoDAO INSTANCE = null;

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
	}

	public static ProductoDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private ProductoDAO() {
		super();

	}

	/**
	 * 
	 * @param nombreProducto buusca la palabra nombreProducto dentro del nombre del
	 *                       producto, si queremos todos pasar ""
	 * @param precioMinimo   float si no queremos filtrar, pasar 0 o neggativo
	 * @param PrecioMax      float si no queremos filtrar, pasar 0 o neggativo
	 * @param idFabricante   int identificador del fabricante, si queremos todos
	 *                       pasar 0
	 * @return listado de productos , si no encuentra, retorna listado vacio
	 */
	public ArrayList<Producto> buscar(Formulario form) {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		String where = "";
		if (form.getNombre() != null) {
			where = "WHERE p.nombre LIKE '%" + form.getNombre() + "%'";
		}
		if (form.getpMin() > 0) {
			where += " AND precio >= " + form.getpMin() + "";
		}
		if (form.getpMax() > 0) {
			where += " AND precio <= " + form.getpMax() + "";
		}
		if (form.getIdFabricante() > 0) {
			where += " AND p.codigo_fabricante=" + form.getIdFabricante() + "";
		}

		String sql = "SELECT p.id as 'id_producto',p.nombre as 'nombre_producto',precio, f.id, f.nombre FROM productos p "
				+ "INNER JOIN Fabricantes f ON p.codigo_fabricante=f.id " + where + " ORDER BY p.id DESC LIMIT 500";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id_producto"));
				p.setNombre(rs.getString("nombre_producto"));
				p.setPrecio(rs.getFloat("precio"));

				Fabricante f = new Fabricante();
				f.setId(rs.getInt("f.id"));
				f.setNombre(rs.getString("f.nombre"));

				p.setFabricante(f);

				productos.add(p);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return productos;

	}

	public ArrayList<Fabricante> getAllFabricantes() {
		ArrayList<Fabricante> fabricantesR = new ArrayList<Fabricante>();

		try (Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst=conn.prepareStatement("SELECT id, nombre FROM Fabricantes ORDER BY nombre DESC LIMIT 500");
				ResultSet rs=pst.executeQuery()){
			
			Fabricante fab=null;
			while (rs.next()) {
				fab=new Fabricante();
				fab.setId(rs.getInt("id"));
				fab.setNombre(rs.getString("nombre"));
				fabricantesR.add(fab);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return fabricantesR;
	}

}
