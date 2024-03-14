import { Button, Linking, StyleSheet, Text, View } from 'react-native'
import React, { useLayoutEffect } from 'react'

export default function ScreenA({ navigation }) {

  function handleCallPress(){
    Linking.openURL(`tel:911`)
  }

  useLayoutEffect(() => {
      navigation.setOptions({ title: "Call 911"})
  },[])

  return (
    <View>
      <Text>ScreenA</Text>
      <Button title='call 911' onPress={handleCallPress} />
    </View>
  )
}

const styles = StyleSheet.create({})