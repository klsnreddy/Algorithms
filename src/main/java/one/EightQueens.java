package one;

import java.util.Arrays;

public class EightQueens {

	
	public void arrange(int row, int col, int[] pos) {
		
		if(row >= 8 || col >= 8)
			return;

		for(int j = 0; j < 8; j++) {
			int p = findPos(row, j, pos);
			if(p!= -1) {
				pos[row] = p;
				arrange(row + 1, 0, pos);
				if(pos[7] != -1)
					break;
			}
		}
		if(pos[row] == -1 && row > 0)
			pos[row -1] = -1;
	}
	
	private int findPos(int i, int j, int[] pos) {
		//check row
		if(pos[i] != -1)
			return -1;
		
		//check column
		for(int k = 0; k <= i; k++)
			if(pos[k] == j)
				return -1;
		
		//check the top left diagonal
		for(int k = j - 1, q = i - 1; k >= 0 && q >= 0; k--, q--)
			if(pos[q] == k)
				return -1;
		
		//check the top right diagonal
		for(int k = j + 1, q = i - 1; k < 8 && q >= 0; k++, q--)
			if(pos[q] == k)
				return -1;
		
		return j;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EightQueens eq = new EightQueens();
		
		int[] pos = new int[8];
		
		for(int i = 0; i < 8; i++)
			pos[i] = -1;
		
		eq.arrange(0, 0, pos);
		
		System.out.println(Arrays.toString(pos));
	}

}
