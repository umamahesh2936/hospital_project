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

@WebServlet("/doctorpass")
public class ChangeDoctorPassoword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		DoctorService service = new DoctorService();
		String old = req.getParameter("opass");
		String newPass = req.getParameter("newpass");
		String cNewPass = req.getParameter("cnewpass");
		String s = service.changePass(old, newPass);
		HttpSession session = req.getSession(false);
		Logger logger = (Logger) session.getAttribute("doc");
		if (newPass.equals(cNewPass) && s != null) {
			logger.log(Level.INFO, "Successfully Updated");
			req.setAttribute("cpass", "Successfully Updated");
			RequestDispatcher dispatcher = req.getRequestDispatcher("changedoctorpassword.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.log(Level.WARNING, "Invalid Details");
			req.setAttribute("cpass", "Invalid Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("changedoctorpassword.jsp");
			try {
				dispatcher.include(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
