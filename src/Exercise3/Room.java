package Exercise3;

public class Room
{
	private int roomWidth;
	private int roomLength;
	private int roomHeight;
	
	private int roomDoors;		//Number of doors in the room
	private int roomWindows;	//Number of windows in the room
	
	public int calculateWallArea()
	{
		int wallArea1 = roomWidth * roomHeight;		//One pair of walls will be width * height
		int wallArea2 = roomLength * roomHeight;	//Second pair of walls will be length * height
		
		int totalWallArea = wallArea1 + wallArea1 + wallArea2 + wallArea2;	//Total surface area of all four walls
		return totalWallArea;
	}
	
	public int calculateCeilingArea()
	{
		int roomCeilingArea = roomWidth * roomLength;	//Surface area of ceiling
		return roomCeilingArea;
	}
	
	public int calculateFloorArea()
	{
		int roomFloorArea = roomWidth * roomLength;	//Surface area of floor
		return roomFloorArea;
	}

	public int getRoomWidth() 
	{
		return roomWidth;
	}

	public void setRoomWidth(int roomWidth) 
	{
		this.roomWidth = roomWidth;
	}

	public int getRoomLength() 
	{
		return roomLength;
	}

	public void setRoomLength(int roomLength) 
	{
		this.roomLength = roomLength;
	}

	public int getRoomHeight() 
	{
		return roomHeight;
	}

	public void setRoomHeight(int roomHeight) 
	{
		this.roomHeight = roomHeight;
	}

	public int getRoomDoors() 
	{
		return roomDoors;
	}

	public void setRoomDoors(int roomDoors) 
	{
		this.roomDoors = roomDoors;
	}

	public int getRoomWindows() 
	{
		return roomWindows;
	}

	public void setRoomWindows(int roomWindows) 
	{
		this.roomWindows = roomWindows;
	}		
}