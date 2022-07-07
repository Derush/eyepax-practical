package com.eyepax;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Derushan Jul 7, 2022
 */
public class GridBlock implements Comparable<GridBlock> {

	private String color;

	private Set<GridNode> gridNodes;

	/**
	 * @param color
	 * @param gridNode
	 */
	public GridBlock(String color) {
		super();
		this.color = color;
		this.gridNodes = new HashSet<>();
	}

	public Set<GridNode> allGridNodes(){
		return this.gridNodes;
	}
	
	public Set<ColorGrid> allColourGrids(){
		return this.gridNodes.stream().map(element -> element.getColorGrid()).collect(Collectors.toSet());
	}
	
	public boolean addNode(GridNode gridNode) {
		if(gridNode != null && !this.gridNodes.contains(gridNode) && gridNode.getColor().equals(this.color)) {
			return this.gridNodes.add(gridNode);
		}
		return false;
	}
	
	public boolean hasGridNode(GridNode gridNode) {
		if(gridNode == null) 
			return false;
		return this.gridNodes.stream().anyMatch(element -> element.getId() == gridNode.getId());
	}
	
	
	public void display() {
		this.gridNodes.forEach(element -> System.out.println(element.toString()));
	}
	
	public int size() {
		return this.gridNodes.size();
	}

	@Override
	public int compareTo(GridBlock o) {
		return this.gridNodes.size() - this.size();
	}
}
