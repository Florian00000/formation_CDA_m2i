import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function ScreenC({ navigation }) {
  return (
    <View>
      <Text>ScreenC</Text>
      <Text>On va rajouter un bouton ver la page ScreenA</Text>
      <Button title='Go to Screen A' onPress={() => navigation.navigate("EcranA")}></Button>
      <Text>On va rajouter un bouton ver la page ScreenB avec un params value qui contient toto</Text>
      <Button title='Go to Screen B' onPress={() => navigation.navigate("EcranB",{ value : "toto"})}></Button>
      <Text>On va rajouter un bouton ver la page ScreenB avec un params value qui contient tata</Text>
      <Button title='Go to Screen B' onPress={() => navigation.navigate("EcranB",{ value : "tata" , qt : 25})}></Button>
      <Text>On va rajouter un bouton ver la page ScreenB avec un params value qui contient rien</Text>
      <Button title='Go to Screen B' onPress={() => navigation.navigate("EcranB")}></Button>
    </View>
  )
}

const styles = StyleSheet.create({})