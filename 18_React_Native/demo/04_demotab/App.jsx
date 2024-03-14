import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import Home from './screen/Home'
import Contact from './screen/Contact'
import About from './screen/About'
import Icon from 'react-native-vector-icons/FontAwesome'


// package necessaire navigation :
// npm install @react-navigation/native
// npm install react-native-screens react-native-safe-area-context
// npm install @react-navigation/bottom-tabs

// Pour l'utilisation d'icone :
// npm install react-native-vector-icons
// Dans le fichier
// android/app/build.gradle
// Ajouter la ligne : 
// apply from: "../../node_modules/react-native-vector-icons/fonts.gradle"

const Tab = createBottomTabNavigator()

export default function App() {
  return (
    <NavigationContainer>
      {/* <Tab.Navigator screenOptions={{tabBarIconStyle:{display: 'none'},tabBarLabelPosition: 'beside-icon'}}> */}
      <Tab.Navigator screenOptions={{
        tabBarActiveTintColor: "orange",
      }} >
        <Tab.Screen name='Home' component={Home} options={{
          tabBarIcon:({color,size}) => (<Icon name="home" size={size} color={color}/>),
          tabBarLabel: "Home" 
        }}/>
        <Tab.Screen name='Contact' component={Contact} options={{
          tabBarIcon:({color,size}) => (<Icon name="usb" size={size} color={color}/>),
          tabBarLabel: "Contact" 
        }} />
        <Tab.Screen name='About' component={About} options={{
          tabBarIcon:({color,size}) => (<Icon name="edge" size={size} color={color}/>),
          tabBarLabel: "About" 
        }}/>
      </Tab.Navigator>
    </NavigationContainer>
  )
}

const styles = StyleSheet.create({})