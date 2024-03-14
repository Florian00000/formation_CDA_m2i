import React from 'react';
import {View, StyleSheet, Text, FlatList} from 'react-native';
import contacts from "../data/contacts.json";
import ContactDetails from '../components/ContactDetails';

const ContactsList = ({navigation}) => {    

    return (
        <View style={styles.main}>
            <FlatList
            data={contacts}
            renderItem={(contact) => (
                <ContactDetails contact={contact} navigation={navigation} />
            )}
            keyExtractor={(contact, index) => {
                return index;
            }}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    main: {
        backgroundColor: "#181818",
        flex: 1
    }
})

export default ContactsList;
