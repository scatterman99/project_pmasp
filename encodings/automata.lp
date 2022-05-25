unary(absence).
unary(atleast1).
unary(atleast2).
unary(atleast3).
unary(atmost1).
unary(atmost2).
unary(atmost3).
unary(end).
unary(exactly1).
unary(exactly2).
unary(exactly3).
unary(init).
binary(alternateprecedence).
binary(alternateresponse).
binary(alternatesuccession).
binary(chainprecedence).
binary(chainresponse).
binary(chainsuccession).
binary(choice).
binary(coexistence).
binary(exclusivechoice).
binary(notchainprecedence).
binary(notchainresponse).
binary(notcoexistence).
binary(notrespondedexistence).
binary(notresponse).
binary(notsuccession).
binary(precedence).
binary(respondedexistence).
binary(response).
binary(succession).

state(absence, s_0, sat_temp).
initial(absence, s_0).
accepting(absence, s_0).
automaton(absence, s_0, c, s_0, irrelevant).

state(atleast1, s_0, sat_perm).
state(atleast1, s_1, vio_temp).
initial(atleast1, s_1).
accepting(atleast1, s_0).
automaton(atleast1, s_0, a, s_0, irrelevant).
automaton(atleast1, s_0, c, s_0, irrelevant).
automaton(atleast1, s_1, a, s_0, relevant).
automaton(atleast1, s_1, c, s_1, irrelevant).

state(atleast2, s_0, vio_temp).
state(atleast2, s_1, vio_temp).
state(atleast2, s_2, sat_perm).
initial(atleast2, s_1).
accepting(atleast2, s_2).
automaton(atleast2, s_0, a, s_2, relevant).
automaton(atleast2, s_0, c, s_0, irrelevant).
automaton(atleast2, s_1, a, s_0, irrelevant).
automaton(atleast2, s_1, c, s_1, irrelevant).
automaton(atleast2, s_2, a, s_2, irrelevant).
automaton(atleast2, s_2, c, s_2, irrelevant).

state(atleast3, s_0, vio_temp).
state(atleast3, s_1, vio_temp).
state(atleast3, s_2, vio_temp).
state(atleast3, s_3, sat_perm).
initial(atleast3, s_1).
accepting(atleast3, s_3).
automaton(atleast3, s_0, a, s_2, irrelevant).
automaton(atleast3, s_0, c, s_0, irrelevant).
automaton(atleast3, s_1, a, s_0, irrelevant).
automaton(atleast3, s_1, c, s_1, irrelevant).
automaton(atleast3, s_2, a, s_3, relevant).
automaton(atleast3, s_2, c, s_2, irrelevant).
automaton(atleast3, s_3, a, s_3, irrelevant).
automaton(atleast3, s_3, c, s_3, irrelevant).

state(atmost1, s_0, sat_temp).
state(atmost1, s_1, sat_temp).
initial(atmost1, s_1).
accepting(atmost1, s_0).
accepting(atmost1, s_1).
automaton(atmost1, s_0, c, s_0, irrelevant).
automaton(atmost1, s_1, a, s_0, relevant).
automaton(atmost1, s_1, c, s_1, irrelevant).

state(atmost2, s_0, sat_temp).
state(atmost2, s_1, sat_temp).
state(atmost2, s_2, sat_temp).
initial(atmost2, s_1).
accepting(atmost2, s_0).
accepting(atmost2, s_1).
accepting(atmost2, s_2).
automaton(atmost2, s_0, c, s_0, irrelevant).
automaton(atmost2, s_1, a, s_2, irrelevant).
automaton(atmost2, s_1, c, s_1, irrelevant).
automaton(atmost2, s_2, a, s_0, relevant).
automaton(atmost2, s_2, c, s_2, irrelevant).

