import React from 'react';
import {View, StyleSheet, Text, Image} from 'react-native';

const App = () => {
  return (
    <View style={styles.container}>
      <Text style={[styles.monTexte, styles.tailleTexte]}>Hello World</Text>
      <Image
        style={styles.monImage}
        source={{uri: 'https://i.ytimg.com/vi/F0Mj2wEyXNY/maxres2.jpg'}}
      />
    </View>
  );
};

//Mauvaise pratique
// const container = {
//     backgroundColor: "chartreuse",
//     flex: 1
// }

//Bonne pratique
const styles = StyleSheet.create({
  container: {
    backgroundColor: 'black',
    flex: 1, //Permet de prendre toute la place disponible
    padding: 20
  },
  monTexte: {
    color: 'chartreuse',
    margin: 5 
  },
  tailleTexte: {
    fontSize: 32
  },
  monImage: {
    width: 400,
    height: 250,
    borderRadius: 10
  }
});

export default App;
