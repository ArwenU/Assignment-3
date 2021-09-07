package com.coderscampus.uservalidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
		
	public void loadUserArray (User[] users) throws IOException {
		
		BufferedReader fileReader = null;
		fileReader = new BufferedReader(new FileReader("data.txt"));
		
		try {	
			int i = 0;
			String line = null;
			
			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				User userData = new User(lineData[0], lineData[1], lineData[2]);
				users[i] = userData;
				i++;
			}
		}
		finally {
			if (fileReader != null);
			fileReader.close();
		}

		
	} //end of loadUserArray method
		
}
