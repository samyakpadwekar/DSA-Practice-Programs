import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
 public static void main(String[] args) throws Exception
 {	
	 ArrayList<Employee> list = new ArrayList<Employee>();
	 Employee emp=new Employee();
	 try(BufferedReader reader = new BufferedReader(new FileReader(new File("emp.csv"))))
	 {
		 int empId,deptno,mgrId;
		 String name,job,hireDate;
		 double comm,salary;
		 String line;
		 while((line=reader.readLine())!=null)  
		 {  
			 String[] arr = line.split(",");
			 empId=Integer.parseInt(arr[0]);
			 name=arr[1];
			 job=arr[2];
			 mgrId=(arr[3].compareTo("NULL")==0)? 0 : Integer.parseInt(arr[3]);
			 hireDate=arr[4];
			 salary=Double.parseDouble(arr[5]);
			 comm=(arr[6].compareTo("NULL")==0)? 0 : Double.parseDouble(arr[6]);
			 deptno=Integer.parseInt(arr[7]);
			 
			 list.add(new Employee(empId,deptno,mgrId,name,job,hireDate,comm,salary));
		 }
		 for (Employee employee : list) {
			System.out.println(employee.toString());
		}
	 }
	 System.out.println();
	 System.out.println();
	 System.out.println("Ascending order by name");
	 list.sort(new SortByName());
	 for (Employee employee : list) {
			System.out.println(employee.toString());
	 }
	 System.out.println();
	 System.out.println();
	 System.out.println("Descending order by job");
	 list.sort(new SortByJob());
	 for (Employee employee : list) {
			System.out.println(employee.toString());
	 }
	 System.out.println();
	 System.out.println();
	 System.out.println("Ascending order by deptno and descending order of sal (if deptno is same)");
	 list.sort(new SortByDeptNo());
	 for (Employee employee : list) {
			System.out.println(employee.toString());
	 }
}
}



