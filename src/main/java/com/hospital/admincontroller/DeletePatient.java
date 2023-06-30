package com.hospital.admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class DeletePatient
 *         Handles the deletion of a patient's information.
 */
@WebServlet("/deletepat")
public class DeletePatient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		AdminService service = new AdminService();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String message = service.deleteById(id);
		if ("".equals(message)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("getallpatient");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			req.setAttribute("inid", "Invalid Id Given");
			try {
				RequestDispatcher dispatcher = req.getRequestDispatcher("deletepatient.jsp");
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
