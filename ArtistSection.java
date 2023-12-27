

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArtistSection extends Home {
	Login lg;
	User u;
	Users us;
    public ArtistSection(User u, Users us, Login lg, Musics ms) {
        super(u, us, lg, ms); // Call the constructor of the superclass (ArtistSection)
    }
	public String getTitle() {
        return "Artist Section";
    }

}