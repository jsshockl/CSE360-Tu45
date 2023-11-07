package application;

import java.util.HashMap;

public class Database {
	
HashMap<String, String> credentials = new HashMap<String, String>();
	
		public Database()	{
		credentials.put("Joseph", "password");
		credentials.put("Raneem", "september");
		credentials.put("Katherine", "joust");
		credentials.put("Kat", "pulling");
		credentials.put("Yahia", "tour");
	}
	
	protected HashMap getCredentials()	{
		return credentials;
	}

}
