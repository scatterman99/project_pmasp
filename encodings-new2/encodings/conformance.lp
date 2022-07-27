rejects(TID) :- model2(C), trace(TID), not holds(C,TID).
accepts(TID) :- trace(TID), not rejects(TID).


#show rejects/1.
#show accepts/1.
