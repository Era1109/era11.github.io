package Classes;
import java.lang.*;
 
 
public interface IUsers{

	void addUser(User u);

    User getUser(int index, String pass);

    void deleteUser(User u);

    void updatePassword(int index, String password);

    int userExists(String email);

}