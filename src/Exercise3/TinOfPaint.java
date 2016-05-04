package Exercise3;

public class TinOfPaint
{
	String name;
	int costPerTin = 0;
	int litresPerTin = 0;
	int coveragePerLitre = 0;
	
	public TinOfPaint()
	{
		String name;
		int costPerTin;
		int litresPerTin;
		int coveragePerLitre;
	}
	
	public TinOfPaint(String name, int costPerTin, int litresPerTin, int coveragePerLitre)
	{
		this.name = name;
		this.costPerTin = costPerTin;
		this.litresPerTin = litresPerTin;
		this.coveragePerLitre = coveragePerLitre;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getCostPerTin() 
	{
		return costPerTin;
	}

	public void setCostPerTin(int costPerTin) 
	{
		this.costPerTin = costPerTin;
	}

	public int getLitresPerTin() 
	{
		return litresPerTin;
	}

	public void setLitresPerTin(int litresPerTin) 
	{
		this.litresPerTin = litresPerTin;
	}

	public int getCoveragePerLitre() 
	{
		return coveragePerLitre;
	}

	public void setCoveragePerLitre(int coveragePerLitre) 
	{
		this.coveragePerLitre = coveragePerLitre;
	}
}