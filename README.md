Proiect BD Popescu Razvan.
Am pus in cod si versiunea de apel al procedurii stocate de pe serverul lefti, insa nu am reusit sa o fac sa functioneze, deoarece nu am reusit sa integrez jdbc-ul in proiectul de android. Liniile sunt comentate pentru ca programul sa poata fi rulat.
In continuare am incarcat codul pentru crearea procedurii stocate de pe server.
Am incarcat codul de mai jos si pe campus impreuna cu linkul catre acest repo.
USE starwars
DROP PROCEDURE IF EXISTS insertStarship
DELIMITER $$
CREATE PROCEDURE insertStarship(
IN people VARCHAR(45),
IN starship VARCHAR(45),
IN starship_passenger VARCHAR(45))
BEGIN
# se declara variabile locale pentru identificatorii studentului
# idStudent, respectiv facultatii la care studentul este inscris
# idFacultate
DECLARE idS INT DEFAULT NULL;
DECLARE idP INT DEFAULT NULL;
INSERT INTO starship(starship_name, starship_passengers)
VALUES (starship,starship_passengers);
SELECT LAST_INSERT_ID() INTO idS;
SELECT peropleID INTO idP
FROM people
WHERE people_name = people;
# daca studentul nu a fost introdus in tabelul studenti
# sau facultate precizata ca parametru nu exista va fi afisat
# mesajul ‘Error’
# in caz contrar studentul este inscris la facultatea precizata si
# se obtine numarul de cursuri alocate (in urma declansarii TRIGGER)
IF idS IS NOT NULL AND idF IS NOT NULL THEN
INSERT INTO people_starship(peopleID, starshipID)
VALUES(idP, idS);
ELSE
SELECT 'Error';
END IF;
