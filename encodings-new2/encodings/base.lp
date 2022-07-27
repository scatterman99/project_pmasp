% trace/3: <log_file>.lp

trace(TID) :- trace(TID,_,_).
activity(A) :- trace(_,_,A).
length(TID,L) :- trace(TID), L = #max{T: trace(TID,T,_)}.
occurrences(TID,A,N) :- trace(TID), activity(A), N = #count{T: trace(TID,T,A)}.
log_length(L) :- L = #sum{F,TID: variant_frequence(TID,F)}.

type(existence).
type(relational).
subtype(existence, cardinality).
subtype(existence, position).
subtype(relational, forward).
subtype(relational, backward).
subtype(relational, coupling).
subtype(relational, negative).

template(absence).
template(absence, cardinality).
template(atleast1).
template(atleast1, cardinality).
template(atleast2).
template(atleast2, cardinality).
template(atleast3).
template(atleast3, cardinality).
template(atmost1).
template(atmost1, cardinality).
template(atmost2).
template(atmost2, cardinality).
template(atmost3).
template(atmost3, cardinality).
template(exactly1).
template(exactly1, cardinality).
template(exactly2).
template(exactly2, cardinality).
template(exactly3).
template(exactly3, cardinality).

template(init).
template(init, position).
template(end).
template(end, position).

template(respondedexistence).
template(respondedexistence, forward).
template(response).
template(response, forward).
template(alternateresponse).
template(alternateresponse, forward).
template(chainresponse). 
template(chainresponse, forward). 

template(precedence).
template(precedence, backward).
template(alternateprecedence).
template(alternateprecedence, backward).
template(chainprecedence).
template(chainprecedence, backward).


template(coexistence).
template(coexistence, coupling).
template(succession).
template(succession, coupling).
template(alternatesuccession).
template(alternatesuccession, coupling).
template(chainsuccession).
template(chainsuccession, coupling).


template(notchainsuccession).
template(notchainsuccession, negative).
template(notsuccession).
template(notsuccession, negative).
template(notcoexistence).
template(notcoexistence, negative).

unary(T) :- template(T, C), subtype(existence, C).
binary(T) :- template(T), not unary(T).