state(atmost3, s_0, sat_temp).
state(atmost3, s_1, sat_temp).
state(atmost3, s_2, sat_temp).
state(atmost3, s_3, sat_temp).
initial(atmost3, s_3).
accepting(atmost3, s_0).
accepting(atmost3, s_1).
accepting(atmost3, s_2).
accepting(atmost3, s_3).
automaton(atmost3, s_0, a, s_2, irrelevant).
automaton(atmost3, s_0, c, s_0, irrelevant).
automaton(atmost3, s_1, c, s_1, irrelevant).
automaton(atmost3, s_2, a, s_1, relevant).
automaton(atmost3, s_2, c, s_2, irrelevant).
automaton(atmost3, s_3, a, s_0, irrelevant).
automaton(atmost3, s_3, c, s_3, irrelevant).

state(end, s_0, sat_temp).
state(end, s_1, vio_temp).
initial(end, s_1).
accepting(end, s_0).
automaton(end, s_0, a, s_0, irrelevant).
automaton(end, s_0, c, s_1, relevant).
automaton(end, s_1, a, s_0, relevant).
automaton(end, s_1, c, s_1, irrelevant).

state(exactly1, s_0, sat_temp).
state(exactly1, s_1, vio_temp).
initial(exactly1, s_1).
accepting(exactly1, s_0).
automaton(exactly1, s_0, c, s_0, irrelevant).
automaton(exactly1, s_1, a, s_0, relevant).
automaton(exactly1, s_1, c, s_1, irrelevant).

state(exactly2, s_0, sat_temp).
state(exactly2, s_1, vio_temp).
state(exactly2, s_2, vio_temp).
initial(exactly2, s_1).
accepting(exactly2, s_0).
automaton(exactly2, s_0, c, s_0, irrelevant).
automaton(exactly2, s_1, a, s_2, irrelevant).
automaton(exactly2, s_1, c, s_1, irrelevant).
automaton(exactly2, s_2, a, s_0, relevant).
automaton(exactly2, s_2, c, s_2, irrelevant).

state(exactly3, s_0, sat_temp).
state(exactly3, s_1, vio_temp).
state(exactly3, s_2, vio_temp).
state(exactly3, s_3, vio_temp).
initial(exactly3, s_3).
accepting(exactly3, s_0).
automaton(exactly3, s_0, c, s_0, irrelevant).
automaton(exactly3, s_1, a, s_2, irrelevant).
automaton(exactly3, s_1, c, s_1, irrelevant).
automaton(exactly3, s_2, a, s_0, relevant).
automaton(exactly3, s_2, c, s_2, irrelevant).
automaton(exactly3, s_3, a, s_1, irrelevant).
automaton(exactly3, s_3, c, s_3, irrelevant).

state(init, s_0, vio_temp).
state(init, s_1, sat_perm).
initial(init, s_0).
accepting(init, s_1).
automaton(init, s_0, a, s_1, relevant).
automaton(init, s_1, a, s_1, irrelevant).
automaton(init, s_1, c, s_1, irrelevant).

state(alternateprecedence, s_0, sat_temp).
state(alternateprecedence, s_1, sat_temp).
initial(alternateprecedence, s_0).
accepting(alternateprecedence, s_0).
accepting(alternateprecedence, s_1).
automaton(alternateprecedence, s_0, a, s_1, relevant).
automaton(alternateprecedence, s_0, c, s_0, irrelevant).
automaton(alternateprecedence, s_1, a, s_1, irrelevant).
automaton(alternateprecedence, s_1, b, s_0, relevant).
automaton(alternateprecedence, s_1, c, s_1, irrelevant).

state(alternateresponse, s_0, sat_temp).
state(alternateresponse, s_1, vio_temp).
initial(alternateresponse, s_0).
accepting(alternateresponse, s_0).
automaton(alternateresponse, s_0, a, s_1, relevant).
automaton(alternateresponse, s_0, b, s_0, irrelevant).
automaton(alternateresponse, s_0, c, s_0, irrelevant).
automaton(alternateresponse, s_1, b, s_0, relevant).
automaton(alternateresponse, s_1, c, s_1, irrelevant).

state(alternatesuccession, s_0, sat_temp).
state(alternatesuccession, s_1, vio_temp).
initial(alternatesuccession, s_0).
accepting(alternatesuccession, s_0).
automaton(alternatesuccession, s_0, a, s_1, relevant).
automaton(alternatesuccession, s_0, c, s_0, irrelevant).
automaton(alternatesuccession, s_1, b, s_0, relevant).
automaton(alternatesuccession, s_1, c, s_1, irrelevant).

