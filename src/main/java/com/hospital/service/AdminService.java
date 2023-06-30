package com.hospital.service;

import java.sql.ResultSet;
import java.util.List;

import com.hospital.dao.AdminDao;
import com.hospital.dto.Admin;
import com.hospital.dto.Patient;

/**
 * The AdminService class provides service methods for handling administrative
 * operations in a hospital.
 */
public class AdminService {
	 AdminDao dao = new AdminDao();

	/**
	 * Saves a patient record.
	 *
	 * @param p The patient to be saved.
	 * @return The saved patient.
	 */
	public Patient savePatient(Patient p) {
		return dao.save(p);
	}

	/**
	 * Retrieves all patient records.
	 *
	 * @return A list of all patients.
	 */
	public List<Patient> getAll() {
		return dao.getAll();
	}

	/**
	 * Retrieves a patient record by ID along with associated doctor information.
	 *
	 * @param id The ID of the patient.
	 * @return A ResultSet containing the patient and doctor information.
	 */
	public ResultSet getByIdWithDoc(int id) {
		return dao.getByIdWithDoctor(id);
	}

	/**
	 * Updates a patient record.
	 *
	 * @param patient The patient to be updated.
	 * @return The updated patient.
	 */
	public Patient update(Patient patient) {
		return dao.updatePatient(patient);
	}

	/**
	 * Deletes a patient record by ID.
	 *
	 * @param id The ID of the patient to be deleted.
	 * @return A message indicating the result of the deletion.
	 */
	public String deleteById(int id) {
		return dao.deletePatient(id);
	}

	/**
	 * Changes the password for an administrator.
	 *
	 * @param op The old password.
	 * @param np The new password.
	 * @return A message indicating the result of the password change.
	 */
	public String changePass(String op, String np) {
		return dao.changePassword(op, np);
	}

	/**
	 * Logs in an administrator with the specified email and password.
	 *
	 * @param email    The email of the administrator.
	 * @param password The password of the administrator.
	 * @return The logged-in administrator.
	 */
	public Admin loginAdmin(String email, String password) {
		return dao.login(email, password);
	}

	/**
	 * Retrieves a patient record by ID.
	 *
	 * @param id The ID of the patient.
	 * @return The patient with the specified ID.
	 */
	public Patient getById(int id) {
		return dao.getById(id);
	}
}
