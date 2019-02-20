/**
 * 
 */
package coding.excercise.typeaheadsearch.executors;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import coding.excercise.typeaheadsearch.model.Movie;
import coding.excercise.typeaheadsearch.model.MovieCatalog;

/**
 * @author subbaramanv
 *
 */
public class QueryExecutor_t {

	MovieCatalog catalog;
	Set<Movie> movies;
	StringBuffer expected;
	List<String> expectedRows;


	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		catalog = new MovieCatalog();
		movies = new TreeSet<>();
		expected = new StringBuffer();
		expectedRows = new ArrayList<>();


	}

	@Test
	public void testQueryExecutorConstructor() {
		assertNotNull(new QueryExecutor(catalog));
	}

	@Test
	public void testQueryExecutorSearch() {
		
		// load movies
		Movie m1 = new Movie("2008", "US", "Starship Troopers 3");
		Movie m2 = new Movie("2008", "US", "Naming Pluto");
		Movie m3 = new Movie("2008", "US", "Apple starship1 Troopers 3");
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		
		String prefix = new String();
		// 1. all movies
		QueryExecutor query = new QueryExecutor(catalog);
		List<String> result = query.typeAheadSearchByPrefix(prefix);
		expectedRows.clear();;
		expected.setLength(0);
		expectedRows.add(expected.append("2008").append("\t").append("US").append("Apple starship1 Troopers 3").toString());
		expected.setLength(0);
		expectedRows.add(expected.append("2008").append("\t").append("US").append("Naming Pluto").toString());
		expected.setLength(0);
		expectedRows.add(expected.append("2008").append("\t").append("US").append("Starship Troopers 3").toString());
		assertTrue(expectedRows.containsAll(result));
		
		prefix = "star";
		result = query.typeAheadSearchByPrefix(prefix);
		expectedRows.clear();;
		expected.setLength(0);
		expectedRows.add(expected.append("2008").append("\t").append("US").append("Apple starship1 Troopers 3").toString());
		expected.setLength(0);
		expectedRows.add(expected.append("2008").append("\t").append("US").append("Starship Troopers 3").toString());
		assertTrue(expectedRows.containsAll(result));
		
	}


}
