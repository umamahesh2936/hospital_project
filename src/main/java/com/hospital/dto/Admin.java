package com.hospital.dto;

/**
 * @author umamahesh.gudiboina
 *  Class representing an admin.
 */
public class Admin {
	private int id;
	private String name;
	private String email;
	private String password;

	/**
	 * Retrieves the ID of the admin.
	 *
	 * @return The admin ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the admin.
	 *
	 * @param id The admin ID to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the admin.
	 *
	 * @return The admin name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the admin.
	 *
	 * @param name The admin name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the email of the admin.
	 *
	 * @return The admin email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the admin.
	 *
	 * @param email The admin email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the password of the admin.
	 *
	 * @return The admin password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the admin.
	 *
	 * @param password The admin password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
