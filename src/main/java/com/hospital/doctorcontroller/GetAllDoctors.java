package com.hospital.doctorcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dto.Doctor;
import com.hospital.service.DoctorService;

/**
 * @author umamahesh.gudiboina Servlet implementation class GetAllDoctors
 * 
 *         This servlet is responsible for retrieving all doctors from the
 *         database and forwarding the request to the appropriate view.
 */
@WebServlet("/getall")
public class GetAllDoctors extends HttpServlet {
	/**
	 * Processes the GET request and retrieves all doctors from the database. If
	 * doctors are found, forwards the request to the "displaydoctors.jsp" view,
	 * otherwise forwards to the "registerdoctor.jsp" view.
	 *
	 * @param req  The HttpServletRequest object.
	 * @param resp The HttpServletResponse object.
	 * @throws ServletException If the servlet encounters a problem.
	 * @throws IOException      If there is an I/O problem.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		DoctorService doctorService = new DoctorService();
		List<Doctor> list = doctorService.getAll();
		if (!list.isEmpty()) {
			req.setAttribute("get", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("displaydoctors.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("registerdoctor.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
