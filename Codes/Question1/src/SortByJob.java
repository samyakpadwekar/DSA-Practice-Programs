
import java.util.Comparator;

public class SortByJob implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e2.getJob().compareTo(e1.getJob());
	}
	
}
