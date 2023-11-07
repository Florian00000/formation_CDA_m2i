<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER c"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2defaut="" F2para="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" totalAffichages="1000" totalBoucles="5000000" epaisseurLigne="2" nbDecimales="8" maxBoucle="500000" epaisseurPoint="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="c EST_DU_TYPE NOMBRE" code="1#NOMBRE#c"/>
        <item algoitem="ci EST_DU_TYPE NOMBRE" code="1#NOMBRE#ci"/>
        <item algoitem="t EST_DU_TYPE NOMBRE" code="1#NOMBRE#t"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Entrez le capital&quot;" code="4#Entrez le capital#0"/>
        <item algoitem="LIRE c" code="2#c#pasliste"/>
        <item algoitem="ci PREND_LA_VALEUR c" code="5#ci#c#pasliste"/>
        <item algoitem="AFFICHER &quot;Entrez le taux&quot;" code="4#Entrez le taux#0"/>
        <item algoitem="LIRE t" code="2#t#pasliste"/>
        <item algoitem="t PREND_LA_VALEUR t /100" code="5#t#t /100#pasliste"/>
        <item algoitem="t PREND_LA_VALEUR 1 + t" code="5#t#1 + t#pasliste"/>
        <item algoitem="i PREND_LA_VALEUR 0" code="5#i#0#pasliste"/>
        <item algoitem="TANT_QUE (c &lt; ci * 2) FAIRE" code="15#c &lt; ci * 2">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="c PREND_LA_VALEUR c * t" code="5#c#c * t#pasliste"/>
            <item algoitem="i PREND_LA_VALEUR i + 1" code="5#i#i + 1#pasliste"/>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="AFFICHER &quot;Il faut &quot;" code="4#Il faut #0"/>
        <item algoitem="AFFICHER i" code="3#i#0#pasliste"/>
        <item algoitem="AFFICHER &quot; années&quot;" code="4# années#1"/>
        <item algoitem="AFFICHER c" code="3#c#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
