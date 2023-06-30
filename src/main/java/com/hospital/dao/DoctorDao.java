package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dto.Doctor;
import com.hospital.dto.Patient;

/**
 * @author umamahesh.gudiboina This class provides data access methods for the
 *         Doctor entity.
 */
public class DoctorDao {
	/**
	 * Saves a doctor to the database.
	 *
	 * @param doctor The doctor object to be saved.
	 * @return The saved doctor object.
	 */
	Connection connection;
	PreparedStatement statement;
	Statement statement2;

	public Doctor saveDoctor(Doctor doctor) {
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("insert into umamahesh.Doctor values(?,?,?,?,?,?,?)");
				statement.setInt(1, doctor.getId());
				statement.setString(2, doctor.getName());
				statement.setInt(3, doctor.getAge());
				statement.setString(4, doctor.getSpecialist());
				statement.setString(5, doctor.getEmail());
				statement.setString(6, doctor.getPassword());
				statement2 = connection.createStatement();
				ResultSet resultSet = statement2.executeQuery("select * from umamahesh.patient");
				int count = 0;
				while (resultSet.next()) {
					if (doctor.getId() == resultSet.getInt(4)) {
						count++;
					}
				}
				statement.setInt(7, count);
				int a = statement.executeUpdate();
				if (a != 0) {
					return doctor;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Updates a doctor in the database.
	 *
	 * @param doctor The doctor object to be updated.
	 * @return The updated doctor object.
	 */
	public Doctor update(Doctor doctor) {

		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement(
						"update doctor set doctor_name=?,doctor_age=?,doctor_specialization=? where doctor_id=?");
				statement.setString(1, doctor.getName());
				statement.setInt(2, doctor.getAge());
				statement.setString(3, doctor.getSpecialist());
				statement.setInt(4, doctor.getId());
				int a = statement.executeUpdate();
				if (a != 0) {
					return doctor;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Deletes a doctor from the database.
	 *
	 * @param id The ID of the doctor to be deleted.
	 * @return A string indicating the result of the delete operation.
	 */
	public String deleteDoctor(int id) {
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("delete from doctor where doctor_id=?");
				statement.setInt(1, id);
				int j = statement.executeUpdate();
				if (j > 0) {
					return "deleted successfully";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves a doctor by ID from the database.
	 *
	 * @param id The ID of the doctor to retrieve.
	 * @return The doctor object if found, null otherwise.
	 */
	public Doctor getById(int id) {
		Doctor doctor = new Doctor();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("select * from doctor where doctor_id=?");
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					doctor.setId(resultSet.getInt(1));
					doctor.setName(resultSet.getString(2));
					doctor.setAge(resultSet.getInt(3));
					doctor.setSpecialist(resultSet.getString(4));
					doctor.setEmail(resultSet.getString(5));
					doctor.setPassword(resultSet.getString(6));
					doctor.setPatientCount(resultSet.getInt(7));
					return doctor;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Performs login for a doctor using email and password.
	 *
	 * @param email    The email of the doctor.
	 * @param password The password of the doctor.
	 * @return The logged-in doctor object if authentication is successful,
	 *         otherwise an empty doctor object.
	 */
	public Doctor login(String email, String password) {
		Doctor doctor = new Doctor();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection
						.prepareStatement("select * from doctor where doctor_email=? and doctor_password=?");
				statement.setString(1, email);
				statement.setString(2, password);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					doctor.setId(resultSet.getInt(1));
					doctor.setName(resultSet.getString(2));
					doctor.setAge(resultSet.getInt(3));
					doctor.setSpecialist(resultSet.getString(4));
					doctor.setEmail(resultSet.getString(5));
					doctor.setPassword(resultSet.getString(6));
					doctor.setPatientCount(resultSet.getInt(7));
					return doctor;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retrieves a list of all doctors from the database.
	 *
	 * @return A list of all doctors.
	 */
	public List<Doctor> getAll() {
		List<Doctor> list = new ArrayList<>();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {

				statement2 = connection.createStatement();
				ResultSet resultSet = statement2.executeQuery("select * from umamahesh.doctor");
				while (resultSet.next()) {
					Doctor doctor = new Doctor();
					doctor.setId(resultSet.getInt(1));
					doctor.setName(resultSet.getString(2));
					doctor.setAge(resultSet.getInt(3));
					doctor.setSpecialist(resultSet.getString(4));
					doctor.setEmail(resultSet.getString(5));
					doctor.setPatientCount(resultSet.getInt(7));
					list.add(doctor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Retrieves a list of patients assigned to a doctor.
	 *
	 * @param id The ID of the doctor.
	 * @return A list of patients assigned to the doctor.
	 */
	public List<Patient> getMyPatients(int id) {
		List<Patient> list = new ArrayList<>();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("select * from patient where doctor_id=?");
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Patient patient = new Patient();
					patient.setId(resultSet.getInt(1));
					patient.setName(resultSet.getString(2));
					patient.setAge(resultSet.getInt(3));
					patient.setDoctorId(resultSet.getInt(4));
					list.add(patient);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Changes the password of the admin.
	 *
	 * @param old   the old password
	 * @param npass the new password
	 * @return a string indicating the password change status
	 */
	public String changePassword(String old, String npass) {
		int j = 0;
		String s = null;
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {

				statement = connection
						.prepareStatement("UPDATE doctor SET doctor_password = ? WHERE doctor_password = ?");
				statement.setString(1, npass);
				statement.setString(2, old);
				j = statement.executeUpdate();
				if (j > 0) {
					s = "Success";
				} else {
					s = "Unsuccess";

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
