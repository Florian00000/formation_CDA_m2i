## énoncé

EvenementID, TypeEvenement, Date, Lieu, ParticipantID, NomParticipant, EmailParticipant  
E01, Conférence, 2021-09-15, Centre des Congrès, P01, Jean Dupont, jean.dupont@email.com  
E02, Séminaire, 2021-09-20, Hôtel de Ville, P02, Marie Curie, marie.curie@email.com  
E02, Séminaire, 2021-09-20, Hôtel de Ville, P03, Albert Einstein, albert.einstein@email.com  
E01, Conférence, 2021-09-15, Centre des Congrès, P04, Isaac Newton, isaac.newton@email.com

## exercice

| EvenementID | TypeEvenement | 
|:-:|-|
|E01| Conférence|
|E02| Séminaire| 

|ParticipantID | NomParticipant | EmailParticipant|
|:-:|-|-|
|P01| Jean Dupont| jean.dupont@email.com|
|P02| Marie Curie| marie.curie@email.com|
|P03| Albert Einstein| albert.einstein@email.com|
|P04| Isaac Newton| isaac.newton@email.com|

| EvenementID | ParticipantID |
|:-:|:-:|
|E01|P01|
|E02|P02|
|E02|P03|
|E01|P04|

| EvenementID | Lieu | Date | 
|:-:|:-:|:-:|
|E01|Centre des Congrès|  2021-09-15| 
|E02|Hôtel de Ville| 2021-09-20| 