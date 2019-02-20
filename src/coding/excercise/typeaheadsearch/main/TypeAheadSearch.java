/**
 * 
 */
package coding.excercise.typeaheadsearch.main;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import coding.excercise.typeaheadsearch.config.Command;
import coding.excercise.typeaheadsearch.config.Commands;
import coding.excercise.typeaheadsearch.config.Configuration;
import coding.excercise.typeaheadsearch.executors.CommandExecutor;
import coding.excercise.typeaheadsearch.executors.QueryExecutor;
import coding.excercise.typeaheadsearch.model.MovieCatalog;

/**
 * @author subbaramanv
 *
 */
public class TypeAheadSearch {
	
	// Executor thread pool for update commands
    private static ExecutorService executor = Executors.newFixedThreadPool(Configuration.NUM_THREADS);

    // Limit search result to 10 records
    private static final int SEARCH_RESULT_LIMIT = 10;
    
	// initialize catalog
	private static MovieCatalog catalog = new MovieCatalog();
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Setup scanner for parsing STDIN
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new java.io.BufferedInputStream(System.in), Configuration.CHARSET_NAME);
		scanner.useLocale(Configuration.LOCALE);
		
		// Input line
		String line = new String();
		
		// Iterate over input line by line
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			// Print directive line
			System.out.println(line);

			// Split directive line to tokens by space
			String[] tokens = line.split(" ");
			
			// Create update command executor
			if(tokens.length > 0){
				String command = tokens[0];
				String arg = new String();
				if(tokens.length>1){
					arg = tokens[1];
				}
				Command commandDirective = new Command(command, arg);

				// 1. Validate directive line
				// command argument
				if(Commands.validate(commandDirective)){
					System.out.println("Invalid directive. Skipping.");
					continue;
				}
				
				// 2. Submit update commands (process-file) to executor pool 
				if(commandDirective.getCommand().equals(Commands.PROCESS_FILE)){
					CommandExecutor commandExecutor = new CommandExecutor(catalog, arg);
					executor.execute(commandExecutor);
				} else if(commandDirective.getCommand().equals(Commands.QUERY)){
					QueryExecutor queryExecutor = new QueryExecutor(catalog);
					
					// Fetch type ahead search result
					List<String> result = queryExecutor.typeAheadSearchByPrefix(arg);
					
					// Iterate and print up to search limit
					int i = 0;
					for(String record: result){
						if(i >= SEARCH_RESULT_LIMIT) break;
						System.out.println(record);
						i++;
					}
				} else if(commandDirective.getCommand().equals(Commands.QUIT)) {
					// Exit application
					System.exit(0);
				}
				
			}
			
		}
		
	}

}
