#!/bin/bash

JAVA=java
LIB="lib/junit.jar:lib/system-rules-1.19.0.jar:lib/org.hamcrest.core_1.3.0.v201303031735.jar:bin:."
JUNITRUNNER=org.junit.runner.JUnitCore

echo "Running coding.excercise.typeaheadsearch.config.Command_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.config.Command_t
sleep 1

echo "Running coding.excercise.typeaheadsearch.config.Commands_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.config.Commands_t
sleep 1

echo "Running coding.excercise.typeaheadsearch.executors.CommandExecutor_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.executors.CommandExecutor_t
sleep 1 

echo "Running coding.excercise.typeaheadsearch.executors.QueryExecutor_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.executors.QueryExecutor_t
sleep 1 

echo "Running coding.excercise.typeaheadsearch.model.MovieTrie_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.model.MovieTrie_t
sleep 1 

echo "Running coding.excercise.typeaheadsearch.model.MovieCatalog_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.model.MovieCatalog_t
sleep 1

echo "Running coding.excercise.typeaheadsearch.model.Movie_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.model.Movie_t
sleep 1

echo "Running coding.excercise.typeaheadsearch.main.TypeAheadSearch_t"
$JAVA -cp $LIB $JUNITRUNNER coding.excercise.typeaheadsearch.main.TypeAheadSearch_t


