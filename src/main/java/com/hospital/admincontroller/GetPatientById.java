package com.hospital.admincontroller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class GetPatientById
 *         Handles retrieving a patient's information by ID.
 */
@WebServlet("/getpatbyid")
public class GetPatientById extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		AdminService service = new AdminService();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		ResultSet set = service.getByIdWithDoc(id);
		HttpSession session2 = req.getSession(false);
		Logger logger = (Logger) session2.getAttribute("alog");
		if (set != null) {
			logger.log(Level.INFO, "Data fetched by id success");

			req.setAttribute("pat", set);
			RequestDispatcher dispatcher = req.getRequestDispatcher("displaypatientbyid.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "No data found");
			req.setAttribute("inid", "Invlaid id");
			RequestDispatcher dispatcher = req.getRequestDispatcher("getpatientbyid.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
