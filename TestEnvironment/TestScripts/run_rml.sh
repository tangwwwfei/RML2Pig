#!/bin/bash
formulas=("csv" "json" "xml")
type_arr=("1M" "2M" "3M" "4M" "5M")
wdp=/opt/pig_test/data

for formula in ${formulas[@]}
do
    for cnt in ${type_arr[@]}
    do
        path=${wdp}/${formula}/${cnt}
        if [ -d "${path}" ]; then
            outpath=rml470_${formula}_$cnt.out
            if [ ! -f "${outpath}" ]; then
                time(docker run --rm -v $(pwd):/data rmlmapper -m "${formula}/${cnt}/${formula}.rml.ttl" -o "${outpath}") 2>time_470_${formula}_${cnt}
            fi
        fi
    done
done
