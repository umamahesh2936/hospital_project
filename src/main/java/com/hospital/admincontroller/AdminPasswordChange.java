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

import com.hospital.service.AdminService;

/**
 * @author umamahesh.gudiboina Servlet implementation class AdminPasswordChange
 *         Handles the password change functionality for administrators.
 */
@WebServlet("/savepass")
public class AdminPasswordChange extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		AdminService service = new AdminService();
		String old = req.getParameter("opass");
		String newPass = req.getParameter("newpass");
		String cNewPass = req.getParameter("cnewpass");
		String s = service.changePass(old, newPass);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("alog");
		if (newPass.equals(cNewPass) && s != null) {
			logger.log(Level.INFO, "Password Changed successfully");
			req.setAttribute("cpass", "Successfully Updated");
			RequestDispatcher dispatcher = req.getRequestDispatcher("changepassword.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "information Invalid for password change");
			req.setAttribute("cpass", "Invalid Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("changepassword.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
