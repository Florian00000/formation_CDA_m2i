<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER max" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" epaisseurLigne="2" totalBoucles="5000000" maxBoucle="500000" nbDecimales="8" totalAffichages="1000" arrondiAuto="vrai"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="n EST_DU_TYPE NOMBRE" code="1#NOMBRE#n"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="max EST_DU_TYPE NOMBRE" code="1#NOMBRE#max"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Entrez un premier chiffre&quot;" code="4#Entrez un premier chiffre#0"/>
        <item algoitem="LIRE n" code="2#n#pasliste"/>
        <item algoitem="max PREND_LA_VALEUR n" code="5#max#n#pasliste"/>
        <item algoitem="POUR i ALLANT_DE 2 A 6" code="12#i#2#6">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="AFFICHER &quot;Entrez un &quot;" code="4#Entrez un #0"/>
            <item algoitem="AFFICHER i" code="3#i#0#pasliste"/>
            <item algoitem="AFFICHER &quot;e nombre&quot;" code="4#e nombre#0"/>
            <item algoitem="LIRE n" code="2#n#pasliste"/>
            <item algoitem="SI (max &lt; n) ALORS" code="6#max &lt; n">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="max PREND_LA_VALEUR n" code="5#max#n#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="AFFICHER &quot;Le nombre le plus élevé est &quot;" code="4#Le nombre le plus élevé est #0"/>
        <item algoitem="AFFICHER max" code="3#max#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
