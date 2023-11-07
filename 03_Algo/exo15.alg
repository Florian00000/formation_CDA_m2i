<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER r"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2etat="inactif" F2para="" F2lignes="" F2defaut=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalBoucles="5000000" totalAffichages="1000" epaisseurLigne="2" arrondiAuto="vrai" nbDecimales="8" epaisseurPoint="2" maxBoucle="500000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#plusGrand#a, b" algoitem="FONCTION plusGrand(a, b)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION">
                <item code="1#NOMBRE#e" algoitem="e EST_DU_TYPE NOMBRE"/>
            </item>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="6#a > b" algoitem="SI (a > b) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#e#a#pasliste" algoitem="e PREND_LA_VALEUR a"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="5#e#b#pasliste" algoitem="e PREND_LA_VALEUR b"/>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="205#e" algoitem="RENVOYER e"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#a" algoitem="a EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#b" algoitem="b EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#r" algoitem="r EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Entrez un premier nombre#0" algoitem="AFFICHER &quot;Entrez un premier nombre&quot;"/>
        <item code="2#a#pasliste" algoitem="LIRE a"/>
        <item code="4#Entrez un second nombre#0" algoitem="AFFICHER &quot;Entrez un second nombre&quot;"/>
        <item code="2#b#pasliste" algoitem="LIRE b"/>
        <item code="5#r#plusGrand(a, b)#pasliste" algoitem="r PREND_LA_VALEUR plusGrand(a, b)"/>
        <item code="4#LE plus grand des deux nombres est #0" algoitem="AFFICHER &quot;LE plus grand des deux nombres est &quot;"/>
        <item code="3#r#0#pasliste" algoitem="AFFICHER r"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
