import java.util.*;

public class nodeList {
	 public char [][] maze;
	 public Objects origin;
	
	 public nodeList(char[][] lab, Objects origin){
		 maze = new char[6][5];
		 for(int i=0; i<6; i++){
			 for (int j=0; j<5; j++){
				 maze[i][j]=lab[i][j];
			 }
		 }
		 this.origin=origin;
	 }
	}
