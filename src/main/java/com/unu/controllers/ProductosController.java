package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.unu.model.ProductoModel;

@WebServlet(name = "ProductosController", urlPatterns = { "/ProductosController" })
public class ProductosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProductoModel productoModel = new ProductoModel();
       
    public ProductosController() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
			if(request.getParameter("operacion") == null) {
				listar(request, response);
				return;
			}
			
			String operacion = request.getParameter("operacion");
			switch (operacion) {
				case "listar":
					listar(request, response);
					break;
				case "eliminar":
					eliminar(request, response);
					break;
			}
		} catch (Exception e) {
			System.out.println("processRequest() " + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("productos", productoModel.listarProductos());
			request.getRequestDispatcher("/productos/listaProductos.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idproducto = Integer.parseInt(request.getParameter("idproducto"));
			
			if(productoModel.eliminarProducto(idproducto) > 0) {
				request.getSession().setAttribute("exito", "producto eliminado");
			}else {
				request.getSession().setAttribute("fracaso", "producto NO eliminado");
			}
			response.sendRedirect(request.getContextPath() + "/ProductosController");
		} catch (Exception e) {
			System.out.println("eliminar() " + e.getMessage());
		}
	}

}
