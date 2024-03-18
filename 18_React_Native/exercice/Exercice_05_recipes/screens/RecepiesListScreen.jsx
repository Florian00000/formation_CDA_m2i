import React, { useLayoutEffect, useState } from 'react';
import {View, StyleSheet, FlatList} from 'react-native';
import { MEALS } from '../recettes/data/data';
import RecepieCard from '../components/RecepieCard';

const RecepiesListScreen = ({navigation, route}) => {
    const categorie = route.params;
    // console.log(categorie.id);

    const [recepiesList, setRecepiesList] = useState(MEALS);

    useLayoutEffect(() => {
        // const recipes = recepiesList.filter(recipe => {
        //     return !!recipe.categoryIds.find(catId => catId == categorie.id)
        // })
        const recipes = recepiesList.filter(recipe => recipe.categoryIds.includes(categorie.id)
        )
        setRecepiesList(recipes)
        // console.log(recipes);
    }, [])

    return (
        <View style={styles.main}>
            <FlatList
            data={recepiesList}
            renderItem={recipe => (
                <RecepieCard recipe={recipe.item} navigation= {navigation}/>
            )}
            keyExtractor={(_recipe, index) => {
                return index;
            }}
            style={styles.list}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    main: {        
        flex: 1
      },
    list:{
        width:"100%"
    }
})

export default RecepiesListScreen;
