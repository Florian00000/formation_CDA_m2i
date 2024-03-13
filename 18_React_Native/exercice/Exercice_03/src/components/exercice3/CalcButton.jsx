import React from 'react';
import { Pressable, StyleSheet, Text} from 'react-native';

const CalcButton = (props) => {
    return (
        <Pressable style={props.stylesPressable}>
            <Text style={props.styleText} >{props.buttonValue}</Text>
        </Pressable>
    );
}

const styles = StyleSheet.create({})

export default CalcButton;
