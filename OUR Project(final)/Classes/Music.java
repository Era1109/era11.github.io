package Classes;
import java.lang.*;

public class Music extends Entity{
	String artist;
	String duration;
	String Musicpath,thumpath;
	
	public Music(String name, String artist, String duration,String Musicpath,String thumpath){
		super(name);
		this.name = name;
		this.artist = artist;
		this.duration = duration;
		this.Musicpath = Musicpath;
		this.thumpath = thumpath;
	}
	
    //Setter
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	public void setDuration(String duration){
		this.duration = duration;
	}
	
	public void setMusicpath(String Musicpath){
		this.Musicpath = Musicpath;
	}
	public void setThumpath(String thumpath){
		this.thumpath = thumpath;
	}
	
	
	
	//Getter

	public String getArtist(){
		return artist;
	}
	public String getDuration(){
		return duration;
	}
	
	public String getMusicpath(){
		return Musicpath;
	}
	public String getThumpath(){
		return thumpath;
	}
	

}