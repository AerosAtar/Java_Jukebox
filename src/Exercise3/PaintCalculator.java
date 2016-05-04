package Exercise3;

import java.util.ArrayList;
import java.util.Scanner;	//Import the Scanner library

public class PaintCalculator
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);	//Launch a new instance of Scanner on system input

		Room rm = new Room();		//Create a new instance of the Room object
		
		System.out.println("Please enter the width of the room, in millimeters:");
		rm.setRoomWidth(sc.nextInt());		//Room width
		
		System.out.println("Please enter the length of the room, in millimeters:");
		rm.setRoomLength(sc.nextInt());		//Room length
		
		System.out.println("Please enter the height of the room, in millimeters:");
		rm.setRoomHeight(sc.nextInt());		//Room height
		
		System.out.println("Please enter the number of doors in the room:");
		rm.setRoomDoors(sc.nextInt());		//Number of doors
		
		//Record details for all of the indicated doors
		ArrayList<Door> doors = new ArrayList<Door>();		//Create array to hold Door object(s)
		
		for(int i=1; i<= rm.getRoomDoors(); i++)		//Loop through each indicated Door (skip if setRoomDoors = 0)
		{
			Door currentDoor = new Door();		//Create new Door object
			
			System.out.println("Please enter the width of door " + i + ", in millimeters:");
			currentDoor.setDoorWidth(sc.nextInt());		//Use next integer input
									
			System.out.println("Please enter the height of door " + i + ", in millimeters:");
			currentDoor.setDoorHeight(sc.nextInt());		//Use next integer input
						
			doors.add(currentDoor);		//Add object to Array List
		}

		System.out.println("Please enter the number of windows in the room:");
		rm.setRoomWindows(sc.nextInt());		//Number of windows
		
		ArrayList<Window> windows = new ArrayList<Window>();	//Create array to hold Window object(s)
		
		for(int i=1; i<= rm.getRoomWindows(); i++)		//Loop through each indicated Window (skip if setRoomWindows = 0)
		{
			Window currentWindow = new Window();		//Create new Window object
			
			System.out.println("Please enter the width of window " + i + ", in millimeters:");
			currentWindow.setWindowWidth(sc.nextInt());		//Use next integer input
						
			System.out.println("Please enter the height of window " + i + ", in millimeters:");
			currentWindow.setWindowHeight(sc.nextInt());		//Use next integer input
			
			windows.add(currentWindow);		//Add object to Array List
		}
		
		System.out.println("Do you wish to include the area of the ceiling in the calculation?");
		String useCeiling = sc.next();		//Take next string input
		int ceilingArea = 0;
		
		if (useCeiling.equalsIgnoreCase("yes") || useCeiling.equalsIgnoreCase("y"))		//If the input was "yes"
		{
			ceilingArea = rm.calculateCeilingArea();		//Calculate the surface area of the ceiling
		}
		
		System.out.println("Do you wish to include the area of the floor in the calculation?");
		String useFloor = sc.next();		//Take next string input
		int floorArea = 0;
		
		if (useFloor.equalsIgnoreCase("yes") || useFloor.equalsIgnoreCase("y"))		//If the input was "yes"
		{
			floorArea = rm.calculateFloorArea();		//Calculate the surface area of the floor
		}
		
		System.out.println("You have entered the following details:");
		System.out.println();
		System.out.println("Room Dimensions (W x L x H): " + rm.getRoomWidth() + "mm x " + rm.getRoomLength() + "mm x " + rm.getRoomHeight() + "mm");
		if (rm.getRoomDoors() >= 1)
		{
			System.out.println("Number of Doors: " + rm.getRoomDoors());
			System.out.println("Door Measurements (W x H): ");
			for (int i = 0; i < rm.getRoomDoors(); i++)
			{
				System.out.println("    " + (i + 1) + ") " + doors.get(i).getDoorWidth() + "mm x " + doors.get(i).getDoorHeight() + "mm");
			}
		}
		if (rm.getRoomWindows() >= 1)
		{
			System.out.println("Number of Windows: " + rm.getRoomDoors());
			System.out.println("Window Measurements (W x H): ");
			for (int i = 0; i < rm.getRoomWindows(); i++)
			{
				System.out.println("    " + (i + 1) + ") " + windows.get(i).getWindowWidth() + "mm x " + windows.get(i).getWindowHeight() + "mm");
			}
		}
		System.out.println();
		System.out.println("Are these details correct?");
		String detailsCorrect = sc.next();
		if (detailsCorrect.equalsIgnoreCase("no") || detailsCorrect.equalsIgnoreCase("n"))
		{
			System.out.println("Please restart the programme to enter correct values.");
			System.exit(0);
		}
						
		sc.close();		//End of this user input section, so close the scanner
	
		//Run the calculations to get the total surface area to be painted
		int totalDoorArea = 0;
		int totalWindowArea = 0;
				
		for (int i = 0; i < rm.getRoomDoors(); i++)		//Loop through all Door objects
		{
			totalDoorArea = totalDoorArea + doors.get(i).calculateDoorArea();
		}
		
		for (int i = 0; i < rm.getRoomWindows(); i++)		//Loop through all Window objects
		{
			totalWindowArea = totalWindowArea + windows.get(i).calculateWindowArea();
		}
		
		int totalSurfaceArea = (rm.calculateWallArea() + (ceilingArea + floorArea) - (totalDoorArea + totalWindowArea)) / 1000;		//Calculate the total surface area to be painted  
		
		//Create objects for tins of paint
		TinOfPaint CheapoMax = new TinOfPaint();
		CheapoMax.setName("CheapoMax");
		CheapoMax.setCostPerTin(1999);
		CheapoMax.setLitresPerTin(20);
		CheapoMax.setCoveragePerLitre(11000);
		
		TinOfPaint AverageJones = new TinOfPaint();
		AverageJones.setName("AverageJones");
		AverageJones.setCostPerTin(1999);
		AverageJones.setLitresPerTin(15);
		AverageJones.setCoveragePerLitre(14000);
		
		TinOfPaint DuluxourousPaints = new TinOfPaint();
		DuluxourousPaints.setName("DuluxourousPaints");
		DuluxourousPaints.setCostPerTin(1999);
		DuluxourousPaints.setLitresPerTin(10);
		DuluxourousPaints.setCoveragePerLitre(17000);
		
		//Create Array List of all tins of paint 
		ArrayList<TinOfPaint> paints = new ArrayList<TinOfPaint>();
		paints.add(CheapoMax);
		paints.add(AverageJones);
		paints.add(DuluxourousPaints);

		//Run the calculations for each tin of paint
		int coveragePerTin;
		int requiredNumberOfTins;
		int leftoverPaintCoverage;
		int totalCostOfPaint;
		
		int[][] paintTotals = new int[paints.size()][4]; 
		
		for (int i = 0; i < paints.size(); i++)
		{
			coveragePerTin = paints.get(i).getLitresPerTin() * paints.get(i).getCoveragePerLitre();
			
			requiredNumberOfTins = (int) Math.ceil((double) totalSurfaceArea / (double) coveragePerTin);
			
			leftoverPaintCoverage = (coveragePerTin * requiredNumberOfTins) - totalSurfaceArea;
			
			totalCostOfPaint = paints.get(i).getCostPerTin() * requiredNumberOfTins;
			
			paintTotals[i][0] = i;
			paintTotals[i][1] = requiredNumberOfTins;
			paintTotals[i][2] = leftoverPaintCoverage;
			paintTotals[i][3] = totalCostOfPaint;
		}
		
		//Calculate the cheapest paint to use
		String cheapestPaint = "";
		int cheapestNumberOfTins = 0;
		int cheapestCost = 0;
				
		for (int i = 0; i < paints.size(); i++)
		{
			if (cheapestPaint != "")
			{
				if (paintTotals[i][3] < cheapestCost)
				{
					cheapestPaint = paints.get(i).name;
					cheapestNumberOfTins = paintTotals[i][1];
					cheapestCost = paintTotals[i][3];
				}
				else
				{
					cheapestPaint = cheapestPaint;
					cheapestNumberOfTins = cheapestNumberOfTins;
					cheapestCost = cheapestCost;
				}
			}
			else
			{
				cheapestPaint = paints.get(i).name;
				cheapestNumberOfTins = paintTotals[i][1];
				cheapestCost = paintTotals[i][3];
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.print("The cheapest paint to use is " + cheapestPaint + ", requiring " + cheapestNumberOfTins + " can"); 
		if(cheapestNumberOfTins > 1){System.out.print("s");}
		System.out.println(" at a total cost of £" + ((double) cheapestCost / 100));
	}
}