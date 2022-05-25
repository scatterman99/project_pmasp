import os
from argparse import ArgumentParser
from xes2lp import import_xes, unique_variants, events_sequence_from_variant_name, variant_to_lp

if __name__ == '__main__':
    p = ArgumentParser()
    p.add_argument('--input-log', '-i', required=True, type=str, help="Path of the input log file, in XES format.")
    p.add_argument('--output-log', '-o', required=True, type=str, help="Path for the variants-as-facts output file.")
    p.add_argument('--frequence-treshold', '-f', required=True, type=float, help="Discards process variants below the given frequence "
                                                                       "treshsold.")
    args = p.parse_args()

    log = import_xes(args.input_log)
    variants = unique_variants(log)

    logic_program = []
    for id, process_variant in enumerate(variants, start=1):
        frequence = process_variant['count'] / len(log)

        if frequence >= args.frequence_treshold:
            process_variant['variant'] = events_sequence_from_variant_name(process_variant['variant'])
            process_variant['id'] = id
            logic_program.extend(variant_to_lp(process_variant))

    with open(os.path.join(args.output_log), 'w') as f:
        for line in logic_program:
            f.write(line)
            f.write('\n')