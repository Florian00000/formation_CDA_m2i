<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_SINON" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2etat="inactif" F2lignes="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalAffichages="1000" nbDecimales="8" epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2" arrondiAuto="vrai" maxBoucle="500000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#A" algoitem="A EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#B" algoitem="B EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Entrez un entier#0" algoitem="AFFICHER &quot;Entrez un entier&quot;"/>
        <item code="2#A#pasliste" algoitem="LIRE A"/>
        <item code="5#B#A%3#pasliste" algoitem="B PREND_LA_VALEUR A%3"/>
        <item code="6#B == 0" algoitem="SI (B == 0) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="3#A#0#pasliste" algoitem="AFFICHER A"/>
            <item code="4# est divisible par 3#0" algoitem="AFFICHER &quot; est divisible par 3&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="3#A#0#pasliste" algoitem="AFFICHER A"/>
                <item code="4# n'est pas divisible par 3#0" algoitem="AFFICHER &quot; n'est pas divisible par 3&quot;"/>
                <item code="11#finsinon" algoitem="FIN_SINON"/>
            </item>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
