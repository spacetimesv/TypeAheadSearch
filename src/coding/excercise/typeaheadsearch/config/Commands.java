package coding.excercise.typeaheadsearch.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Commands {

	public static final String PROCESS_FILE = "process-file";
	public static final String QUERY = "query";
	public static final String QUIT = "quit";
	
	// all directives
	List<Command> commands = new CopyOnWriteArrayList<>();
	
	/**
	 * @param command
	 * @param arg
	 */
	public synchronized void addDirective(String command, String arg){
		if(command==null || command.length()==0) {
			return;
		}
		Command d = new Command(command, arg);
		commands.add(d);
	}
	
	// Validator for directives
	public static boolean validate(Command d){
		if(d==null) return false;
		
		String command = d.getCommand();
		if(command != PROCESS_FILE && command != QUERY && command != QUIT) {
			// throw exception
			return false;
		}
		
		// check directive: process-file filename
		if(command == PROCESS_FILE){
			if(d.getArg().length()==0) {
				System.out.println(command + " requires argument. Usage: " + command + " filename.");
				return false;
			} else {
				// validate given file
				String fileName = d.getArg();
				File file = new File(fileName);
	            if (!file.exists()) {
	            	return false;
	            }
			}
		}
		
		return true;
	}
	
	public Iterable<Command> getCommands(){
		return commands;
	}
	
}
