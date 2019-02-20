/**
 * 
 */
package coding.excercise.typeaheadsearch.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author subbaramanv
 *
 */
public class MovieCatalog_t {

	List<String> movieTitles;
	Set<Movie> movies;
	MovieCatalog catalog;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		movieTitles = new ArrayList<>();
		movies = new HashSet<>();
		catalog = new MovieCatalog();
	}
	
	@After
	public void clearTestData(){
		// clear existing test data
		movieTitles.clear();
		movies.clear();
		catalog.clearMoviesCatalog();
	}
	

	@Test
	public void testAddMovie() {
		// create movies and records
		movieTitles.add("Star trooper 123");
		movieTitles.add("Apple trooper 123");
		movieTitles.add("Google start 123");
		movieTitles.add("Net st s ST S flix123 123");
		movieTitles.add("APp TRooper 00 123");
		movieTitles.add("star S T R st sT trooper 123");
		movieTitles.add("_Apple trooper 123");
		
		// movie records
		for(String title: movieTitles){
			Movie m = new Movie("2010", "US", title);
			movies.add(m);
		}
		
		// add movies to movie catalog database
		for(Movie m: movies){
			catalog.addMovie(m);
		}
		
		// assert catalog size = 7
		assertEquals(movies.size(), catalog.getAllMovies().size());
	
	}

	@Test
	public void testAddMovieDupNames() {
		// create movies and records
		movieTitles.add("Star trooper 123");
		movieTitles.add("Apple trooper 123");
		movieTitles.add("Google start 123");
		
		// movie records
		for(String title: movieTitles){
			Movie m = new Movie("2010", "US", title);
			// duplicate movie name with different release date
			Movie m2 = new Movie("2012", "US", title);
			movies.add(m);
			movies.add(m2);
		}
		
		// add movies to movie catalog database
		for(Movie m: movies){
			catalog.addMovie(m);
		}
		
		// assert catalog size = 7
		assertEquals(movies.size(), catalog.getAllMovies().size());
	
	}
	
	@Test
	public void testQueryByPrefix(){
		
		// create movies and records
		movieTitles.add("Star trooper 123");
		movieTitles.add("Apple tRooper 123");
		movieTitles.add("Google start 123");
		movieTitles.add("Net st s ST S flix123 123");
		movieTitles.add("Special characters movie #@%$ '' S flix123 123");
		movieTitles.add("APp TRooper --__ 00 123");
		movieTitles.add("ZZZ qqq TRooper 00 123");
		movieTitles.add("star S T R st sT trooper 123");
		movieTitles.add("_Apple trooper 123");
		
		// movie records
		for(String title: movieTitles){
			Movie m = new Movie("2010", "US", title);
			movies.add(m);
		}
		
		// add movies to movie catalog database
		for(Movie m: movies){
			catalog.addMovie(m);
		}
		
		Set<Movie> movies;
		Set<Movie> expectedResult = new HashSet<>();
		// prefix = "star"
		String prefix = "star";
		movies = catalog.moviesByPrefix(prefix);
		expectedResult.add(new Movie("2010", "US", "Star trooper 123"));
		expectedResult.add(new Movie("2010", "US", "Google start 123"));
		expectedResult.add(new Movie("2010", "US", "Star trooper 123"));
		expectedResult.add(new Movie("2010", "US", "star S T R st sT trooper 123"));
		assertEquals(expectedResult.size(), movies.size());
		assertEquals(true, expectedResult.containsAll(movies));


		// Empty prexi = returns all movies
		prefix = "";
		movies = catalog.moviesByPrefix(prefix);
		expectedResult.clear();
		expectedResult.addAll(catalog.getAllMovies());
		assertEquals(expectedResult.size(), movies.size());
		assertEquals(true, expectedResult.containsAll(movies));
		
		// Non-existent prefix
		prefix = "qqqqqqqqqq";
		movies = catalog.moviesByPrefix(prefix);
		expectedResult.clear();
		assertEquals(expectedResult.size(), movies.size());
		
	}
	

}
