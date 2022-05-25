from argparse import ArgumentParser
import json
from .declarejson2lp import clean_activity_name, Constraint

if __name__ == '__main__':
    p = ArgumentParser()
    p.add_argument('--input-model', '-i', required=True, type=str, help="Path of the input Declare model, in JSON format (as output by MINERful's --save-as-json).")
    p.add_argument('--output-path', '-o', required=True, type=str, help="Output directory for the model-as-facts file.")
    args = p.parse_args()

    with open(args.input_model, 'r') as f:
        declare_map = json.load(f)

    lp = []
    for task in declare_map['tasks']:
        lp.append(f'activity({clean_activity_name(task)}).')

    for idx, constraint in enumerate(declare_map['constraints'], start=1):
        c = Constraint.parse(constraint)
        lp.extend(c.as_facts(idx))

    with open(args.output_path, 'w') as f:
        for line in lp:
            f.write(line)
            f.write('\n')