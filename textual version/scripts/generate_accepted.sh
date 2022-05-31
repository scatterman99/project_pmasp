#! /usr/bin/sh
clingo encodings/generate_accepted_traces.lp encodings/conformance_gen.lp encodings/automata.lp encodings/templates.lp artifacts/bindings.lp --out-atomf=%s. --models $1 --const length=$2 -V0 | head -n -1 | awk '{gsub("replaceme",NR,$0);print}' | tr ' ' '\n'


