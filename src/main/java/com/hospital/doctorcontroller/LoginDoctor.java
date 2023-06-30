package com.hospital.doctorcontroller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
 * @author umamahesh.gudiboina Servlet implementation class LoginDoctor
 * 
 *         This servlet is responsible for handling the login of a doctor. It
 *         verifies the provided credentials and redirects to the appropriate
 *         view.
 */
@WebServlet("/login")
public class LoginDoctor extends HttpServlet {
	/**
	 * Processes the POST request and handles the login of a doctor. It validates
	 * the provided email and password, and redirects to the appropriate view.
	 *
	 * @param req  The HttpServletRequest object.
	 * @param resp The HttpServletResponse object.
	 * @throws ServletException If the servlet encounters a problem.
	 * @throws IOException      If there is an I/O problem.
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		DoctorService doctorService = new DoctorService();
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		Doctor d = doctorService.login(email, password);
		final Logger logger = Logger.getLogger("mainLogger");
		HttpSession session = req.getSession();
		try {
			Handler fileHandler = new FileHandler(
					"C:\\Users\\umamahesh.gudiboina\\Desktop\\eclipse workspace\\Logfile\\logs", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Failed to configure FileHandler", e);
		}
		if (d != null) {
			req.setAttribute("doc2", d);
			session.setAttribute("doc", logger);
			logger.log(Level.INFO, "Login Success");
			RequestDispatcher dispatcher = req.getRequestDispatcher("doctorhome.jsp");

			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "Invalid Details");
			req.setAttribute("wrong", "Invalid Credentials");
			RequestDispatcher dispatcher = req.getRequestDispatcher("doctorlogin.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
