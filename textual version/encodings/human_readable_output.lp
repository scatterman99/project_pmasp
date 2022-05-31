expand(K,(N,A,T)) :- constraint(K,N), binary(N), activation(K,A), target(K,T).
expand(K,(N,A))   :- constraint(K,N), unary(N), activation(K,A).

hro_accept(X,TID) :- expand(K,X), accept(K,TID).
hro_nv_accept(X,TID) :- expand(K,X), nv_accept(K,TID).
hro_nv_reject(X,TID) :- expand(K,X), nv_reject(K,TID).
hro_reject(X,TID) :- expand(K,X), reject(K,TID).

% Witness delle violazioni dei constraint
hro_w_witness(X,TID,T) :- expand(K,X), weak_witness(K,TID,T).
hro_p_witness(X,TID,T) :- expand(K,X), perm_witness(K,TID,T).

#show hro_w_witness/3.
#show hro_p_witness/3.
#show hro_accept/2.
#show hro_nv_accept/2.
