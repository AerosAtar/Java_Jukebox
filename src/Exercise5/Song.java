package Exercise5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Song
{
	private String songTitle;
	private String songArtist;
	private int songLength;		//Song duration in seconds
	
//Constructors
	//Only one constructor is used as a song that is missing any of the information would
	//be unusable and therefore cannot be added
	public Song(String songTitle, String songArtist, int songLength)
	{
		this.songTitle = songTitle;
		this.songArtist = songArtist;
		this.songLength = songLength;
	}
	
//Methods
	public static ArrayList<String> songDisplayTitles()
	{
		//Create the array list to hold the display titles
		ArrayList<String> songDisplayTitles = new ArrayList<String>();
		
		//Loop through the song array
		for (int i = 0; i < DataInitialiser.songList.size(); i++)
		{
			//Construct the string to hold the display title (song title + artist name) and add it to the array
			songDisplayTitles.add(DataInitialiser.songList.get(i).getSongTitle() + " - " + DataInitialiser.songList.get(i).getSongArtist());
		}

		return songDisplayTitles;
	}

	public static ArrayList<String> songField(String field)
	{
		//Create a temporary set so we can get all unique values from the array
		Set<String> songFieldTemp = new HashSet<String>();
		
		//Loop through the array of songs
		for (int i = 0; i < DataInitialiser.songList.size(); i++)
		{
			//Select field value to add based on the passed string
			switch (field.toLowerCase())
			{
				case "artist":
					//Add song artist to the set (will skip over duplicates so they are not added)
					songFieldTemp.add(DataInitialiser.songList.get(i).getSongArtist());
					break;
				//Using this case is not recommended as multiple artists can release songs with the same title
				case "title":
					//Add song title to the set (will skip over duplicates so they are not added)
					songFieldTemp.add(DataInitialiser.songList.get(i).getSongTitle());
					break;
				default:
					//Add song artist to the set (will skip over duplicates so they are not added)
					songFieldTemp.add(DataInitialiser.songList.get(i).getSongArtist());
					break;
			}
		}
		
		//Create an array to hold the values
		ArrayList<String> songField = new ArrayList<String>();
		
		//Add all of the values from the tempoary set into the array
		songField.addAll(songFieldTemp);
		
		return songField;
	}

	public static ArrayList<String> songField(String field, String filterBy, String filterValue)
	{
		//Create a temporary set so we can get all unique values from the array
		Set<String> songFieldTemp = new HashSet<String>();
		
		boolean filterResult = false;
		
		//Loop through the array of songs
		for (int i = 0; i < DataInitialiser.songList.size(); i++)
		{
			//Filter the list based on the passed in filter variable and value
			switch(filterBy.toLowerCase())
			{
				case "artist":
					filterResult = DataInitialiser.songList.get(i).equals(filterValue);
					break;
			}
			
			if (filterResult)
			{
				//Select field value to add based on the passed string
				switch (field.toLowerCase())
				{
					case "artist":
						//Add song artist to the set (will skip over duplicates so they are not added)
						songFieldTemp.add(DataInitialiser.songList.get(i).getSongArtist());
						break;
					//Using this case is not recommended as multiple artists can release songs with the same title
					case "title":
						//Add song title to the set (will skip over duplicates so they are not added)
						songFieldTemp.add(DataInitialiser.songList.get(i).getSongTitle());
						break;
					default:
						//Add song artist to the set (will skip over duplicates so they are not added)
						songFieldTemp.add(DataInitialiser.songList.get(i).getSongArtist());
						break;
				}
			} else { filterResult = false; }
		}
		
		//Create an array to hold the values
		ArrayList<String> songField = new ArrayList<String>();
		
		//Add all of the values from the tempoary set into the array
		songField.addAll(songFieldTemp);
		
		return songField;
	}
	
//Getter and Setters
	public String getSongTitle()
	{
		return songTitle;
	}

	public void setSongTitle(String songTitle) 
	{
		this.songTitle = songTitle;
	}

	public String getSongArtist() 
	{
		return songArtist;
	}

	public void setSongArtist(String songArtist) 
	{
		this.songArtist = songArtist;
	}

	public int getSongLength() 
	{
		return songLength;
	}

	public void setSongLength(int songLength) 
	{
		this.songLength = songLength;
	}
}