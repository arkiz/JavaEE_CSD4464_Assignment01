package Employee;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.lang.String;
public class Register {
	
	private String first_name;
	private String last_name;
	private String user_name;
	private String msg;
	private int emp_id;
	private Float salary;
	private int dept_id;
	File empFile = new File("C:/eclipse_workspace/JavaEE_CSD4464_Assignment01/employees.txt");
	
    /**
     * Default constructor. 
     */
	public Register()
	{
		
	}
	
    public Register(String user_name, int emp_id, String first_name, String last_name, int dept_id, float salary)
	{
    	this.user_name = user_name;
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dept_id = dept_id;
		this.salary = salary;
		
	}
    
    public boolean InsertEmp() throws FileNotFoundException
    {
    	
		Scanner fileScanner = new Scanner(this.empFile);
    	
		Boolean valid = true;
		String msg = "";
		

		for (; fileScanner.hasNextLine(); ) 
		{
			StringTokenizer st = new StringTokenizer(fileScanner.nextLine(), ",");

			String v_userName = st.nextToken();
			String v_empId = st.nextToken();
			String v_firstName = st.nextToken();
			String v_lastName = st.nextToken();
			
			System.out.println("this.user_name:" + this.user_name + " v_user_name:"  + v_userName);
			
			if(v_userName.equals(this.user_name)){
				System.out.println("Duplicated!");
				valid = false;
				msg = "user name '" + this.user_name + "' is already exists";
				break;
			}

		}
		System.out.println(msg);
		
		if(valid){
			
			
			try {
			
				
				String newRecord = this.user_name + ","
								+ this.emp_id + ","
								+ this.first_name + ","
								+ this.last_name + ","
								+ this.dept_id + ","
								+ this.salary
								;
				BufferedWriter bw = new BufferedWriter(new FileWriter(this.empFile, true));
				
				for (; fileScanner.hasNextLine();) {
					
					fileScanner.next();
				}
				//bw.write(newRecord); 
				
				bw.append(newRecord);
				bw.newLine();
				//bw.append("\n");
				bw.flush();
				bw.close(); 
		           
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		fileScanner.close();
		
		this.setMsg(msg);
		
		return valid;
    	
    	
    }


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String fist_name) {
		this.first_name = fist_name;
	}


	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	/**
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}


	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	/**
	 * @return the dept_id
	 */
	public int getDept_id() {
		return dept_id;
	}

	/**
	 * @param dept_id the dept_id to set
	 */
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
