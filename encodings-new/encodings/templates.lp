_model(constraint(T,A,A)) :- model(T,A), unary(T).
_model(constraint(T,A,B)) :- model(T,A,B), binary(T).
sc(C) :- _model(C).

% Absence
holds(constraint(absence,X,X),TID) :- trace(TID), activity(X), not trace(TID,_,X), sc(constraint(absence,X,X)).

% AtLeast1
holds(constraint(atleast1,X,X),TID) :- trace(TID,_,X), sc(constraint(atleast1,X,X)).

% AtLeast2
holds(constraint(atleast2,X,X),TID) :- occurrences(TID,X,N), N >= 2, sc(constraint(atleast2,X,X)).

% AtLeast3
holds(constraint(atleast3,X,X),TID) :- occurrences(TID,X,N), N >= 3, sc(constraint(atleast3,X,X)).

% AtMost1
holds(constraint(atmost1,X,X),TID) :- occurrences(TID,X,N), N <= 1, sc(constraint(atmost1,X,X)).

% AtMost2
holds(constraint(atmost2,X,X),TID) :- occurrences(TID,X,N), N <= 2, sc(constraint(atmost2,X,X)).

% AtMost3
holds(constraint(atmost3,X,X),TID) :- occurrences(TID,X,N), N <= 3, sc(constraint(atmost3,X,X)).

% Exactly1
holds(constraint(exactly1,X,X),TID) :- occurrences(TID,X,1), sc(constraint(exactly1,X,X)).

% Exactly2
holds(constraint(exactly2,X,X),TID) :- occurrences(TID,X,2), sc(constraint(exactly2,X,X)).

% Exactly3
holds(constraint(exactly3,X,X),TID) :- occurrences(TID,X,3), sc(constraint(exactly3,X,X)).

% Init
holds(constraint(init,X,X),TID) :- trace(TID,1,X), sc(constraint(init,X,X)).

% End
holds(constraint(end,X,X),TID) :- length(TID,K), trace(TID,K,X), sc(constraint(end,X,X)).

% Responded Existence
__aux__not_respondedexistence(TID,X,Y) :- activity(Y), trace(TID,_,X), not trace(TID,_,Y), sc(constraint(respondedexistence,X,Y)).
holds(constraint(respondedexistence,X,Y),TID) :- X != Y, activity(X), activity(Y), trace(TID), not __aux__not_respondedexistence(TID,X,Y), sc(constraint(respondedexistence,X,Y)).

