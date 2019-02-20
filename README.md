# README

## Overview
Type ahead search application that support querying movies by prefix on any word in title. The app also support live updates to movies data. The app takes input
from standard input as directives and processes them until it sees quit.

## App packaging and extraction
1. To compress the project folder
	tar -zcvf TypeAheadSearch.tar.gz TypeAheadSearch
2. To extract the archive to a directory
	cd <working directory>
	tar -zxvf TypeAheadSearch.tar.gz

## Requirements
> Please make sure you have Java installed and added to path. 
> You should be able to verify by 
> java -version
> javac -version
 
## Build Instruction
1. cd <working directory>/TypeAheadSearch
2. ./build.sh
The above build script compiles all java and test classes and creates an app jar in target folder.

## Data files
> All data files for the app are available in data folder. This includes directives and movie data files.

## Run Instruction
1. cd <working-directory>/TypeAheadSearch
2. ./typeAheadSearch < data/directives.txt
3. Or you can run it like
	cat data/directives.txt | ./typeAheadSearch
  
## Testing
#### Unit tests
* All unit tests for the classes can be found in test/ folder.
* Unit tests can be executed using the script
	./run.tests.sh
	
### Application testing
* All data files that were used for testing can be found in data/ folder
#### Test cases
1. Simple directives and data/file1.txt
	cat data/directives.quick.txt | ./typeAheadSearch
	Tests basic use-case and program exits after it seems quit
2. Testing for bad commands
	cat data/directives.badcommands.txt | ./typeAheadSearch
	Tests how the program handles bad commands
3.  Testing bad data file
	cat data/directives.badfiles.txt | ./typeAheadSearch
	Tests how the program handles data file that cannot be accessed
4. Testing large live updates
	cat data/directives1.txt | ./typeAheadSearch
	Tests large live updates and how we see query results as updates happen
5. Testing max thread capacity
	cat data/directives.threadcap.txt | ./typeAheadSearch
	Tests more than 5 continuous process-file updates. The program has set thread pool capacity to 5.
6. Testing special characters in search prefix
	cat data/directives.query-special-chars.txt | ./typeAheadSearch
	Tests special characters in prefix and shows result if there are movies with any special characters in word beginnings.

	
### Generating directives online
1. Use sample script provided to send directives in a controlled way to program.
Example:
	./generate-directives.sh | ./typeAheadSearch 
	
### Generating sample movies data file
* Please refer to ./gen.movies.sh about how I have generated different movies data samples.


## Application - assumptions
1.	This program is written in Java and the user's desktop should have java version 8 installed and in their path.
2.	The type-ahead search program accepts a directive file and supports three commands
		process-file fileName
		query [prefix]
		quit
3.	Process file adds movie records to application data structure. It does not update existing movie records. It simply adds records to data structure.
4. Query by prefix returns all movies that have prefix in one of their title words
5. If the prefix is empty query returns all movies
6. The program limits search results to 10 and alphabetizes output by movie name
7. Movie names could contain alphabets (lower and upper), numbers and "-".
8. Quit exits the program immediately. It does not do graceful shutdown.
9. Multithreading pool capacity is set to 5  

### Error handling
1. If the input movies data file is not accessible, the program throws an exception and continues with next directive.
2. File access/open issues are reported on STDOUT and program continues
3. Any unsupported command is printed on STDOUT and the program continues


