import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import ScreenA from './screens/ScreenA'
import ScreenB from './screens/ScreenB'
import ScreenC from './screens/ScreenC'
import ScreenD from './screens/ScreenD'

// package necessaire navigation :
// npm install @react-navigation/native
// npm install react-native-screens react-native-safe-area-context
// npm i @react-navigation/native-stack
// npm install @react-navigation/bottom-tabs


const Stack = createNativeStackNavigator()
const Tab = createBottomTabNavigator()


function MyTabNavigator() {
  return(
    <Stack.Navigator>
        <Stack.Screen name='EcranA' component={ScreenA} />
        <Stack.Screen name='EcranB' component={ScreenB} />
      </Stack.Navigator>
  )
}

export default function App() {
  return (
    <NavigationContainer>
      <Tab.Navigator>
      <Tab.Screen name='EcranC' component={ScreenC} />
      <Tab.Screen name='EcranD' component={ScreenD} />
      <Tab.Screen name='Ecran' component={MyTabNavigator} />
    </Tab.Navigator>
    </NavigationContainer>
  )
}

const styles = StyleSheet.create({})