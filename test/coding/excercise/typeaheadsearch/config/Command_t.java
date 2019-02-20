package coding.excercise.typeaheadsearch.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Command_t {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String directive = "process-file";
		String arg = "file1.txt";
		Command command = new Command(directive, arg);
		assertNotNull(command);
	}

}
