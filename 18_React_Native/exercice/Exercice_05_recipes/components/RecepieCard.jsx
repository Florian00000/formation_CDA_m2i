import React from 'react';
import {View, StyleSheet, Text, Image, Pressable} from 'react-native';

const RecepieCard = ({recipe, navigation}) => {
  const redirect = recipeInfo => {
    // console.log(recipeInfo);
    navigation.navigate('RecipeDetails', recipeInfo);
  };

  return (
    <View style={styles.main}>
      <Pressable onPress={() => redirect(recipe)}>
        <View style={styles.card}>
          <Image style={styles.image} source={{uri: recipe.imageUrl}} />
          <Text style={styles.title}>{recipe.title} </Text>
          <Text style={styles.text}>
            {recipe.duration}m {recipe.complexity} {recipe.affordability}
          </Text>          
        </View>
      </Pressable>
    </View>
  );
};

const styles = StyleSheet.create({
  image: {
    height: 250,
    width: 350,
    borderTopLeftRadius: 10,
    borderTopRightRadius: 10,
  },
  main: {
    width: 'auto',
    backgroundColor: '#f2f2f2',
    alignItems: 'center',
  },
  card: {
    borderWidth: 1,
    borderColor: '#cecece',
    marginVertical: 15,
    borderRadius: 10,
    alignItems: 'center',
  },
  title: {
    fontWeight: 'bold',
    fontSize: 18,
    marginVertical: 5,
  },
  text: {
    marginBottom: 10,
    color: 'black',
  },
});

export default RecepieCard;
