#!/bin/bash

formulas=("csv" "json" "xml")
type_arr=("1M" "2M" "3M" "4M" "5M")
run_mode="yarn-cluster" #"yarn-client" #"local[*]"
for formula in ${formulas[@]}
do
	for cnt in ${type_arr[@]}
	do
		if [ -d "/opt/pig_test/data/${formula}/$cnt" ]; then
			if [ ! -f "scala_${run_mode}_${formula}_${cnt}.out" ]; then
				time(spark-submit --class "persons_$formula" --master ${run_mode} Scala-2-11-12-assembly-0.1.jar /opt/pig_test/data/$formula/$cnt/persons.$formula $run_mode) &> scala_${run_mode}_${formula}_$cnt.out
			fi
		fi
	done
done
