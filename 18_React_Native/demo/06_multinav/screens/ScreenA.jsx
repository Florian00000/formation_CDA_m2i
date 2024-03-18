import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function ScreenA({navigation}) {
  return (
    <View>
      <Text>ScreenA</Text>
      <Button onPress={() => navigation.navigate("EcranB")} title='Got to Ecran'/>
    </View>
  )
}

const styles = StyleSheet.create({})