import React, { useState } from 'react';
import {View, StyleSheet, Text, Button, FlatList, TextInput} from 'react-native';
import ModalDemo01 from './ModalDemo01';

const Demo01 = () => {

    const [modalVisible, setModalVisible] = useState(false);
    const [textInput, setTextInput] = useState('');

    const tab = [{text: "toto", id: 1}, {text: "tata", id: 2}, {text: "tutu", id: 3}]

    function closeModal(){
        setModalVisible(!modalVisible)
    }

    function recupInput (enteredText) {
        console.log(enteredText)
        setTextInput(enteredText)
    }

    return (
        <View>
            <Text>Ma première démo réact native</Text>
            <Button title='Mon Bouton' onPress={closeModal}/>
            <ModalDemo01 visible={modalVisible} closeModal={closeModal}></ModalDemo01>
            <FlatList 
                data={tab} 
                renderItem={(itemData) => {
                    return (
                        <View>
                            <Text>{itemData.item.text} {itemData.item.id}</Text>
                        </View>
                    )
                }}
                keyExtractor={(item, index) => {
                    return index;
                }}
            />
            <TextInput onChangeText={recupInput} value={textInput} />
        </View>
    );
}

const styles = StyleSheet.create({})

export default Demo01;
