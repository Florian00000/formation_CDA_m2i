<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER &quot;   ii   &quot;" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2lignes="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurPoint="2" epaisseurLigne="2" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#LISTE#tab" algoitem="tab EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#j" algoitem="j EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="12#i#0#2" algoitem="POUR i ALLANT_DE 0 A 2">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Ici c est la matière #0" algoitem="AFFICHER &quot;Ici c est la matière &quot;"/>
            <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
            <item code="12#j#0#14" algoitem="POUR j ALLANT_DE 0 A 14">
                <item code="13#debutpour" algoitem="DEBUT_POUR"/>
                <item code="2#n#pasliste" algoitem="LIRE n"/>
                <item code="5#tab#n#i*15 + j" algoitem="tab[i*15 + j] PREND_LA_VALEUR n"/>
                <item code="14#finpour" algoitem="FIN_POUR"/>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="12#i#0#2" algoitem="POUR i ALLANT_DE 0 A 2">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="12#j#0#14" algoitem="POUR j ALLANT_DE 0 A 14">
                <item code="13#debutpour" algoitem="DEBUT_POUR"/>
                <item code="6#j == 0" algoitem="SI (j == 0) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                    <item code="4#Matière #0" algoitem="AFFICHER &quot;Matière &quot;"/>
                    <item code="3#i#1#pasliste" algoitem="AFFICHER i"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="3#tab#1#i*15+j" algoitem="AFFICHER tab[i*15+j]"/>
                <item code="14#finpour" algoitem="FIN_POUR"/>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="4#iiiiiiii#1" algoitem="AFFICHER &quot;iiiiiiii&quot;"/>
        <item code="4#__    __#1" algoitem="AFFICHER &quot;__    __&quot;"/>
        <item code="4#   ||   #1" algoitem="AFFICHER &quot;   ||   &quot;"/>
        <item code="4#|______|#1" algoitem="AFFICHER &quot;|______|&quot;"/>
        <item code="4#   ii   #1" algoitem="AFFICHER &quot;   ii   &quot;"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
