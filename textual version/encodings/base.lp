trace(TID) :- trace(TID,_,_).
activity(A) :- trace(_,_,A).
length(TID,L) :- trace(TID), #max {T : trace(TID,T,_)} = L.
