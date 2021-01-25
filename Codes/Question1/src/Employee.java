//Load employees data from emp.csv into ArrayList and sort them using comparator as follows.
//a. in ascending order by name
//b. in descending order by job
//c. in ascending order by deptno and descending order of sal (if deptno is same).

public class Employee {
	private int empId,deptno,mgrId;
	private String name,job,hireDate;
	private double comm,salary;
	public Employee(int empId, int deptno, int mgrId, String name, String job, String hireDate, double comm,
			double salary) {
		super();
		this.empId = empId;
		this.deptno = deptno;
		this.mgrId = mgrId;
		this.name = name;
		this.job = job;
		this.hireDate = hireDate;
		this.comm = comm;
		this.salary = salary;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", deptno=" + deptno + ", mgrId=" + mgrId + ", name=" + name + ", job="
				+ job + ", hireDate=" + hireDate + ", comm=" + comm + ", salary=" + salary + "]";
	}
	
	
	
}
