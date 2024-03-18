import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function ScreenC({navigation}) {
  return (
    <View>
      <Text>ScreenC</Text>
      <Button title='Go to Ecran B' onPress={() => navigation.navigate("EcranB")} />
    </View>
  )
}

const styles = StyleSheet.create({})