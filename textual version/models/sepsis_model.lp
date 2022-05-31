activity(crp).
activity(release_b).
activity(leucocytes).
activity(release_a).
activity(er_registration).
activity(iv_liquid).
activity(release_d).
activity(release_c).
activity(release_e).
activity(admission_ic).
activity(return_er).
activity(admission_nc).
activity(er_sepsis_triage).
activity(lacticacid).
activity(er_triage).
activity(iv_antibiotics).

constraint(1,notsuccession).
activation(1,release_c).
target(1,er_triage).

constraint(2,absence).
activation(2,er_triage).

constraint(3,absence).
activation(3,release_c).

constraint(4,notchainsuccession).
activation(4,er_sepsis_triage).
target(4,release_e).
