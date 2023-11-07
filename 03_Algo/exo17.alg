<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_POUR" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2lignes="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurPoint="2" epaisseurLigne="2" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#LISTE#tab" algoitem="tab EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="12#i#0#14" algoitem="POUR i ALLANT_DE 0 A 14">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Entrez la #0" algoitem="AFFICHER &quot;Entrez la &quot;"/>
            <item code="20#i + 1#0" algoitem="AFFICHERCALCUL i + 1"/>
            <item code="4#e note#0" algoitem="AFFICHER &quot;e note&quot;"/>
            <item code="2#n#pasliste" algoitem="LIRE n"/>
            <item code="5#tab#n#i" algoitem="tab[i] PREND_LA_VALEUR n"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="12#i#0#14" algoitem="POUR i ALLANT_DE 0 A 14">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#la #0" algoitem="AFFICHER &quot;la &quot;"/>
            <item code="20#i + 1#0" algoitem="AFFICHERCALCUL i + 1"/>
            <item code="4#e note est #0" algoitem="AFFICHER &quot;e note est &quot;"/>
            <item code="3#tab#1#i" algoitem="AFFICHER tab[i]"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