state(chainprecedence, s_0, sat_temp).
state(chainprecedence, s_1, sat_temp).
initial(chainprecedence, s_0).
accepting(chainprecedence, s_0).
accepting(chainprecedence, s_1).
automaton(chainprecedence, s_0, a, s_1, relevant).
automaton(chainprecedence, s_0, c, s_0, irrelevant).
automaton(chainprecedence, s_1, a, s_1, irrelevant).
automaton(chainprecedence, s_1, b, s_0, relevant).
automaton(chainprecedence, s_1, c, s_0, relevant).

state(chainresponse, s_0, sat_temp).
state(chainresponse, s_1, vio_temp).
initial(chainresponse, s_0).
accepting(chainresponse, s_0).
automaton(chainresponse, s_0, a, s_1, relevant).
automaton(chainresponse, s_0, b, s_0, irrelevant).
automaton(chainresponse, s_0, c, s_0, irrelevant).
automaton(chainresponse, s_1, b, s_0, relevant).

state(chainsuccession, s_0, vio_temp).
state(chainsuccession, s_1, sat_temp).
initial(chainsuccession, s_1).
accepting(chainsuccession, s_1).
automaton(chainsuccession, s_0, b, s_1, relevant).
automaton(chainsuccession, s_1, a, s_0, relevant).
automaton(chainsuccession, s_1, c, s_1, irrelevant).

state(choice, s_0, sat_perm).
state(choice, s_1, vio_temp).
initial(choice, s_1).
accepting(choice, s_0).
automaton(choice, s_0, a, s_0, irrelevant).
automaton(choice, s_0, b, s_0, irrelevant).
automaton(choice, s_0, c, s_0, irrelevant).
automaton(choice, s_1, a, s_0, relevant).
automaton(choice, s_1, b, s_0, relevant).
automaton(choice, s_1, c, s_1, irrelevant).

state(coexistence, s_0, sat_temp).
state(coexistence, s_1, vio_temp).
state(coexistence, s_2, vio_temp).
state(coexistence, s_3, sat_perm).
initial(coexistence, s_0).
accepting(coexistence, s_0).
accepting(coexistence, s_3).
automaton(coexistence, s_0, a, s_1, relevant).
automaton(coexistence, s_0, b, s_2, relevant).
automaton(coexistence, s_0, c, s_0, irrelevant).
automaton(coexistence, s_1, a, s_1, irrelevant).
automaton(coexistence, s_1, b, s_3, relevant).
automaton(coexistence, s_1, c, s_1, irrelevant).
automaton(coexistence, s_2, a, s_3, relevant).
automaton(coexistence, s_2, b, s_2, irrelevant).
automaton(coexistence, s_2, c, s_2, irrelevant).
automaton(coexistence, s_3, a, s_3, irrelevant).
automaton(coexistence, s_3, b, s_3, irrelevant).
automaton(coexistence, s_3, c, s_3, irrelevant).

state(exclusivechoice, s_0, vio_perm).
initial(exclusivechoice, s_0).

state(notchainprecedence, s_0, sat_temp).
state(notchainprecedence, s_1, sat_temp).
initial(notchainprecedence, s_0).
accepting(notchainprecedence, s_0).
accepting(notchainprecedence, s_1).
automaton(notchainprecedence, s_0, a, s_1, relevant).
automaton(notchainprecedence, s_0, b, s_0, irrelevant).
automaton(notchainprecedence, s_0, c, s_0, irrelevant).
automaton(notchainprecedence, s_1, a, s_1, irrelevant).
automaton(notchainprecedence, s_1, c, s_0, relevant).

state(notchainresponse, s_0, sat_temp).
state(notchainresponse, s_1, sat_temp).
initial(notchainresponse, s_1).
accepting(notchainresponse, s_0).
accepting(notchainresponse, s_1).
automaton(notchainresponse, s_0, a, s_0, irrelevant).
automaton(notchainresponse, s_0, c, s_1, relevant).
automaton(notchainresponse, s_1, a, s_0, relevant).
automaton(notchainresponse, s_1, b, s_1, irrelevant).
automaton(notchainresponse, s_1, c, s_1, irrelevant).

