package com.hospital.admincontroller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dto.Patient;
import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class AddPatient Handles
 *         the addition of a patient's information.
 */
@WebServlet("/savepatient")
public class AddPatient extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("alog");
		try {
			AdminService adminService = new AdminService();
			Patient patient = new Patient();
			patient.setId(Integer.parseInt(req.getParameter("id")));
			patient.setName(req.getParameter("name"));
			patient.setAge(Integer.parseInt(req.getParameter("age")));
			patient.setDoctorId(Integer.parseInt(req.getParameter("did")));
			Patient p = adminService.savePatient(patient);
			if (p != null) {
				logger.log(Level.INFO, "Patient Added Successfully");
				RequestDispatcher dispatcher = req.getRequestDispatcher("adminhome.jsp");
				dispatcher.forward(req, resp);
			} else {
				logger.log(Level.WARNING, "Something went Wrong ");
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("message", "Please enter valid details");
				RequestDispatcher dispatcher = req.getRequestDispatcher("addpatient.jsp");
				dispatcher.include(req, resp);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Number formatException occurred ");

		}
	}
}
