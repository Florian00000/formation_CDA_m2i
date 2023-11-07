<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER t[8]" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2lignes="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurPoint="2" epaisseurLigne="2" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nb" algoitem="nb EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#v" algoitem="v EST_DU_TYPE NOMBRE"/>
        <item code="1#LISTE#t" algoitem="t EST_DU_TYPE LISTE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Entrez le nombre de valeurs pour le tableau#0" algoitem="AFFICHER &quot;Entrez le nombre de valeurs pour le tableau&quot;"/>
        <item code="2#nb#pasliste" algoitem="LIRE nb"/>
        <item code="12#i#0#(nb - 1)" algoitem="POUR i ALLANT_DE 0 A (nb - 1)">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Entrez une #0" algoitem="AFFICHER &quot;Entrez une &quot;"/>
            <item code="20#i + 1#0" algoitem="AFFICHERCALCUL i + 1"/>
            <item code="4#e valeur#0" algoitem="AFFICHER &quot;e valeur&quot;"/>
            <item code="2#v#pasliste" algoitem="LIRE v"/>
            <item code="5#t#v#i" algoitem="t[i] PREND_LA_VALEUR v"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="4#LA 9e valeur est #0" algoitem="AFFICHER &quot;LA 9e valeur est &quot;"/>
        <item code="3#t#0#8" algoitem="AFFICHER t[8]"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
