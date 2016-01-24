import java.awt.*;
import java.awt.Point;
import javax.swing.*;

public class Lavirinthos extends JPanel  {
	//Σημείο Εκκίνησης
	final static int entranceC = 1;
	final static int entranceL = 5;
	//Σημείο Εξόδου
	final static int exitC = 3;
	final static int exitL = 5;
	//Θα χρησιμοποιηθούν για την εμφάνιση των αποτελεσμάτων
	static char[][] printed = new char[6][5];
	static char[][] printedF = new char[6][5];

	/*Μέθοδος που δημιουργεί τον λαβύρινθο. 
	 */
	public static void setWalls(char[][] lab){
		lab[0][0]=lab[1][0]=lab[2][0]=lab[3][0]=lab[4][0]=lab[5][0]= 'W';
		lab[0][4]=lab[1][4]=lab[2][4]=lab[3][4]=lab[4][4]=lab[5][4]='W';
		lab[0][1]=lab[0][3]='W';
		lab[5][2]=lab[4][2]=lab[2][2]=lab[1][2]=lab[0][2]='W';
	}
	 /**
	  * Μέθοδος που ελέγχει αν έχει βρεθεί η λύση.
	  * Δηλαδή, ελέγχει αν έχουμε φτάσει στο σημείο
	  * εξόδου.
	  * @param current
	  * @return
	  */
	public static boolean isSolution(nodeList current){
		if (current.maze[exitL][exitC]=='V'){
			return true;
		}
		return false;
	}
	/*Μέθοδος που βρίσκει αν από την παρούσα κατάσταση
	 * του λαβύρινθου μπορεί να γίνει βήμα προς τα πάνω ή όχι.
	 * Αν ναι, δημιουργεί αντικείμενο γι' αυτό το βήμα και το
	 * προσθέτει στο δέντρο.
	 */
	public static nodeList maketheChildup(Objects origin){
		
		if ((((origin.current.x)+1)!=6)&&(origin.maze[origin.current.x+1][origin.current.y]!='W')){
			if(origin.maze[origin.current.x+1][origin.current.y]!='V'){
				Objects child1 = new Objects(origin.maze, origin.current, origin);
				child1.current.setLocation(origin.current.x+1, origin.current.y);
				child1.maze[child1.current.x][child1.current.y] = 'V';
				origin.children[0]=child1;
				nodeList tip = new nodeList(origin.children[0].maze, origin.children[0]);
				return tip;
			}
		}
		 return null;
	}
	/*Μέθοδος που βρίσκει αν από την παρούσα κατάσταση
	 * του λαβύρινθου μπορεί να γίνει βήμα προς τα κάτω ή όχι.
	 * Αν ναι, δημιουργεί αντικείμενο γι' αυτό το βήμα και το
	 * προσθέτει στο δέντρο.
	 */
	public static nodeList maketheChilddown(Objects origin){
		if (((origin.current.x)!=0)&&(origin.maze[origin.current.x-1][origin.current.y]!='W')){
			if(origin.maze[origin.current.x-1][origin.current.y]!='V'){
				Objects child2 = new Objects(origin.maze, origin.current, origin);
				child2.current.setLocation(origin.current.x-1, origin.current.y);
				child2.maze[child2.current.x][child2.current.y] = 'V';
				origin.children[1]=child2;		
				nodeList tip = new nodeList(origin.children[1].maze, origin.children[1]);
				return tip;
			}
		}
		 return null;
	}
	/*Μέθοδος που βρίσκει αν από την παρούσα κατάσταση
	 * του λαβύρινθου μπορεί να γίνει βήμα προς τα δεξιά ή όχι.
	 * Αν ναι, δημιουργεί αντικείμενο γι' αυτό το βήμα και το
	 * προσθέτει στο δέντρο.
	 */
	public static nodeList maketheChildright(Objects origin){
		if ((origin.current.y!=4)&&(origin.maze[origin.current.x][origin.current.y+1]!='W')){
			if (origin.maze[origin.current.x][origin.current.y+1]!='V'){
				Objects child3 = new Objects(origin.maze, origin.current, origin);
				child3.current.setLocation(origin.current.x, origin.current.y+1);
				child3.maze[child3.current.x][child3.current.y] = 'V';
				origin.children[2]=child3;	
				nodeList tip = new nodeList(origin.children[2].maze, origin.children[2]);
				return tip;
			}
		}
		 return null;
	}
	/*Μέθοδος που βρίσκει αν από την παρούσα κατάσταση
	 * του λαβύρινθου μπορεί να γίνει βήμα προς τα αριστερά ή όχι.
	 * Αν ναι, δημιουργεί αντικείμενο γι' αυτό το βήμα και το
	 * προσθέτει στο δέντρο.
	 */
	public static nodeList maketheChildleft(Objects origin){

		if ((origin.current.y!=0)&&(origin.maze[origin.current.x][origin.current.y-1]!='W')){
			if (origin.maze[origin.current.x][origin.current.y-1]!='V'){
				Objects child4 = new Objects(origin.maze, origin.current, origin);
				child4.current.setLocation(origin.current.x, origin.current.y-1);
				child4.maze[child4.current.x][child4.current.y] = 'V';
				origin.children[3]=child4;	
				nodeList tip = new nodeList(origin.children[3].maze, origin.children[3]);
				return tip;
			}
		}
		 return null;
		
	}
	/**
	 * Τυπώνει μη-γραφικά, στην κονσόλα την κατάσταση
	 * του λαβύρινθου.
	 * @param now
	 */
	public static  void tipwma (nodeList now){
	
	int height = 1;
	int width = 1;
		for (int i=0; i<6; i++){
			for (int j=0; j<5; j++){
				System.out.print("|"+now.maze[i][j]+"|");

			}
			System.out.println();
		}
		
		System.out.println("\n\n");
	}
/**
 * Μέθοδος που χρησιμοποιείται για να εμφανίσουμε
 * στην οθόνη με γραφικό τρόποτην αρχική κατάσταση του λαβύρινθου
 * αλλά και τη λύση του.
 */
	   public void paint(Graphics g) {
		   int countI= 0;
		   int countJ=0;
		   for (int i=0; i<6; i++){
				  for (int j=0; j<5; j++){
					  if (printedF[i][j]=='W'){
						  g.setColor(Color.black); 
					      g.fillRect (j+countJ, i+countI, 50, 50);
					  }
					  if (printedF[i][j]=='E'){
						  g.setColor(Color.white); 
					      g.fillRect (j+countJ, i+countI, 50, 50);
					  }
					  if ((printedF[i][j]=='V')||(printedF[i][j]=='G')){
						  g.setColor(Color.red); 
					      g.fillRect (j+countJ, i+countI, 50, 50);
					  }
					  countJ=countJ+50;
				  }
				  countI = countI+50;
				  countJ = 0;
			  }
		   countI=0;
		  for (int i=0; i<6; i++){
			  for (int j=0; j<5; j++){
				  if (printed[i][j]=='W'){
					  g.setColor(Color.black); 
				      g.fillRect (j+countJ+300, i+countI, 50, 50);
				  }
				  if (printed[i][j]=='E'){
					  g.setColor(Color.white); 
				      g.fillRect (j+countJ+300, i+countI, 50, 50);
				  }
				  if (printed[i][j]=='V'){
					  g.setColor(Color.red); 
				      g.fillRect (j+countJ+300, i+countI, 50, 50);
				  }
				  countJ=countJ+50;
			  }
			  countI = countI+50;
			  countJ = 0;
		  }
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = 6;
		int width = 5;
		
		 char[][] labyrinth = new char [height][width];
		 for(int i=0; i<height; i++){
			 for (int j=0; j<width; j++ ){
				 labyrinth[i][j]='E';//ορισμός ελεύθερων μονοπατιών
			 }
		 }
		setWalls(labyrinth);//ορισμός τοίχων
		labyrinth[entranceL][entranceC]='V';//είσοδος ορίζεται ως θέση που έχουμε επισκεφθεί
		labyrinth[exitL][exitC]='G';//έξοδος
		Point minotaur = new Point();//σημείο κίνησης ως "μινόταυρος"
		minotaur.setLocation(entranceL, entranceC);//
		System.out.println("The labyrinth:");
		Objects root = new Objects(labyrinth, minotaur, null);
		Queue<nodeList> metwpo = new Queue();
		nodeList rootL = new nodeList(root.maze, root);
		metwpo.enqueue(rootL);
		for(int i=0; i<6; i++){
			for (int j=0; j<5; j++){
				printedF[i][j]=rootL.maze[i][j];
			}
		}
		tipwma(rootL);
		while(!(metwpo.isEmpty())){
			
			nodeList now = metwpo.dequeue();
			nodeList currentCheck = new nodeList (now.maze, now.origin);

			if (!(isSolution(currentCheck))){
				nodeList up = maketheChildup(currentCheck.origin);
				nodeList down = maketheChilddown(currentCheck.origin);
				nodeList right = maketheChildright(currentCheck.origin);
				nodeList left = maketheChildleft(currentCheck.origin);
				
				if (up!=null){
					metwpo.enqueue(up);
				}
				if(down!=null){
					metwpo.enqueue(down);
				}
				if(right!=null){
					metwpo.enqueue(right);
				}
				if (left!=null){
					metwpo.enqueue(left);
				}
				
			}
			else{
				tipwma(currentCheck);
				   
				for (int i=0; i<6; i++){
					for (int j=0; j<5; j++){
						printed[i][j]=currentCheck.maze[i][j];
					}
				}
				System.out.println("I lisi vrethike!");
				  JFrame f = new JFrame();
			      f.setSize(600, 600);
			      f.add(new Lavirinthos());
			      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      f.setVisible(true);
			}
		}
		
	}

}
