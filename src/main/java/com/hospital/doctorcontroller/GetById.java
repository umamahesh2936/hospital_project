package com.hospital.doctorcontroller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dto.Doctor;
import com.hospital.service.DoctorService;

/**
 * @author umamahesh.gudiboina Servlet implementation class GetById
 * 
 *         This servlet is responsible for retrieving a doctor by their ID from
 *         the database and forwarding the request to the appropriate view.
 */
@WebServlet("/getdocbyid")
public class GetById extends HttpServlet {
	/**
	 * Processes the GET request and retrieves a doctor by their ID from the
	 * database. If a doctor is found, forwards the request to the appropriate view,
	 * otherwise forwards to another view.
	 *
	 * @param req  The HttpServletRequest object.
	 * @param resp The HttpServletResponse object.
	 * @throws ServletException If the servlet encounters a problem.
	 * @throws IOException      If there is an I/O problem.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		DoctorService doctorService = new DoctorService();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Doctor doc = doctorService.getDocById(id);
		HttpSession httpSession = req.getSession();
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("doc");
		if (doc != null) {
			logger.log(Level.INFO, "Fetched by id successfully");
			req.setAttribute("getwithid", doc);
			RequestDispatcher dispatcher = req.getRequestDispatcher("displaydoctorbyid.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			httpSession.setAttribute("showmess", "No Doctor Present With Given ID");
			RequestDispatcher dispatcher = req.getRequestDispatcher("getdoctorbyid.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
