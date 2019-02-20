/**
 * 
 */
package coding.excercise.typeaheadsearch.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author subbaramanv
 *
 */
public class MovieCatalog {

	// Index for movie name to record
	// For every movie name, we maintain a unique collection of movie objects <String, Set<Movie>>
	Map<String, Set<Movie>> cache = new ConcurrentHashMap<>();
	
	// Index words in movie name
	// We index every word (lower-case) that appears on movie name
	// We want a unique collection of movie names for a given word index and hence choosing a Set<String>
	Map<String, Set<String>> wordIndex = new ConcurrentHashMap<>();
	
	// Trie data structure for every word in the movie names
	// This gives us to query keys by prefix
	MovieTrie trie = new MovieTrie();

   /**
     * Initializes movie catalog
     */
    public MovieCatalog() {
    	
    }

    
    /**
     * @param movie
     * Synchronized since this is accessed by multiple update commands
     */
    public synchronized void addMovie(Movie movie){
    	if(movie==null) return;
    	
    	String key = movie.getName();
    	// System.out.println("MovieCatalog::addMovie name " + key);
    	
    	// Build index of words in name
    	String[] words = key.split(" ");
    	for(String w: words){
    		String wordLower = w.toLowerCase();
    		if(!wordIndex.containsKey(wordLower)){
    			wordIndex.put(wordLower, new HashSet<String>());
    		}
    		wordIndex.get(wordLower).add(key);
        	// System.out.println("wordIndex key = " + wordLower + " value = " + key);
    		
        	// add each word in movie name to trie
    		// we add lower-case of word since we ignore case for prefix searches
        	trie.add(wordLower);
    	}
    	
    	
    	// Add to cache
    	// For every unique movie name we would have a set of movie objects
    	// Note: there are movies with same name but different release years - they are considered as different movies
    	if(!cache.containsKey(key)){
    		Set<Movie> moviesSet = new HashSet<>();
    		cache.put(key,  moviesSet);
    	}
    	cache.get(key).add(movie);
    }
    
    /**
     * @param name
     * @return set of movies
     */
    public Set<Movie> getMovies(String name){
    	return cache.get(name);
    }

    /**
     * @param 
     * @return movies
     */
    public Set<Movie> getAllMovies(){
    	Set<Movie> movies = new HashSet<>();
    	Set<Map.Entry<String, Set<Movie>>> entries = cache.entrySet();
  
    	for(Entry<String, Set<Movie>> e: entries){
    		Set<Movie> set = e.getValue();
    		movies.addAll(set);
    	}
    
    	return movies;
    }
    
    /**
     * clear catalog
     */
    public void clearMoviesCatalog(){
    	// clear words index
    	wordIndex.clear();
    	
    	// clear cache
    	cache.clear();
    }

	/**
	 * @param prefix
	 * @return set of movies that contains this prefix ignoring case in one of its words in the name
	 * Chosen TreeSet since we need to return an ordered set of movies
	 */
	public Set<Movie> moviesByPrefix(String prefix){
		Set<Movie> result = new TreeSet<>();
		
		Iterable<String> words = trie.keysWithPrefix(prefix.toLowerCase());
		for(String word: words){
			// System.out.print(word + " ");
			Set<String> names = new HashSet<>();
			names = wordIndex.get(word.toLowerCase());
			for(String name: names){
				//System.out.println("From cache; key = " + name);
				Set<Movie> movies = cache.get(name);
				for(Movie m: movies){
					//System.out.println(" Movie = " + m.getYearOfRelease() + " " + m.getCountryCode() + " " + m.getName());
					result.add(m);
				}
				//System.out.println();
			}
		}
		return result;
	}
    
	public static void main(String[] args){
		
		List<String> movies = new ArrayList<>();
		movies.add("Star trooper 123");
		movies.add("Apple trooper 123");
		movies.add("Google start 123");
		movies.add("Net st s ST S flix123 123");
		movies.add("APp TRooper 00 123");
		movies.add("star S T R st sT trooper 123");
		movies.add("_Apple trooper 123");
		movies.add("zzzzzzzzzzzzzzzzzzzzzzz");

		MovieCatalog cat = new MovieCatalog();
		for(String name: movies){
			Movie m = new Movie("2018", "US", name);
			Movie m1 = new Movie("2019", "US", name);
			cat.addMovie(m);
			cat.addMovie(m1);
		}
		
		for(Movie m: cat.getMovies("Google start 123")){
			System.out.println("Movie from catalog " + m.getYearOfRelease() + " " + m.getCountryCode() + " " + m.getName()); 
		}
		String prefix = "st";
		Set<Movie> result = cat.moviesByPrefix(prefix);
		System.out.println();
		System.out.println("Movies by prefix " + prefix);
		for(Movie m : result){
			System.out.println("Movie - " + m.getYearOfRelease() + " " + m.getCountryCode() + " " + m.getName());
		}

		prefix = "";
		System.out.println();
		System.out.println("Movies by prefix " + prefix);
		Set<Movie> result1 = cat.moviesByPrefix(prefix);
		System.out.println("Size = " + result1.size());
		for(Movie m : result1){
			System.out.println("Movie - " + m.getYearOfRelease() + " " + m.getCountryCode() + " " + m.getName());
		}
	
	}
}
