/******************************************
 *  Board.java                            *
 *  Board for Creature objects            *
 *  Version 0.0.1                         *
 *  August 12, 2016                       *
 *  - includes populating board randomly  *
 *  - crude display                       *
 ******************************************/

public class Board extends Utilities {
	private int sizex;
	private int sizey;
	private int population;
	private int max_population;
	Creature[][] board;

	public void Board(int sizex, int sizey, int creaturePop) {
		this.sizex = sizex;
		this.sizey = sizey;
		this.board = new Creature[sizex][sizey];
		this.max_population = sizex * sizey;
		populate(creaturePop);
	}

	public void populate(int pop) {
		for (int i = 0; i < pop; i++) {
			if (population >= max_population) {
				return;
			}
			int x;
			int y;
			do {
				x = random.nextInt(sizex);
				y = random.nextInt(sizey);
			} while (board[x][y] != null);
			board[x][y] = new Creature();
			population++;
			
		}
	}

	public void display() {
		String total = "";
		for (int x = 0; x < sizex; x++) {
			String line = "";
			for (int y = 0; y < sizey; y++) {
				if (board[x][y] == null) {
					line += " ";
				} else line += board[x][y].getName();
			}
			total += line + "\n";
		}
		System.out.print(total);
	}
}