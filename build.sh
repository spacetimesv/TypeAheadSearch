#!/bin/bash

# Build and create all compiled classes in bin directory
echo Building app...
echo "find src test -name "*.java" | xargs javac -cp "lib/junit.jar:lib/system-rules-1.19.0.jar:bin:." -d bin/ -sourcepath " 
# /usr/bin/find ./src -name "*.java" | xargs /usr/bin/javac -d ./bin -sourcepath ./src 
/usr/bin/find src test -name "*.java" | xargs javac -cp "lib/junit.jar:lib/system-rules-1.19.0.jar:bin:." -d bin/ -sourcepath 

# Create app jar file
cd ./bin
echo "Creating app jar file in ./target folder"
echo "jar -cfm ../target/typeaheadsearch.jar ./Manifest.txt *"
jar -cfm ../target/typeaheadsearch.jar ../Manifest.txt *