state(notcoexistence, s_0, sat_temp).
state(notcoexistence, s_1, sat_temp).
state(notcoexistence, s_2, sat_temp).
initial(notcoexistence, s_2).
accepting(notcoexistence, s_0).
accepting(notcoexistence, s_1).
accepting(notcoexistence, s_2).
automaton(notcoexistence, s_0, a, s_0, irrelevant).
automaton(notcoexistence, s_0, c, s_0, irrelevant).
automaton(notcoexistence, s_1, b, s_1, irrelevant).
automaton(notcoexistence, s_1, c, s_1, irrelevant).
automaton(notcoexistence, s_2, a, s_0, relevant).
automaton(notcoexistence, s_2, b, s_1, relevant).
automaton(notcoexistence, s_2, c, s_2, irrelevant).

state(notrespondedexistence, s_0, sat_temp).
state(notrespondedexistence, s_1, sat_temp).
state(notrespondedexistence, s_2, sat_temp).
initial(notrespondedexistence, s_0).
accepting(notrespondedexistence, s_0).
accepting(notrespondedexistence, s_1).
accepting(notrespondedexistence, s_2).
automaton(notrespondedexistence, s_0, a, s_1, relevant).
automaton(notrespondedexistence, s_0, b, s_2, relevant).
automaton(notrespondedexistence, s_0, c, s_0, irrelevant).
automaton(notrespondedexistence, s_1, a, s_1, irrelevant).
automaton(notrespondedexistence, s_1, c, s_1, irrelevant).
automaton(notrespondedexistence, s_2, b, s_2, irrelevant).
automaton(notrespondedexistence, s_2, c, s_2, irrelevant).

state(notresponse, s_0, sat_temp).
state(notresponse, s_1, sat_temp).
initial(notresponse, s_0).
accepting(notresponse, s_0).
accepting(notresponse, s_1).
automaton(notresponse, s_0, a, s_1, relevant).
automaton(notresponse, s_0, b, s_0, irrelevant).
automaton(notresponse, s_0, c, s_0, irrelevant).
automaton(notresponse, s_1, a, s_1, irrelevant).
automaton(notresponse, s_1, c, s_1, irrelevant).

state(notsuccession, s_0, sat_temp).
state(notsuccession, s_1, sat_temp).
initial(notsuccession, s_0).
accepting(notsuccession, s_0).
accepting(notsuccession, s_1).
automaton(notsuccession, s_0, a, s_1, relevant).
automaton(notsuccession, s_0, b, s_0, irrelevant).
automaton(notsuccession, s_0, c, s_0, irrelevant).
automaton(notsuccession, s_1, a, s_1, irrelevant).
automaton(notsuccession, s_1, c, s_1, irrelevant).

state(precedence, s_0, sat_temp).
state(precedence, s_1, sat_perm).
initial(precedence, s_0).
accepting(precedence, s_0).
accepting(precedence, s_1).
automaton(precedence, s_0, a, s_1, relevant).
automaton(precedence, s_0, c, s_0, irrelevant).
automaton(precedence, s_1, a, s_1, irrelevant).
automaton(precedence, s_1, b, s_1, irrelevant).
automaton(precedence, s_1, c, s_1, irrelevant).

state(respondedexistence, s_0, vio_temp).
state(respondedexistence, s_1, sat_perm).
state(respondedexistence, s_2, sat_temp).
initial(respondedexistence, s_2).
accepting(respondedexistence, s_1).
accepting(respondedexistence, s_2).
automaton(respondedexistence, s_0, a, s_0, irrelevant).
automaton(respondedexistence, s_0, b, s_1, relevant).
automaton(respondedexistence, s_0, c, s_0, irrelevant).
automaton(respondedexistence, s_1, a, s_1, irrelevant).
automaton(respondedexistence, s_1, b, s_1, irrelevant).
automaton(respondedexistence, s_1, c, s_1, irrelevant).
automaton(respondedexistence, s_2, a, s_0, relevant).
automaton(respondedexistence, s_2, b, s_1, relevant).
automaton(respondedexistence, s_2, c, s_2, irrelevant).

