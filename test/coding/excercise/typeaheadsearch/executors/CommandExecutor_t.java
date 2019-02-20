/**
 * 
 */
package coding.excercise.typeaheadsearch.executors;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import coding.excercise.typeaheadsearch.config.Configuration;
import coding.excercise.typeaheadsearch.model.MovieCatalog;

/**
 * @author subbaramanv
 *
 */
public class CommandExecutor_t {

	MovieCatalog catalog;
	String fileName;
    private static ExecutorService executor = Executors.newFixedThreadPool(1);

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		catalog = new MovieCatalog();
		fileName = "data/file1.txt";
	}

	@Test
	public void testCommandExecutor() {
	
		CommandExecutor commandExecutor = new CommandExecutor(catalog, fileName);
		assertNotNull(commandExecutor);
	}

	@Test
	public void testCommandExecutorRun() {
	
		CommandExecutor commandExecutor = new CommandExecutor(catalog, fileName);
		executor.execute(commandExecutor);
		try {
			executor.awaitTermination(500, TimeUnit.MILLISECONDS);
			assertFalse(executor.isShutdown());
			assertTrue(catalog.getAllMovies().size() > 0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
