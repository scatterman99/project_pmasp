%%% Check it is deterministic
:- automaton(N,S,C,S',_), automaton(N,S,C,S'',_), S' != S''.

%%% Check it reads {a,b?,c} in every state
should_read(N,a;N,b;N,c) :- binary(N).
should_read(N,a;N,c) :- unary(N).
reads(N,S,C) :- automaton(N,S,C,_,_).
:- should_read(N,C), state(N,S,_), not reads(N,S,C).
