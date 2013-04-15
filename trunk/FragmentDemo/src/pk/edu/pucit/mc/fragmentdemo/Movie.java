package pk.edu.pucit.mc.fragmentdemo;

public class Movie {
	private String name;
	private String description;
	
	public Movie(String name, String description) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setDescription(description);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
}
