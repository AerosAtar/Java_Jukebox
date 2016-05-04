package Exercise5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Album
{
	private String albumTitle;
	private String albumArtist;
	private int albumYearOfRelease;
	private int albumDiscNumber;
	private ArrayList<String> albumGenres = new ArrayList<String>();
	private ArrayList<Song> albumTracks = new ArrayList<Song>();

	//Constructors
	public Album(String albumTitle, String albumArtist, int albumYearOfRelease, int albumDiscNumber)
	{
		this.setAlbumTitle(albumTitle);
		this.setAlbumArtist(albumArtist);
		this.setAlbumYearOfRelease(albumYearOfRelease);
		this.setAlbumDiscNumber(albumDiscNumber);
	}

	//Methods
	public void addTrackToAlbum(int trackNumber, Song song)
	{
		this.albumTracks.add((trackNumber - 1), song);
	}
	
	public void removeTrackFromAlbum(int trackNumber)
	{
		this.albumTracks.remove(trackNumber - 1);
	}
	
	public void addGenreToAlbum(String genre)
	{
		this.albumGenres.add(genre);
	}
	
	public void removeGenreFromAlbum(int genre)
	{
		this.albumGenres.remove(genre - 1);
	}
	
	public static ArrayList<String> albumField(String field)
	{
		//Create a temporary set so we can get all unique values from the array
		Set<String> albumFieldTemp = new HashSet<String>();
		
		//Loop through the array of albums
		for (int i = 0; i < DataInitialiser.albumList.size(); i++)
		{
			//Select field value to add based on the passed string
			switch (field.toLowerCase())
			{
				case "title":
					//Add album title to the set (will skip over duplicates so they are not added)
					albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumTitle());
					break;
				case "artist":
					//Add album artist to the set (will skip over duplicates so they are not added)
					albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumArtist());
					break;
				case "genre":
					//Loop through the genres array
					for (int j = 0; j < DataInitialiser.albumList.get(i).getAlbumGenres().size(); j++)
					{
						//Add album genre to the set (will skip over duplicates so they are not added)
						albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumGenres().get(j));
					}
					break;
				default:
					//Add album title to the set (will skip over duplicates so they are not added)
					albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumTitle());
					break;
			}
		}
		
		//Create an array list to hold the values 
		ArrayList<String> albumField = new ArrayList<String>();
		
		//Add all of the values from the temporary set into the array
		albumField.addAll(albumFieldTemp);
		
//		//Sort the array list
//		ListSorting.sortStrings(albumField);
		
		//Return the array list
		return albumField;
	}

	public static ArrayList<String> albumField(String field, String filterBy, String filterValue)
	{
		//Create a temporary set so we can get all unique values from the array
		Set<String> albumFieldTemp = new HashSet<String>();
		
		boolean filterResult = false;
		
		//Loop through the array of albums
		for (int i = 0; i < DataInitialiser.albumList.size(); i++)
		{
			//Filter the list based on the passed in filter variable and value
			switch (filterBy.toLowerCase())
			{
				case "artist":
					filterResult = DataInitialiser.albumList.get(i).getAlbumArtist().equals(filterValue);
					break;
				case "title":
					filterResult = DataInitialiser.albumList.get(i).getAlbumTitle().equals(filterValue);
					break;
			}
			
			if (filterResult)
			{
				//Select while field value to add based on the passed string
				switch (field.toLowerCase())
				{
					case "artist":
						//Add album artist to the set (will skip over duplicates so they are not added)
						albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumArtist());
						break;
					case "title":
						//Add album title to the set (will skip over duplicates so they are not added)
						albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumTitle());
						break;
					case "genre":
						//Loop through the genres array
						for (int j = 0; j < DataInitialiser.albumList.get(i).getAlbumGenres().size(); j++)
						{
							//Add album genre to the set (will skip over duplicates so they are not added)
							albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumGenres().get(j));
						}
						break;
					default:
						//Add album title to the set (will skip over duplicates so they are not added)
						albumFieldTemp.add(DataInitialiser.albumList.get(i).getAlbumTitle());
						break;
				}
			}
			else { filterResult = false; }
		}
		
		//Create an array list to hold the values 
		ArrayList<String> albumField = new ArrayList<String>();
		
		//Add all of the values from the temporary set into the array
		albumField.addAll(albumFieldTemp);
		
