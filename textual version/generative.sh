#! /usr/bin/sh

if [ $# -ne 3 ]; then
        echo "Usage: generative.sh MODEL_FILE LOG_LENGTH TRACE_LENGTH"
        exit 0
fi




MODEL=$1
LOG_LENGTH=$2
TRACE_LENGTH=$3

echo "Cleaning up..."
./scripts/cleanup.sh

echo "Computing model bindings..."
./scripts/compute_bindings.sh $MODEL > artifacts/bindings.lp

echo "Generating negative traces.."
./scripts/generate_rejected.sh $LOG_LENGTH $TRACE_LENGTH> artifacts/noncompliant_traces.lp

echo "Generating positive traces..."
./scripts/generate_accepted.sh $LOG_LENGTH $TRACE_LENGTH > artifacts/compliant_traces.lp


