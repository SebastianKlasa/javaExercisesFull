
CREATE TABLE SEKTORY (
    nazwa CHAR CHECK(nazwa BETWEEN 'A' AND 'Z') PRIMARY KEY,
    ilosc_cel INT CHECK(ilosc_cel BETWEEN 0 AND 1000) NOT NULL
);

CREATE TABLE CELE (
    nr INT CHECK(nr BETWEEN 0 AND 1000) PRIMARY KEY,
    ilosc_miejsc INT CHECK(ilosc_miejsc BETWEEN 0 AND 10) NOT NULL,
    powierzchnia FLOAT CHECK(powierzchnia BETWEEN 1 AND 50) NOT NULL,
    id_sektor CHAR REFERENCES SEKTORY
);


CREATE TABLE WIEZNIOWIE (
    pesel CHAR(11) PRIMARY KEY,
    imie VARCHAR(20) NOT NULL,
    nazwisko VARCHAR(20),
    data_rozpoczecia_kary DATE NOT NULL,
    data_zakonczenia_kary DATE,
    data_zwolnienia_warunkowego DATE,
    czy_zwolnic_warunkowo CHAR(3) CHECK (czy_zwolnic_warunkowo IN ('tak', 'nie')),
    akta TEXT,
    uwagi TEXT,
    id_cela INT REFERENCES CELE 
);

CREATE TABLE KARY (
    ID INT AUTO_INCREMENT PRIMARY KEY,  
    data_rozpoczecia DATETIME NOT NULL,
    data_zakonczenia DATETIME NOT NULL,
    przyczyna VARCHAR(300) NOT NULL,
    rodzaj VARCHAR(50) NOT NULL,
    miejsce VARCHAR(50) NOT NULL,
    id_wiezien CHAR(11) REFERENCES WIEZNIOWIE ON DELETE CASCADE
);

CREATE TABLE STRAZNICY (
    pesel CHAR(11) PRIMARY KEY,
    imie VARCHAR(20) NOT NULL,
    nazwisko VARCHAR(20),
    nr_tel VARCHAR(9) NOT NULL,
    adres VARCHAR(50) NOT NULL,
    data_zatrudnienia DATE NOT NULL,
    data_zwolnienia DATE
);

CREATE TABLE ZMIANY (
    ID INT AUTO_INCREMENT PRIMARY KEY,  
    data DATE NOT NULL,
    godzina_rozpoczecia TIME NOT NULL,
    godzina_zakonczenia TIME NOT NULL,
    id_straznik CHAR(11) REFERENCES STRAZNICY,
    id_sektor CHAR REFERENCES SEKTORY
);

CREATE TABLE PRZEPUSTKI (
    ID INT AUTO_INCREMENT PRIMARY KEY,  
    data_rozpoczecia DATETIME NOT NULL,
    data_zakonczenia DATETIME NOT NULL,
    powod VARCHAR(50) NOT NULL,
    id_wiezien CHAR(11) REFERENCES WIEZNIOWIE ON DELETE CASCADE
);

CREATE TABLE PRACE (
    ID INT PRIMARY KEY,  
    rodzaj VARCHAR(50) NOT NULL,
    dzien_tygodnia VARCHAR(12) CHECK (dzien_tygodnia IN ('poniedzialek','wtorek','sroda','czwartek','piatek','sobota','niedziela')) NOT NULL,
    godzina_rozpoczecia TIME NOT NULL,
    godzina_zakonczenia TIME NOT NULL
);

CREATE TABLE ODWIEDZAJACY (
    pesel CHAR(11) PRIMARY KEY,
    imie VARCHAR(20) NOT NULL,
    nazwisko VARCHAR(20),
    nr_tel VARCHAR(11) NOT NULL,
    adres VARCHAR(50) NOT NULL,
    inne_uwagi VARCHAR(100)
);

CREATE TABLE ODWIEDZINY (
    ID INT PRIMARY KEY,  
    data DATE NOT NULL,
    godzina_rozpoczecia TIME NOT NULL,
    godzina_zakonczenia TIME NOT NULL,
    id_wiezien CHAR(11) REFERENCES WIEZNIOWIE ON DELETE CASCADE
);

CREATE TABLE ODWIEDZA_ODWIEDZI (
    id_odwiedzajacy CHAR(11) REFERENCES ODWIEDZAJACY,
    id_odwiedziny INT REFERENCES ODWIEDZINY ON DELETE CASCADE,
    PRIMARY KEY (id_odwiedzajacy, id_odwiedziny)
);

CREATE TABLE PRACE_WIEZ (
    id_wiezien CHAR(11) REFERENCES WIEZNIOWIE ON DELETE CASCADE,
    id_praca INT REFERENCES PRACE,
    PRIMARY KEY (id_wiezien, id_praca)
);

ALTER TABLE STRAZNICY
    ADD poprzednie_stanowisko VARCHAR(50);