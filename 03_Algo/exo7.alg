<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot;Merci&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2lignes="" F2defaut=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" arrondiAuto="vrai" totalAffichages="1000" maxBoucle="500000" totalBoucles="5000000" nbDecimales="8" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Ecrire un nombre entre 1 et 3#0" algoitem="AFFICHER &quot;Ecrire un nombre entre 1 et 3&quot;"/>
        <item code="2#n#pasliste" algoitem="LIRE n"/>
        <item code="15#n &lt; 1 OU n > 3" algoitem="TANT_QUE (n &lt; 1 OU n > 3) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="4#Lis bien l'instruction stp#1" algoitem="AFFICHER &quot;Lis bien l'instruction stp&quot;"/>
            <item code="4#Ecrire un nombre entre 1 et 3#0" algoitem="AFFICHER &quot;Ecrire un nombre entre 1 et 3&quot;"/>
            <item code="2#n#pasliste" algoitem="LIRE n"/>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="4#Merci#0" algoitem="AFFICHER &quot;Merci&quot;"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
