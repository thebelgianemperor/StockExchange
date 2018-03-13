package Domain;
import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private int size;
	private List<Minion> board;
	
	public Board(int size){
		this.setSize(size);
		this.board = new ArrayList<Minion>(this.getSize());
		System.out.println();
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Minion getMinionAt(int index){
		return board.get(index);
	}
	
	public void addMinion(int index, Minion minion){
		CopyCard copy = new CopyCard(minion);
		board.add(index, (Minion) copy.card);
	}
	
	public Minion removeMinionAt(int index){
		Minion minion = this.getMinionAt(index);
		this.board.set(index, null);
		return minion;
	}
	
	public boolean isFull(){
		for (Minion minion: board){
			if (minion == null)
				return false;
		}
		return true;
	}
}
