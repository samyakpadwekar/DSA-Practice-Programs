import java.util.Comparator;

public class SortByDeptNo implements Comparator<Employee> {

	
	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getDeptno()==e2.getDeptno())
			return (int) (e2.getSalary() - e1.getSalary());
		else
			return e1.getDeptno()-e2.getDeptno();
	}

}
