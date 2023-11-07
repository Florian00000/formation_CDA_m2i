<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER tab[8]"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2etat="inactif" F2para="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalBoucles="5000000" arrondiAuto="vrai" epaisseurLigne="2" maxBoucle="500000" totalAffichages="1000" epaisseurPoint="2" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#tableau#nb" algoitem="FONCTION tableau(nb)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION">
                <item code="1#NOMBRE#v" algoitem="v EST_DU_TYPE NOMBRE"/>
                <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
            </item>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="12#i#0#(nb - 1)" algoitem="POUR i ALLANT_DE 0 A (nb - 1)">
                <item code="13#debutpour" algoitem="DEBUT_POUR"/>
                <item code="4#Entrez une #0" algoitem="AFFICHER &quot;Entrez une &quot;"/>
                <item code="20#i + 1#0" algoitem="AFFICHERCALCUL i + 1"/>
                <item code="4#e valeur#0" algoitem="AFFICHER &quot;e valeur&quot;"/>
                <item code="2#v#pasliste" algoitem="LIRE v"/>
                <item code="5#tab#v#i" algoitem="tab[i] PREND_LA_VALEUR v"/>
                <item code="14#finpour" algoitem="FIN_POUR"/>
            </item>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#LISTE#tab" algoitem="tab EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Entrez le nombre de valeurs pour le tableau#0" algoitem="AFFICHER &quot;Entrez le nombre de valeurs pour le tableau&quot;"/>
        <item code="2#n#pasliste" algoitem="LIRE n"/>
        <item code="206#tableau(n)" algoitem="APPELER_FONCTION tableau(n)"/>
        <item code="3#tab#0#8" algoitem="AFFICHER tab[8]"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
