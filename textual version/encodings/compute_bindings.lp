binds(K,a,A) :- activation(K,A).
binds(K,b,T) :- target(K,T).
binds(K,c,A) :- constraint(K,N), activity(A), not binds(K,a,A), not binds(K,b,A), binary(N).
binds(K,c,A) :- constraint(K,N), activity(A), not binds(K,a,A), unary(N).

#show constraint/2.
#show binds/3.
#show activation/2.
#show target/2.
#show activity/1.
