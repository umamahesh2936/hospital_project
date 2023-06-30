package com.hospital.dto;

/**
 * @author umamahesh.gudiboina
 *  Class representing a doctor.
 */
public class Doctor {
	private int id;
	private String name;
	private int age;
	private String specialist;
	private String email;
	private String password;
	private int patientCount;

	/**
	 * Retrieves the number of patients associated with the doctor.
	 *
	 * @return The patient count.
	 */
	public int getPatientCount() {
		return patientCount;
	}

	/**
	 * Sets the number of patients associated with the doctor.
	 *
	 * @param patientCount The patient count to set.
	 */
	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}

	/**
	 * Retrieves the ID of the doctor.
	 *
	 * @return The doctor ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the doctor.
	 *
	 * @param id The doctor ID to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the doctor.
	 *
	 * @return The doctor name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the doctor.
	 *
	 * @param name The doctor name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the age of the doctor.
	 *
	 * @return The doctor age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the doctor.
	 *
	 * @param age The doctor age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retrieves the specialist of the doctor.
	 *
	 * @return The doctor specialist.
	 */
	public String getSpecialist() {
		return specialist;
	}

	/**
	 * Sets the specialist of the doctor.
	 *
	 * @param specialist The doctor specialist to set.
	 */
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	/**
	 * Retrieves the email of the doctor.
	 *
	 * @return The doctor email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the doctor.
	 *
	 * @param email The doctor email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the password of the doctor.
	 *
	 * @return The doctor password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the doctor.
	 *
	 * @param password The doctor password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
