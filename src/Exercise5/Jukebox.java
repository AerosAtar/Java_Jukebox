package Exercise5;

import java.util.ArrayList;
import java.util.Scanner;

public class Jukebox {

	public static void main(String[] args) 
	{
		//Initialise the album and song data
		DataInitialiser.generateSongsAndAlbums();
		
		//Create a blank playlist
		Playlist currentPlaylist = new Playlist();
		
		//Add a random track to the playlist
		currentPlaylist.generateRandomPlaylistEntry();

		//Start the player
//		Thread player = new Thread(new Player());
//		player.start();
				
		//Declare and set the default menuWidth variable value
		int menuWidth = 56;

		//Initialise a new Scanner instance for system input
		Scanner sc = new Scanner(System.in);
		
		//While the user input is not 0
		int menuSelection;
		do {
			//Initialise the front menu
			MenuBuilder.buildMenu(menuWidth, "Welcome to the Jukebox", DataInitialiser.frontMenu(), true);;

			//Select from the main menu based on user input
			menuSelection = sc.nextInt();

			switch (menuSelection)
			{
				case 1:
					listAlbumsByTitle(menuWidth, currentPlaylist, sc);

					//Leave the switch statement
					break;
				case 2:
					listAlbumsByArtist(menuWidth, currentPlaylist, sc);

					//Leave the switch statement
					break;
				case 3: 
					listSongsByTitle(menuWidth, currentPlaylist, sc);
					
					//Leave the switch statement
					break;
				case 4:
					listSongsByArtist(menuWidth, currentPlaylist, sc);
					
					//Leave the switch statement
					break;
				case 5:
					searchByText(menuWidth, currentPlaylist, sc);
					
					break;
				case 6:
					showPlaylist(menuWidth, currentPlaylist, sc);
					
			        //Leave the switch statement
					break;
				case 7:
				case 8:
				case 9:
				case 0:
					break;
				default:
					break;
			}
		} while (menuSelection != 0);
		
		//Close the scanner to prevent memory leaks
		sc.close();
	}
	
	public static void listAlbumsByTitle(int menuWidth, Playlist currentPlaylist, Scanner sc)
	{
		//Initialise the variables that will be used and set their values, if appropriate
		int menu1Selection;		//Input used at first menu
		ArrayList<String> albumTitles = Album.albumField("Title");
						
		//While the user does not select "Return to previous menu"
		Menu1:		//Return point for Break statements 
		do 
		{
			//Get the value to use for menuWidth
			menuWidth = MenuBuilder.getMenuWidth(albumTitles);

			//Build the menu
			MenuBuilder.buildMenu(menuWidth, "Listing Albums by Title", albumTitles, false);
			
			//Select from the menu based on user input
			menu1Selection = sc.nextInt();

			//If user selects "return to previous menu", break out of the loop
			if (menu1Selection == 0 ) { break Menu1; }
			
			//While the user does not select "Return to previous menu"
			int menu2Selection;		//Input used at second menu
			Menu2:		//Return point for Break statements
			do 
			{
				//Get the value to use for menuWidth
				menuWidth = MenuBuilder.getMenuWidth(Album.albumDetails(DataInitialiser.albumList.get(menu1Selection - 1)));
			
				//Build the menu
				MenuBuilder.buildDetails(menuWidth, albumTitles.get(menu1Selection - 1));
			
				//Select from the menu based on user input
				menu2Selection = sc.nextInt();

				//If user selects "return to previous menu", break out of the loop
				if (menu2Selection == 0 ) { break Menu2; }
				
				//Add the selected song to the playlist
				currentPlaylist.addTrackToPlaylist(DataInitialiser.albumList.get(menu1Selection - 1).getAlbumTracks().get(menu2Selection - 1));
				
				//Inform the user of their selection's position in the playlist
				System.out.println("Your selection has been added to the playlist. It is currently number " + currentPlaylist.getPlaylistTracks().size() + " in the list");

			} while(menu2Selection != 0);
		} while(menu1Selection != 0);
	}
	
