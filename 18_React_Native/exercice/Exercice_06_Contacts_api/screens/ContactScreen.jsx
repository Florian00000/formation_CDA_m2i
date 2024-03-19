import React, {useLayoutEffect} from 'react';
import {View, StyleSheet, Text, Linking, Pressable} from 'react-native';

const ContactScreen = ({navigation, route}) => {
  const contact = route.params;

  useLayoutEffect(() => {
    navigation.setOptions({
      title: `${contact.name}`,
      headerStyle: {
        backgroundColor: "black"
      },
      headerTintColor: "white"
    });
  }, []);

  const handleCallPress = () => {
    const tel = contact.phone.split(' ')[0].replace(/[-().]/g, '');
    Linking.openURL(`tel:${tel}`)
  }

  return (
    <View style={styles.main}>      
      <View>        
      <Text style={styles.textContact}>Nom Complet: {contact.name}</Text>
      <Text style={styles.textContact}>Adresse: {contact.address.street} {contact.address.suite}</Text>
      <Text style={styles.textContact}>{contact.address.city} {contact.address.zipcode}</Text>
      <Text style={styles.textContact}>Numéro: {contact.phone}</Text>
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
