#! /usr/bin/sh

>&2 echo "Computing which constraints are valid on the log process variants'..."

clingo encodings/automata.lp $1 encodings/conformance.lp encodings/base.lp artifacts/bindings.lp -V0 --out-atomf=%s. | head -n 1 | tr ' ' '\n'


