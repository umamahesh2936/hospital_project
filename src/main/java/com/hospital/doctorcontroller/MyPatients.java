package com.hospital.doctorcontroller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dto.Patient;
import com.hospital.service.DoctorService;

/**
 * @author umamahesh.gudiboina Servlet implementation class MyPatients
 * 
 *         This servlet is responsible for retrieving and displaying the list of
 *         patients associated with a particular doctor.
 */
@WebServlet("/mypatient")
public class MyPatients extends HttpServlet {
	/**
	 * Processes the GET request and retrieves the list of patients associated with
	 * a doctor. It forwards the request to the appropriate view to display the
	 * patient list.
	 *
	 * @param req  The HttpServletRequest object.
	 * @param resp The HttpServletResponse object.
	 * @throws ServletException If the servlet encounters a problem.
	 * @throws IOException      If there is an I/O problem.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		DoctorService doctorService = new DoctorService();
		String s = req.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		List<Patient> list = doctorService.getpatientList(id);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("doc");
		if (!list.isEmpty()) {
			req.setAttribute("mypat", list);
			logger.log(Level.INFO, "Doctor got all his patients");
			RequestDispatcher dispatcher = req.getRequestDispatcher("mypatients.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			session.setAttribute("np", "No Patient Found");
			req.setAttribute("obj", doctorService.getDocById(id));
			RequestDispatcher dispatcher = req.getRequestDispatcher("doctorhome.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
