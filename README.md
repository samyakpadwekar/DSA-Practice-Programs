# DSA-Practice-Programs  

1. Load employees data from emp.csv into ArrayList<Emp> and sort them using comparator as follows.
	a. in ascending order by name
	b. in descending order by job
	c. in ascending order by deptno and descending order of sal (if deptno is same).
	
2. Implement a selection sort algorithm for array of double variables. The function should return number of swappings.

3. Implement a generic bubble sort and insertion sort method. Method takes two arguments array of objects to be sorted and comparator object. Method should sort array contents based on comparator.

4. Implement a doubly linked list of "java.lang.Object" with standard operations. Write a menu driven program to use the linked list to manage objects of user defined Person class.

5. Implement doubly circular linked list of any type, with following operations:
	a. addFirst()
	b. addLast()
	c. insertAtPos()
	d. delFirst()
	e. delLast()
	f. delAtPos()
	g. displayForward()
	h. displayReverse()

6. For a singly linked list of integers perform following operations:
	a. find middle node of list
	b. count number of integers matching given criteria -- pass Predicate<> object.
	c. reverse the linked list using recursion
	d. add difference of two consecutive nodes before them.
		input: 4 -> 7 -> 9 -> 1 -> 2 -> 6 -> 5
		output: 3 -> 4 -> 7 -> 8 -> 9 -> 1 -> 4 -> 2 -> 6 -> 5
			3 = | 4 - 7 |
			8 = | 9 - 1 |
			4 = | 2 - 6 |

7. Singly linked list of double stores coefficients of a polynomial f(a) from power 0 (first element) to n (last element).
	* f(a) = -2a$3 + 5a - 3
		* f(a) = -2a$3 + 0a$2 + 5a$1 + -3a$0  
	Then linked list will be: -3 -> 5 -> 0 -> -2
   Write a program to input coefficients from the user and build the linked list. Then input the value of variable "a" and solve the polynomial for the result.
	* user given a = 2;
		* f(2) = -2 * 2$3 + 0 * 2$2 + 5 * 2$1 + -3 * 2$0 = ??

8. Use java.util.Stack to solve an expression using prefix/postfix conversion. Assume that input expression contains operands and operators separated by spaces. Expression can have operators like (, ), *, /, +, - and $ (power). Note that operand value may range from -999 to +999.
	* 12 + 48 / ( 32 - 28) * -4 + 2 $ 5
		* String[] tokens = str.split(" ");
		* isNumber(String num) --> Integer.parseInt(num) -- if Exception, not a number; else it is number (operand) 

9. Use java.util.Queue to simulate FCFS scheduling algorithm. The jobs information like process id, arrival time and burst time a should be loaded from a text file (example given below). Output should be table printing process id, arrival time, burst time, waiting time and turnaround time in order of scheduling.
   Input format (process id, arrival time and burst time):
	1,0,14
	2,2,6
	3,3,10
	4,6,2
	5,40,10
   * For FCFS algorithm
		* Waiting time = Scheduling time - Arrival time
		* Turn-around time = Completion time - Arrival time

10. Load all movies data from movies_caret.csv into a user-defined hash table. Maximum number of slots in hash table are 100. Use chaining in case of collision. The key is movieId and value is Movie objects.

11. Create adjacency matrix for the given graph. Implement a function that returns new adjacency matrix after removing the given vertext.
	int[][] removeVertex(int[][] mat, int removeVertexId);

12. Count number of occurrences of each word in the text file.
	* input file:
		* red green blue
		* red red green
		* blue red green
	* Hint:
		* HashMap<String,Integer>: key = word, value = count.
	* output:
		* red = 4
		* green = 3
		* blue = 2

