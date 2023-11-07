<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER c"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2lignes="" F2defaut=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" arrondiAuto="vrai" totalAffichages="1000" maxBoucle="500000" totalBoucles="5000000" nbDecimales="8" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#p" algoitem="p EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#t" algoitem="t EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#c" algoitem="c EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#entrez le poid#0" algoitem="AFFICHER &quot;entrez le poid&quot;"/>
        <item code="2#p#pasliste" algoitem="LIRE p"/>
        <item code="4#entrez la taille#0" algoitem="AFFICHER &quot;entrez la taille&quot;"/>
        <item code="2#t#pasliste" algoitem="LIRE t"/>
        <item code="6#p >= 43 ET p &lt;= 65" algoitem="SI (p >= 43 ET p &lt;= 65) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="6#(t &lt; 172 ET p &lt;= 47) OU (t &lt; 169 ET p >= 48 ET p &lt;= 53) OU (t &lt; 166 ET p >= 54 ET p &lt;= 59) OU (t &lt; 163)" algoitem="SI ((t &lt; 172 ET p &lt;= 47) OU (t &lt; 169 ET p >= 48 ET p &lt;= 53) OU (t &lt; 166 ET p >= 54 ET p &lt;= 59) OU (t &lt; 163)) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#c#1#pasliste" algoitem="c PREND_LA_VALEUR 1"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="8#finsi" algoitem="FIN_SI"/>
        </item>
        <item code="6#p >= 48 ET p &lt;= 71" algoitem="SI (p >= 48 ET p &lt;= 71) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="6#(t >= 169 ET t &lt; 183 ET p >= 48 ET p &lt;=53) OU (t >= 166 ET t &lt; 178 ET p >= 54 ET p &lt;= 59) OU (t >= 163 ET t &lt; 175 ET p >= 60 ET p &lt;=65) OU (t >= 160 ET t &lt; 172 ET p >= 66 ET p &lt;=71)" algoitem="SI ((t >= 169 ET t &lt; 183 ET p >= 48 ET p &lt;=53) OU (t >= 166 ET t &lt; 178 ET p >= 54 ET p &lt;= 59) OU (t >= 163 ET t &lt; 175 ET p >= 60 ET p &lt;=65) OU (t >= 160 ET t &lt; 172 ET p >= 66 ET p &lt;=71)) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#c#2#pasliste" algoitem="c PREND_LA_VALEUR 2"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="8#finsi" algoitem="FIN_SI"/>
        </item>
        <item code="6#p >= 54 ET p &lt;= 77" algoitem="SI (p >= 54 ET p &lt;= 77) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="6#(t > 175) OU (t > 172 ET p >= 60 ET p &lt;= 65) OU (t > 169 ET p >= 66 ET p &lt;= 71) OU (t >= 163 ET p >= 72)" algoitem="SI ((t > 175) OU (t > 172 ET p >= 60 ET p &lt;= 65) OU (t > 169 ET p >= 66 ET p &lt;= 71) OU (t >= 163 ET p >= 72)) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#c#3#pasliste" algoitem="c PREND_LA_VALEUR 3"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="8#finsi" algoitem="FIN_SI"/>
        </item>
        <item code="4#La taille du vêtement est #0" algoitem="AFFICHER &quot;La taille du vêtement est &quot;"/>
        <item code="3#c#0#pasliste" algoitem="AFFICHER c"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
