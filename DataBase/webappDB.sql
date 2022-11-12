
DROP TABLE IF EXISTS `actor_movie`;
CREATE TABLE `actor_movie` (
  `idactor` int NOT NULL,
  `idmovie` int NOT NULL,
  `idcharacter` int NOT NULL,
  PRIMARY KEY (`idactor`,`idmovie`,`idcharacter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `actor_movie` WRITE;
INSERT INTO `actor_movie` VALUES (1,1,1),(2,1,2),(3,2,25),(4,2,3),(5,3,4),(6,1,15),(6,8,14),(7,4,5),(8,4,6),(9,5,7),(10,5,8),(11,6,9),(12,6,10),(13,7,11),(14,7,12),(14,12,24),(15,8,13),(16,9,16),(17,9,17),(19,11,20),(19,12,19),(20,11,21),(21,12,22),(22,12,23);
UNLOCK TABLES;


DROP TABLE IF EXISTS `actors`;
CREATE TABLE `actors` (
  `idActors` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `dateOfBirth` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `info` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`idActors`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `actors` WRITE;
INSERT INTO `actors` VALUES (1,'Christian','Bale','30.01.1974','Britanac','../assets/img/actor/1.jpg','Christian Charles Philip Bale britanski je glumac rođen u Walesu, najpoznatiji po filmovima Carstvo sunca, Prestiž, Američki psiho, Equilibrium, Batman: Početak, Vitez tame te Boksač, za kojeg je nagrađen Oscarom za najboljeg sporednog glumca'),(2,'Heath','Ledger','04.04.1979','Australac','../assets/img/actor/2.jpg','Heath Andrew Ledger bio je australski glumac. Glumio je u brojnim filmovima, hvaljenim kako od kritike, tako i od publike, uključujući Planinu Brokeback, Monster\'s Ball i Nema me, a prije smrti dovršio je i snimanje uloge ikoničnog negativca Jokera u filmu o Batmanu, Vitez tame.'),(3,'Joaquin','Phoenix','28.10.1974','Amerikanac','../assets/img/actor/3.jpg','Počeo je glumiti još kao dijete. Pokazao je sposobnost portretiranja međusobno vrlo različitih likova. Godine 1986., s dvanaest godina, dobio je ulogu u filmu Spacecamp, a 1987. je glumio u Russkies uz svoju sestru Summer i Carole King. '),(4,'Robert','De Niro','17.08.1943','Amerikanac','../assets/img/actor/4.jpg','Robert De Niro, američki filmski glumac, redatelj i producent, dvostruki dobitnik Oscara i Zlatnog globusa. Jedan od najvećih američkih karakternih glumaca, najpoznatiji po dugoj suradnji s redateljem Martinom Scorseseom i ranim radom s redateljem Brianom De Palmom.'),(5,'Henry','Cavill','05.05.1983','Englez','../assets/img/actor/5.jpg','Henry William Dalgliesh Cavill engleski je glumac. Poznat je po portretiranju Charlesa Brandona u Showtimeu The Tudors, lika DC Comicsa Supermana u DC Extended Universe, Geralta iz Rivije u Netflixovoj fantastičnoj seriji The Witcher, kao i Sherlocka Holmesa'),(6,'Joseph','Gordon-Levitt','17.02.1981','Amerikanac','../assets/img/actor/6.jpg','oseph Leonard Gordon-Levitt američki je glumac, filmaš, pjevač i poduzetnik. Dobio je razna priznanja, uključujući nominacije za nagradu Zlatni globus za najboljeg glumca - mjuzikl ili komediju za vodeće izvedbe u 500 dana ljeta'),(7,'Morgan ','Freeman','01.06.1937','Amerikanac','../assets/img/actor/7.jpg','Morgan Freeman je američki filmski glumac i redatelj. Postao je poznat u devedesetima nakon što je nastupio u seriji uspješnih holivudskih filmova.'),(8,'Tim ','Robbins','16.10.1958','Amerikanac','../assets/img/actor/8.jpg','Timothy Francis Robbins je američki glumac, scenarist, redatelj, producent, aktivist i povremeni glazbenik. Dobitnik je Oscara za najboljeg sporednog glumca 2003., za ulogu u filmu Clinta Eastwooda, Mistična rijeka.'),(9,'Al ','Pacino','25.04.1940','Amerikanac','../assets/img/actor/9.jpg','Alfredo James \"Al\" Pacino, proslavljeni je američki filmski i kazališni glumac, dobitnik nagrada Oscar, Emmy i Tony. Oscara za najbolju mušku ulogu dobio je 1992. godine za ulogu u filmu Miris žene.'),(10,'Marlon ','Brando','03.04.1924','Amerikanac','../assets/img/actor/10.jpg','Marlon Brando, američki glumac, dvostruki dobitnik Oscara i jedan od najutjecajnijih glumaca dvadesetog stoljeća.'),(11,'Elijah ','Wood','28.01.1981','Amerikanac','../assets/img/actor/11.jpg','Elijah Jordan Wood, američki filmski i televizijski glumac i filmski producent. Stariji je brat američke glumice Hannah Wood. Glumačku je karijeru započeo u djetinjstvu, ulogama u filmovima Radio Flyer, The Good Son, North i Flipper. '),(12,'Ian ','McKellen','25.05.1939','Englez','../assets/img/actor/12.jpg','Sir Ian Murray McKellen CH CBE (rođen 25. svibnja 1939.) engleski je glumac čija karijera traje šest desetljeća. Nastupao je u žanrovima od Shakespearea i modernog kazališta do popularne fantazije i znanstvene fantastike.'),(13,'John ','Travolta','18.02.1954','Amerikanac','../assets/img/actor/13.jpg','John Travolta se proslavio ulogom nadobudnog tinejdžera Vinnie Barborina u američkom sitcomu \"Welcome back, Kotter\" iz 1975. godine, ali tek pravu slavu stekao je samo dvije godine poslije, u filmu Groznica subotnje večeri, zbog čije je glavne uloge zaradio prvu nominaciju za Oscara.'),(14,'Samuel ','L. Jackson','21.12.1984','Amerikanac','../assets/img/actor/14.jpg','Samuel Leroy Jackson, američki glumac. Jackson je postao slavan početkom devedesetih nakon niza zapaženih izvedbi, nakon čega je postao velika filmska zvijezda i kulturna ikona'),(15,'Leonardo ','DiCaprio','11.11.1974','Amerikanac','../assets/img/actor/15.jpg','Leonardo Wilhelm DiCaprio, američki glumac. DiCaprio je ulogom Jacka Dawsona u Titanicu 1997. stekao svjetsku slavu. Posljednjih godina se pojavio u filmovima Martina Scorsesea Bande New Yorka, Avijatičar i Pokojni'),(16,'Keanu ','Reeves','02.09.1964','Kanađanin','../assets/img/actor/16.jpg','Keanu Charles Reeves je kanadski filmski glumac, producent, redatelj, glazbenik i poduzetnik. Njegove su najpoznatije uloge u filmovima: Bill & Ted\'s Excellent Adventure, Brzina, Pakleni val i trilogiji The Matrix.'),(17,'Carrie-Anne','Moss','21.0\'8.1967','Kanađanka','../assets/img/actor/17.jpg','Carrie-Anne Moss je kanadska glumica. Nakon ranih uloga na televiziji, postala je međunarodno istaknuta zbog uloge Trinity u seriji The Matrix.'),(18,'Cho','Yeo-jeong','10.02.1981','JuznoKorejka','../assets/img/actor/18.jpg','Cho Yeo-jeong je južnokorejska glumica. Međunarodno je najpoznatija po ulozi u filmu Parazit koji je osvojio četiri nagrade Oskar i postao prvi film na engleskom jeziku koji je osvojio nagradu za najbolji film'),(19,'Natalie ','Portman','09.10.1981','Amerikanka','../assets/img/actor/19.jpg','Natalie Portman je rođena 1981. u Jeruzalemu. Njezina je obitelj preselila 1984. u Maryland, kratko nakon toga u Washington te krajem 1987. u New Haven, Connecticut. Godine 1990. seli se s obitelji konačno u Syosset, New York'),(20,'Jean ','Reno','30.11.1948','Spanjolac','../assets/img/actor/20.jpg','Jean Reno (rođen u Casablanci 30. srpnja 1948. kao Juan Moreno y Herrera-Jiménez) francuski je filmski glumac španjolskog podrijetla. Glumio je u brojnim francuskim i međunarodnim produkcijama.'),(21,'Robert ','Downey Jr.','04.04.1965','Amerikanac','../assets/img/actor/21.jpg','Robert Downey mlađi američki je glumac i glazbenik. Sin je Roberta Downeya, nezavisnog filmaša i glumca. Downey mlađi je jednako poznat po svojim filmskim i TV ulogama kao i po uživanju narkotika i problemima sa zakonom.'),(22,'Chris','Hemsworth','11.08.1983','Australac','../assets/img/actor/22.jpg','Christopher Hemsworth australski je glumac. Prvo se istaknuo u Australiji glumeći Kim Hyde u australskoj televizijskoj seriji Kući i daleko, prije nego što je započeo filmsku karijeru u Hollywoodu');
UNLOCK TABLES;



DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `authority` WRITE;
INSERT INTO `authority` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
UNLOCK TABLES;


DROP TABLE IF EXISTS `characters`;
CREATE TABLE `characters` (
  `idCharacter` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `info` varchar(999) DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  PRIMARY KEY (`idCharacter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



LOCK TABLES `characters` WRITE;
INSERT INTO `characters` VALUES (1,'Batman','Batman je izmišljeni lik, stripovski junak izdavačke kuće DC Comics, kojeg su stvorili crtač Bob Kane i pisac Bill Finger. Prvi put se pojavio 1939. godine u stripu Detective Comics #27. Poznat je još kao \"Vitez tame\", \"Maskirani križar\" i \"Najveći svjetski detektiv\". U Hrvatskoj je Batman mnogo popularniji u filmskim utjelovljenjima, nego u stripu.',NULL),(2,'Joker','Joker je izmišljeni lik, zlikovac koji se pojavljuje u stripovima izdavačke kuće DC Comics. Lik su stvorili Jerry Robinson, Bill Finger i Bob Kane, a prvi put se pojavio 1940. godine u stripu Batman #1. Kao praneprijatelj superjunaka Batmana, Joker se pojavljivao u raznim stripovima, filmovima, TV serijama, igricama i proizvodima.',NULL),(3,'Murray Franklin','-',NULL),(4,'Superman','Superman (nadčovjek) je fiktivni, stripovski superjunak, općenito smatran jednim od najpoznatijih i najpopularnijih likova, te američka kulturna ikona. Stvorili su ga američki pisac Jerry Siegel i kanadski umjetnik Joe Shuster 1932. godine, kada su obojica živjela u Clevelandu, u saveznoj državi Ohio. Prava na strip su prodali izdavačkoj kući Detective Comics 1938. godine.',NULL),(5,'	Andy Dufresne','-',NULL),(6,'Ellis Boyd \'Red\' Redding','-',NULL),(7,'Don Vito Corleone','-',NULL),(8,'Michael Corleone','-',NULL),(9,'Frodo','-',NULL),(10,'Gandalf','-',NULL),(11,'Vincent Vega','-',NULL),(12,'Jules Winnfield','-',NULL),(13,'Cobb','-',NULL),(14,'Arthur','-',NULL),(15,'Officer','-',NULL),(16,'Neo','-',NULL),(17,'Trinity','-',NULL),(18,'Cho','-',NULL),(19,'Jane Foster','-',NULL),(20,'Mathilda','-',NULL),(21,'Leon','-',NULL),(22,'Thor','-',NULL),(23,'IronMan','Iron Man je izmišljeni lik, superjunak koji se pojavljuje u stripovima izdavačke kuće Marvel Comics. Stvorio ga je pisac i izdavač Stan Lee, a razvili su ga scenarist Larry Lieber te crtači Jack Kirby i Don Heck. Prvi put se pojavio u stripu Tales of Suspense #39 u ožujku 1963. godine.',NULL),(24,'Nick Fury','-',NULL),(25,'Joker','-',NULL);
UNLOCK TABLES;


DROP TABLE IF EXISTS `directors`;
CREATE TABLE `directors` (
  `idDirector` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `dateOfBirth` varchar(45) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDirector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `directors` WRITE;
INSERT INTO `directors` VALUES (1,'Christoper','Nolan','30.07.1970','../assets/img/director/1.jpg'),(2,'Todd ','Phillips','20.12.1970','../assets/img/director/2.jpg'),(3,'Zack ','Synder','01.03.1966','../assets/img/director/3.jpg'),(4,'Frank ','Darabont ','28.01.1959','../assets/img/director/4.jpg'),(5,'Francis ','Ford Coppola','07.04.1939','../assets/img/director/5.jpg'),(6,'Peter','Jackson','31.10.1961','../assets/img/director/6.jpg'),(7,'Quentin','Tarantino','27.03.1963','../assets/img/director/7.jpg'),(8,'Lana ','Wachowski','21.06.1965','../assets/img/director/8.jpg'),(9,'Bong ',' Joon Ho','14.09.1969','../assets/img/director/9.jpg'),(10,'Luc ','Besson ','18.03.1959','../assets/img/director/10.jpg'),(11,'Anthony ','Russo','03.03.1970','../assets/img/director/11.jpg');
UNLOCK TABLES;


DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
  `idgenre` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idgenre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



LOCK TABLES `genre` WRITE;
INSERT INTO `genre` VALUES (1,' Action','Action film is a film genre in which the protagonist or protagonists are thrust into a series of events that typically include violence, extended fighting, physical feats, rescues and frantic chases.');
UNLOCK TABLES;


DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `idMovie` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `releaseyear` varchar(55) DEFAULT NULL,
  `synopsis` varchar(999) DEFAULT NULL,
  `trailerUrl` varchar(255) DEFAULT NULL,
  `durationMin` int DEFAULT NULL,
  `directorId` int NOT NULL,
  `rated` varchar(45) DEFAULT NULL,
  `image` varchar(455) DEFAULT NULL,
  `idgenre` int DEFAULT NULL,
  `moviestudioid` int DEFAULT NULL,
  PRIMARY KEY (`idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



LOCK TABLES `movie` WRITE;
INSERT INTO `movie` VALUES (1,'The Dark Knight','2008','Vitez tame film je Christophera Nolana iz 2008. o liku Batmana iz stripova DC Comicsa, odnosno drugi dio Nolanova filmskog serijala o Batmanu i nastavak filma Batman: Početak. Christian Bale reprizira glavnu ulogu.','https://www.youtube.com/embed/EXeTwQWrcwY',152,1,'PG-13','../assets/img/movie/1.jpg',1,1),(2,'Joker','2019','Joker je američki psihološki triler iz 2019.godine od redatelja Todd Phillipsa, koji je zajedno sa Scottom Silverom napisao scenarij. Film temeljen na DC Comics likovima, stavlja Joaquina Phoenixa u ulogu Jokera i predstavlja moguću priču o podrijetlu lika.','https://www.youtube.com/embed/zAGVQLHvwOY',122,2,'R','../assets/img/movie/2.jpg',NULL,1),(3,'Man Of Steel','2013','Čovjek od čelika (eng. Man of Steel) je američki film iz 2013. godine temeljen na liku iz stripa izdavačke kuće DC Comics Supermanu kojeg su koproducirale kompanije Legendary Pictures i Syncopy Films, a kojeg je u svjetskim kinima distribuirala kompanija Warner Bros. To je ujedno i prvi film u seriji filmova o superjunacima koji se originalno pojavljuju u stripovima izdavačke kuće DC Comics, a čije će se priče međusobno ispreplitati.','https://www.youtube.com/embed/T6DJcgm3wNY',143,3,'PG-13','../assets/img/movie/3.jpg',NULL,1),(4,'The Shawshank Redemption','1994','Iskupljenje u Shawshanku je zatvorska drama redatelja i scenarista Franka Darabonta iz 1994. s Timom Robbinsom i Morganom Freemanom u glavnim ulogama. Film je nastao kao adaptacija romana Stephena Kinga, Rita Hayworth i iskupljenje u Shawshanku.','https://www.youtube.com/embed/6hB3S9bIaco',142,4,'R','../assets/img/movie/4.jpg',NULL,2),(5,'The Godfather','1972','Kum je kriminalistička drama Francisa Forda Coppole temeljena na istoimenom romanu Maria Puza. U glavnim ulogama pojavljuju se Marlon Brando, Al Pacino, Robert Duvall, Diane Keaton i James Caan. Radnja filma proteže se na deset godina od kraja 1945. do 1955. te predstavlja kronologiju mafijaške obitelji Corleone','https://www.youtube.com/embed/sY1S34973zA',175,5,'R','../assets/img/movie/5.jpg',NULL,3),(6,'The Lord of the Rings: The Return of the King','2003','Kako Sauron započinje posljednju fazu pokoravanja Međuzemlja, čarobnjak Gandalf i Kralj Theoden od Rohana udružuju snage kako bi zaštitili glavni grad Gondora, Minas Tirith od ove prijetnje. Aragorn konačno mora preuzeti kraljevski tron Gondora pa okuplja vojsku duhova kako bi porazio Saurona. Na kraju, iako pod punom spremom, shvaćaju da ne mogu pobijediti; sve spada na hobite Froda i Sama koji se sami moraju suočiti s težinom Prstena i Gollumovom izdajom, kako bi uništili Prsten u Mordoru.','https://www.youtube.com/embed/JB7fjEtzrsk',201,6,'PG-13','../assets/img/movie/6.jpg',NULL,4),(7,'Pulp Fiction','1994','Pakleni šund američki je film Quentina Tarantina iz 1994. godine koji je napisao scenarij zajedno s Rogerom Avaryjem. Poznat je po nelinearnoj radnji, eklektičnim dijalozima te ironičnoj mješavini humora i nasilja ispunjenoj citatima odnosno parafrazama poznatih filmova i popularne kulture.','https://www.youtube.com/embed/s7EdQ4FqbhY',154,7,'R','../assets/img/movie/7.jpg',NULL,5),(8,'Inception','2010','Početak (eng. Inception) je britansko-američki znanstveno-fantastični film iz 2010. godine s elementima misterije,akcije i trilera. Napisao ga je, ko-producirao i režirao Christopher Nolan. U filmu su glavne uloge ostvarili Leonardo DiCaprio, Ken Watanabe, Joseph Gordon-Levitt, Marion Cotillard, Ellen Page, Tom Hardy, Dileep Rao, Cillian Murphy, Tom Berenger i Michael Caine. DiCaprio tumači ulogu Dominicka Cobba, lopova koji obavlja poslove industrijske špijunaže koristeći eksperimentalnu vojnu tehnologiju koja mu omogućava ulazak u podsvijest svojih meta. Nakon što mu je ponuđena prilika da se vrati svom starom životu on pristaje na naizgled nemogući zadatak: \"usađivanje\", umetanje tuđe ideje u podsvijest svoje mete.','https://www.youtube.com/embed/YoHD9XEInc0',148,1,'PG-13','../assets/img/movie/8.jpg',NULL,1),(9,'The Matrix','1999','Matrix je znanstvenofantastični film iz 1999. godine koji su napisali i režirali Lana i Andy Wachowski. U filmu nastupaju Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Joe Pantoliano i Hugo Weaving, te se počeo prikazivati u SAD-u 31. ožujka 1999.g.','https://www.youtube.com/embed/vKQi3bBA1y8',136,8,'R','../assets/img/movie/9.jpg',NULL,1),(11,'Léon: The Professional','1994','Léon: The Professional, naslovljen Leon u Velikoj Britaniji i Australiji, francuski je akcijski triler na engleskom jeziku iz 1994. godine koji je napisao i režirao Luc Besson. U njemu glume Jean Reno, Gary Oldman i Natalie Portman','https://www.youtube.com/embed/aNQqoExfQsg',111,10,'R','../assets/img/movie/11.jpg',NULL,7),(12,'Avengers: Endgame','2019','Avengers: Endgame je američki film o superherojima iz 2019. godine baziran na superherojskom timu Marvel Comics Avengersa. U produkciji Marvel Studios, a u distribuciji Walt Disney Studios Motion Pictures, izravni je nastavak filma Avengers: Infinity War i 22. filma u Marvel Cinematic Universeu.','https://www.youtube.com/embed/TcMBFSGVi1c',181,11,'PG-13','../assets/img/movie/12.jpg',NULL,8),(13,'Mortal Kombat','23 Apr 2021','MMA fighter Cole Young seeks out Earth\'s greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.','https://www.youtube.com/embed/kAJXFRshQfw',110,3,'R','https://m.media-amazon.com/images/M/MV5BY2ZlNWIxODMtN2YwZi00ZjNmLWIyN2UtZTFkYmZkNDQyNTAyXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_SX300.jpg',NULL,2),(14,'Love and Monsters','16 Oct 2020','Seven years after he survived the monster apocalypse, lovably hapless Joel leaves his cozy underground bunker behind on a quest to reunite with his ex.','https://www.youtube.com/embed/kAJXFRshQfw',109,3,'PG-13','https://m.media-amazon.com/images/M/MV5BYWVkMWEyMDUtZTVmOC00MTYxLWE1ZTUtNjk4M2IzMjY2OTIxXkEyXkFqcGdeQXVyMDk5Mzc5MQ@@._V1_SX300.jpg',NULL,2),(15,'Godzilla vs. Kong','31 Mar 2021','The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.','https://www.youtube.com/embed/kAJXFRshQfw',113,3,'PG-13','https://m.media-amazon.com/images/M/MV5BZmYzMzU4NjctNDI0Mi00MGExLWI3ZDQtYzQzYThmYzc2ZmNjXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_SX300.jpg',NULL,2),(16,'Justice League','17 Nov 2017','Justice League (sh. Liga pravde) je američki science fiction film snimljen 2017. godine u režiji Zacka Snydera. Predstavlja adaptaciju istoimenog stripa u izdanju DC Comics, peti film iz ciklusa o superherojima DC Extended Universe i neposredni nastavak filma Batman v Superman: Dawn of Justice.','https://www.youtube.com/embed/kAJXFRshQfw',120,3,'PG-13','../assets/img/movie/14.jpg',NULL,1);
UNLOCK TABLES;


DROP TABLE IF EXISTS `movie_studio`;
CREATE TABLE `movie_studio` (
  `idMovie_studio` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMovie_studio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `movie_studio` WRITE;
INSERT INTO `movie_studio` VALUES (1,'Warner Bros. Pictures Legendary Pictures DC Comics','../assets/img/studio/1.jpg'),(2,'Castle Rock Entertainment','../assets/img/studio/2.jpg'),(3,'Paramount Pictures Alfran Productions','../assets/img/studio/3.jpg'),(4,'New Line Cinema WingNut Films','../assets/img/studio/4.jpg'),(5,'A Band Apart Jersey Films','../assets/img/studio/5.jpg'),(6,'CJ Entertainment','../assets/img/studio/6.jpg'),(7,'	Gaumont Buena Vista International','../assets/img/studio/7.jpg'),(8,'Walt Disney Studios Motion Pictures','../assets/img/studio/8.jpg');
UNLOCK TABLES;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `idRole` int NOT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



LOCK TABLES `role` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(250) NOT NULL,
  `first_name` varchar(250) NOT NULL,
  `last_name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;




DROP TABLE IF EXISTS `user_authority`;

CREATE TABLE `user_authority` (
  `user_id` bigint NOT NULL,
  `authority_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





DROP TABLE IF EXISTS `user_rating`;
CREATE TABLE `user_rating` (
  `idRating` int NOT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  `idUser` int DEFAULT NULL,
  PRIMARY KEY (`idRating`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



LOCK TABLES `user_rating` WRITE;

INSERT INTO `user_rating` VALUES (1,'Ekstremno zabavan film.',7,1,1),(2,'Veoma zanimljivo.',8,1,1),(3,'Zabavan i poucan film.',10,1,1),(4,'Jako dobro rezisirano, odlicni efekti.',9,2,2),(5,'Dobar',8,2,2),(6,'Moglo je i bolje',5,2,2),(7,'Losa razrada likova',6,2,2),(8,'Izvrsno odglumljeno od strane Pheonixa',8,2,1),(9,'Odlican',10,5,1),(10,'Predugo traje',9,5,1),(11,'Odlican',9,5,1),(12,'kul je',9,1,4),(13,'Dobar film.',9,1,2),(14,'asdasd',9,1,2),(15,'asdasd',8,3,7),(16,'dozivljaj',6,1,2),(17,NULL,9,16,1),(18,NULL,9,7,1),(19,'Izvrsno odglumljeno od strane Pheonixa',8,2,8),(20,'Izvrsno odglumljeno od strane Morgana Freemana',9,4,8),(21,'asd',2,1,1),(22,NULL,4,2,9),(23,'neki komentar',9,11,14),(24,'koemtarneki',3,5,15);

UNLOCK TABLES;
