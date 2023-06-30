
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

import com.hospital.service.DoctorService;

/**
 * @author umamahesh.gudiboina Servlet implementation class DeleteDoctor
 */
@WebServlet("/delete")
public class DeleteDoctor extends HttpServlet {

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		DoctorService service = new DoctorService();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String result = service.deleteDoctor(id);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("doc");
		if (result != null) {
			logger.log(Level.INFO, "Deleted Succesfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("doctorlogin.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "Check the Detatils");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registerdoctor.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}