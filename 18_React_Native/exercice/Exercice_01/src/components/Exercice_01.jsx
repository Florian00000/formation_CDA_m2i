import React from 'react';
import {View, StyleSheet, Image, Text} from 'react-native';

const Exercice_01 = () => {
    return (
        <View style={styles.main}>
            <Image
            style={styles.logo}
            source={{uri: 'https://i.ytimg.com/vi/F0Mj2wEyXNY/maxres2.jpg'}}
            />
            <View>
            <Text style={styles.text}>Nom: <Text style={styles.bold}>Capitaine</Text> </Text>
            <Text style={styles.text}>Prénom: <Text style={styles.bold}>Hadock</Text> </Text>
            <Text style={styles.text}>Téléphone: <Text style={styles.bold}>06 06 06 06 06</Text> </Text>
            <Text style={styles.text}>Adresse: <Text style={styles.bold}>8 rue de la haute Borne</Text> </Text>

            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    logo:{
        width:100,
        height:100,
        borderRadius: 50,
        marginBottom: 30
    },
    bold:{
        fontWeight: "bold"
    },
    text:{
        fontSize: 20
    },
    main: {
        backgroundColor: "#f9ecd7",
        flex: 1,
        justifyContent: "center",
        alignItems:"center"
    }
})

export default Exercice_01;
