is_sat(sat_perm;sat_temp).
is_unsat(vio_perm;vio_temp).

% sat -> vio_perm is a witness
perm_witness(K,TID,T) :- cur_state(K,TID,S,T-1,_), cur_state(K,TID,S',T,_), constraint(K,N), state(N,S,STATUS), state(N,S',vio_perm), is_sat(STATUS), reject(K,TID).

% vio_temp -> vio_perm is a witness
perm_witness(K,TID,T) :- cur_state(K,TID,S,T-1,_), cur_state(K,TID,S',T,_), constraint(K,N), state(N,S,vio_temp), state(N,S',vio_perm), reject(K,TID).

% vio_temp -> vio_temp
becomes_sat_in_the_future(K,T) :- cur_state(K,TID,S',T',_), cur_state(K,TID,S,T,_), state(N,S',STATUS'), T' > T, constraint(K,N), state(N,S,STATUS), is_unsat(STATUS), is_sat(STATUS').

has_p_explaination(K,TID) :- perm_witness(K,TID,_).


% massimo istante di tempo T
% in cui mi trovo in uno stato UNSAT
% che in futuro non diventerà SAT
weak_witness(K,TID,T) :- not has_p_explaination(K,TID), T = #max{Y: cur_state(K,TID,S,Y,_), constraint(K,N), state(N,S,STATUS), is_unsat(STATUS), not becomes_sat_in_the_future(K,Y)}, reject(K,TID).

% sanity check
has_explaination(K,TID) :- reject(K,TID), perm_witness(K,TID,_).
has_explaination(K,TID) :- reject(K,TID), weak_witness(K,TID,_).
no_expl(K,TID) :- reject(K,TID), not has_explaination(K,TID).
% se dà UNSATISFIABLE piango :'(
:- no_expl(K,TID).

#show perm_witness/3.
#show weak_witness/3.
#show reject/2.
