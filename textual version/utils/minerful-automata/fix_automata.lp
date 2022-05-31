%%% Takes in input automata.lp file printed out by MINERful and generates 
%%% states & transitions to make the corresponding automata total.
%%% Call: clingo fix_automata.lp automata.lp
%%% rename the atoms in the answer set and add them to automata.lp

should_read(N,a;N,b;N,c) :- binary(N).
should_read(N,a;N,c) :- unary(N).

reads(N,S,C) :- automaton(N,S,C,_,_).
missing(N,S,C) :- should_read(N,C), state(N,S,_), not reads(N,S,C).

missing_automaton(N,S,C,dead,irrelevant) :- missing(N,S,C).
missing_automaton(N,dead,C,dead,irrelevant) :- should_read(N,C), missing(N,_,_).
missing_state(N,dead,vio_perm) :- missing(N,_,_).

#show missing_automaton/5.
#show missing_state/3.
