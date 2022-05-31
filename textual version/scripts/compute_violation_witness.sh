#! /usr/bin/sh
>&2 echo "Computing violation witnesses..."
clingo encodings/violation_witness.lp artifacts/trace_alignment.lp encodings/templates.lp artifacts/bindings.lp $1 -V0 --out-atomf=%s. | head -n1 | tr ' ' '\n'

