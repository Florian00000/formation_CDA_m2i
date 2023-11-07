<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot; années pour que Tourcoing atteigne 120 000 habitants&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2etat="inactif" F2lignes="" F2para="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalBoucles="5000000" nbDecimales="8" maxBoucle="500000" arrondiAuto="vrai" epaisseurLigne="2" epaisseurPoint="2" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#hab" algoitem="hab EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#t" algoitem="t EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#a" algoitem="a EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#hab#96809#pasliste" algoitem="hab PREND_LA_VALEUR 96809"/>
        <item code="5#t#1.0089#pasliste" algoitem="t PREND_LA_VALEUR 1.0089"/>
        <item code="5#a#0#pasliste" algoitem="a PREND_LA_VALEUR 0"/>
        <item code="15#hab &lt; 120000" algoitem="TANT_QUE (hab &lt; 120000) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="5#hab#hab * t#pasliste" algoitem="hab PREND_LA_VALEUR hab * t"/>
            <item code="5#a#a + 1#pasliste" algoitem="a PREND_LA_VALEUR a + 1"/>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="4#Il faut #0" algoitem="AFFICHER &quot;Il faut &quot;"/>
        <item code="3#a#0#pasliste" algoitem="AFFICHER a"/>
        <item code="4# années pour que Tourcoing atteigne 120 000 habitants#0" algoitem="AFFICHER &quot; années pour que Tourcoing atteigne 120 000 habitants&quot;"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
