from dataclasses import dataclass
from math import floor


def clean_activity_name(s):
    s = s.strip().lower()
    s = '_'.join(s.split(' '))
    return s

@dataclass
class Constraint:
    template_name: str
    activation: str
    target: str

    @classmethod
    def parse(cls, dictionary):
        params = dictionary['parameters']
        act, tar = None, None

        if len(params) == 2:
            act, tar = clean_activity_name(params[0][0]), clean_activity_name(params[1][0])
        else:
            act, tar = clean_activity_name(params[0][0]), None

        return Constraint(
            template_name=dictionary['template'].lower(),
            activation=act,
            target=tar
        )

    def as_facts(self, id):
        lp = [
            f'constraint({id},{self.template_name}).',
            f'activation({id},{self.activation}).'
        ]

        if self.target is not None:
            lp.append(f'target({id},{self.target}).')

        return lp