state(response, s_0, sat_temp).
state(response, s_1, vio_temp).
initial(response, s_0).
accepting(response, s_0).
automaton(response, s_0, a, s_1, relevant).
automaton(response, s_0, b, s_0, irrelevant).
automaton(response, s_0, c, s_0, irrelevant).
automaton(response, s_1, a, s_1, irrelevant).
automaton(response, s_1, b, s_0, relevant).
automaton(response, s_1, c, s_1, irrelevant).

state(succession, s_0, vio_temp).
state(succession, s_1, sat_temp).
state(succession, s_2, sat_temp).
initial(succession, s_2).
accepting(succession, s_1).
accepting(succession, s_2).
automaton(succession, s_0, a, s_0, irrelevant).
automaton(succession, s_0, b, s_1, relevant).
automaton(succession, s_0, c, s_0, irrelevant).
automaton(succession, s_1, a, s_0, relevant).
automaton(succession, s_1, b, s_1, irrelevant).
automaton(succession, s_1, c, s_1, irrelevant).
automaton(succession, s_2, a, s_0, relevant).
automaton(succession, s_2, c, s_2, irrelevant).

%%% Dead states transitions, generate by the following call:
%%% clingo fix_automata.lp automata.lp -V0 --out-atomf=%s. | head -n 1 | tr ' ' '\n' | sed s/"missing_"/''/g

