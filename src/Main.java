import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("Taylor Hits", "Taylor Swift");
        album1.addSongToAlbum("Bad Blood", 4.05);
        album1.addSongToAlbum("Wildest Dream", 4.55);
        album1.addSongToAlbum("Love Story", 3.05);

        Album album2 = new Album("Kpop", "BTS");
        album2.addSongToAlbum("Butter", 3.55);
        album2.addSongToAlbum("Dynamite", 4.35);
        album2.addSongToAlbum("Run BTS", 4.05);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("Bad Blood"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlayList(1, myPlayList);
        album1.addToPlayList("Love Story", myPlayList);
        album2.addToPlayList(1, myPlayList);
        album2.addToPlayList("Run BTS", myPlayList);

        play(myPlayList);
    }
        public static void play(LinkedList<Song>playList){
        Scanner sc=new Scanner(System.in);
            boolean isForward=false;
            ListIterator<Song>itr=playList.listIterator();
            if(playList.size()>0){
                System.out.println("You're currently playing : ");
                System.out.println(itr.next());
                isForward=true;
            }
            else{
                System.out.println("Playlist is Empty");
                return;
            }

            printMenu();
            boolean quit=false;
            while(!quit){
                int choice =sc.nextInt();
                switch(choice){
                    case 1:
                        if(isForward==false){
                            itr.next();
                            isForward=true;
                        }
                        if(itr.hasNext()){
                            System.out.println("You're currently playing : ");
                            System.out.println(itr.next());
                        }
                        else{
                            System.out.println("You've reached the end of the playlist");
                        }
                        break;
                    case 2:
                        if(isForward==true){
                            itr.previous();
                            isForward=false;
                        }
                        if(itr.hasPrevious()){
                            System.out.println("You're currently playing : ");
                            System.out.println(itr.previous());
                        }
                        else{
                            System.out.println("You're at the start of the playlist");
                        }
                        break;
                    case 3:
                        if(isForward==true){
                            if(itr.hasPrevious()) {
                                System.out.println("You're currently playing : ");
                                System.out.println(itr.previous());
                                isForward=false;
                            }
                            else{
                                System.out.println("Song doesn't exist");
                            }
                        }
                        else{
                            if(itr.hasNext()){
                                System.out.println("You're currently playing : ");
                                System.out.println(itr.next());
                                isForward=true;
                            }
                            else{
                                System.out.println("Song doesn't exist");
                            }
                        }
                        break;
                    case 4:
                        printMenu();
                        break;
                    case 5:
                        itr.remove();
                        System.out.println("Song has been removed from  the playlist");
                        break;
                    case 6:
                        printAllSongs(playList);
                        break;
                    case 7:
                        quit=true;
                        break;

                }
            }
        }

        public static void printAllSongs(LinkedList<Song>playList){
        for(Song song:playList)
            System.out.println(song);
        return;
        }

    public static void printMenu(){
        System.out.println("SELECT YOUR CHOICE:");
        System.out.println(("1 - Play next song"));
        System.out.println(("2 - Play previous song"));
        System.out.println(("3 - Repeat the current song"));
        System.out.println(("4 - Show menu again"));
        System.out.println(("5 - Delete the current song"));
        System.out.println(("6 - Print all the songs in PlayList"));
        System.out.println(("7 - Exit"));

        return;
    }


}