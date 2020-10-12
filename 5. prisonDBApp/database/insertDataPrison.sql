INSERT INTO SEKTORY VALUES ('A',100);
INSERT INTO SEKTORY VALUES ('B',100);
INSERT INTO SEKTORY VALUES ('C',100);
INSERT INTO SEKTORY VALUES ('D',100);
INSERT INTO SEKTORY VALUES ('E',300);
INSERT INTO SEKTORY VALUES ('F',200);
INSERT INTO SEKTORY VALUES ('G',50);
INSERT INTO SEKTORY VALUES ('X',0);
INSERT INTO SEKTORY VALUES ('Y',0);
INSERT INTO SEKTORY VALUES ('Z',25);

INSERT INTO CELE VALUES (1,5,25,'A');
INSERT INTO CELE VALUES (2,6,25,'A');
INSERT INTO CELE VALUES (3,8,25,'A');
INSERT INTO CELE VALUES (4,5,25,'A');
INSERT INTO CELE VALUES (5,5,25,'B');
INSERT INTO CELE VALUES (6,5,25,'B');
INSERT INTO CELE VALUES (7,9,25,'A');
INSERT INTO CELE VALUES (8,5,25,'A');
INSERT INTO CELE VALUES (9,1,25,'Z');
INSERT INTO CELE VALUES (10,5,25,'A');
INSERT INTO CELE VALUES (11,5,25,'A');
INSERT INTO CELE VALUES (12,6,25,'A');
INSERT INTO CELE VALUES (13,8,25,'A');
INSERT INTO CELE VALUES (14,5,25,'A');
INSERT INTO CELE VALUES (15,5,25,'B');
INSERT INTO CELE VALUES (16,5,25,'B');
INSERT INTO CELE VALUES (17,9,25,'E');
INSERT INTO CELE VALUES (18,5,25,'E');
INSERT INTO CELE VALUES (19,1,25,'E');
INSERT INTO CELE VALUES (20,5,25,'E');


INSERT INTO WIEZNIOWIE VALUES( '90121200111','Jan','Kowalski','2017-01-09',
    '2018-01-09',NULL,'nie',NULL,NULL,1);
INSERT INTO WIEZNIOWIE VALUES( '56013212192','Piotr','Nowak','2000-05-19',
    '2025-05-19','2020-05-19','tak',NULL,NULL,2);
INSERT INTO WIEZNIOWIE VALUES( '76062284994','Tomasz','Mickiewicz','2013-11-13',
    '2018-11-13',NULL,'nie',NULL,'Trzymać z dala od niebezpiecznych więźniów',3);
INSERT INTO WIEZNIOWIE VALUES( '89111190234','Zbigniew','Słowacki','2017-12-13',
    '2018-06-13',NULL,'nie',NULL,NULL,1);
INSERT INTO WIEZNIOWIE VALUES( '96011206113','Andrzej','Kowalczyk','2015-02-09',
    '2019-02-09',NULL,'nie',NULL,NULL,5);
INSERT INTO WIEZNIOWIE VALUES( '78020266773','Bartosz','Bąk','1996-11-11',
    NULL,NULL,'nie',NULL,'Niebezpieczny osobnik, dożywocie, przebywa w odosobieniu',9);
INSERT INTO WIEZNIOWIE VALUES( '95111012433','Ignacy','Trzmiel','2017-05-09',
    '2022-05-09',NULL,'nie',NULL,NULL,4);
INSERT INTO WIEZNIOWIE VALUES( '55110909933','Jan','Mucha','2010-04-09',
    '2020-04-09',NULL,'nie',NULL,NULL,8);
INSERT INTO WIEZNIOWIE VALUES( '85050309435','Maciej','Maciejewski','2005-01-29',
    '2025-01-29','2020-01-29','tak',NULL,NULL,6);
INSERT INTO WIEZNIOWIE VALUES( '83070889112','Piotr','Kowalski','2017-03-15',
    '2032-03-15',NULL,'nie',NULL,'Przyłapany na ucieczce',6);

