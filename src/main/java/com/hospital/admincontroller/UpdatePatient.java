package com.hospital.admincontroller;

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

import com.hospital.dto.Patient;
import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class UpdatePatient
 *         Handles updating patient information.
 */
@WebServlet("/updatepat")
public class UpdatePatient extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		AdminService service = new AdminService();
		Patient patient = new Patient();
		try {
			patient.setId(Integer.parseInt(req.getParameter("id")));
			patient.setName(req.getParameter("name"));
			patient.setAge(Integer.parseInt(req.getParameter("age")));
			patient.setDoctorId(Integer.parseInt(req.getParameter("did")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Patient updatedPatient = service.update(patient);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("alog");

		if (updatedPatient != null) {
			logger.log(Level.INFO, "Updated successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminhome.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "Some went wrong check");
			RequestDispatcher dispatcher = req.getRequestDispatcher("addpatient.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
