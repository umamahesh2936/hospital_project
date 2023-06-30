package com.hospital.admincontroller;

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
import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class GetAllPatients
 *         Handles retrieving all patients' information.
 */
@WebServlet("/getallpatient")
public class GetAllPatients extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
		AdminService adminService = new AdminService();
		List<Patient> list = adminService.getAll();
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("alog");
		if (!list.isEmpty()) {
			logger.log(Level.INFO, "All patients fetched successfully");
			req.setAttribute("get", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("displaypatient.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.INFO, "No Data Found");
			RequestDispatcher dispatcher = req.getRequestDispatcher("addpatient.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
