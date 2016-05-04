package Exercise3;

public class Window
{
	private int windowWidth;
	private int windowHeight;
	
	public Window() 
	{
		int windowWidth;
		int windowHeight;
	}

	public Window(int windowWidth, int windowHeight) 
	{
		windowWidth = windowWidth;
		windowHeight = windowHeight;
	}

	public int calculateWindowArea()
	{
		int windowArea = windowWidth * windowHeight;
		return windowArea;
	}

	public int getWindowWidth() 
	{
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) 
	{
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() 
	{
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) 
	{
		this.windowHeight = windowHeight;
	}
}