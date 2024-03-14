import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import ScreenA from './screens/ScreenA'
import ScreenB from './screens/ScreenB'
import ScreenC from './screens/ScreenC'

// package necessaire navigation :
// npm install @react-navigation/native
// npm install react-native-screens react-native-safe-area-context
// npm i @react-navigation/native-stack

const Stack = createNativeStackNavigator()

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='EcranC'>
        <Stack.Screen name='EcranA' component={ScreenA} options={{title : "Page A"}}/>
        <Stack.Screen name='EcranB' component={ScreenB} />
        <Stack.Screen name='EcranC' component={ScreenC} options={{headerShown : false}}/>
      </Stack.Navigator>
    </NavigationContainer>
  )
}

const styles = StyleSheet.create({})