import java.awt.Point;
public class Objects {
	public char[][] maze;
	public Point current=null;
	public Objects parent;
	public Objects[] children = new Objects[4];

	public Objects(){
		
	}
	
	public Objects(char[][] lab, Point now, Objects par){
		maze = new char [6][5];
		current = new Point();
		current.setLocation(now);
		for (int i=0; i<6; i++){
			for (int j=0; j<5; j++){
				maze[i][j]=lab[i][j];
			}
		}
		this.parent=par;
	}
	
	public Objects getParent(Objects node){
		return node.parent;
	}
	
}
