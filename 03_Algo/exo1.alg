<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER B"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2etat="inactif" F2defaut="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param nbDecimales="8" epaisseurLigne="2" maxBoucle="500000" arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#A" algoitem="A EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#B" algoitem="B EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#C" algoitem="C EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#B#10#pasliste" algoitem="B PREND_LA_VALEUR 10"/>
        <item code="5#A#5#pasliste" algoitem="A PREND_LA_VALEUR 5"/>
        <item code="4#A = #0" algoitem="AFFICHER &quot;A = &quot;"/>
        <item code="3#A#1#pasliste" algoitem="AFFICHER A"/>
        <item code="4#B = #0" algoitem="AFFICHER &quot;B = &quot;"/>
        <item code="3#B#1#pasliste" algoitem="AFFICHER B"/>
        <item code="5#C#A#pasliste" algoitem="C PREND_LA_VALEUR A"/>
        <item code="5#A#B#pasliste" algoitem="A PREND_LA_VALEUR B"/>
        <item code="5#B#C#pasliste" algoitem="B PREND_LA_VALEUR C"/>
        <item code="4#Après permutation#1" algoitem="AFFICHER &quot;Après permutation&quot;"/>
        <item code="4#A = #0" algoitem="AFFICHER &quot;A = &quot;"/>
        <item code="3#A#1#pasliste" algoitem="AFFICHER A"/>
        <item code="4#B = #0" algoitem="AFFICHER &quot;B = &quot;"/>
        <item code="3#B#0#pasliste" algoitem="AFFICHER B"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
