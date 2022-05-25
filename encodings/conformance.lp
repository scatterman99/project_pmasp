cur_state(K, TID, S, 0, irrelevant) :- constraint(K,N), trace(TID), initial(N,S).
cur_state(K, TID, S2, T, R) :- constraint(K,N), cur_state(K, TID, S1, T-1, _), automaton(N, S1, X, S2, R), trace(TID, T, A), binds(K,X,A).

relevant(K, TID) :- cur_state(K, TID, _, _, relevant).
irrelevant(K,TID) :- not relevant(K,TID), trace(TID), constraint(K,_).

accept(K,TID) :- cur_state(K,TID,S,L,_), constraint(K,N), state(N,S,sat_temp), length(TID,L).
accept(K,TID) :- cur_state(K,TID,S,L,_), constraint(K,N), state(N,S,sat_perm), length(TID,L).
reject(K,TID) :- cur_state(K,TID,S,L,_), constraint(K,N), state(N,S,vio_temp), length(TID,L).
reject(K,TID) :- cur_state(K,TID,S,L,_), constraint(K,N), state(N,S,vio_perm), length(TID,L).

nv_accept(K,TID) :- accept(K,TID), relevant(K,TID).
nv_reject(K,TID) :- reject(K,TID), relevant(K,TID).

invalid(TID) :- reject(K, TID).
invalid(TID) :- nv_reject(K, TID).
valid(TID) :- trace(TID), not invalid(TID).

total_violations(N) :- N = #sum{F,TID: invalid(TID), variant_frequence(TID,F)}.

#show valid/1.
#show invalid/1.
#show accept/2.
#show reject/2.
#show nv_accept/2.
#show nv_reject/2.
#show cur_state/5.
#show state/3.