	public static void listAlbumsByArtist(int menuWidth, Playlist currentPlaylist, Scanner sc) //TODO Refactor code - put method returns into variables for reusability!!!!!!!!!!
	{
		//Initialise the variables that will be used and set their values, if appropriate
		int menu1Selection;		//Input used at first menu
		ArrayList<String> albumArtists = Album.albumField("Artist");
		
		//While the user does not select "Return to previous menu"
		Menu1:		//Return point for Break statements 
		do 
		{
			//Get the value to use for menuWidth
			menuWidth = MenuBuilder.getMenuWidth(albumArtists);

			//Build the menu
			MenuBuilder.buildMenu(menuWidth, "Listing Artists", albumArtists, false);
			
			//Select from the menu based on user input
			menu1Selection = sc.nextInt();

			//If user selects "return to previous menu", break out of the loop
			if (menu1Selection == 0 ) { break Menu1; }
			
			//While the user does not select "Return to previous menu"
			int menu2Selection;		//Input used at the second menu
			Menu2:		//Return point for Break statements
			do 
			{
				//Get the value to use for menuWidth
				menuWidth = MenuBuilder.getMenuWidth(Album.albumDetails(DataInitialiser.albumList.get(menu1Selection - 1)));

				//Build the menu
				MenuBuilder.buildMenu(menuWidth, ("Listing Albums by " + albumArtists.get(menu1Selection - 1)), 
									  Album.albumField("Title", "Artist", albumArtists.get(menu1Selection - 1)), false);
				
				//Select from the menu based on user input
				menu2Selection = sc.nextInt();
				
				//If user selects "return to previous menu", break out of the loop
				if (menu2Selection == 0 ) { break Menu2; }
				
				//While the user does not select "Return to previous menu"
				int menu3Selection;		//Input used at the third menu
				Menu3:		//Return point for break statements
				do 
				{
					//Get the value to use for menuWidth
					menuWidth = MenuBuilder.getMenuWidth(Album.albumDetails(DataInitialiser.albumList.get(menu2Selection - 1)));
				
					//Build the menu
					MenuBuilder.buildDetails(menuWidth, Album.albumField("Title", "Artist", albumArtists.get(menu1Selection - 1)).get(menu2Selection - 1));
				
					//Select from the menu based on user input
					menu3Selection = sc.nextInt();
					
					//If user selects "return to previous menu", break out of the loop
					if (menu3Selection == 0 ) { break Menu3; }
					
					//Add the selected song to the playlist
					currentPlaylist.addTrackToPlaylist(Album.allAlbumsByArtist(albumArtists.get(menu1Selection - 1)).get(menu2Selection - 1).getAlbumTracks().get(menu3Selection - 1));  //TODO Make this cope with multi-disc albums
					
					//Add the selected song to the playlist, including handling multi-disc albums
//					int trackSelectionModifier = 1;
//					for (int i = 0; i < Album.getAllDiscTracks(DataInitialiser.albumList.get(menu2Selection - 1).getAlbumTitle()).size(); i++)
//					{
//						if ((menu3Selection - trackSelectionModifier) < Album.getAllDiscTracks().getAlbumTitle()).get(i))
//						{
//							currentPlaylist.addTrackToPlaylist(Album.allAlbumsByArtist(Album.albumField("Artist").get(menu1Selection - 1)).get(menu2Selection - 1).getAlbumTracks().get(menu3Selection - trackSelectionModifier));
//						}
//						else
//						{
//							trackSelectionModifier = trackSelectionModifier + Album.getAllDiscTracks(DataInitialiser.albumList.get(menu2Selection - 1).getAlbumTitle()).get(i);
//						}
//					}

					
					//Inform the user of their selection's position in the playlist
					System.out.println("Your selection has been added to the playlist. It is currently number " + currentPlaylist.getPlaylistTracks().size() + " in the list");

				} while(menu3Selection != 0);
			} while (menu2Selection != 0);
		} while(menu1Selection != 0);
	}

	public static void listSongsByTitle(int menuWidth, Playlist currentPlaylist, Scanner sc) //TODO Refactor code - put method returns into variables for reusability!!!!!!!!!!
	{
		//While the user does not select "return to previous menu"
		int menu1Selection;
		Menu1:
		do 
		{
			//Get the value to use for menuWidth
			menuWidth = MenuBuilder.getMenuWidth(Song.songDisplayTitles());
			
			//Build the menu
			MenuBuilder.buildMenu(menuWidth, "Listing Songs By Title", Song.songDisplayTitles(), false);
			
			//Select from the menu based on user input
			menu1Selection = sc.nextInt();
			
			//If user selects "return to previous menu", break out of the loop
			if (menu1Selection == 0) { break Menu1; }
			
			//Add the selected song to the playlist
			currentPlaylist.addTrackToPlaylist(DataInitialiser.songList.get(menu1Selection - 1));
			
			//Inform the user of their selection's position in the playlist
			System.out.println("Your selection has been added to the playlist. It is currently number " + currentPlaylist.getPlaylistTracks().size() + " in the list");
			
		} while (menu1Selection != 0);
	}
	
	public static void listSongsByArtist(int menuWidth, Playlist currentPlaylist, Scanner sc)	//TODO
	{
		//While the user does not select "return to previous menu"
		int menu1Selection;
		Menu1:
		do
		{
			//Get the value to use for menuWidth
			menuWidth = MenuBuilder.getMenuWidth(Song.songField("Artist"));
			
			//Build the menu
			MenuBuilder.buildMenu(menuWidth, "Listing Artists", Song.songField("Artist"), false);
			
			//Select from the menu based on user input
			menu1Selection = sc.nextInt();
			
			//If user selects "return to previous menu", break out of the loop
			if (menu1Selection == 0) { break Menu1; }
			
			//While the user does not select "return to previous menu"
			int menu2Selection;
			Menu2:
			do
			{
				//Get the value to use for menuWidth
				menuWidth = MenuBuilder.getMenuWidth(Song.songField("Title", "Artist", Song.songField("Artist").get(menu1Selection - 1)));
				
				//Build the menu
				MenuBuilder.buildMenu(menuWidth, ("Listing songs by " + Song.songField("Artist").get(menu1Selection - 1)), Song.songField("Title", "Artist", Song.songField("Artist").get(menu1Selection - 1)), false);
				//Select from the menu based on user input
				menu2Selection = sc.nextInt();
				
				//If user selects "return to previous menu", break out of the loop
				if (menu2Selection == 0) { break Menu2; }
				
				//Add the selected song to the playlist
//				currentPlaylist.addTrackToPlaylist(song);
				//Inform the user of their selection's position in the playlist
			} while (menu2Selection != 0);
		} while (menu1Selection != 0);
	}
	
	public static void searchByText(int menuWidth, Playlist currentPlaylist, Scanner sc)	//TODO
	{
		
	}
	
	public static void showPlaylist(int menuWidth, Playlist currentPlaylist, Scanner sc)
	{
		//Get the value to use for menuWidth
		ArrayList<String> playlistDisplayTitles = Playlist.playlistDisplayTitles(currentPlaylist);
		menuWidth = MenuBuilder.getMenuWidth(playlistDisplayTitles);

		//Build the menu
		MenuBuilder.showCurrentPlaylist(menuWidth, currentPlaylist, playlistDisplayTitles);
		
		//Take the next input (any character or null) and return to the main menu					
        try
        { System.in.read(); }  
        catch(Exception e)
        {}
	}
}