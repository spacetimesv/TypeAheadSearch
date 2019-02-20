/**
 * 
 */
package coding.excercise.typeaheadsearch.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author subbaramanv
 *
 */
public class MovieTrie_t {

	MovieTrie trie;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		trie = new MovieTrie();
	}

	@Test
	public void testAdd() {
		// add a key word to trie
		String key = "star";
		trie.add(key);
		boolean containsKey = trie.contains(key);
		assertEquals(true, containsKey);
	}

	@Test
	public void testAddPrefix() {
		// add a key word to trie
		String key = "star";
		trie.add(key);
		
		String prefix = "st";
		Iterable<String> keys = trie.keysWithPrefix(prefix);
		
		assertEquals(key, keys.iterator().next());
	}

	
	@Test
	public void testAddPrefixes() {
		// add a key word to trie
		String movieName = "Star trooper 2019";
		String[] tokens = movieName.split(" ");
		for(String w: tokens){
			trie.add(w);
		}
		
		String prefix = "tr";
		Iterable<String> keys = trie.keysWithPrefix(prefix);
		
		assertEquals(tokens[1], keys.iterator().next());
	}

	@Test
	public void testKeysWithPrefixes() {
		// add a key word to trie
		String movieName = "Star trooper 2019";
		String[] tokens = movieName.split(" ");
		for(String w: tokens){
			trie.add(w);
		}
		
		String prefix = "tr";
		Iterable<String> keys = trie.keysWithPrefix(prefix);
		assertEquals(tokens[1], keys.iterator().next());
		
		prefix = "S";
		keys = trie.keysWithPrefix(prefix);
		assertEquals(tokens[0], keys.iterator().next());
		
		prefix = "2";
		keys = trie.keysWithPrefix(prefix);
		assertEquals(tokens[2], keys.iterator().next());
	}

}
