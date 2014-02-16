package ie.lyit.adt.tests.algorithms.searching;

/**
 * Student data structure class used for generic search testing
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class Student implements Comparable<Student> {
	/**
	 * Student ID field
	 */
	public Integer studentID;

	/**
	 * Password field
	 */
	public String password;

	/**
	 * Creates a new student
	 * 
	 * @param studentID
	 *            Student ID field
	 * @param password
	 *            Password field
	 */
	public Student(Integer studentID, String password) {
		this.studentID = studentID;
		this.password = password;
	}

	/**
	 * Checks if another object equals our own
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return studentID.equals(((Student) obj).studentID);
		}

		return false;
	}

	/**
	 * Returns java hash code (just the student ID) for student (not MD5 hash)
	 */
	@Override
	public int hashCode() {
		return this.studentID;
	}

	/**
	 * Compares this student to another based on student ID
	 */
	@Override
	public int compareTo(Student other) {
		return this.studentID.compareTo(other.studentID);
	}

	/**
	 * Returns student information string
	 */
	@Override
	public String toString() {
		return "Student [ID=" + this.studentID + ", Password=" + this.password
				+ "]";
	}
}
