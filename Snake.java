import java.util.*;

public class Snake  {

	private ArrayList<Integer> snakex = new ArrayList<Integer>();
	private ArrayList<Integer> snakey = new ArrayList<Integer>();

	public Snake(){
		snakex.add(0,100);
		snakex.add(1,75);
		snakex.add(2,50);

		snakey.add(0, 100);
		snakey.add(1, 100);
		snakey.add(2, 100);

	}

	public void moveSnake(int x, int y, int i){
		snakex.set(i, x);
		snakey.set(i, y);
	}


	public int getX(int a){
		return snakex.get(a);
	}

	public int getY(int a){
		return snakey.get(a);
	}


	public int getArraySize(){
		return snakex.size();
	}


	public void add() {
		snakex.add(snakex.get(snakex.size()-1) - 15);
		snakey.add(snakey.get(snakey.size() - 1));
	}

}
