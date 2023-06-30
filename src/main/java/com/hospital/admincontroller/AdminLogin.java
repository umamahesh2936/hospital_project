package com.hospital.admincontroller;

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

import com.hospital.dto.Admin;
import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class AdminLogin Handles
 *         the login functionality for administrators.
 */
@WebServlet("/loginadm")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		AdminService adminService = new AdminService();
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		Admin admin = adminService.loginAdmin(email, password);
		final Logger logger1 = Logger.getLogger("adminLogger");

		try {
			Handler fileHandler = new FileHandler(
					"C:\\Users\\umamahesh.gudiboina\\Desktop\\eclipse workspace\\Logfile\\adminlogs", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger1.addHandler(fileHandler);
		} catch (Exception e) {
			logger1.log(Level.SEVERE, "Failed to configure FileHandler", e);
		}
		if (admin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("alog", logger1);
			logger1.log(Level.INFO, "Login Success");
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminhome.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger1.log(Level.WARNING, "Invalid Details");
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("mess", "Invalid Credentials");
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminlogin.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
