package sunbeam;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonUtil {
	public static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("\n1. Add Record");
		System.out.println("2. Remove Record");
		System.out.println("3. Display Record");
		System.out.print("Enter Choice : ");
		return sc.nextInt();
	}

	public static Person accept() {
		sc.nextLine();
		System.out.print("Enter name : ");
		String name = sc.nextLine();
		System.out.print("Enter date of birth (yyyy:mm:dd)");
		LocalDate date = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.print("Enter age : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter address : ");
		String address = sc.nextLine();
		return new Person(name, age, date, address);
	}


}
