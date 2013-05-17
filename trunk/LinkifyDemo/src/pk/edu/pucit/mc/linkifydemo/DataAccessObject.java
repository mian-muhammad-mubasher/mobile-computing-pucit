package pk.edu.pucit.mc.linkifydemo;

import java.util.HashMap;
import java.util.Map;

public class DataAccessObject {
	static public Map<String, User> users = new HashMap<String, User>();
	
	static{
		users.put("@swjaffry", new User("@swjaffry", "Syed Waqar Ul Jaffry", "Assistant Professor", "Phd"));
		users.put("@mmmubasher", new User("@mmmubasher", "Mian Muhammad Mubasher", "Adjunct Faculty", "BS"));		
	}
	
	public static User getUser(String userName){
		return users.get(userName);
	}
	
}
