import React, {useEffect, useState} from 'react';
import {View, StyleSheet, Text, FlatList} from 'react-native';
import ContactDetails from '../components/ContactDetails';
import axios from 'axios';

const ContactsList = ({navigation}) => {
  const [contacts, setContacts] = useState();

  useEffect(() => {
    axios
      .get('https://jsonplaceholder.typicode.com/users')
      .then(response => {
        console.log(response.data);
        setContacts(response.data);
      })
      .catch(error => console.error(error));
  }, []);

  return (
    <View style={styles.main}>
      <FlatList
        data={contacts}
        renderItem={contact => (
          <ContactDetails contact={contact} navigation={navigation} />
        )}
        keyExtractor={(contact, index) => {
          return index;
        }}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  main: {
    backgroundColor: '#181818',
    flex: 1,
  },
});

export default ContactsList;
