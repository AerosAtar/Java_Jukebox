package Exercise5;

import java.util.ArrayList;

public class MenuBuilder 
{
	//Get the width of the menu based on the length of the items in the menu
	public static int getMenuWidth(ArrayList<String> menuItems)
	{
		//Declare and set the default value for the menuWidth variable
		int menuWidth = 56;
		
		//Iterate through each item in the array list
		for (int i = 0; i < menuItems.size(); i++)
		{	
			//Compare the length of the item to menuWidth
			if (menuWidth < menuItems.get(i).length())
			{
				//If menuWidth is smaller, set it to the length of the item
				menuWidth = menuItems.get(i).length();
			}
		}
		
		//return the value of menuWidth
		return menuWidth;
	}
	
	//Build a 'standard' menu
	public static void buildMenu(int menuWidth, String menuTitle, ArrayList<String> menuItems, boolean mainMenu)
	{
	//Declare and set the measurement variables for the menu width
		int titleLength = menuTitle.length();
		int menuLeftSpace = (menuWidth - (titleLength + 2)) / 2;
		int menuRightSpace = menuWidth - (titleLength + 2 + menuLeftSpace);
		
	//Build the title section of the menu
		//Opening line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");
		
		//Title line
		System.out.print("*");
		for (int i = 1; i <= menuLeftSpace; i++) { System.out.print(" "); }
		System.out.print(menuTitle);
		for (int i = 1; i <= menuRightSpace; i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Closing line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");

	//Build the details section of the menu
		//Opening line
		System.out.print("*");
		for (int i = 1; i <= (menuWidth - 2); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Instruction line
		System.out.print("* Please make a selection from the following options:");
		for (int i = 1; i <= (menuWidth - 54); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Menu items
		for (int i = 0; i < menuItems.size(); i++)
		{
			System.out.print("* " + ((i < 9) ? " " : "") + (i + 1) + ") ");
			System.out.print(menuItems.get(i));
			for (int j = 1; j <= (menuWidth - (menuItems.get(i).length() + 7)); j++) { System.out.print(" "); }
			System.out.println("*");
		}
		
	//Build the closing section of the menu
		//Final menu item
		//Main Menu: Empty
		//Sub-menus: Return to previous menu
		if (mainMenu)
		{}
		else
		{
			System.out.print("*  0) Return to previous menu");
			for (int i = 1; i <= (menuWidth - 30); i++) { System.out.print(" "); }
			System.out.println("*");
		}
		
		//Closing line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");
	}

	//Build a menu showing the details of a single album (all discs)
	public static void buildDetails(int menuWidth, String albumTitle)
	{
		//Identify the album based on the passed album title
		Album album = null;
		
		for (int i = 0; i < DataInitialiser.albumList.size(); i++)
		{
			if (DataInitialiser.albumList.get(i).getAlbumTitle().equals(albumTitle))
			{
				album = DataInitialiser.albumList.get(i);
			}
		}
		
	//Build the title section of the menu
		//Opening line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");
		
		//Album title
		System.out.print("* Title: " + album.getAlbumTitle());
		for (int i = 1; i <= (menuWidth - (album.getAlbumTitle().length() + 10)); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Album artist
		System.out.print("* Artist: " + album.getAlbumArtist());
		for (int i = 1; i <= (menuWidth - (album.getAlbumArtist().length() + 11)); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Album year of release
		System.out.print("* Year of Release: " + album.getAlbumYearOfRelease());
		for (int i = 1; i <= (menuWidth - 24); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Album genres
			//Create a temporary String variable
			String genresTemp = null;
			
			//Loop through each genre
			for (int i = 0; i < album.getAlbumGenres().size(); i++)
			{
				//Add each genre to the string
				if (i == 0) { genresTemp = album.getAlbumGenres().get(i); }
				else {genresTemp = genresTemp + ", " + album.getAlbumGenres().get(i); }
			}
			
			//List out the genre details
			System.out.print("* Genres: " + genresTemp);
			for (int i = 1; i <= (menuWidth - (genresTemp.length() + 11)); i++) { System.out.print(" "); }
			System.out.println("*");
		
		//Closing line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");

	//Build the tracks section of the menu
		//Opening line
		System.out.print("*");
		for (int i = 1; i <= (menuWidth - 2); i++) { System.out.print(" "); }
		System.out.println("*");

		//Instruction line
		System.out.print("* Please make a selection from the following options:");
		for (int i = 1; i <= (menuWidth - 54); i++) { System.out.print(" "); }
		System.out.println("*");

		//Menu items
			//Create a temporary array list to hold the tracks
			ArrayList<Song> tracks = new ArrayList<Song>();
			
			//Loop through the album array list and identify all discs of the album
			for (int i = 0; i < DataInitialiser.albumList.size(); i++)
			{
				//If the album's title matches the title of the passed album
				if (DataInitialiser.albumList.get(i).getAlbumTitle().equals(album.getAlbumTitle()))
				{
					//Loop through the album's track list				
					for (int j = 0; j < DataInitialiser.albumList.get(i).getAlbumTracks().size(); j++)
					{
						//Add the track to the temporary array list
						tracks.add(DataInitialiser.albumList.get(i).getAlbumTracks().get(j));
					}
				}
			}
	
			//List each track in the arraylist
			for (int j = 0; j < tracks.size(); j++)
			{
				System.out.print("* " + ((j < 9) ? " " : "") + (j + 1) + ") ");
				System.out.print(tracks.get(j).getSongTitle());
				for (int k = 1; k <= (menuWidth - (tracks.get(j).getSongTitle().length() + 7)); k++) { System.out.print(" "); }
				System.out.println("*");
			}
		
	//Build the closing section of the menu
		//Final menu item
		System.out.print("*  0) Return to previous menu");
		for (int i = 1; i <= (menuWidth - 30); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Closing line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");
	}


	//Build a menu showing the current playlist
	public static void showCurrentPlaylist(int menuWidth, Playlist playlist, ArrayList<String> menuItems) 
	{
	//Declare and set the measurement variables for the menu width
		int titleLength = 16;
		int menuLeftSpace = (menuWidth - (titleLength + 2)) / 2;
		int menuRightSpace = menuWidth - (titleLength + 2 + menuLeftSpace);
		
	//Build the title section of the menu
		//Opening line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");
		
		//Title line
		System.out.print("*");
		for (int i = 1; i <= menuLeftSpace; i++) { System.out.print(" "); }
		System.out.print("Current Playlist");
		for (int i = 1; i <= menuRightSpace; i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Closing line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");

	//Build the details section of the menu
		//Opening line
		System.out.print("*");
		for (int i = 1; i <= (menuWidth - 2); i++) { System.out.print(" "); }
		System.out.println("*");

		//Now Playing line
		System.out.print("* Now Playing: ");
		System.out.print(menuItems.get(0));
		for (int i = 1; i <= (menuWidth - (menuItems.get(0).length() + 16)); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Separator line
		System.out.print("*");
		for (int i = 1; i <= (menuWidth - 2); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Remaining tracks in playlist
		for (int i = 1; i < menuItems.size(); i++)
		{
			System.out.print("* " + ((i < 9) ? " " : "") + (i) + ") ");
			System.out.print(menuItems.get(i));
			for (int j = 1; j <= (menuWidth - (menuItems.get(i).length() + 7)); j++) { System.out.print(" "); }
			System.out.println("*");
		}
		
		//Separator line
		System.out.print("*");
		for (int i = 1; i <= (menuWidth - 2); i++) { System.out.print(" "); }
		System.out.println("*");

		//Instruction line
		System.out.print("* Press any key to continue...");
		for (int i = 1; i <= (menuWidth - 31); i++) { System.out.print(" "); }
		System.out.println("*");
		
		//Closing line
		for (int i = 1; i <= (menuWidth - 1); i++) { System.out.print("*"); }
		System.out.println("*");
	}
}