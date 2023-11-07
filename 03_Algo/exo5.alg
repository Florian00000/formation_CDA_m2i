<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_SINON" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2lignes="" F2para="" F2etat="inactif" F2defaut=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" epaisseurLigne="2" totalBoucles="5000000" totalAffichages="1000" epaisseurPoint="2" arrondiAuto="vrai" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#a" algoitem="a EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Entrez l'âge de l'enfant#0" algoitem="AFFICHER &quot;Entrez l'âge de l'enfant&quot;"/>
        <item code="2#a#pasliste" algoitem="LIRE a"/>
        <item code="6#a >= 13" algoitem="SI (a >= 13) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="4#L'enfant est un cadet#0" algoitem="AFFICHER &quot;L'enfant est un cadet&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="6#a &lt; 13 ET a >= 11" algoitem="SI (a &lt; 13 ET a >= 11) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#L'enfant est un Minime#0" algoitem="AFFICHER &quot;L'enfant est un Minime&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="6#a &lt;= 10 ET a >= 9" algoitem="SI (a &lt;= 10 ET a >= 9) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#L'enfant est un Pupille#0" algoitem="AFFICHER &quot;L'enfant est un Pupille&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="6#a &lt;= 8 ET a >= 7" algoitem="SI (a &lt;= 8 ET a >= 7) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#L'enfant est un Poussin#0" algoitem="AFFICHER &quot;L'enfant est un Poussin&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="6#a &lt;= 6 ET a >= 3" algoitem="SI (a &lt;= 6 ET a >= 3) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#L'enfant est un Baby#0" algoitem="AFFICHER &quot;L'enfant est un Baby&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="11#finsinon" algoitem="FIN_SINON"/>
            </item>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
