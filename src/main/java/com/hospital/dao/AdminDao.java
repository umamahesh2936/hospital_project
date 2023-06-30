package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dto.Admin;
import com.hospital.dto.Doctor;
import com.hospital.dto.Patient;

/**
 * @author umamahesh.gudiboina The AdminDao class provides database operations
 *         for the Admin entity.
 */
public class AdminDao {
	Connection connection;
	PreparedStatement statement;
	Statement statement2;
	static DoctorDao dao = new DoctorDao();
	Doctor d;
	Patient patient;

	/**
	 * Saves a patient to the database.
	 *
	 * @param p the patient to be saved
	 * @return the saved patient object
	 */
	public Patient save(Patient p) {

		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("INSERT INTO patient VALUES (?, ?, ?, ?)");
				statement.setInt(1, p.getId());
				statement.setString(2, p.getName());
				statement.setInt(3, p.getAge());
				statement.setInt(4, p.getDoctorId());
				d = dao.getById(p.getDoctorId());

				if (d != null) {
					int count = 0;
					int j = statement.executeUpdate();

					statement = connection.prepareStatement("SELECT patient_count FROM doctor WHERE doctor_id = ?");
					statement.setInt(1, d.getId());
					ResultSet resultSet = statement.executeQuery();
					if (resultSet.next()) {
						count = resultSet.getInt(1);
						count = count + 1;
					}
					statement = connection.prepareStatement("UPDATE doctor SET patient_count = ? WHERE doctor_id = ?");
					statement.setInt(1, count);
					statement.setInt(2, d.getId());
					statement.executeUpdate();
					if (j > 0) {
						return p;
					}
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retrieves a list of all patients from the database.
	 *
	 * @return a list of all patients
	 */
	public List<Patient> getAll() {
		List<Patient> list = new ArrayList<>();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement2 = connection.createStatement();
				ResultSet resultSet = statement2.executeQuery("SELECT * FROM patient");
				while (resultSet.next()) {
					patient = new Patient();
					patient.setId(resultSet.getInt(1));
					patient.setName(resultSet.getString(2));
					patient.setAge(resultSet.getInt(3));
					patient.setDoctorId(resultSet.getInt(4));
					list.add(patient);
				}
				return list;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Retrieves a ResultSet containing the patient information along with the
	 * corresponding doctor information.
	 *
	 * @param id the patient ID
	 * @return the ResultSet containing patient and doctor information
	 */
	public ResultSet getByIdWithDoctor(int id) {
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement(
						"SELECT p.*, d.doctor_name, d.doctor_specialization FROM patient p, doctor d WHERE p.doctor_id = d.doctor_id AND p.patient_id = ?");
				statement.setInt(1, id);
				ResultSet set = statement.executeQuery();

				if (set.next()) {
					return set;
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retrieves a patient by ID from the database.
	 *
	 * @param id the patient ID
	 * @return the patient object
	 */
	public Patient getById(int id) {
		patient = new Patient();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("SELECT * FROM patient WHERE patient_id = ?");
				statement.setInt(1, id);
				ResultSet set = statement.executeQuery();
				while (set.next()) {
					patient.setId(set.getInt(1));
					patient.setName(set.getString(2));
					patient.setAge(set.getInt(3));
					patient.setDoctorId(set.getInt(4));
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patient;
	}

	/**
	 * Updates a patient in the database.
	 *
	 * @param p the patient to be updated
	 * @return the updated patient object
	 */
	public Patient updatePatient(Patient p) {
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null && p != null) {
				statement = connection.prepareStatement(
						"UPDATE patient SET patient_id = ?, patient_name = ?, patient_age = ?, doctor_id = ? WHERE patient_id = ?");
				statement.setInt(1, p.getId());
				statement.setString(2, p.getName());
				statement.setInt(3, p.getAge());
				statement.setInt(4, p.getDoctorId());
				statement.setInt(5, p.getId());
				statement.executeUpdate();
				return p;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Deletes a patient from the database.
	 *
	 * @param id the ID of the patient to be deleted
	 * @return a string indicating the deletion status
	 */
	public String deletePatient(int id) {
		int c = 0;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement("SELECT * FROM patient WHERE patient_id = ?");
				statement.setInt(1, id);
				ResultSet set = statement.executeQuery();
				if (set.next()) {
					patient = new Patient();
					patient.setId(set.getInt(1));
					patient.setName(set.getString(2));
					patient.setAge(set.getInt(3));
					patient.setDoctorId(set.getInt(4));

					if (patient != null) {
						d = dao.getById(patient.getDoctorId());
						count = d.getPatientCount();
						statement = connection.prepareStatement("DELETE FROM patient WHERE patient_id = ?");
						statement.setInt(1, id);
						c = statement.executeUpdate();
					}
				}
				if (c > 0 && d != null) {
					count -= 1;
					statement = connection.prepareStatement("UPDATE doctor SET patient_count = ? WHERE doctor_id = ?");
					statement.setInt(1, count);
					statement.setInt(2, d.getId());
					statement.executeUpdate();
					return "Deleted successfully";

				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
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
				statement = connection.prepareStatement("UPDATE admin SET admin_password = ? WHERE admin_password = ?");
				statement.setString(1, npass);
				statement.setString(2, old);
				j = statement.executeUpdate();
				if (j > 0) {
					s = "Success";
				} else {
					s = "Unsuccess";
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * Performs the login operation for the admin.
	 *
	 * @param email    the admin email
	 * @param password the admin password
	 * @return the admin object if login is successful, null otherwise
	 */
	public Admin login(String email, String password) {

		Admin a = new Admin();
		try {
			connection = DatabaseConnection.getConnection();
			if (connection != null) {
				statement = connection
						.prepareStatement("SELECT * FROM admin WHERE admin_email = ? AND admin_password = ?");
				statement.setString(1, email);
				statement.setString(2, password);
				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {
					a.setId(resultSet.getInt(1));
					a.setName(resultSet.getString(2));
					return a;
				}
			}
			if (connection != null)
				connection.close();
			connection.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
}
