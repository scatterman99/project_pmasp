import json
import sys
from typing import List, Iterable

from frozendict import frozendict
from pm4py.objects.log.importer.xes import importer as xes_importer
from pm4py.objects.log.obj import EventLog
from pm4py.statistics.traces.generic.log import case_statistics
from pm4py.algo.filtering.log.attributes import attributes_filter
from pathlib import Path
import string
from bidict import frozenbidict

ACTIVITY_NAME_XML_ATTRIBUTE = "concept:name"
TRACE_ACTIVITY_NAME_SEPARATOR = ','

from argparse import ArgumentParser


def load_xes_log(log_path: str):
    # Read XES file
    full_log_path: str = str(Path(log_path).expanduser().resolve())
    log: EventLog = xes_importer.apply(full_log_path)

    # Build activities' symbol table
    activities = sorted(attributes_filter.get_attribute_values(log, ACTIVITY_NAME_XML_ATTRIBUTE).keys())

    variants = [
        (str(data['variant']), data['count']) for data in case_statistics.get_variant_statistics(log)
    ]

    return activities, variants


def xes2lp(activities, variants):
    edb = []
    TRACE_3 = 'trace({trace_id}, {timestep}, \"{activity}\").'
    VARIANT_FREQUENCE_2 = 'variant_frequence({trace_id}, {count}).'
    ACTIVITY_1 = 'activity(\"{symbol}\").'

    for activity in activities:
        edb.append(ACTIVITY_1.format(symbol=activity))

    for trace_id, (variant, count) in enumerate(variants, start=1):
        edb.append(VARIANT_FREQUENCE_2.format(trace_id=trace_id, count=count))

        for timestep, symbol in enumerate(variant.split(TRACE_ACTIVITY_NAME_SEPARATOR), start=1):
            edb.append(TRACE_3.format(
                trace_id=trace_id,
                timestep=timestep,
                activity=symbol)
            )

    return edb


def logicify_log(path):
    activities, variants = load_xes_log(path)
    return xes2lp(activities, variants)

if __name__ == '__main__':
    p = ArgumentParser()
    p.add_argument('log', type=str)
    p.add_argument('-o', '--output-file', type=str, default=None)

    args = p.parse_args()

    edb = logicify_log(args.log)

    if args.output_file is None:
        sys.stdout.write('\n'.join(edb) + '\n')
        sys.exit(0)

    with open(args.output_file, 'w') as f:
        f.write('\n'.join(edb) + '\n')
    sys.exit(0)
