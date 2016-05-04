package Exercise5;

import java.util.ArrayList;
import java.util.Random;

public class Playlist 
{
	private ArrayList<Song> playlistEntry = new ArrayList<Song>();
	
	//Constructors
	
	//Methods
	public void addTrackToPlaylist(Song song)
	{
		this.playlistEntry.add(song);
	}
	
	public void removeTrackFromPlaylist(int playlistPosition)
	{
		this.playlistEntry.remove(playlistPosition - 1);
	}
	
	public static ArrayList<String> playlistDisplayTitles(Playlist playlist)
	{ 
		//Create an array list to hold the values 
		ArrayList<String> playlistDisplayTitle = new ArrayList<String>();
		
		//Loop through the playlist
		for (int i = 0; i < playlist.getPlaylistTracks().size(); i++)
		{
			//Build the display string for each track
			playlistDisplayTitle.add(playlist.getPlaylistTracks().get(i).getSongTitle() + " - " + playlist.getPlaylistTracks().get(i).getSongArtist() + " (" +
					   					(playlist.getPlaylistTracks().get(i).getSongLength() / 60) + ":" + (playlist.getPlaylistTracks().get(i).getSongLength() - 
					   					((playlist.getPlaylistTracks().get(i).getSongLength() / 60)*60))+ ")");
		}
	
		//Return the array list
		return playlistDisplayTitle;
	}
	
	public void generateRandomPlaylistEntry()
	{
		Random randa = new Random();
		Random randb = new Random();
		
		//Get List of Albums
		ArrayList<Album> Albums = DataInitialiser.albumList;
		
		//Generate random song from random album
		int randomAlbum = randa.nextInt(Albums.size());
		int randomSong = randb.nextInt(Albums.get(randomAlbum).getAlbumTracks().size());
		
		//Add the random track to the playlist
		this.addTrackToPlaylist(Albums.get(randomAlbum).getAlbumTracks().get(randomSong));
	}

	public void ensurePlaylistNeverZeroLength(Playlist playlist)
	{
		//If the playlist is only 1 track long, add a random track to the end of the list
		if (playlist.getPlaylistTracks().size() == 1)
		{
			playlist.generateRandomPlaylistEntry();
		}
	}
	
	//Getters and Setters
	public ArrayList<Song> getPlaylistTracks()
	{
		return playlistEntry;
	}
}