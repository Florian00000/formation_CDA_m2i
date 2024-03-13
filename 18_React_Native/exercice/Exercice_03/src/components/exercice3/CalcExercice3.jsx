import React, { useState } from 'react';
import {View, StyleSheet, Text} from 'react-native';
import CalcButton from './CalcButton';

const CalcExercice3 = () => {

    const [result, setResult] = useState(0)
        
    return (
        <View style={styles.main}>
            <Text style={styles.title}>Calculatrice</Text>
            <Text style={styles.res}>{result}</Text>
            <View>
                <View style={styles.interfaceCalc}>

                <View style={styles.calc}>
                <CalcButton buttonValue={"AC"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton} />
                <CalcButton buttonValue={"x²"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton}/>
                <CalcButton buttonValue={"%"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton}/>
                <CalcButton buttonValue={"/"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton}/>
                </View>
                <View style={styles.calc}>
                <CalcButton buttonValue={"7"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"8"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"9"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"X"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton}/>
                </View>
                <View style={styles.calc}>
                <CalcButton buttonValue={"4"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"5"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"6"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"-"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton}/>
                </View>
                <View style={styles.calc}>
                <CalcButton buttonValue={"1"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton} value={1}/>
                <CalcButton buttonValue={"2"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton} value={2}/>
                <CalcButton buttonValue={"3"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton} value={3}/>
                <CalcButton buttonValue={"+"} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton} />
                </View>
                <View style={styles.calc}>
                <CalcButton buttonValue={","} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"0"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"Del"} stylesPressable={styles.circleButton} styleText={styles.textCircleButton}/>
                <CalcButton buttonValue={"="} stylesPressable={styles.cubeButton} styleText={styles.textCubeButton} />
                </View>
                </View>
                            
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    title: {
        color: "white",
        fontSize: 40,
        textAlign: "center",
        marginTop: 15
    },
    res: {
        color: "grey",
        fontSize: 70,
        textAlign: "right",        
        marginRight: 15,      
        height: 300,
        paddingTop: 170  
    },
    interfaceCalc: {
        justifyContent: "space-around"
    },
    calc: {
        flexDirection: "row",
        justifyContent: "space-between"
    },
    cubeButton: {
        backgroundColor: "grey",
        borderRadius: 10,
        height: 80,
        width:80,
        margin: 10,
        justifyContent: "center",
        alignItems: "center"
    },
    textCubeButton:{
        color: "white",
        fontSize: 20
    },
    main: {
        backgroundColor: "black",
        flex: 1
    },
    circleButton:{
        backgroundColor: "whitesmoke",
        height: 80,
        width:80,
        borderRadius: 40,
        justifyContent: "center",
        alignItems: "center",
        margin: 10,
    },
    textCircleButton:{
        color: "black",
        fontSize: 20
    },
})

export default CalcExercice3;