state(absence,dead,vio_perm).
state(atmost1,dead,vio_perm).
state(atmost2,dead,vio_perm).
state(atmost3,dead,vio_perm).
state(exactly1,dead,vio_perm).
state(exactly2,dead,vio_perm).
state(exactly3,dead,vio_perm).
state(init,dead,vio_perm).
state(alternateprecedence,dead,vio_perm).
state(alternateresponse,dead,vio_perm).
state(alternatesuccession,dead,vio_perm).
state(chainprecedence,dead,vio_perm).
state(chainresponse,dead,vio_perm).
state(chainsuccession,dead,vio_perm).
state(exclusivechoice,dead,vio_perm).
state(notchainprecedence,dead,vio_perm).
state(notchainresponse,dead,vio_perm).
state(notcoexistence,dead,vio_perm).
state(notrespondedexistence,dead,vio_perm).
state(notresponse,dead,vio_perm).
state(notsuccession,dead,vio_perm).
state(precedence,dead,vio_perm).
state(succession,dead,vio_perm).
automaton(absence,dead,a,dead,irrelevant).
automaton(absence,dead,c,dead,irrelevant).
automaton(atmost1,dead,a,dead,irrelevant).
automaton(atmost1,dead,c,dead,irrelevant).
automaton(atmost2,dead,a,dead,irrelevant).
automaton(atmost2,dead,c,dead,irrelevant).
automaton(atmost3,dead,a,dead,irrelevant).
automaton(atmost3,dead,c,dead,irrelevant).
automaton(exactly1,dead,a,dead,irrelevant).
automaton(exactly1,dead,c,dead,irrelevant).
automaton(exactly2,dead,a,dead,irrelevant).
automaton(exactly2,dead,c,dead,irrelevant).
automaton(exactly3,dead,a,dead,irrelevant).
automaton(exactly3,dead,c,dead,irrelevant).
automaton(init,dead,a,dead,irrelevant).
automaton(init,dead,c,dead,irrelevant).
automaton(alternateprecedence,dead,a,dead,irrelevant).
automaton(alternateprecedence,dead,b,dead,irrelevant).
automaton(alternateprecedence,dead,c,dead,irrelevant).
automaton(alternateresponse,dead,a,dead,irrelevant).
automaton(alternateresponse,dead,b,dead,irrelevant).
automaton(alternateresponse,dead,c,dead,irrelevant).
automaton(alternatesuccession,dead,a,dead,irrelevant).
automaton(alternatesuccession,dead,b,dead,irrelevant).
automaton(alternatesuccession,dead,c,dead,irrelevant).
automaton(chainprecedence,dead,a,dead,irrelevant).
automaton(chainprecedence,dead,b,dead,irrelevant).
automaton(chainprecedence,dead,c,dead,irrelevant).
automaton(chainresponse,dead,a,dead,irrelevant).
automaton(chainresponse,dead,b,dead,irrelevant).
automaton(chainresponse,dead,c,dead,irrelevant).
automaton(chainsuccession,dead,a,dead,irrelevant).
automaton(chainsuccession,dead,b,dead,irrelevant).
automaton(chainsuccession,dead,c,dead,irrelevant).
automaton(exclusivechoice,dead,a,dead,irrelevant).
automaton(exclusivechoice,dead,b,dead,irrelevant).
automaton(exclusivechoice,dead,c,dead,irrelevant).
automaton(notchainprecedence,dead,a,dead,irrelevant).
automaton(notchainprecedence,dead,b,dead,irrelevant).
automaton(notchainprecedence,dead,c,dead,irrelevant).
automaton(notchainresponse,dead,a,dead,irrelevant).
automaton(notchainresponse,dead,b,dead,irrelevant).
automaton(notchainresponse,dead,c,dead,irrelevant).
automaton(notcoexistence,dead,a,dead,irrelevant).
automaton(notcoexistence,dead,b,dead,irrelevant).
automaton(notcoexistence,dead,c,dead,irrelevant).
automaton(notrespondedexistence,dead,a,dead,irrelevant).
automaton(notrespondedexistence,dead,b,dead,irrelevant).
automaton(notrespondedexistence,dead,c,dead,irrelevant).
automaton(notresponse,dead,a,dead,irrelevant).
automaton(notresponse,dead,b,dead,irrelevant).
automaton(notresponse,dead,c,dead,irrelevant).
automaton(notsuccession,dead,a,dead,irrelevant).
automaton(notsuccession,dead,b,dead,irrelevant).
automaton(notsuccession,dead,c,dead,irrelevant).
automaton(precedence,dead,a,dead,irrelevant).
automaton(precedence,dead,b,dead,irrelevant).
automaton(precedence,dead,c,dead,irrelevant).
automaton(succession,dead,a,dead,irrelevant).
automaton(succession,dead,b,dead,irrelevant).
automaton(succession,dead,c,dead,irrelevant).
automaton(absence,s_0,a,dead,irrelevant).
automaton(atmost1,s_0,a,dead,irrelevant).
automaton(atmost2,s_0,a,dead,irrelevant).
automaton(atmost3,s_1,a,dead,irrelevant).
automaton(exactly1,s_0,a,dead,irrelevant).
automaton(exactly2,s_0,a,dead,irrelevant).
automaton(exactly3,s_0,a,dead,irrelevant).
automaton(init,s_0,c,dead,irrelevant).
automaton(alternateprecedence,s_0,b,dead,irrelevant).
automaton(alternateresponse,s_1,a,dead,irrelevant).
automaton(alternatesuccession,s_0,b,dead,irrelevant).
automaton(alternatesuccession,s_1,a,dead,irrelevant).
automaton(chainprecedence,s_0,b,dead,irrelevant).
automaton(chainresponse,s_1,a,dead,irrelevant).
automaton(chainresponse,s_1,c,dead,irrelevant).
automaton(chainsuccession,s_0,a,dead,irrelevant).
automaton(chainsuccession,s_0,c,dead,irrelevant).
automaton(chainsuccession,s_1,b,dead,irrelevant).
automaton(exclusivechoice,s_0,a,dead,irrelevant).
automaton(exclusivechoice,s_0,b,dead,irrelevant).
automaton(exclusivechoice,s_0,c,dead,irrelevant).
automaton(notchainprecedence,s_1,b,dead,irrelevant).
automaton(notchainresponse,s_0,b,dead,irrelevant).
automaton(notcoexistence,s_0,b,dead,irrelevant).
automaton(notcoexistence,s_1,a,dead,irrelevant).
automaton(notrespondedexistence,s_1,b,dead,irrelevant).
automaton(notrespondedexistence,s_2,a,dead,irrelevant).
automaton(notresponse,s_1,b,dead,irrelevant).
automaton(notsuccession,s_1,b,dead,irrelevant).
automaton(precedence,s_0,b,dead,irrelevant).
automaton(succession,s_2,b,dead,irrelevant).
