package Exercise5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSorter {

	//Sort string list alphabetically
	public static ArrayList<String> sortStrings(ArrayList<String> list)
	{
		Collections.sort(list);

		return list;
	}
	
	//Sort album list alphabetically by album artist
	public static ArrayList<Album> sortAlbumsByArtist(ArrayList<Album> albumsList)
	{
		Collections.sort(albumsList, new Comparator<Album>()
		{
			public int compare(Album a1, Album a2)
			{
				return a1.getAlbumArtist().compareToIgnoreCase(a2.getAlbumArtist());
			}
		});
		
		return albumsList;
	}

	//Sort album list alphabetically by album title
	public static ArrayList<Album> sortAlbumsByTitle(ArrayList<Album> albumsList)
	{
		Collections.sort(albumsList, new Comparator<Album>()
		{
			public int compare(Album a1, Album a2)
			{
				return a1.getAlbumTitle().compareToIgnoreCase(a2.getAlbumTitle());
			}
		});
		
		return albumsList;
	}

	//Sort song list alphabetically by song artist
	public void sortSongsByArtist(ArrayList<Song> songsList)
	{
		Collections.sort(songsList, new Comparator<Song>()
		{
			public int compare(Song s1, Song s2)
			{
				return s1.getSongArtist().compareToIgnoreCase(s2.getSongArtist());
			}
		});
	}

	//Sort song list alphabetically by song
	public void sortSongsByTitle(ArrayList<Song> songsList)
	{
		Collections.sort(songsList, new Comparator<Song>()
		{
			public int compare(Song s1, Song s2)
			{
				return s1.getSongTitle().compareToIgnoreCase(s2.getSongTitle());
			}
		});
	}

}
