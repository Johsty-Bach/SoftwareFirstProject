package test_prep;

import java.util.ArrayList;
import java.util.List;

abstract class Employee
{
	String name;
	double hourly_rate;
	int hours_worked;

	public Employee(String name, double hourly_rate)
	{
		this.name = name;
		this.hourly_rate = hourly_rate;
		this.hours_worked = 0;
	}
	
	public abstract double calculatePay();
	
	public void setHoursWorked(int hours)
	{
		this.hours_worked = hours;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

class Contractor extends Employee {
    public Contractor(String name, double hourly_rate) 
    {
        super(name, hourly_rate);
    }

    @Override
    public double calculatePay() 
    {
        return hourly_rate * hours_worked;
    }
}

class HourlyWorker extends Employee 
{
    public HourlyWorker(String name, double hourly_rate) 
    {
        super(name, hourly_rate);
    }

    @Override
    public double calculatePay() 
    {
        if (hours_worked <= 40) 
        {
            return hourly_rate * hours_worked;
        } 
        else 
        {
            return (40 * hourly_rate) + ((hours_worked - 40) * hourly_rate * 1.5);
        }
    }
}

class SalaryWorker extends Employee 
{
    public SalaryWorker(String name, double hourly_rate) 
    {
        super(name, hourly_rate);
    }

    @Override
    public double calculatePay() 
    {
        return hourly_rate * 40;
    }
}

class Payroll
{
	private List<Employee> employees = new ArrayList<>();
	
	public void addEmployees(Employee employee) 
	{
		employees.add(employee);
	}
	
    public double[] employeePayroll() 
    {
        double[] payroll = new double[employees.size()];
        for (int i = 0; i < employees.size(); i++) 
        {
            payroll[i] = employees.get(i).calculatePay();
        }
        return payroll;
    }
    
    public void printPayroll() 
    {
        for (Employee employee : employees) 
        {
            System.out.println(employee.getName() + " earned: $" + employee.calculatePay());
        }
    }    
}






