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
 * @author umamahesh.gudiboina Servlet implementation class SaveDoctor Handles
 *         the saving of a doctor's information.
 */
@WebServlet("/save")
public class SaveDoctor extends HttpServlet {

	/**
	 * Handles the HTTP POST request to save the doctor's information.
	 *
	 * @param req  the HttpServletRequest object
	 * @param resp the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		DoctorService doctorService = new DoctorService();
		Doctor d = new Doctor();
		try {
			d.setId(Integer.parseInt(req.getParameter("id")));
			d.setName(req.getParameter("name"));
			d.setAge(Integer.parseInt(req.getParameter("age")));
			d.setEmail(req.getParameter("email"));
			d.setPassword(req.getParameter("pass"));
			d.setSpecialist(req.getParameter("spi"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Doctor doctor = doctorService.saveDoctor(d);
		final Logger logger = Logger.getLogger("mainLogger");

		try {
			Handler fileHandler = new FileHandler(
					"C:\\Users\\umamahesh.gudiboina\\Desktop\\eclipse workspace\\Logfile\\logs", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Failed to configure FileHandler", e);
		}
		HttpSession session = req.getSession();

		if (doctor != null) {
			session.setAttribute("saved", "Data Saved Successfully");
			logger.log(Level.INFO, "Data Saved Succesfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registerdoctor.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			session.invalidate();
		} else {
			session.setAttribute("saved", "Invalid Data");
			logger.log(Level.WARNING, "Data is not correct");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registerdoctor.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
