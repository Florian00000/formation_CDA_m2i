<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_TANT_QUE" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2lignes="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurPoint="2" epaisseurLigne="2" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#Menu# " algoitem="FONCTION Menu( )">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="4#Pour quitter le programme: entrez 0#1" algoitem="AFFICHER &quot;Pour quitter le programme: entrez 0&quot;"/>
            <item code="4#Pour entrez de nouvelles notes: entrez 1#1" algoitem="AFFICHER &quot;Pour entrez de nouvelles notes: entrez 1&quot;"/>
            <item code="4#Pour voir les statistiques: entrez 2#1" algoitem="AFFICHER &quot;Pour voir les statistiques: entrez 2&quot;"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#min" algoitem="min EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#max" algoitem="max EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#som" algoitem="som EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#moy" algoitem="moy EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nb" algoitem="nb EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#prog" algoitem="prog EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#prog#1#pasliste" algoitem="prog PREND_LA_VALEUR 1"/>
        <item code="15#prog != 0" algoitem="TANT_QUE (prog != 0) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="6#prog == 1" algoitem="SI (prog == 1) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#Entrez le nombre de notes#0" algoitem="AFFICHER &quot;Entrez le nombre de notes&quot;"/>
                <item code="2#nb#pasliste" algoitem="LIRE nb"/>
                <item code="4#Entrez une première valeur#0" algoitem="AFFICHER &quot;Entrez une première valeur&quot;"/>
                <item code="2#n#pasliste" algoitem="LIRE n"/>
                <item code="5#min#n#pasliste" algoitem="min PREND_LA_VALEUR n"/>
                <item code="5#max#n#pasliste" algoitem="max PREND_LA_VALEUR n"/>
                <item code="5#som#n#pasliste" algoitem="som PREND_LA_VALEUR n"/>
                <item code="12#i#2#nb" algoitem="POUR i ALLANT_DE 2 A nb">
                    <item code="13#debutpour" algoitem="DEBUT_POUR"/>
                    <item code="4#Entrez une #0" algoitem="AFFICHER &quot;Entrez une &quot;"/>
                    <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                    <item code="4#e valeur#0" algoitem="AFFICHER &quot;e valeur&quot;"/>
                    <item code="2#n#pasliste" algoitem="LIRE n"/>
                    <item code="5#som#som + n#pasliste" algoitem="som PREND_LA_VALEUR som + n"/>
                    <item code="6#min > n" algoitem="SI (min > n) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="5#min#n#pasliste" algoitem="min PREND_LA_VALEUR n"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="6#max &lt; n" algoitem="SI (max &lt; n) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="5#max#n#pasliste" algoitem="max PREND_LA_VALEUR n"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="14#finpour" algoitem="FIN_POUR"/>
                </item>
                <item code="5#moy#som / nb#pasliste" algoitem="moy PREND_LA_VALEUR som / nb"/>
                <item code="5#prog#3#pasliste" algoitem="prog PREND_LA_VALEUR 3"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#prog == 2" algoitem="SI (prog == 2) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#La plus petite note est: #0" algoitem="AFFICHER &quot;La plus petite note est: &quot;"/>
                <item code="3#min#1#pasliste" algoitem="AFFICHER min"/>
                <item code="4#La plus grande note est: #0" algoitem="AFFICHER &quot;La plus grande note est: &quot;"/>
                <item code="3#max#1#pasliste" algoitem="AFFICHER max"/>
                <item code="4#La moyenne est: #0" algoitem="AFFICHER &quot;La moyenne est: &quot;"/>
                <item code="3#moy#1#pasliste" algoitem="AFFICHER moy"/>
                <item code="5#prog#3#pasliste" algoitem="prog PREND_LA_VALEUR 3"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#prog == 3" algoitem="SI (prog == 3) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="19#AFFICHER* &quot;Pour quitter le programme: entrez 0&quot;" algoitem="//AFFICHER* &quot;Pour quitter le programme: entrez 0&quot;"/>
                <item code="19#AFFICHER* &quot;Pour entrez de nouvelles notes: entrez 1&quot;" algoitem="//AFFICHER* &quot;Pour entrez de nouvelles notes: entrez 1&quot;"/>
                <item code="19#AFFICHER* &quot;Pour voir les statistiques: entrez 2&quot;" algoitem="//AFFICHER* &quot;Pour voir les statistiques: entrez 2&quot;"/>
                <item code="206#Menu()" algoitem="APPELER_FONCTION Menu()"/>
                <item code="2#prog#pasliste" algoitem="LIRE prog"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
