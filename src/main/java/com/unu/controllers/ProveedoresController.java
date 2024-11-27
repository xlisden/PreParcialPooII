package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Proveedor;
import com.unu.model.ProveedorModel;

@WebServlet(name = "ProveedoresController", urlPatterns = { "/ProveedoresController" })
public class ProveedoresController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProveedorModel proveedorModel = new ProveedorModel();
       
    public ProveedoresController() {
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
				case "nuevo":
					request.getRequestDispatcher("/proveedores/nuevoProveedor.jsp").forward(request, response);
					break;
				case "insertar":
					insertar(request, response);
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
			request.setAttribute("proveedores", proveedorModel.listarProveedores());
			request.getRequestDispatcher("/proveedores/listaProveedores.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
			
			if(proveedorModel.eliminarProveedor(idproveedor) > 0) {
				request.getSession().setAttribute("exito", "proveedor eliminado");
			}else {
				request.getSession().setAttribute("fracaso", "proveedor NO eliminado");
			}
			response.sendRedirect(request.getContextPath() + "/ProveedoresController");
		} catch (Exception e) {
			System.out.println("eliminar() " + e.getMessage());
		}
	}
	
	protected boolean validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean hayErrores = false;
		List<String> listaErrores = new ArrayList<String>();
		try {
			validarParametro(request, "razonSocial", listaErrores, "Ingrese la razón social del proveedor.");
			if(listaErrores.size() > 0) {
				hayErrores = true;
			}
			request.setAttribute("hayErrores", hayErrores);
			request.setAttribute("listaErrores", listaErrores);
		} catch (Exception e) {
			System.out.println("validar() " + e.getMessage());
		}
		return hayErrores;
	}
	
	protected void validarParametro(HttpServletRequest request, String parametro, List<String> listaErrores, String mensaje) throws ServletException, IOException {
		try {
			String aux = request.getParameter(parametro);
			if(aux == null || aux.isEmpty()) {
				listaErrores.add(mensaje);
				request.setAttribute(parametro, null);
			}else {
				request.setAttribute(parametro, request.getAttribute(parametro));
			}
		} catch (Exception e) {
			System.out.println("validarParametro() " + e.getMessage());
		}
	}
	
	protected void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(!validar(request, response)) {
				Proveedor proveedor = new Proveedor();
				proveedor.setRazonSocial(request.getParameter("razonSocial"));
				
				if(proveedorModel.insertarProveedor(proveedor) > 0) {
					request.getSession().setAttribute("exito", "proveedor insertado");
				}else {
					request.getSession().setAttribute("fracaso", "proveedor NO insertado");
				}
				response.sendRedirect(request.getContextPath() + "/ProveedoresController");
			}else {
				request.getRequestDispatcher("/proveedores/nuevoProveedor.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("insertar() " + e.getMessage());
		}
	}
}
