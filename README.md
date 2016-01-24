# Artificial_Intelligence_SoverOfAnyMaze

This is a simple java project that solves any maze obeying the principles of Artificial Intelligence course.

**Algorithm:**

1. Firstly, a 2D table is declared. The cells that are "walls" are flagged. 

2. Then we track the cell of entrance and the cell of exit. 

3. Two data-structures are used: a tree and a queue (first-in, first-out)

4. In the root of the tree, the first state of the solution is declared. The first state is the maze-table with the flagged entry and exit points.

5. This state it is also kept in the queue.

6. There is a while-loop that is terminated when the queue is empty.

**The algorithm in the while-loop:**

1. The first element of the queue is removed from the queue and the program checks if this state is the solution.

2. If this state is not the solution, the program identifies the next possible steps, and it for every possible movement, a new child of the current node is declared in the tree.

3. Every possible step is also placed in the queue.

4. The program is terminated when the next output of the queue is the solution of the maze.

