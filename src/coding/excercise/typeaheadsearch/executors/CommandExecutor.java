/**
 * 
 */
package coding.excercise.typeaheadsearch.executors;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import coding.excercise.typeaheadsearch.config.Configuration;
import coding.excercise.typeaheadsearch.model.Movie;
import coding.excercise.typeaheadsearch.model.MovieCatalog;

/**
 * @author subbaramanv
 *
 */
public class CommandExecutor implements Runnable {

	// Movie catalog
	MovieCatalog catalog;
	
	private String fileName;
	
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * 
	 */
	public CommandExecutor(MovieCatalog catalog, String fileName) {
		super();
		// TODO Auto-generated constructor stub
		this.catalog = catalog;
		this.fileName = fileName;
		//System.out.println("Inside Command Executor contructor");
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("resource")
	@Override
	public void run() {
		//System.out.println("Inside Command Executor run. file name = " + fileName);
		File file = new File(fileName);
		Scanner fileScanner = null;
		try {
            // for consistency with StdIn, wrap with BufferedInputStream instead of use
            // file as argument to Scanner
            FileInputStream fis = new FileInputStream(file);
            fileScanner = new Scanner(new BufferedInputStream(fis), Configuration.CHARSET_NAME);
            fileScanner.useLocale(Configuration.LOCALE);
			while(fileScanner.hasNextLine()){
				String movieRecord = fileScanner.nextLine();
				//System.out.println("Inside Command Executor run - file record = " + movieRecord);
				String[] field = movieRecord.split("\t");
				if(field.length < 3) {
					System.out.println("Movie record should contain 3 fields - Release-date country-code and movie-name. Skipping record.");
					continue;
				}
				
				// create a movie record and add to our data structure
				String date = field[0];
				String country = field[1];
				String movieName = field[2];
				//System.out.println("Inside Command Executor run. Adding movie = " + date + " " + country + " " + movieName);
				Movie movie = new Movie(date, country, movieName);
				catalog.addMovie(movie);
			}
         } catch (IOException ioe) {
            throw new IllegalArgumentException("Could not open " + fileName, ioe);
        }

	}

}
