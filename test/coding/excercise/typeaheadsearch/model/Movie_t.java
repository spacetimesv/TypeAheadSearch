package coding.excercise.typeaheadsearch.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Movie_t {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMovie() {
		
		Movie m = new Movie("2019", "UK", "Bodyguard");
		assertNotNull(m);
	}

	@Test
	public void testMovieEquals() {
		
		Movie m1 = new Movie("2019", "UK", "Bodyguard");
		Movie m2 = new Movie("2019", "UK", "Bodyguard");

		Movie m3 = new Movie("2019", "UK", "Bodyguard");
		Movie m4 = new Movie("2019", "US", "Star wars");

		assertEquals(m1, m2);
		assertNotEquals(m3, m4);
	}

	@Test
	public void testMovieCompareTo() {
		
		Movie m1 = new Movie("2019", "UK", "Bodyguard");
		Movie m2 = new Movie("2019", "UK", "Pulp fiction");
		assertTrue(m1.compareTo(m2) < 0);;
		
		m1 = new Movie("2019", "UK", "Bodyguard");
		m2 = new Movie("2019", "UK", "Bodyguard");
		assertEquals(0, m1.compareTo(m2));
		
		m1 = new Movie("1973", "US", "Enter the Dragon");
		m2 = new Movie("2018", "US", "Annihilation");
		assertTrue(m1.compareTo(m2) > 0);
		
		
	}

}
