import java.lang.*;
public interface IMusics {
    int MusicExists(String duration);
    void addMusic(Music m);
    void deleteMusic(String name);
    Music[] getAllMusic();
}