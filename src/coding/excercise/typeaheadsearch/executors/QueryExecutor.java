/**
 * 
 */
package coding.excercise.typeaheadsearch.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import coding.excercise.typeaheadsearch.model.Movie;
import coding.excercise.typeaheadsearch.model.MovieCatalog;

/**
 * @author subbaramanv
 *
 */
public class QueryExecutor {

	// movie catalog
	MovieCatalog catalog;
			
	/**
	 * @param prefix
	 */
	public QueryExecutor(MovieCatalog catalog) {
		super();
		this.catalog = catalog;
		// System.out.println("Inside Query Executor contructor");
	}

	public List<String> typeAheadSearchByPrefix(String prefix){
		List<String> result = new ArrayList<>();
		Set<Movie> movies = catalog.moviesByPrefix(prefix);
		
		StringBuffer sb = new StringBuffer();
		for(Movie movie: movies){
			sb.append(movie.getYearOfRelease());
			sb.append("\t");
			sb.append(movie.getCountryCode());
			sb.append("\t");
			sb.append(movie.getName());
			result.add(sb.toString());
			
			// clear string buffer
			sb.setLength(0);
		}
		
		return result;
	}

}
