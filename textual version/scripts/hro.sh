#! /usr/bin/sh

clingo encodings/human_readable_output.lp artifacts/rejection_witnesses.lp artifacts/trace_alignment.lp artifacts/bindings.lp encodings/templates.lp -V0 --out-atomf=%s. | head -n 1 | tr ' ' '\n'


