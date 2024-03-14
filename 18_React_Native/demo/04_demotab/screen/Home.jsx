import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Icon from 'react-native-vector-icons/FontAwesome'

export default function Home() {
  return (
    <View>
      <Text>Home</Text>
      <Icon name="headphones" size={32} color="black"/>
    </View>
  )
}

const styles = StyleSheet.create({})