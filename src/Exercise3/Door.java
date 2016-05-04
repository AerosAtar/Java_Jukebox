package Exercise3;

public class Door
{
	private int doorWidth;
	private int doorHeight;
	
	public Door() 
	{
		doorWidth = 900;	//Width of 'standard' door assumed to be 900mm
		doorHeight = 2100;	//Height of 'standard' door assumed to be 2100mm
	}
	
	public Door(int doorWidth, int doorHeight) 
	{
		doorWidth = doorWidth;
		doorHeight = doorHeight;
	}

	public int calculateDoorArea()
	{
		int doorArea = doorWidth * doorHeight;
		return doorArea;
	}

	public int getDoorWidth() 
	{
		return doorWidth;
	}

	public void setDoorWidth(int doorWidth) 
	{
		this.doorWidth = doorWidth;
	}

	public int getDoorHeight() 
	{
		return doorHeight;
	}

	public void setDoorHeight(int doorHeight)
	{
		this.doorHeight = doorHeight;
	}
}