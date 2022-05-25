cur_state(K, S, 0, irrelevant) :- constraint(K,N), initial(N,S).
cur_state(K, S2, T, R) :- constraint(K,N), cur_state(K, S1, T-1, _), automaton(N, S1, X, S2, R), trace(T, A), binds(K,X,A).

relevant(K) :- cur_state(K, _, _, relevant).
irrelevant(K) :- not relevant(K), constraint(K,_).

length(L) :- L = #max{T: trace(T,_)}.
accept(K) :- cur_state(K,S,L,_), constraint(K,N), state(N,S,sat_temp), length(L).
accept(K) :- cur_state(K,S,L,_), constraint(K,N), state(N,S,sat_perm), length(L).
reject(K) :- cur_state(K,S,L,_), constraint(K,N), state(N,S,vio_temp), length(L).
reject(K) :- cur_state(K,S,L,_), constraint(K,N), state(N,S,vio_perm), length(L).

nv_accept(K) :- accept(K), relevant(K).
nv_reject(K) :- reject(K), relevant(K).

invalid :- reject(K).
invalid :- nv_reject(K).
valid :-  not invalid.

