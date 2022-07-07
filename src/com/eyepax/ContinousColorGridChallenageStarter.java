/*
Copyright [2020] [Apptimus Tech (Pvt) Ltd.]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/**
 * 
 */
package com.eyepax;

/**
 * @author Derushan Jul 7, 2022
 */
public class ContinousColorGridChallenageStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int WIDTH = 6;
		int HEIGHT = 6;

		ContinuousColorGridCountChallenge challenge = new ContinuousColorGridCountChallenge();
		challenge.countChallengeInitialize(WIDTH, HEIGHT);
		challenge.printCountChallengeColourGrid();

		GridBlock gridBlock = challenge.getLargestBlock();

		if (gridBlock != null) {
			System.out.println("++++++++++++++++++++LARGEST_BLOCK_OUTPUT++++++++++++++++++++");
			System.out.println("++++++++++++++++++++LARGEST_BLOCK_OUTPUT++++++++++++++++++++");
			
			challenge.printCountChallengeColourGridWithGridBlock(gridBlock);

		}

	}
}
