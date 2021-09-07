package com.coderscampus.uservalidation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {
	public static UserService userService = new UserService();
	public static User[] users = new User[4];

	public static void main(String[] args) throws IOException {
		userService.loadUserArray(users);
		Scanner scanner = null;
		String foundUser = null;

		try {
			scanner = new Scanner(System.in);
			int logins = 0;
			boolean validUser = false;

			while (logins < 5 && validUser != true) {

				System.out.println("Enter your username: ");
				String username = scanner.nextLine();
				System.out.println("Enter you password: ");
				String password = scanner.nextLine();

				for (User user : users) {
					if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
						validUser = true;
						foundUser = user.getName();
						break;
					}
				}
				if (validUser) {
					System.out.println("Welcome: " + foundUser);
					break;
				} else {
					logins++;
					if (logins > 4) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					} else {
						System.out.println("Invalid login, please try again.");
					}
				}
			} //end of while loop
		} //end of try loop
		finally {
			scanner.close();
		} //end of finally
	} //end of main
} //end of class

// test@email.com,passwordTest!1,Test User
// another@user.com,asdfasdf,Another User
// john.doe@mydomain.net,Hdk398jf!,John Doe
// jane.doe@myotherdomain.com,sunrise-sunset,Jane Doe