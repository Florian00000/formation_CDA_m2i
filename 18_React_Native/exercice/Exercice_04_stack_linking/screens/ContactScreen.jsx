import React, {useLayoutEffect} from 'react';
import {View, StyleSheet, Text, Image, Button, Linking, Pressable} from 'react-native';

const ContactScreen = ({navigation, route}) => {
  const contact = route.params;

  useLayoutEffect(() => {
    navigation.setOptions({title: `${contact.prenom} ${contact.nom}`});
  }, []);

  const handleCallPress = () => {
    Linking.openURL(`tel:${contact.tel}`)
  }

  // console.log(contact.nom);
  return (
    <View style={styles.main}>
      <Image style={styles.imgContact} source={{uri: contact.image}} />
      <View>
        <Text style={styles.textContact}>Prénom: {contact.prenom}</Text>
        <Text style={styles.textContact}>Nom: {contact.nom}</Text>
      <Text style={styles.textContact}>Numéro: {contact.tel}</Text>
      </View>
      <Pressable style={styles.callButton}  onPress={handleCallPress}>
        <Text style={styles.callButtonText}>Appeler</Text>
      </Pressable>
    </View>
  );
};

const styles = StyleSheet.create({
  main: {
    backgroundColor: '#181818',
    flex: 1,
    justifyContent: "space-evenly",
    alignItems: "center",
  },
  textContact: {
    color: 'white',
    fontSize: 20,
    paddingBottom: 5 
  },
  imgContact: {
    width: 200,
    height: 200,
    borderRadius: 100,
  },
  callButton: {
    backgroundColor: "chartreuse",
    width: 200,
    height: 50,
    borderRadius: 10,
    justifyContent: "center",
    alignItems: "center"
  }, 
  callButtonText: {
    fontSize: 20
  }
});

export default ContactScreen;