//		//Sort the array list
//		ListSorting.sortStrings(albumField);
		
		//Return the array list

		return albumField;
	}

	public static ArrayList<String> albumDetails(Album album)
	{
		//Create a temporary set so we add only unique strings from the album details
		Set<String> albumDetailsTemp = new HashSet<String>();
		
		//Loop through each disc of the album and add the album details to the set
		for (int i = 0; i < DataInitialiser.albumList.size(); i++)
			if (DataInitialiser.albumList.get(i).getAlbumTitle().equals(album))
			{
				albumDetailsTemp.add(DataInitialiser.albumList.get(i).getAlbumTitle()); //Album title
				albumDetailsTemp.add(DataInitialiser.albumList.get(i).getAlbumArtist()); //Album artist
				//Full list of album genres, since these will be displayed on one line
				for (int j = 0; j < DataInitialiser.albumList.get(i).getAlbumGenres().size(); j++)
				{
					String genres = null;
					if ( j == 0) { genres = DataInitialiser.albumList.get(i).getAlbumGenres().get(j); }
					else { genres = genres + ", " + DataInitialiser.albumList.get(i).getAlbumGenres().get(j); }
				}
				//The title of each song on the album
				for (int j = 0; j < DataInitialiser.albumList.get(i).getAlbumTracks().size(); j++)
				{
					albumDetailsTemp.add(DataInitialiser.albumList.get(i).getAlbumTracks().get(j).getSongTitle());
				}
			}
		
		//Create an arraylist to hold the details
		ArrayList<String> albumDetails = new ArrayList<String>();
		
		//Add all of the details from the temporary set into the array
		albumDetails.addAll(albumDetailsTemp);
		
		return albumDetails;
	}
	
	public static ArrayList<Integer> getAllDiscTracks(String albumTitle)
	{
		ArrayList<Integer> allDiscTracks = new ArrayList<Integer>();
		
		for (int i = 0; i < DataInitialiser.albumList.size(); i++)
		{
			if (DataInitialiser.albumList.get(i).getAlbumTitle().equals(albumTitle))
			{
				allDiscTracks.add(DataInitialiser.albumList.get(i).getAlbumTracks().size());
			}
		}
		
		return allDiscTracks;
	}
	
	public static ArrayList<Album> allAlbumsByArtist(String artist)
	{
		//Create the array list to hold the albums
		ArrayList<Album> allAlbumsByArtist = new ArrayList<Album>();
		
		//Loop through the full album array
		for (int i = 0; i < DataInitialiser.albumList.size(); i++)
		{
			//If the album artist matches the passed variable, add it to the new array
			if (DataInitialiser.albumList.get(i).getAlbumArtist().equals(artist))
			{
				allAlbumsByArtist.add(DataInitialiser.albumList.get(i));
			}
		}
		
		return allAlbumsByArtist;
	}
	
	//Getters and Setters
	public String getAlbumTitle() 
	{
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) 
	{
		this.albumTitle = albumTitle;
	}
	

	public String getAlbumArtist() 
	{
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) 
	{
		this.albumArtist = albumArtist;
	}

	public int getAlbumYearOfRelease() 
	{
		return albumYearOfRelease;
	}

	public void setAlbumYearOfRelease(int albumYearOfRelease) 
	{
		this.albumYearOfRelease = albumYearOfRelease;
	}

	public int getAlbumDiscNumber() 
	{
		return albumDiscNumber;
	}

	public void setAlbumDiscNumber(int albumDiscNumber) 
	{
		this.albumDiscNumber = albumDiscNumber;
	}
	
	public ArrayList<String> getAlbumGenres() 
	{
		return albumGenres;
	}

	public ArrayList<Song> getAlbumTracks() 
	{
		return albumTracks;
	}
}