import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import Button from './Button'

export default function Calculatrice() {

  const [firstNumber,setFirstNumber] = useState('0')
  const [secondNumber, setSecondNumber] = useState('0')
  const [operation, setOperation] = useState('0')
  const [result, setResult] = useState('')

  function numberPress(number){
    console.log("appuie sur un nombre : "+ number)
    if (firstNumber != "0"){
      setFirstNumber(firstNumber + number)
    }else {
      setFirstNumber(number)
    }
  }

  function operationPress(operateur){
 console.log("appuie sur un operateur : "+ operateur)
 setOperation(operateur)
 setSecondNumber(firstNumber)
 setFirstNumber("")
  }

  function resultPress(){
    console.log("appuie sur égal")
    console.log("faire l'operation de "+ secondNumber + " " + operation + " " + firstNumber)
    let resultat;
    switch(operation){
        case "+":
          resultat = parseFloat(secondNumber) + parseFloat(firstNumber)
          setFirstNumber(resultat)
        break;
        case "-":
          resultat = parseFloat(secondNumber) - parseFloat(firstNumber)
          setFirstNumber(resultat)
        break;
        case "/":
          resultat = parseFloat(secondNumber) / parseFloat(firstNumber)
          setFirstNumber(resultat)
        break;
        case "X":
          resultat = parseFloat(secondNumber) * parseFloat(firstNumber)
          setFirstNumber(resultat)
        break;
    }
  }

  function clear(){
    console.log("appuier sur clear")
    setFirstNumber("0")
  }


  return (
    <View style={styles.calculatrice}>
      <View >
        <Text style={styles.displayText}></Text>
      </View>
      <View>
        <Text style={styles.displayText}>{firstNumber}</Text>
      </View>
      <View style={styles.row}>
        <Button title={"AC"} onPress={clear} />
        <Button title={"^"} />
        <Button title={"%"} />
        <Button title={"/"} onPress={() => operationPress("/")} />
      </View>
      <View style={styles.row}>
        <Button title={"7"} isWhite onPress={() => numberPress("7")}/>
        <Button title={"8"} isWhite onPress={() => numberPress("8")}/>
        <Button title={"9"} isWhite onPress={() => numberPress("9")}/>
        <Button title={"X"} onPress={() => operationPress("X")} />
      </View>
      <View style={styles.row}>
        <Button title={"4"} isWhite onPress={() => numberPress("4")}/>
        <Button title={"5"}  isWhite onPress={() => numberPress("5")}/>
        <Button title={"6"} isWhite onPress={() => numberPress("6")}/>
        <Button title={"-"} onPress={() => operationPress("-")} />
      </View>
      <View style={styles.row}>
        <Button title={"1"}  isWhite onPress={() => numberPress("1")}/>
        <Button title={"2"} isWhite onPress={() => numberPress("2")}/>
        <Button title={"3"} isWhite onPress={() => numberPress("3")}/>
        <Button title={"+"} onPress={() => operationPress("+")} />
      </View>
      <View style={styles.row}>
        <Button title={"."} isWhite />
        <Button title={"0"} isWhite onPress={() => numberPress("0")}/>
        <Button title={"Del"} isWhite onPress={clear}/>
        <Button title={"="} onPress={resultPress} />
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  calculatrice: {
    width: '100%',
    position: 'absolute',
    bottom: 50
  },
  row: {
    width: '100%',
    flexDirection: 'row',
    justifyContent: 'space-around',
    marginVertical: 10
  },
  displayText: {
    fontSize: 90,
    fontWeight: "300",
    color: "grey",
    alignSelf: "flex-end",
    marginRight: 20
  }


})