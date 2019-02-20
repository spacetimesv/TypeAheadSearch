/**
 * 
 */
package coding.excercise.typeaheadsearch.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author subbaramanv
 *
 */
public class Commands_t {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValidator() {
		
		Command command = new Command("process-file", "data/file1.txt");
		boolean result = Commands.validate(command);
		assertTrue(result);
		
	}

}
