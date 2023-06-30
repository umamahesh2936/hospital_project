package com.hospital.dto;

/**
 * @author umamahesh.gudiboina
 *  Class representing a patient.
 */
public class Patient {
	private int id;
	private String name;
	private int age;
	private int doctorId;

	/**
	 * Retrieves the ID of the patient.
	 *
	 * @return The patient ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the patient.
	 *
	 * @param id The patient ID to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the patient.
	 *
	 * @return The patient name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the patient.
	 *
	 * @param name The patient name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the age of the patient.
	 *
	 * @return The patient age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the patient.
	 *
	 * @param age The patient age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retrieves the ID of the doctor associated with the patient.
	 *
	 * @return The doctor ID.
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the ID of the doctor associated with the patient.
	 *
	 * @param doctorId The doctor ID to set.
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
}
