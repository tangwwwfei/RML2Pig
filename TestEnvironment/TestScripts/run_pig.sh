#!/bin/bash
execTypes=("tez")
formulas=("csv" "json" "xml")
type_arr=("1M" "2M" "3M" "4M" "5M")
for execType in ${execTypes[@]}
do
	for formula in ${formulas[@]}
	do
		for type_cnt in ${type_arr[@]}
		do
			if [ -d "/opt/pig_test/data/${formula}/${type_cnt}" ]; then
				outputFile="pig-${execType}-${formula}-${type_cnt}-result.out"
				if [ ! -f $outputFile ]; then
					(pig -x ${execType} -f "${formula}.pig" -p type=${type_cnt}) 2> $outputFile
				fi
			fi
		done
	done
done
