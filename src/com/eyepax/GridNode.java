package com.eyepax;

/**
 * @author Derushan Jul 7, 2022
 */
public class GridNode {

	private ColorGrid colorGrid;
	private String color;
	private int id;

	public GridNode(int id, String color, int cordX, int cordY) {

		this.id = id;
		this.color = color;
		this.colorGrid = new ColorGrid(cordX, cordY);

	}

	public ColorGrid getColorGrid() {
		return this.colorGrid;
	}

	public String getColor() {
		return this.color;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((colorGrid == null) ? 0 : colorGrid.hashCode());
		result = prime * result + id;
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
		GridNode other = (GridNode) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (colorGrid == null) {
			if (other.colorGrid != null)
				return false;
		} else if (!colorGrid.equals(other.colorGrid))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(colourGrid=" + colorGrid.toString() + ", colour=" + color + ", id=" + id + ")";
	}
	
	
	
}
