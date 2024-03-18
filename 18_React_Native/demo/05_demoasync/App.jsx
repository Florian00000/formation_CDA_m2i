import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import AsyncStorage from '@react-native-async-storage/async-storage'

export default function App() {

  const [value,setValue] = useState()

  const addData = async () => {
    try{
      const data = {prenom: "jean", nom: "dupont"}
      await AsyncStorage.setItem('value', JSON.stringify(data))
    }catch(error){
      console.log(error)
    }
  }

  const recupData = async () => {
    try{
      const value =  await AsyncStorage.getItem('value')     
      if(value !== null){
        setValue(JSON.parse(value))
      }
    }catch(error){
      console.log(error)
    }
  }

  const deleteData = async () => {
    try{
      await AsyncStorage.removeItem('value')
      setValue(null)
    }catch(error){
      console.log(error)
    }
  }


  return (
    <View>
      <Text>Prénom: {value?.prenom} / Nom: {value?.nom} </Text>
      <Button title='Ajout' onPress={addData}/>
      <Button title='Recup' onPress={recupData}/>
      <Button title='Delete' onPress={deleteData}/>
    </View>
  )
}

const styles = StyleSheet.create({})