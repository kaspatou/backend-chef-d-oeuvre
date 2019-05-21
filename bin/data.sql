INSERT INTO `bd-gestion-materiel`.categorie (id, nom) VALUES (1, 'telephone');
INSERT INTO `bd-gestion-materiel`.categorie (id, nom) VALUES (2, 'tablette');
INSERT INTO `bd-gestion-materiel`.categorie (id, nom) VALUES (3, 'PC portable');
INSERT INTO `bd-gestion-materiel`.categorie (id, nom) VALUES (4, 'routeur');
INSERT INTO `bd-gestion-materiel`.donnees_materiel (id, compte_administrateur, compte_utilisateur, mdp_administrateur, mdp_utilisateur, pin, url_configuration) VALUES (1, 'admin@laposte.fr', 'thomas.longueville.lp2@gmail.com', 'toto', 'toto', 1234, null);
INSERT INTO `bd-gestion-materiel`.donnees_materiel (id, compte_administrateur, compte_utilisateur, mdp_administrateur, mdp_utilisateur, pin, url_configuration) VALUES (2, 'admin@laposte.fr', 'thomas.longueville@laposte.fr', 'toto', 'toto', 1235, null);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (1, 1234, 'Samsung', 'Galaxy S9', 'Android', 'A231546', '6.0.2', 1, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (2, 3456, 'Samsung', 'Galaxy S7', 'Android', 'A45739', '6.0.2', 1, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (3, 3352, 'Huawei', 'P20 lite', 'Android', 'BC56487', '6.0.2', 1, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (4, 3453, 'Huawei', 'P20 pro', 'Android', 'D182934', '6.0.2', 1, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (5, 5464, 'Samsung', 'Galaxy S8', 'Android', 'A231778', '6.0.2', 1, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (6, 5461, 'Nokia', 'S321', 'Android', 'D564659', '6.0.2', 1, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (7, 1234, 'Apple', 'IPad Air', 'IOS', 'FDD2354', '5', 2, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (8, 1234, 'Apple', 'IMac', 'Mac OS X', 'FR45687', '10.12', 3, 1);
INSERT INTO `bd-gestion-materiel`.materiel (id, imei, marque, modele, os, serie, ver_os, id_categorie, id_donnees_materiel) VALUES (9, 1233, 'TRENDnet', 'TEW-731BR', '', 'DS5467', '', 4, 1);
INSERT INTO `bd-gestion-materiel`.profil (id, fonction) VALUES (1, 'admin');
INSERT INTO `bd-gestion-materiel`.profil (id, fonction) VALUES (2, 'gestionnaire');
INSERT INTO `bd-gestion-materiel`.profil (id, fonction) VALUES (3, 'emprunteur');
INSERT INTO `bd-gestion-materiel`.utilisateur (id, adresse_mail, identifiant, password, id_profil) VALUES (1, 'thomas.longueville@laposte.fr', 'thomas', 'toto', 1);
INSERT INTO `bd-gestion-materiel`.utilisateur (id, adresse_mail, identifiant, password, id_profil) VALUES (2, 'samuel.sabot@laposte.fr', 'samsabot', null, 3);
INSERT INTO `bd-gestion-materiel`.utilisateur (id, adresse_mail, identifiant, password, id_profil) VALUES (3, 'david.pouline@laposte.fr', 'davidP', null, 3);


INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (1, '2019-05-13', '2019-05-18', '2019-05-18', 1,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (2, '2019-05-13', '2019-05-16', '2019-05-16', 1,1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (3, '1972-04-27', '2018-03-29', '2018-05-01', 3,1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (4, '2018-05-30', '2018-06-24', '2018-06-27', 2,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (5, '2018-04-25', '2018-04-29', '2018-05-30', 1,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (6, '2018-04-25', '2018-04-29', '2018-05-30', 2,4);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (7, '2018-04-25', '2018-04-29', '2018-05-30', 1,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (8, '2018-04-25', '2018-04-29', '2018-05-30', 3,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (9, '2018-04-25', '2018-04-29', '2018-05-30', 1,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (10, '2018-04-25', '2018-04-29', '2018-05-30', 2,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (11, '2018-04-25', '2018-04-29', '2018-05-30', 3,2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur,id_materiel) VALUES (12, '2018-04-25', '2018-04-30', '2018-05-30', 2,2);





/*
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (1, '2019-05-13', '2019-05-18', '2019-05-18', 1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (2, '2019-05-13', '2019-05-16', '2019-05-16', 1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (3, '1972-04-27', '2018-03-29', '2018-05-01', 3);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (4, '2018-05-30', '2018-06-24', '2018-06-27', 2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (5, '2018-04-25', '2018-04-29', '2018-05-30', 1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (6, '2018-04-25', '2018-04-29', '2018-05-30', 2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (7, '2018-04-25', '2018-04-29', '2018-05-30', 1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (8, '2018-04-25', '2018-04-29', '2018-05-30', 3);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (9, '2018-04-25', '2018-04-29', '2018-05-30', 1);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (10, '2018-04-25', '2018-04-29', '2018-05-30', 2);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (11, '2018-04-25', '2018-04-29', '2018-05-30', 3);
INSERT INTO `bd-gestion-materiel`.prets (id, debut, fin_prevue, fin_reelle, id_utilisateur) VALUES (12, '2018-04-25', '2018-04-30', '2018-05-30', 2);
*/
/*
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (1, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (2, 1);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (3, 1);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (4, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (5, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (6, 4);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (7, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (8, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (9, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (10, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (11, 2);
INSERT INTO `bd-gestion-materiel`.fournit (id_prets, id) VALUES (12, 2);
*/