INSERT INTO KARY VALUES(1, '2017-11-12','2018-02-12','Próba ucieczki',
    'Brak możliwości opuszczenia celi','cela nr6','83070889112');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('1996-11-13','1996-12-13','Pobicie współwięźnia',
    'Zamknięcie w izolatce','cela izolatka nr 3','78020266773');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('1997-03-26','1997-04-26','Pobicie współwięźnia',
    'Zamknięcie w izolatce','cela izolatka nr 1','78020266773');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('1998-01-01','1998-02-01','Napadnięcie na strażnika',
    'Zamknięcie w izolatce','izolatka nr 3','78020266773');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('2000-07-11','2000-08-11','Wywołanie buntu',
    'Zamknięcie w izolatce','izolatka nr 8','78020266773');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('2017-08-15','2017-11-29','Przemyt',
    'Brak otrzymania paczek oraz bezpośrednich widzeń',
	'cela nr 8','55110909933');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('2017-05-15','2017-05-29','Udział w bójce',
    'Zamknięcie w izolatce','izolatka nr 2','83070889112');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('2017-05-15','2017-05-29','Przebywanie w miejscu przeznaczonego dla strażników',
    'nagana','cela','83070889112');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('2013-11-14','2013-11-17','Niezachowanie ciszy nocnej',
    'izolatka','izolatka nr 5','76062284994');
INSERT INTO KARY (data_rozpoczecia, data_zakonczenia, przyczyna, rodzaj, miejsce, id_wiezien) VALUES('2013-11-14','2013-11-17','Udział w bijatyce',
    'karne prace','Toalety','76062284994');

INSERT INTO STRAZNICY VALUES ('90122102273','Mateusz','Lewandowski',
    '543154091','Gdańsk, ul. Mickiewicza 1/12','2017-02-02',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('89010112331','Rafał','Lewendowski',
    '486092402','Gdańsk, ul. Słowackiego 43/43','2010-06-17',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('86021242513','Tomasz','Rzodkiewka',
    '906123695','Gdańsk, ul. Kilińskiego 12/54','2015-03-13',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('78122102713','Joaquine',NULL,
    '512987203','Gdynia, ul. Niemcewicza 14/4','2016-12-02',NULL,'Służby specjalne');
INSERT INTO STRAZNICY VALUES ('76093009853','Robert','Wasilewski',
    '412543095','Lębork, ul. Dokerów 23','2005-02-12',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('86021101153','Andrzej','Stolarski',
    '690145098','Wejcherowo, ul. Lipowa 65','2010-12-21',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('65060111153','Ignacy','Kołobrzeski',
    '205123404','Gdańsk, ul. Na Zaspę 14/232','2008-06-12',NULL,'Policjant');
INSERT INTO STRAZNICY VALUES ('67031290176','Tadeusz','Krawczyk',
    '165044366','Gdańsk, ul. Hynka 13/3','1999-04-30',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('67062302293','Karol','Norek',
    '743234098','Gdynia, ul. Al Rzeczpospoliej 4A/343','2017-10-02',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('55103012654','Jacek','Pomidor',
    '598098198','Gdańsk, ul. Kołobrzeska 67/8','2017-10-12',NULL,NULL);
INSERT INTO STRAZNICY VALUES ('77112386493','Arnold','Jaroszewski',
    '506789374','Rumia, ul. Pastelowa 12','2017-11-10','2017-12-03','Murarz');
INSERT INTO STRAZNICY VALUES ('54112013354','Jacek','Pomidor',
    '678012543','Gdańsk, ul. Ogrodowa 12/2','2000-10-28','2017-11-03',NULL);

INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-14','8:00','16:00','90122102273','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','8:00','16:00','90122102273','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','8:00','16:00','90122102273','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','8:00','16:00','89010112331','E');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','8:00','16:00','89010112331','E');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','8:00','16:00','89010112331','E');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','16:00','0:00','86021242513','E');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','16:00','0:00','86021242513','E');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','16:00','0:00','86021242513','E');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','16:00','0:00','78122102713','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','16:00','0:00','78122102713','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','16:00','0:00','78122102713','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','16:00','0:00','76093009853','B');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','16:00','0:00','76093009853','B');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','16:00','0:00','76093009853','B');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','8:00','16:00','86021101153','B');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','8:00','16:00','86021101153','B');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','8:00','16:00','86021101153','B');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','8:00','16:00','65060111153','C');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','8:00','16:00','65060111153','C');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','8:00','16:00','65060111153','C');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','8:00','16:00','67031290176','D');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','8:00','16:00','67031290176','D');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','8:00','16:00','67031290176','D');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','16:00','0:00','67062302293','D');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','16:00','0:00','67062302293','D');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','16:00','0:00','67062302293','D');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-15','0:00','8:00','55103012654','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-16','0:00','8:00','55103012654','A');
INSERT INTO ZMIANY (data, godzina_rozpoczecia, godzina_zakonczenia, id_straznik, id_sektor) VALUES ('2017-12-17','0:00','8:00','55103012654','A');

INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-04-02','2017-04-05','Pogrzeb ciotki','76062284994');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-05-12','2017-05-15','Chrzciny dziecka','95111012433');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-05-14','2017-05-21','Pogrzeb ojca','55110909933');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-06-21','2017-06-25','Odwiedzenie chorej matki','85050309435');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-07-06','2017-07-11','Pogrzeb babci','55110909933');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-07-15','2017-07-17','Rozwód','85050309435');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-07-17','2017-07-21','Chrzciny dziecka','76062284994');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-11-02','2017-11-06','Odwiedzenie chorego ojca','83070889112');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-11-09','2017-11-11','Odwiedzenie chorego wujka','95111012433');
INSERT INTO PRZEPUSTKI (data_rozpoczecia, data_zakonczenia, powod, id_wiezien) VALUES ('2017-12-01','2017-12-05','Odwiedzenie chorego dziadka','96011206113');

INSERT INTO PRACE VALUES (1,'Pralnia','niedziela','15:00','17:00');
INSERT INTO PRACE VALUES (2,'Pralnia','wtorek','15:00','17:00');
INSERT INTO PRACE VALUES (3,'Pralnia','piatek','10:00','13:00');
INSERT INTO PRACE VALUES (4,'Ogród','poniedzialek','10:00','17:00');
INSERT INTO PRACE VALUES (5,'Ogród','sroda','10:00','17:00');
INSERT INTO PRACE VALUES (6,'Ogród','piatek','10:00','17:00');
INSERT INTO PRACE VALUES (7,'Biblioteka','poniedzialek','11:00','18:00');
INSERT INTO PRACE VALUES (8,'Biblioteka','wtorek','11:00','18:00');
INSERT INTO PRACE VALUES (9,'Biblioteka','sroda','11:00','18:00');
INSERT INTO PRACE VALUES (10,'Biblioteka','czwartek','11:00','18:00');
INSERT INTO PRACE VALUES (11,'Biblioteka','piatek','11:00','18:00');
INSERT INTO PRACE VALUES (12,'Prace konserwatorskie','poniedzialek','8:00','18:00');
INSERT INTO PRACE VALUES (13,'Prace konserwatorskie','czwartek','8:00','18:00');
INSERT INTO PRACE VALUES (14,'Prace konserwatorskie','sobota','8:00','18:00');

INSERT INTO ODWIEDZAJACY VALUES('78010454322','Anna','Kowalska','567105981',
    'Gdańsk, ul Partyzantów 12/3',NULL);
INSERT INTO ODWIEDZAJACY VALUES('74042457512','Adam','Kowalski','532123503',
    'Gdańsk, ul Partyzantów 12/3',NULL);
INSERT INTO ODWIEDZAJACY VALUES('97112312215','Maciej','Kowalski','532123503',
    'Gdańsk, ul Partyzantów 12/3',NULL);
