package pk.edu.pucit.mc.webserviceconsumerservicedemo;

public class CityInfoDTO {
	public int id;
	public String name;
	public String countryCode;
	public String district;
	public int population;
	
	public CityInfoDTO(int id, String name, String countryCode,String district,int population) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+id+" | "+name+" | "+countryCode+" | "+district+" | "+population;
	}
}