% Response
__aux_response_witness(TID,X,Y,T) :- trace(TID,T,X), trace(TID,T',Y), T' > T, sc(constraint(response,X,Y)).
__aux_not_response(TID,X,Y) :- trace(TID,T,X), not __aux_response_witness(TID,X,Y,T), activity(Y).
holds(constraint(response,X,Y),TID) :- X != Y, trace(TID), activity(X), activity(Y), not __aux_not_response(TID,X,Y), sc(constraint(response,X,Y)).


% Alternate Response
__aux_alternateresponse_witness(TID,X,Y,T) :- trace(TID,T,X), T'' = #min{Q: trace(TID,Q,X),Q > T}, trace(TID,T',Y), T' > T, T' < T'', sc(constraint(alternateresponse,X,Y)).
__aux_not_alternateresponse(TID,X,Y) :- trace(TID,T,X), activity(Y), not __aux_alternateresponse_witness(TID,X,Y,T), sc(constraint(alternateresponse,X,Y)).
holds(constraint(alternateresponse,X,Y),TID) :- X != Y, trace(TID), activity(X), activity(Y), not __aux_not_alternateresponse(TID,X,Y), sc(constraint(alternateresponse,X,Y)).

% Chain Response
__aux_chainresponse_vio_witness(TID,X,Y) :- trace(TID,T,X), not trace(TID,T+1,Y), activity(Y), sc(constraint(chainresponse,X,Y)).
holds(constraint(chainresponse,X,Y),TID) :- X != Y, activity(X), activity(Y), trace(TID), not __aux_chainresponse_vio_witness(TID,X,Y), sc(constraint(chainresponse,X,Y)).


% Precedence
__aux_precedence_vio_witness(TID,X,Y) :- trace(TID,T',Y), T=#min{Q: trace(TID,Q,X)}, trace(TID,T,X), T' < T, sc(constraint(precedence,X,Y)).
__aux_precedence_vio_witness(TID,X,Y) :- trace(TID,_,Y), activity(X), not trace(TID,_,X), sc(constraint(precedence,X,Y)).
holds(constraint(precedence,X,Y),TID) :- X != Y, activity(X),activity(Y),trace(TID), not __aux_precedence_vio_witness(TID,X,Y), sc(constraint(precedence,X,Y)).

% Alternate Precedence
__aux_alternateprecedence_witness(TID,X,Y,T'') :- trace(TID,T'',Y), T = #max{Q: trace(TID,Q,Y), Q < T''}, trace(TID,T',X), T' < T'', T' > T, sc(constraint(alternateprecedence,X,Y)).
__aux_not_alternateprecedence(TID,X,Y) :- trace(TID,T,Y), activity(X), not __aux_alternateprecedence_witness(TID,X,Y,T), sc(constraint(alternateprecedence,X,Y)).
holds(constraint(alternateprecedence,X,Y),TID) :- X != Y, trace(TID), activity(X), activity(Y), not __aux_not_alternateprecedence(TID,X,Y), sc(constraint(alternateprecedence,X,Y)).

% Chain Precedence
__aux_chainprecedence_vio_witness(TID,X,Y) :- trace(TID,T,Y), not trace(TID,T-1,X), activity(X), sc(constraint(chainprecedence,X,Y)).
holds(constraint(chainprecedence,X,Y),TID) :- X != Y, activity(X), activity(Y), trace(TID), not __aux_chainprecedence_vio_witness(TID,X,Y), sc(constraint(chainprecedence,X,Y)).

% Co-Existence
sc(constraint(respondedexistence,X,Y)) :- sc(constraint(coexistence,X,Y)).
sc(constraint(respondedexistence,Y,X)) :- sc(constraint(coexistence,X,Y)).
holds(constraint(coexistence,X,Y),TID) :- X < Y, holds(constraint(respondedexistence,X,Y),TID), holds(constraint(respondedexistence,Y,X),TID), sc(constraint(coexistence,Y,X)).

% Succession
sc(constraint(response,X,Y)) :- sc(constraint(succession,X,Y)).
sc(constraint(precedence,X,Y)) :- sc(constraint(succession,X,Y)).
holds(constraint(succession,X,Y),TID) :- X != Y, holds(constraint(response,X,Y),TID), holds(constraint(precedence,X,Y),TID).

% Alternate Succession 
sc(constraint(alternateresponse,X,Y)) :- sc(constraint(alternatesuccession,X,Y)).
sc(constraint(alternateprecedence,X,Y)) :- sc(constraint(alternatesuccession,X,Y)).
holds(constraint(alternatesuccession,X,Y),TID) :- X != Y, holds(constraint(alternateprecedence,X,Y),TID), holds(constraint(alternateresponse,X,Y),TID).

% Chain Succession
sc(constraint(chainresponse,X,Y)) :- sc(constraint(chainsuccession,X,Y)).
sc(constraint(chainprecedence,X,Y)) :- sc(constraint(chainsuccession,X,Y)).
holds(constraint(chainsuccession,X,Y),TID) :- X != Y, holds(constraint(chainresponse,X,Y),TID), holds(constraint(chainprecedence,X,Y),TID).

% Not Chain Succession
__aux_notchainsuccession_vio_witness(TID,X,Y) :- trace(TID,T,X), trace(TID,T+1,Y), sc(constraint(notchainsuccession,X,Y)).
holds(constraint(notchainsuccession,X,Y),TID) :- X != Y, activity(X), activity(Y), trace(TID), not __aux_notchainsuccession_vio_witness(TID,X,Y), sc(constraint(notsuccession,X,Y)).

% Not Succession
__aux_succession_vio_witness(TID,X,Y) :- trace(TID,T,X), trace(TID,T',Y), T < T', sc(constraint(notchainsuccession,X,Y)).
holds(constraint(notsuccession,X,Y),TID) :- X != Y, activity(X), activity(Y), trace(TID), not __aux_succession_vio_witness(TID,X,Y), sc(constraint(notsuccession,X,Y)).

% Not Coexistence
__aux_notcoexistence_vio_witness(TID,X,Y) :- trace(TID,_,X), trace(TID,_,Y), sc(constraint(notcoexistence,X,Y)).
holds(constraint(notcoexistence,X,Y),TID) :- X != Y, activity(X), activity(Y), trace(TID), not __aux_notcoexistence_vio_witness(TID,X,Y),sc(constraint(notcoexistence,X,Y)).