INSERT INTO ODWIEDZAJACY VALUES('80120993215','Bożydar','Organek','758302832',
    'Gdańsk, ul Obrońców Wybrzeża 8D/323',NULL);
INSERT INTO ODWIEDZAJACY VALUES('45111165425','Marcelina','Maciejewska','765123094',
    'Warszawa, ul Mickiewicza 17/2',NULL);
INSERT INTO ODWIEDZAJACY VALUES('85122412385','Weronika','Nieborowska','567402174',
    'Elbląg, ul Uphagena 56',NULL);
INSERT INTO ODWIEDZAJACY VALUES('93110312669','Wanda','Nowak','63021243104',
    'Gdańsk, ul Szeroka 34/24',NULL);
INSERT INTO ODWIEDZAJACY VALUES('97072314315','Rafał','Jakubiak','732123098',
    'Gdańsk, ul Słowackiego 18/12',NULL);
INSERT INTO ODWIEDZAJACY VALUES('73022313218','Maciej','Trzmiel','769156023',
    'Gdańsk, ul Północna 34',NULL);
INSERT INTO ODWIEDZAJACY VALUES('73060218988','Marianna','Trzmiel','567091127',
    'Gdańsk, ul Północna 34',NULL);

INSERT INTO ODWIEDZINY VALUES(1,'2017-05-02','8:00','9:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(2,'2017-06-12','18:00','19:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(3,'2017-07-03','9:00','10:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(4,'2017-08-01','8:00','9:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(5,'2017-10-02','18:00','19:00','56013212192');
INSERT INTO ODWIEDZINY VALUES(6,'2017-10-02','8:00','9:00','95111012433');
INSERT INTO ODWIEDZINY VALUES(7,'2017-11-03','8:00','9:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(8,'2017-11-22','18:00','19:00','95111012433');
INSERT INTO ODWIEDZINY VALUES(9,'2017-11-29','8:00','9:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(10,'2017-12-05','18:00','19:00','90121200111');
INSERT INTO ODWIEDZINY VALUES(11,'2017-12-05','8:00','9:00','95111012433');
INSERT INTO ODWIEDZINY VALUES(12,'2017-12-12','8:00','9:00','56013212192');


INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('78010454322',1);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('74042457512',1);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('97112312215',1);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('78010454322',2);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('74042457512',2);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('97112312215',3);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('74042457512',3);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('78010454322',4);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('78010454322',7);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('74042457512',7);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('97112312215',7);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('78010454322',9);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('74042457512',9);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('93110312669',5);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('73022313218',6);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('73022313218',8);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('73022313218',11);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('73060218988',11);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('80120993215',10);
INSERT INTO ODWIEDZA_ODWIEDZI VALUES ('45111165425',12);

INSERT INTO PRACE_WIEZ VALUES('90121200111',1);
INSERT INTO PRACE_WIEZ VALUES('90121200111',2);
INSERT INTO PRACE_WIEZ VALUES('56013212192',7);
INSERT INTO PRACE_WIEZ VALUES('56013212192',8);
INSERT INTO PRACE_WIEZ VALUES('56013212192',9);
INSERT INTO PRACE_WIEZ VALUES('96011206113',4);
INSERT INTO PRACE_WIEZ VALUES('96011206113',5);
INSERT INTO PRACE_WIEZ VALUES('78020266773',12);
INSERT INTO PRACE_WIEZ VALUES('78020266773',13);
INSERT INTO PRACE_WIEZ VALUES('95111012433',12);
INSERT INTO PRACE_WIEZ VALUES('95111012433',13);
INSERT INTO PRACE_WIEZ VALUES('55110909933',10);
INSERT INTO PRACE_WIEZ VALUES('85050309435',11);
INSERT INTO PRACE_WIEZ VALUES('85050309435',3);
INSERT INTO PRACE_WIEZ VALUES('83070889112',14);