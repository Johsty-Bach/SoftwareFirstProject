package hi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonAgeTest
{
	PersonAge R;
	PersonAge J;
	PersonAge M;
	PersonAge Y;

	@BeforeEach
	void setUp() throws Exception
	{
		R = new PersonAge("Romeo", "Mon", 15);
		J = new PersonAge("Juliet", "Cap", 13);
		M = new PersonAge("Count", "Dukoo", 54);
		Y = new PersonAge("Yo", "Da", 973);
	}

	@Test
	void testToString()
	{
		
		assertEquals("Person: Romeo Mon, 15", R.toString());
//		fail("Not yet implemented");
	}
	
	@Test
	void testPerson()
	{
		
		assertThrows(UnderAgeException.class, 
				()->{
					R.makePerson(J);
				});
		assertThrows(UnderAgeException.class, 
				()->{
					M.makePerson(J);
				});
		PersonAge child;
		try
		{
			child = M.makePerson(Y);
			
			assertEquals(M.getFname(), child.getFname());
			assertEquals(Y.getLname(), child.getLname());
			assertEquals(0, child.getAge());
			
			
		} catch (UnderAgeException e)
		{
			e.printStackTrace();
			fail("threw exception");
		}
		
		
	}

}
