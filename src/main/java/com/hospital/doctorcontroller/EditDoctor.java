
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
 * @author umamahesh.gudiboina Servlet implementation class EditDoctor
 */
@WebServlet("/edit")
public class EditDoctor extends HttpServlet {

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
	 */
	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {

		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("doc");
		DoctorService service = new DoctorService();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();

		}
		Doctor doctor = service.getDocById(id);
		if (doctor != null) {
			logger.log(Level.INFO, "Successfully passed to update page");
			req.setAttribute("doctor", doctor);
			RequestDispatcher dispatcher = req.getRequestDispatcher("updatedoctor.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "Invalid Details");
			RequestDispatcher dispatcher = req.getRequestDispatcher("doctorhome.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}