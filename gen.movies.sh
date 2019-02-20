#!/bin/bash

# Generate movies catalog
# 500 records
# Year	Country	Movie-Name
perl -le 'foreach(1..500) {my @year = map{(0..9)[rand 10]} 1..4; my @n = map { ("A".."Z", "a".."z", 0..9, "     ", "-")[rand 128] } 1..100; my $year = join "", @year; my $name = join "", @n; my @country = map{("A".."Z")[rand 26]} 1..2; my $country = join "", @country; print join "\t", ($year, $country, $name);}'


perl -le 'foreach(1..500) {my @year = map{(2,0,1,3)[rand 10]} 1..4; my @n = map { ("A".."Z", "a".."z", 0..9, " ", "-")[rand 128] } 1..100; my $year = join "", @year; my $name = join "", @n; my @country = map{("A".."Z")[rand 26]} 1..2; my $country = join "", @country; print join "\t", ($year, $country, $name);}' > data/file1.500.txt
perl -le 'foreach(1..400) {my @year = map{(0..9)[rand 10]} 1..4; my @n = map { ("A".."Z", "a".."z", 0..9, " ", "-")[rand 128] } 1..100; my $year = join "", @year; my $name = join "", @n; my @country = map{("A".."Z")[rand 26]} 1..2; my $country = join "", @country; print join "\t", ($year, $country, $name);}' > data/file1.400.txt
perl -le 'foreach(1..300) {my @year = map{(0..9)[rand 10]} 1..4; my @n = map { ("A".."Z", "a".."z", 0..9, " ", "-")[rand 128] } 1..100; my $year = join "", @year; my $name = join "", @n; my @country = map{("A".."Z")[rand 26]} 1..2; my $country = join "", @country; print join "\t", ($year, $country, $name);}' > data/file1.300.txt
perl -le 'foreach(1..200) {my @year = map{(0..9)[rand 10]} 1..4; my @n = map { ("A".."Z", "a".."z", 0..9, " ", "-")[rand 128] } 1..100; my $year = join "", @year; my $name = join "", @n; my @country = map{("A".."Z")[rand 26]} 1..2; my $country = join "", @country; print join "\t", ($year, $country, $name);}' > data/file1.200.txt
perl -le 'foreach(1..100) {my @year = map{(0..9)[rand 10]} 1..4; my @n = map { ("A".."Z", "a".."z", 0..9, " ", "-")[rand 128] } 1..100; my $year = join "", @year; my $name = join "", @n; my @country = map{("A".."Z")[rand 26]} 1..2; my $country = join "", @country; print join "\t", ($year, $country, $name);}' > data/file1.100.txt

