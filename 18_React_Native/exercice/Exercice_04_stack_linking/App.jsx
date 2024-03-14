import { NavigationContainer } from '@react-navigation/native';
import React from 'react';
import {View, StyleSheet} from 'react-native';
import ContactsList from './screens/ContactsList';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import ContactScreen from './screens/ContactScreen';

const App = () => {

    const Stack = createNativeStackNavigator();

    return (
        <NavigationContainer>
            <Stack.Navigator initialRouteName='ContactsList'>
                <Stack.Screen name='ContactsList' component={ContactsList} options={{headerShown: false}}/>
                <Stack.Screen name='ContactScreen' component={ContactScreen} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}

const styles = StyleSheet.create({})

export default App;
