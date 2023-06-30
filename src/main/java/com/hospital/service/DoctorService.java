package com.hospital.service;

import java.util.List;

import com.hospital.dao.DoctorDao;
import com.hospital.dto.Doctor;
import com.hospital.dto.Patient;

/**
 * @author umamahesh.gudiboina
 * Service class for managing doctor-related operations.
 */
public class DoctorService {
	DoctorDao dao = new DoctorDao();

	/**
	 * Saves a doctor in the database.
	 *
	 * @param doctor The doctor object to be saved.
	 * @return The saved doctor object.
	 */
	public Doctor saveDoctor(Doctor doctor) {
		return dao.saveDoctor(doctor);
	}

	/**
	 * Retrieves a doctor by ID from the database.
	 *
	 * @param id The ID of the doctor to retrieve.
	 * @return The doctor object if found, null otherwise.
	 */
	public Doctor getDocById(int id) {
		return dao.getById(id);
	}

	/**
	 * Deletes a doctor from the database.
	 *
	 * @param id The ID of the doctor to delete.
	 * @return A string indicating the status of the operation.
	 */
	public String deleteDoctor(int id) {
		return dao.deleteDoctor(id);
	}

	/**
	 * Updates a doctor in the database.
	 *
	 * @param doctor The updated doctor object.
	 * @return The updated doctor object.
	 */
	public Doctor updateDoc(Doctor doctor) {
		return dao.update(doctor);
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
		return dao.login(email, password);
	}

	/**
	 * Retrieves a list of all doctors from the database.
	 *
	 * @return A list of all doctors.
	 */
	public List<Doctor> getAll() {
		return dao.getAll();
	}

	/**
	 * Retrieves a list of patients assigned to a doctor.
	 *
	 * @param id The ID of the doctor.
	 * @return A list of patients assigned to the doctor.
	 */
	public List<Patient> getpatientList(int id) {
		return dao.getMyPatients(id);
	}

	public String changePass(String old, String newPass) {
	
		return dao.changePassword(old, newPass);
	}
}
