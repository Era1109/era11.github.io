
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	public static void main(String args[]){
		Musics ms = new Musics();
		Users us = new Users();
		Login lg = new Login(us,ms);
		Welcome wc = new Welcome(lg);
		//Home home = new Home(null, us, lg,ms);
		//LogIn login = new LogIn();
        //login.setVisible(true);
	}
}