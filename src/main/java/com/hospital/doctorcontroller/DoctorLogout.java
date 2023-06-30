package com.hospital.doctorcontroller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/doclogout")
public class DoctorLogout extends HttpServlet {
	/**
	 * Handles the HTTP GET request for logging out a user. Invalidates the current
	 * session, removing all associated session attributes. Redirects the user to
	 * the landing page.
	 * 
	 * @param request  the HttpServletRequest object that contains the client's
	 *                 request
	 * @param response the HttpServletResponse object used to send the response back
	 *                 to the client
	 * @throws ServletException if there is a servlet-related issue
	 * @throws IOException      if there is an I/O related issue
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) {
		HttpSession session = req.getSession(false); // Retrieve the current session (if exists)

		// Retrieving Logger Object through session
		Logger log = (Logger) session.getAttribute("doc");

		if (session != null) {
			// Logging the logout event
			log.info("Doctor logged out");

			session.invalidate(); // Invalidate the session, which removes all associated session attributes

			// Redirect the user to the landing page or any other desired page
			try {
				response.sendRedirect("home.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// No session found
			log.warning("No session found during logout");
		}
	}
}
