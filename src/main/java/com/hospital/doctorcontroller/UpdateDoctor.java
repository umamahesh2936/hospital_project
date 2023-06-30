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
 * @author umamahesh.gudiboina Servlet implementation class UpdateDoctor Handles
 *         the updating of a doctor's information.
 */
@WebServlet("/update")
public class UpdateDoctor extends HttpServlet {

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
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Doctor doctor = doctorService.updateDoc(d);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("doc");

		if (doctor != null) {
			req.setAttribute("obj", doctor);
			logger.log(Level.INFO, "Updated Successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("doctorhome.jsp");
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
