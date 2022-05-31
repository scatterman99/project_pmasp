#const length=10.
time(1..length).
1 { trace(T,A): activity(A) } 1 :- time(T).
:- valid.

trace(replaceme,T,A) :- trace(T,A).
#show trace/3.
