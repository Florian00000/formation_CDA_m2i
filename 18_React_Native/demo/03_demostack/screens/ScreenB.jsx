import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function ScreenB({navigation,route}) {
  const value = route.params.value
  console.log(route.params.qt)
  return (
    <View>
      <Text>ScreenB</Text>
      <Text>Value : {value}</Text>
    </View>
  )
}

const styles = StyleSheet.create({})