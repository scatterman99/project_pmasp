activity("crp").
activity("release b").
activity("leucocytes").
activity("release a").
activity("er registration").
activity("iv liquid").
activity("release d").
activity("release c").
activity("release e").
activity("admission ic").
activity("return er").
activity("admission nc").
activity("er sepsis triage").
activity("lacticacid").
activity("er triage").
activity("iv antibiotics").
constraint(1,respondedexistence).
activation(1,"lacticacid").
constraint(1,"leucocytes").
constraint(2,notchainsuccession).
activation(2,"iv liquid").
constraint(2,"er registration").
constraint(3,respondedexistence).
activation(3,"iv antibiotics").
constraint(3,"er triage").
constraint(4,notchainsuccession).
activation(4,"iv antibiotics").
constraint(4,"leucocytes").
constraint(5,notchainsuccession).
activation(5,"admission nc").
constraint(5,"lacticacid").
constraint(6,respondedexistence).
activation(6,"lacticacid").
constraint(6,"er registration").
constraint(7,respondedexistence).
activation(7,"iv liquid").
constraint(7,"er triage").
constraint(8,respondedexistence).
activation(8,"leucocytes").
constraint(8,"er triage").
constraint(9,notsuccession).
activation(9,"admission nc").
constraint(9,"er sepsis triage").
constraint(10,notchainsuccession).
activation(10,"crp").
constraint(10,"er registration").
constraint(11,notchainsuccession).
activation(11,"iv antibiotics").
constraint(11,"er registration").
constraint(12,notchainsuccession).
activation(12,"iv antibiotics").
constraint(12,"lacticacid").
constraint(13,notchainsuccession).
activation(13,"lacticacid").
constraint(13,"return er").
constraint(14,notsuccession).
activation(14,"admission nc").
constraint(14,"er triage").
constraint(15,precedence).
activation(15,"er triage").
constraint(15,"admission nc").
constraint(16,notchainsuccession).
activation(16,"lacticacid").
constraint(16,"er triage").
constraint(17,respondedexistence).
activation(17,"er sepsis triage").
constraint(17,"crp").
constraint(18,alternateprecedence).
activation(18,"crp").
constraint(18,"release a").
constraint(19,notsuccession).
activation(19,"return er").
constraint(19,"release a").
constraint(20,notchainsuccession).
activation(20,"iv liquid").
constraint(20,"lacticacid").
constraint(21,notchainsuccession).
activation(21,"er triage").
constraint(21,"leucocytes").
constraint(22,atmost1).
activation(22,"iv antibiotics").
constraint(23,alternateprecedence).
activation(23,"er sepsis triage").
constraint(23,"return er").
constraint(24,coexistence).
activation(24,"er registration").
constraint(24,"er triage").
constraint(25,respondedexistence).
activation(25,"iv liquid").
constraint(25,"er sepsis triage").
constraint(26,respondedexistence).
activation(26,"iv liquid").
constraint(26,"iv antibiotics").
constraint(27,respondedexistence).
activation(27,"er sepsis triage").
constraint(27,"er registration").
constraint(28,notchainsuccession).
activation(28,"admission nc").
constraint(28,"iv liquid").
constraint(29,notchainsuccession).
activation(29,"er registration").
constraint(29,"return er").
constraint(30,notsuccession).
activation(30,"release a").
constraint(30,"er registration").
constraint(31,notsuccession).
activation(31,"iv antibiotics").
constraint(31,"er sepsis triage").
constraint(32,notchainsuccession).
activation(32,"er sepsis triage").
constraint(32,"return er").
constraint(33,notchainsuccession).
activation(33,"leucocytes").
constraint(33,"iv liquid").
constraint(34,respondedexistence).
activation(34,"er triage").
constraint(34,"er sepsis triage").
constraint(35,notchainsuccession).
activation(35,"er triage").
constraint(35,"crp").
constraint(36,notchainsuccession).
activation(36,"er triage").
constraint(36,"er registration").
constraint(37,notsuccession).
activation(37,"return er").
constraint(37,"admission nc").
constraint(38,notsuccession).
activation(38,"return er").
constraint(38,"iv liquid").
constraint(39,notchainsuccession).
activation(39,"iv liquid").
constraint(39,"leucocytes").
constraint(40,notchainsuccession).
activation(40,"iv antibiotics").
constraint(40,"release a").
constraint(41,alternateprecedence).
activation(41,"leucocytes").
constraint(41,"release a").
constraint(42,respondedexistence).
activation(42,"admission nc").
constraint(42,"crp").
constraint(43,notchainsuccession).
activation(43,"lacticacid").
constraint(43,"er sepsis triage").
constraint(44,atleast1).
activation(44,"leucocytes").
constraint(45,notchainsuccession).
activation(45,"er registration").
constraint(45,"iv liquid").
constraint(46,notchainsuccession).
activation(46,"return er").
constraint(46,"leucocytes").
constraint(47,precedence).
activation(47,"er registration").
constraint(47,"admission nc").
constraint(48,notchainsuccession).
activation(48,"admission nc").
constraint(48,"iv antibiotics").
constraint(49,notchainsuccession).
activation(49,"admission nc").
constraint(49,"return er").
constraint(50,coexistence).
activation(50,"er triage").
constraint(50,"er registration").
constraint(51,notchainsuccession).
activation(51,"er registration").
constraint(51,"iv antibiotics").
constraint(52,respondedexistence).
activation(52,"lacticacid").
constraint(52,"crp").
constraint(53,notchainsuccession).
activation(53,"er registration").
constraint(53,"crp").
constraint(54,notchainsuccession).
activation(54,"return er").
constraint(54,"lacticacid").
constraint(55,atleast1).
activation(55,"er registration").
constraint(56,alternateprecedence).
activation(56,"er registration").
constraint(56,"return er").
constraint(57,respondedexistence).
activation(57,"er triage").
constraint(57,"leucocytes").
constraint(58,notsuccession).
activation(58,"release a").
constraint(58,"admission nc").
constraint(59,respondedexistence).
activation(59,"er registration").
constraint(59,"er sepsis triage").
constraint(60,respondedexistence).
activation(60,"leucocytes").
constraint(60,"er registration").
constraint(61,notsuccession).
activation(61,"release a").
constraint(61,"iv liquid").
constraint(62,respondedexistence).
activation(62,"admission nc").
constraint(62,"er sepsis triage").
constraint(63,notchainsuccession).
activation(63,"leucocytes").
constraint(63,"er registration").
constraint(64,notsuccession).
activation(64,"return er").
constraint(64,"er registration").
constraint(65,respondedexistence).
activation(65,"er registration").
constraint(65,"crp").
constraint(66,notchainsuccession).
activation(66,"iv liquid").
constraint(66,"release a").
constraint(67,respondedexistence).
activation(67,"er sepsis triage").
constraint(67,"leucocytes").
constraint(68,respondedexistence).
activation(68,"lacticacid").
constraint(68,"er sepsis triage").
constraint(69,notchainsuccession).
activation(69,"er triage").
constraint(69,"lacticacid").
constraint(70,alternateprecedence).
activation(70,"admission nc").
constraint(70,"return er").
constraint(71,notchainsuccession).
activation(71,"er sepsis triage").
constraint(71,"release a").
constraint(72,notchainsuccession).
activation(72,"lacticacid").
constraint(72,"er registration").
constraint(73,alternateprecedence).
activation(73,"er sepsis triage").
constraint(73,"release a").
constraint(74,notsuccession).
activation(74,"release a").
constraint(74,"er triage").
constraint(75,respondedexistence).
activation(75,"iv antibiotics").
constraint(75,"lacticacid").
constraint(76,notchainsuccession).
activation(76,"leucocytes").
constraint(76,"er triage").
constraint(77,notchainsuccession).
activation(77,"crp").
constraint(77,"iv antibiotics").
constraint(78,alternateprecedence).
activation(78,"crp").
constraint(78,"return er").
constraint(79,notchainsuccession).
activation(79,"release a").
constraint(79,"leucocytes").
constraint(80,notchainsuccession).
activation(80,"er registration").
constraint(80,"release a").
constraint(81,notchainsuccession).
activation(81,"crp").
constraint(81,"return er").
constraint(82,respondedexistence).
activation(82,"crp").
constraint(82,"er registration").
constraint(83,respondedexistence).
activation(83,"lacticacid").
constraint(83,"er triage").
constraint(84,respondedexistence).
activation(84,"iv liquid").
constraint(84,"leucocytes").
constraint(85,notchainsuccession).
activation(85,"iv antibiotics").
constraint(85,"er triage").
constraint(86,atmost1).
activation(86,"release a").
constraint(87,respondedexistence).
activation(87,"iv liquid").
constraint(87,"lacticacid").
constraint(88,respondedexistence).
activation(88,"crp").
constraint(88,"leucocytes").
constraint(89,respondedexistence).
activation(89,"iv liquid").
constraint(89,"er registration").
constraint(90,notchainsuccession).
activation(90,"er registration").
constraint(90,"er sepsis triage").
constraint(91,atmost1).
activation(91,"er sepsis triage").
constraint(92,alternateprecedence).
activation(92,"er registration").
constraint(92,"release a").
constraint(93,notchainsuccession).
activation(93,"release a").
constraint(93,"crp").
constraint(94,alternateprecedence).
activation(94,"er triage").
constraint(94,"return er").
constraint(95,notsuccession).
activation(95,"release a").
constraint(95,"er sepsis triage").
constraint(96,notsuccession).
activation(96,"return er").
constraint(96,"iv antibiotics").
constraint(97,notchainsuccession).
activation(97,"leucocytes").
constraint(97,"iv antibiotics").
constraint(98,notchainsuccession).
activation(98,"release a").
constraint(98,"lacticacid").
constraint(99,notchainsuccession).
activation(99,"er triage").
constraint(99,"return er").
constraint(100,respondedexistence).
activation(100,"iv antibiotics").
constraint(100,"er registration").
constraint(101,notsuccession).
activation(101,"release a").
constraint(101,"iv antibiotics").
constraint(102,respondedexistence).
activation(102,"iv liquid").
constraint(102,"crp").
constraint(103,respondedexistence).
activation(103,"admission nc").
constraint(103,"leucocytes").
constraint(104,respondedexistence).
activation(104,"iv antibiotics").
constraint(104,"leucocytes").
constraint(105,notchainsuccession).
activation(105,"er registration").
constraint(105,"admission nc").
constraint(106,notsuccession).
activation(106,"admission nc").
constraint(106,"er registration").
constraint(107,notchainsuccession).
activation(107,"iv liquid").
constraint(107,"er triage").
constraint(108,notchainsuccession).
activation(108,"er sepsis triage").
constraint(108,"er registration").
constraint(109,notchainsuccession).
activation(109,"er sepsis triage").
constraint(109,"er triage").
constraint(110,notchainsuccession).
activation(110,"er triage").
constraint(110,"release a").
constraint(111,atleast1).
activation(111,"er triage").
constraint(112,respondedexistence).
activation(112,"crp").
constraint(112,"er sepsis triage").
constraint(113,alternateprecedence).
activation(113,"er triage").
constraint(113,"release a").
constraint(114,atmost2).
activation(114,"er triage").
constraint(115,respondedexistence).
activation(115,"er triage").
constraint(115,"crp").
constraint(116,notchainsuccession).
activation(116,"crp").
constraint(116,"er sepsis triage").
constraint(117,atmost1).
activation(117,"iv liquid").
constraint(118,notchainsuccession).
activation(118,"er registration").
constraint(118,"leucocytes").
constraint(119,alternateprecedence).
activation(119,"admission nc").
constraint(119,"release a").
constraint(120,respondedexistence).
activation(120,"leucocytes").
constraint(120,"crp").
constraint(121,notchainsuccession).
activation(121,"er registration").
constraint(121,"lacticacid").
constraint(122,respondedexistence).
activation(122,"er registration").
constraint(122,"leucocytes").
constraint(123,atmost1).
activation(123,"er registration").
constraint(124,notchainsuccession).
activation(124,"lacticacid").
constraint(124,"release a").
constraint(125,respondedexistence).
activation(125,"iv antibiotics").
constraint(125,"crp").
constraint(126,notsuccession).
activation(126,"return er").
constraint(126,"er triage").
constraint(127,notchainsuccession).
activation(127,"er triage").
constraint(127,"iv antibiotics").
constraint(128,notchainsuccession).
activation(128,"er sepsis triage").
constraint(128,"admission nc").
constraint(129,notsuccession).
activation(129,"return er").
constraint(129,"crp").
constraint(130,alternateprecedence).
activation(130,"er sepsis triage").
constraint(130,"iv antibiotics").
constraint(131,notchainsuccession).
activation(131,"iv liquid").
constraint(131,"crp").
constraint(132,notchainsuccession).
activation(132,"leucocytes").
constraint(132,"return er").
constraint(133,notsuccession).
activation(133,"return er").
constraint(133,"er sepsis triage").
constraint(134,notchainsuccession).
activation(134,"iv antibiotics").
constraint(134,"crp").
constraint(135,notchainsuccession).
activation(135,"leucocytes").
constraint(135,"er sepsis triage").
constraint(136,respondedexistence).
activation(136,"crp").
constraint(136,"er triage").
constraint(137,atleast1).
activation(137,"er sepsis triage").
constraint(138,atmost3).
activation(138,"admission nc").
constraint(139,notchainsuccession).
activation(139,"iv liquid").
constraint(139,"er sepsis triage").
constraint(140,atleast1).
activation(140,"crp").
constraint(141,notchainsuccession).
activation(141,"iv liquid").
constraint(141,"return er").
constraint(142,respondedexistence).
activation(142,"er sepsis triage").
constraint(142,"er triage").
constraint(143,respondedexistence).
activation(143,"leucocytes").
constraint(143,"er sepsis triage").
constraint(144,notchainsuccession).
activation(144,"crp").
constraint(144,"er triage").
constraint(145,alternateprecedence).
activation(145,"leucocytes").
constraint(145,"return er").
constraint(146,notchainsuccession).
activation(146,"er triage").
constraint(146,"iv liquid").
constraint(147,notchainsuccession).
activation(147,"iv antibiotics").
constraint(147,"return er").
constraint(148,notchainsuccession).
activation(148,"er triage").
constraint(148,"admission nc").
