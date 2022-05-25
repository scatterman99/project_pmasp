#! /usr/bin/sh
>&2 echo "Computing automata bindings for model file: $1..."
clingo encodings/compute_bindings.lp encodings/templates.lp $1 -V0 --out-atomf=%s. | head -n 1 | tr ' ' '\n'
