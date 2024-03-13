import React from 'react';
import {View, StyleSheet, Modal, Text, Button} from 'react-native';

const ModalDemo01 = (props) => {
    const {modalVisible, closeModal} = props;

    return (
        <Modal visible={props.visible}>
            <View>
                <Text>Ceci est ma modal React Native</Text>
                <Button title='close Modal' onPress={closeModal}></Button>
            </View>
        </Modal>
    );
}

const styles = StyleSheet.create({})

export default ModalDemo01;
