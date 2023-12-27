

import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Users implements IUsers{
	User userList[] = new User[100];
	static int userCount = 0;
	
	public Users(){
		
		try (BufferedReader br = new BufferedReader(new FileReader("Files/userList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5) {
                    String name = userData[0];
                    String password = userData[1];
                    String email = userData[2];
                    String gender = userData[3];
                    String dob = userData[4];

                 User u = new User(name,password,email,gender,dob);
				userList[userCount] = u; 
				userCount++;
                } else {
                    System.out.println("Invalid data in file: " + line);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error reading the file.");
        }
	   
	}
	public int userExists(String email){
		int index = -1;
		for(int i=0;i<userCount;i++){
			if(userList[i].getEmail().equals(email)){
				index = i;
				break;
			}
		}
		return index;
	}
	public void addUser(User u){
		userList[userCount]=u;
		userCount++;
		
		String userDetails = u.getName()+","+
					    u.getPassword() +","+
					    u.getEmail() +","+
						u.getGender()+","+
						u.getDOB()+"\n";

		try{
			FileWriter fw = new FileWriter("Files/userList.txt",true);
			fw.write(userDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
		
	}
	
	public User getUser(int index, String pass){
		if((userList[index].getPassword().equals(pass))){
			return userList[index];
		}else{return null;}
	}
	public void updatePassword(int index,String password){
		userList[index].setPassword(password);
	}
	public void deleteUser(User u){
		int index = userExists(u.getName());
		for(int i=index;i<userCount-1;i++){
			userList[i]=userList[i+1];
		}
		--userCount;
		userList[userCount]=null;
	}
	
}