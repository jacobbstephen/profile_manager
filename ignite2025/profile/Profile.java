package ignite2025.profile;

public class Profile implements Cloneable {
	private String name;
	private String employee_id;
	private String company;
	private String designation;
	
	
	public void setProfile(String name, String employee_id, String company, String designation) {
		this.name = name;
		this.employee_id = employee_id;
		this.company = company;
		this.designation = designation;
	}
	@Override 
	public Profile clone() throws CloneNotSupportedException {
		return (Profile) super.clone();
	}
	@Override
	public String toString() {
		return "Profile =>  [name=" + name + ", employee_id=" + employee_id + ", company=" + company + ", designation="
				+ designation + "]";
	}
}
