package Exercise5;

import java.util.ArrayList;

public class DataInitialiser 
{
	//Create an array list to hold the album details, available to the whole package
	static ArrayList<Album> albumList = new ArrayList<Album>();
	
	//Create an array list to hold the song details, available to the whole package
	static ArrayList<Song> songList = new ArrayList<Song>(); 
	
	//Create the array list of menu options for the main menu
	public static ArrayList<String> frontMenu()
	{
		ArrayList<String> frontMenu = new ArrayList<String>();
		frontMenu.add("List Albums by Title");
		frontMenu.add("List Albums by Artist");
		//frontMenu.add("Search Albums by Genre");
		//frontMenu.add("Search Albums by Release Year");
		frontMenu.add("List Songs by Title");
		frontMenu.add("List Songs by Artist");
		frontMenu.add("Search Albums, Songs and Artists");
		frontMenu.add("View Current Playlist");
		
		return frontMenu;
	}
	
	//Create all of the song and album objects to use in the jukebox
	public static ArrayList<Album> generateSongsAndAlbums()
	{
		//Generate songs
		Song AnimalArmy = new Song("Animal Army","Babylon Zoo", 355);
		Song Spaceman = new Song("Spaceman", "Babylon Zoo", 341);
		Song ZodiacSign = new Song("Zodiac Sign", "Babylon Zoo", 298);
		Song ParisGreen = new Song("Paris Green", "Babylon Zoo", 283);
		Song ConfusedArt = new Song("Confused Art", "Babylon Zoo", 272);
		Song Caffeine = new Song("Caffeine", "Babylon Zoo", 394);
		Song TheBoyWithTheXRayEyes = new Song("The Boy With The X-Ray Eyes", "Babylon Zoo", 267);
		Song DontFeedTheAnimals = new Song("Don't Feed The Animals", "Babylon Zoo", 98);
		Song FireGuidedLight = new Song("Fire Guided Light", "Babylon Zoo", 403);
		Song IsYourSoulForSale = new Song("Is Your Soul For Sale?", "Babylon Zoo", 352);
		Song ImCrackingUpINeedAPill = new Song("I'm Cracking Up I Need a Pill", "Babylon Zoo", 226);
		Song NoMoreWalksInTheWood = new Song("No More Walks in the Wood", "Eagles", 120);
		Song HowLong = new Song("How Long", "Eagles", 196);
		Song BusyBeingFabulous = new Song("Busy Being Fabulous", "Eagles", 260);
		Song WhatDoIDoWithMyHeart = new Song("What Do I Do With My Heart", "Eagles", 234);
		Song GuiltyOfTheCrime = new Song("Guilty of the Crime", "Eagles", 223);
		Song IDontWantToHearAnyMore = new Song("I Don't Want to Hear Any More", "Eagles", 261);
		Song WaitingInTheWeeds = new Song("Waiting in the Weeds", "Eagles", 466);
		Song NoMoreCloudyDays = new Song("No More Cloudy Days", "Eagles", 243);
		Song FastCompany = new Song("Fast Company", "Eagles", 240);
		Song DoSomething = new Song("Do Something", "Eagles", 312);
		Song YouAreNotAlone = new Song("You Are Not Alone", "Eagles", 144);
		Song LongRoadOutOfEden = new Song("Long Roady Out of Eden", "Eagles", 617);
		Song IDreamedThereWasNoWar = new Song("I Dreamed There Was No War", "Eagles", 93);
		Song Somebody = new Song("Somebody", "Eagles", 249);
		Song FrailGraspOnTheBigPicture = new Song("Frail Grasp on the Big Picture", "Eagles", 346);
		Song LastGoodTimeInTown = new Song("Last Good Time in Town", "Eagles", 427);
		Song ILoveToWatchAWomanDance = new Song("I Love to Watch a Woman Dance", "Eagles", 196);
		Song BusinessAsUsual = new Song("Business as Usual", "Eagles", 331);
		Song CenterOfTheUniverse = new Song("Center of the Universe", "Eagles", 222);
		Song ItsYourWorldNow = new Song("It's Your World Now", "Eagles", 262);

		//Add album to array list, including all genres and songs
		Album albumTheBoyWithTheXRayEyes = new Album("The Boy With the X-Ray Eyes", "Babylon Zoo", 1996, 1);
		albumTheBoyWithTheXRayEyes.addGenreToAlbum("Alternative Rock");
		albumTheBoyWithTheXRayEyes.addGenreToAlbum("Space Rock");
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(1, AnimalArmy);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(2, Spaceman);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(3, ZodiacSign);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(4, ParisGreen);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(5, ConfusedArt);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(6, Caffeine);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(7, TheBoyWithTheXRayEyes);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(8, DontFeedTheAnimals);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(9, FireGuidedLight);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(10, IsYourSoulForSale);
		albumTheBoyWithTheXRayEyes.addTrackToAlbum(11, ImCrackingUpINeedAPill);
		albumList.add(albumTheBoyWithTheXRayEyes);

		//Add album to array list, including all genres and songs
		Album albumLongRoadOutOfEden1 = new Album("Long Road Out of Eden", "Eagles", 2007, 1);
		albumLongRoadOutOfEden1.addGenreToAlbum("Rock");
		albumLongRoadOutOfEden1.addTrackToAlbum(1, NoMoreWalksInTheWood);
		albumLongRoadOutOfEden1.addTrackToAlbum(2, HowLong);
		albumLongRoadOutOfEden1.addTrackToAlbum(2, BusyBeingFabulous);
		albumLongRoadOutOfEden1.addTrackToAlbum(4, WhatDoIDoWithMyHeart);
		albumLongRoadOutOfEden1.addTrackToAlbum(5, GuiltyOfTheCrime);
		albumLongRoadOutOfEden1.addTrackToAlbum(6, IDontWantToHearAnyMore);
		albumLongRoadOutOfEden1.addTrackToAlbum(7, WaitingInTheWeeds);
		albumLongRoadOutOfEden1.addTrackToAlbum(8, NoMoreCloudyDays);
		albumLongRoadOutOfEden1.addTrackToAlbum(9, FastCompany);
		albumLongRoadOutOfEden1.addTrackToAlbum(10, DoSomething);
		albumLongRoadOutOfEden1.addTrackToAlbum(11, YouAreNotAlone);
		albumList.add(albumLongRoadOutOfEden1);
		
		//Add album to array list, including all genres and songs
		Album albumLongRoadOutOfEden2 = new Album("Long Road Out of Eden", "Eagles", 2007, 2);
		albumLongRoadOutOfEden2.addGenreToAlbum("Rock");
		albumLongRoadOutOfEden2.addTrackToAlbum(1, LongRoadOutOfEden);
		albumLongRoadOutOfEden2.addTrackToAlbum(2, IDreamedThereWasNoWar);
		albumLongRoadOutOfEden2.addTrackToAlbum(3, Somebody);
		albumLongRoadOutOfEden2.addTrackToAlbum(4, FrailGraspOnTheBigPicture);
		albumLongRoadOutOfEden2.addTrackToAlbum(5, LastGoodTimeInTown);
		albumLongRoadOutOfEden2.addTrackToAlbum(6, ILoveToWatchAWomanDance);
		albumLongRoadOutOfEden2.addTrackToAlbum(7, BusinessAsUsual);
		albumLongRoadOutOfEden2.addTrackToAlbum(8, CenterOfTheUniverse);
		albumLongRoadOutOfEden2.addTrackToAlbum(9, ItsYourWorldNow);
		albumList.add(albumLongRoadOutOfEden2);

		//Populate the list of songs
		populateSongList();
		
		return albumList;
	}

	//Populate the songList array
	public static ArrayList<Song> populateSongList()
	{
		//Loop though the album array
		for (int i = 0; i < albumList.size(); i++)
		{
			//Loop through the tracks array for each album
			for (int j = 0; j < albumList.get(i).getAlbumTracks().size(); j++)
			{
				//Add each song to the songList array
				songList.add(albumList.get(i).getAlbumTracks().get(j));
			}
		}
		
		return songList;
	}
}