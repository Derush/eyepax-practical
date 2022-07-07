package com.eyepax;

/**
 * @author Derushan
 * Jul 7, 2022
 */
public class ColorGrid {
	
	// Grid coordination X as CordX and Y as CordY
	private int cordX , cordY;

	/**
	 * 
	 */
	public ColorGrid() {
		super();
	}

	/**
	 * @param cordX
	 * @param cordY
	 */
	public ColorGrid(int cordX, int cordY) {
		super();
		this.cordX = cordX;
		this.cordY = cordY;
	}

	/**
	 * @return the cordX
	 */
	public int getCordX() {
		return this.cordX;
	}

	/**
	 * @return the cordY
	 */
	public int getCordY() {
		return this.cordY;
	}
	
	// Direction of Colour Grids =====================================================================================
	
	//North
	public ColorGrid northDirection() {
		return new ColorGrid(this.cordX , this.cordY-1);
	}
	
	//East
	public ColorGrid eastDirection() {
		return new ColorGrid(this.cordX+1 , this.cordY);
	}
	
	//South
	public ColorGrid southDirection() {
		return new ColorGrid(this.cordX , this.cordY+1);
	}
	
	//West
	public ColorGrid westDirection() {
		return new ColorGrid(this.cordX-1 , this.cordY);
	}
	// ===============================================================================================================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cordX;
		result = prime * result + cordY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorGrid other = (ColorGrid) obj;
		if (cordX != other.cordX)
			return false;
		if (cordY != other.cordY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(coordinate X=" + cordX + ", coordinate Y=" + cordY + ")";
	}
	
	
	
}
