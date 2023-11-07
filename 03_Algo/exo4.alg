<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER c" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2para="" F2defaut="" F2lignes="" F2etat="inactif"/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param epaisseurPoint="2" maxBoucle="500000" totalBoucles="5000000" nbDecimales="8" arrondiAuto="vrai" totalAffichages="1000" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#c" algoitem="c EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#t" algoitem="t EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Entrez le capital de départ#0" algoitem="AFFICHER &quot;Entrez le capital de départ&quot;"/>
        <item code="2#c#pasliste" algoitem="LIRE c"/>
        <item code="4#Entrez le taux#0" algoitem="AFFICHER &quot;Entrez le taux&quot;"/>
        <item code="2#t#pasliste" algoitem="LIRE t"/>
        <item code="4#Entrez le nombre d'années#0" algoitem="AFFICHER &quot;Entrez le nombre d'années&quot;"/>
        <item code="2#n#pasliste" algoitem="LIRE n"/>
        <item code="5#t#t / 100#pasliste" algoitem="t PREND_LA_VALEUR t / 100"/>
        <item code="5#t#1 + t#pasliste" algoitem="t PREND_LA_VALEUR 1 + t"/>
        <item code="5#c#c * pow(t,n)#pasliste" algoitem="c PREND_LA_VALEUR c * pow(t,n)"/>
        <item code="5#c#round(c)#pasliste" algoitem="c PREND_LA_VALEUR round(c)"/>
        <item code="4#Le capital après intérêt est de #0" algoitem="AFFICHER &quot;Le capital après intérêt est de &quot;"/>
        <item code="3#c#0#pasliste" algoitem="AFFICHER c"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
