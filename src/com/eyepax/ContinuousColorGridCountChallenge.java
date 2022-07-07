package com.eyepax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Derushan Jul 7, 2022
 */
public class ContinuousColorGridCountChallenge {

	public static final String[] COLORS = { "RED", "BLUE", "GRAY" ,"WHITE","GREEN"};

	private HashMap<ColorGrid, GridNode> countChallange;

	private int column, row;

	// First initialize the challenge
	public void countChallengeInitialize(int columns, int rows) {
		this.column = columns;
		this.row = rows;

		Random random = new Random();
		this.countChallange = new HashMap<>();
		for (int i = 0; i < columns * rows; i++) {
			int cordX = i % columns;
			int cordY = (int) Math.floor(i / columns);
			this.countChallange.put(new ColorGrid(cordX, cordY),
					new GridNode(i, COLORS[random.nextInt(3)], cordX, cordY));
		}

	}

	// find the grid coordinates
	public GridNode getGridNode(int cordX, int cordY) {
		return this.countChallange.get(new ColorGrid(cordX, cordY));
	}

	// Print the Color Grid for the count challenge
	public void printCountChallengeColourGrid() {
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < column; x++) {
				if (x == this.column - 1) {
					System.out.println(getGridNode(x, y).getColor());
				} else {
					System.out.print(getGridNode(x, y).getColor() + ", ");
				}
			}
		}
	}

	// print the Grid Block with color
	public void printCountChallengeColourGridWithGridBlock(GridBlock gridBlock) {
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < column; x++) {
				GridNode node = getGridNode(x, y);
				String color =  gridBlock.hasGridNode(node) ? " found " : node.getColor();
				if (x == this.column - 1) {
					System.out.println(color);
				} else {
					System.out.print(color + ",");
				}
			}
		}
	}

	// find the next adjacent node
	private List<GridNode> detectAdjacentNodes(GridNode node, GridBlock gridBlock) {

		List<GridNode> nodes = new ArrayList<>();

		ColorGrid colorGrid = node.getColorGrid();

		GridNode northDirection = this.countChallange.get(colorGrid.northDirection());
		if (northDirection != null && northDirection.getColor() == node.getColor()
				&& !gridBlock.hasGridNode(northDirection)) {
			nodes.add(northDirection);
		}

		GridNode eastDirection = this.countChallange.get(colorGrid.eastDirection());
		if (eastDirection != null && eastDirection.getColor() == node.getColor()
				&& !gridBlock.hasGridNode(eastDirection)) {
			nodes.add(eastDirection);
		}

		GridNode westDirection = this.countChallange.get(colorGrid.westDirection());
		if (westDirection != null && westDirection.getColor() == node.getColor()
				&& !gridBlock.hasGridNode(westDirection)) {
			nodes.add(westDirection);
		}

		GridNode southDirection = this.countChallange.get(colorGrid.southDirection());
		if (southDirection != null && southDirection.getColor() == node.getColor()
				&& !gridBlock.hasGridNode(southDirection)) {
			nodes.add(southDirection);
		}
		return nodes;
	}

	// find the block sequence
	public GridBlock getBlockSequence(int cordX, int cordY) {

		ColorGrid firstColour_Grid = new ColorGrid(cordX, cordY);

		GridNode firstGrid_Node = this.countChallange.get(firstColour_Grid);

		GridBlock gridBlock = new GridBlock(firstGrid_Node.getColor());
		gridBlock.addNode(firstGrid_Node);

		LinkedList<GridNode> inspectNodes = new LinkedList<>();
		inspectNodes.addAll(detectAdjacentNodes(firstGrid_Node, gridBlock));

		while (!inspectNodes.isEmpty()) {
			GridNode nextInspectNode = inspectNodes.remove();
			gridBlock.addNode(nextInspectNode);
			inspectNodes.addAll(detectAdjacentNodes(nextInspectNode, gridBlock));
		}
		return gridBlock;
	}

	// find the largest block
	public GridBlock getLargestBlock() {
		Set<ColorGrid> allColourGrids = new HashSet<>(this.countChallange.keySet());
		List<GridBlock> allGridBlocks = new ArrayList<>();

		while (!allColourGrids.isEmpty()) {
			ColorGrid colorGrid = allColourGrids.iterator().next();
			GridBlock newGridBlock = getBlockSequence(colorGrid.getCordX(), colorGrid.getCordY());
			allGridBlocks.add(newGridBlock);
			allColourGrids.removeAll(newGridBlock.allColourGrids());
		}
		Collections.sort(allGridBlocks);
		return allGridBlocks.size() > 0 ? allGridBlocks.get(0) : null;
	}
	
	

}
