from typing import List

from pm4py.objects.log.importer.xes import importer as xes_importer
from pm4py.statistics.traces.generic.log import case_statistics


# TODO: Import in a common package...
def clean_activity_name(s):
    s = s.strip().lower()
    s = '_'.join(s.split(' '))
    return s


def import_xes(path):
    return xes_importer.apply(path)


def unique_variants(log):
    return case_statistics.get_variant_statistics(log)


def events_sequence_from_variant_name(variant_name):
    return [clean_activity_name(e) for e in variant_name.split(',')]


def variant_to_lp(variant):
    events = variant['variant']
    count = variant['count']
    id = variant['id']

    program = [f'variant_frequence({id},{count}).']
    for time, event in enumerate(events, start=1):
        program.append(f'trace({id},{time},{event}).')

    return program
