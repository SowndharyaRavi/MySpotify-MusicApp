import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean findSong(String title){
        for(Song s:songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    void addSongToAlbum(String name,double duration){
        Song s=new Song(name,duration);

        if(findSong(s.getTitle())==true){
            System.out.println("Song already present in album");
        }
        else{
            songs.add(s);
            System.out.println("New Song has been added");
        }
        return;
    }

    public void addToPlayList(String title, LinkedList<Song> playList){
        if(findSong(title)){
            for(Song s:songs){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is not present in the Album");
        }
        return;
    }

    public void addToPlayList(int trackNo,LinkedList<Song>playList){
         int ind=trackNo-1;
         if(ind>=0 && ind<songs.size()){
             playList.add(songs.get(ind));
             System.out.println("Song has been added to your playlist");
         }
         else{
             System.out.println("Invalid Track Number");
         }
         return;
    }

}
