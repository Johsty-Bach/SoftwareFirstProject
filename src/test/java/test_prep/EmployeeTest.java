package test_prep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest
{
	Payroll P;
	Contractor C;
	HourlyWorker H;
	SalaryWorker S;
	
	@BeforeEach
	void setUp() throws Exception
	{
		P = new Payroll();
		C = new Contractor("Alice", 30);
		H = new HourlyWorker("Bob", 20);
		S = new SalaryWorker("Charlie", 50);
		
		P.addEmployees(C);
		P.addEmployees(H);
		P.addEmployees(S);
	}

	@Test
	void testPayCalculation()
	{
		C.setHoursWorked(45);
		assertEquals(1350.0, C.calculatePay(), 0.01, "Contractor pay should be correct.");
		
		H.setHoursWorked(40);
        assertEquals(800.0, H.calculatePay(), 0.01, "Hourly worker should be paid normally for 40 hours.");
        
        S.setHoursWorked(10); // Should not affect salary workers
        assertEquals(2000.0, S.calculatePay(), 0.01, "Salary worker should always be paid for 40 hours.");
	}

	@Test
	void testPayroll()
	{
		C.setHoursWorked(45);
        H.setHoursWorked(50);
        S.setHoursWorked(0);
        
        double[] expectedPayroll = {1350.0, 1100.0, 2000.0};
        assertArrayEquals(expectedPayroll, P.employeePayroll(), "Payroll calculation should be correct.");
	}
}
