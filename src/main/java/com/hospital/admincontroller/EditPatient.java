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
 * @author umamahesh.gudiboina Servlet implementation class EditPatient Handles
 *         the editing of a patient's information.
 */
@WebServlet("/editpat")
public class EditPatient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		AdminService service = new AdminService();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultSet p = service.getByIdWithDoc(id);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("alog");
		if (p != null) {
			logger.log(Level.INFO, "Successfully passed to update page");
			req.setAttribute("sent", "update");
			req.setAttribute("pat1", p);
			RequestDispatcher dispatcher = req.getRequestDispatcher("updatepatient.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "Details invalid to edit");
			req.setAttribute("inid", "Invalid Id");
			RequestDispatcher dispatcher = req.getRequestDispatcher("editpatient.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}
}
