import React from 'react';
import {View, StyleSheet, Text, Image, Pressable} from 'react-native';

const ContactDetails = ({contact, navigation}) => {
    const redirect = (contactInfos) => {
        const contact = contactInfos.item        
        navigation.navigate("ContactScreen", contact)
    }

  return (
    <Pressable onPress={() => redirect(contact)}>
      <View style={styles.divContact}>        
        <View style={styles.infosContact}>
          <Text style={styles.textContact}>{contact.item.name}</Text>                 
        </View>
      </View>
    </Pressable>
  );
};

const styles = StyleSheet.create({
  imgContact: {
    width: 100,
    height: 100,
    borderRadius: 50,
  },
  textContact: {
    color: 'white',
    margin: 5,
  },
  divContact: {
    padding: 15,
    borderBottomWidth: 2,
    borderColor: '#3f3f3f',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingEnd: 50,
  },
  infosContact: {
    flexDirection: 'row',
  },
});

export default ContactDetails;
