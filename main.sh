#! /usr/bin/sh

if [ $# -ne 2 ]; then
        echo "Usage: main.sh LOG_FILE MODEL_FILE"
        exit 0
fi




LOG=$1
MODEL=$2

echo "Cleaning up..."
./scripts/cleanup.sh

echo "Generating automata bindings for $MODEL..."
./scripts/compute_bindings.sh $MODEL > artifacts/bindings.lp

echo "Checking conformance on $LOG..."
./scripts/compute_conformance.sh $LOG > artifacts/trace_alignment.lp

echo "Computing rejection witnesses for $LOG..."
./scripts/compute_violation_witness.sh $LOG > artifacts/rejection_witnesses.lp

echo "Generating human readable output..."
./scripts/hro.sh > artifacts/hro.lp

cat artifacts/hro.lp
