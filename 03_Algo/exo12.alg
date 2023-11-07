<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="FIN_POUR"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2etat="inactif" F2lignes="" F2para="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalBoucles="5000000" nbDecimales="8" maxBoucle="500000" arrondiAuto="vrai" epaisseurLigne="2" epaisseurPoint="2" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#j" algoitem="j EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="12#i#1#10" algoitem="POUR i ALLANT_DE 1 A 10">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="12#j#0#10" algoitem="POUR j ALLANT_DE 0 A 10">
                <item code="13#debutpour" algoitem="DEBUT_POUR"/>
                <item code="6#j == 0" algoitem="SI (j == 0) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4# #1" algoitem="AFFICHER &quot; &quot;"/>
                    <item code="4#table de #0" algoitem="AFFICHER &quot;table de &quot;"/>
                    <item code="3#i#1#pasliste" algoitem="AFFICHER i"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                <item code="4# * #0" algoitem="AFFICHER &quot; * &quot;"/>
                <item code="3#j#0#pasliste" algoitem="AFFICHER j"/>
                <item code="4# = #0" algoitem="AFFICHER &quot; = &quot;"/>
                <item code="20#i * j#1" algoitem="AFFICHERCALCUL i * j"/>
                <item code="14#finpour" algoitem="FIN_POUR"/>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
