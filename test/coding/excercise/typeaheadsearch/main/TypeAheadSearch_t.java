/**
 * 
 */
package coding.excercise.typeaheadsearch.main;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;



/**
 * @author subbaramanv
 *
 */
public class TypeAheadSearch_t {

	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	@Test
	public void testMain() {

		// no args for this program
	    String[] args = null;
	    
	    final InputStream original = System.in;
	    FileInputStream fips;
		try {
			fips = new FileInputStream(new File("data/directives.quick.txt"));
		    System.setIn(fips);
		    System.out.println("launching program");
		    System.out.println("This is executed before everything.");
	        exit.expectSystemExit();
	        TypeAheadSearch.main(args);
		    System.setIn(original);	
		    assertNotNull(System.out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testMainInputDirectives(){

		System.out.println("Inside testMainInputDirectives");
		// no args for this program
	    String[] args = null;
	    
	    final InputStream original = System.in;
		StringBuffer sb = new StringBuffer();
		sb.append("process-file data/file1.txt\n");
		sb.append("query\n");
		sb.append("query star\n");
		sb.append("quit\n");
		InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
		System.setIn(inputStream);
        exit.expectSystemExit();
		TypeAheadSearch.main(args);
		System.setIn(original);
	    assertNotNull(System.out);

	}
}
