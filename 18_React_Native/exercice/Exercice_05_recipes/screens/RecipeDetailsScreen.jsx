import React from 'react';
import {View, StyleSheet, Image} from 'react-native';

const RecipeDetailsScreen = ({navigation, route}) => {
    const recepie = route.params;

    return (
        <View>
            <Image style={styles.image} source={{uri: recepie.imageUrl}}/>
        </View>
    );
}

const styles = StyleSheet.create({
    image: {
        width: 300,
        height: 300
    }
})

export default RecipeDetailsScreen;
