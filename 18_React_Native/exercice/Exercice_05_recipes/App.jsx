import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React from 'react';
import {View, StyleSheet} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import CategoriesListScreen from './screens/CategoriesListScreen';
import RecepiesListScreen from './screens/RecepiesListScreen';
import RecipeDetailsScreen from './screens/RecipeDetailsScreen';

const App = () => {

    const Stack = createNativeStackNavigator();

    return (
        <NavigationContainer>
            <Stack.Navigator>
                <Stack.Screen name='CategoriesList' component={CategoriesListScreen} options={{title: "Toutes les catégories"}} />
                <Stack.Screen name='RecepiesList' component={RecepiesListScreen} options={{title: "Toutes les recettes"}} />
                <Stack.Screen name='RecipeDetails' component={RecipeDetailsScreen} options={{title: "A propos de la recette"}}/>
            </Stack.Navigator>
        </NavigationContainer>
    );
}

const styles = StyleSheet.create({})

export default App;
