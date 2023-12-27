import java.io.*;

public class Musics implements IMusics{
    Music MusicList[] = new Music[100];
    static int MusicCount = 0;

    public Musics() {
        try (BufferedReader br = new BufferedReader(new FileReader("Files/MusicList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] MusicData = line.split(",");
                if (MusicData.length == 5) {
                    String name = MusicData[0];
                    String artist = MusicData[1];
                    String duration = MusicData[2];
                    String Musicpath = MusicData[3];
                    String thumpath = MusicData[4];

                    Music m = new Music(name, artist, duration, Musicpath, thumpath);
                    MusicList[MusicCount] = m;
                    MusicCount++;
                } else {
                    // Handle invalid data in the file if needed
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error reading the file.");
        }
    }

    public int MusicExists(String duration) {
        int index = -1;
        for (int i = 0; i < MusicCount; i++) {
            if (MusicList[i].getDuration().equals(duration)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void addMusic(Music m) {
        MusicList[MusicCount] = m;
        MusicCount++;

        String MusicDetails = m.getName() + ","
                + m.getArtist() + ","
                + m.getDuration() + ","
                + m.getMusicpath() + ","
                + m.getThumpath() + "\n";

        try {
            FileWriter fw = new FileWriter("Files/MusicList.txt", true);
            fw.write(MusicDetails);
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void deleteMusic(String name) {
    for (int i = 0; i < MusicCount; i++) {
        if (MusicList[i] != null && MusicList[i].getName() != null && MusicList[i].getName().equals(name)) {
            // Shift the remaining elements to fill the gap
            for (int j = i; j < MusicCount - 1; j++) {
                MusicList[j] = MusicList[j + 1];
            }
            MusicCount--;

            // Update the file after deletion
            updateFile();
            return;
        }
    }
    // Music not found
}

    private void updateFile() {
        // Rewrite the entire file with the updated music list
        try (FileWriter fw = new FileWriter("Files/MusicList.txt")) {
            for (int i = 0; i < MusicCount; i++) {
                String MusicDetails = MusicList[i].getName() + ","
                        + MusicList[i].getArtist() + ","
                        + MusicList[i].getDuration() + ","
                        + MusicList[i].getMusicpath() + ","
                        + MusicList[i].getThumpath() + "\n";
                fw.write(MusicDetails);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error updating the file.");
        }
    }

    public Music[] getAllMusic() {
        return MusicList;
    }
}
