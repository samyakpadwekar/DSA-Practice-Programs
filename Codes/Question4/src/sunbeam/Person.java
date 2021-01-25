package sunbeam;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

class Person {
	private String name;
	private int age;
	private LocalDate BirthDate;
	private String address;

	public Person(String name, int age, LocalDate birthDate, String address) {
		this.name = name;
		this.age = age;
		BirthDate = birthDate;
		this.address = address;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("Name=%-10s birthdate=%-15s age=%-5d address=%-20s", this.getName(),
				this.getBirthDate().toString(), this.getAge(), this.getAddress());
	}

}
