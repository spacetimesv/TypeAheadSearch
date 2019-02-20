/**
 * 
 */
package coding.excercise.typeaheadsearch.config;

/**
 * @author subbaramanv
 *
 */
public class Command {

	private String command;
	private String arg;
	
	
	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}



	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}



	/**
	 * @return the arg
	 */
	public String getArg() {
		return arg;
	}



	/**
	 * @param arg the arg to set
	 */
	public void setArg(String arg) {
		this.arg = arg;
	}



	/**
	 * @param command
	 * @param arg
	 */
	public Command(String command, String arg) {
		super();
		this.command = command;
		this.arg = arg;
	}
	
	

}
