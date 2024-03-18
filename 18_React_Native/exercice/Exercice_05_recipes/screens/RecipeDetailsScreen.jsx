import React from 'react';
import {View, StyleSheet, Image, Text, FlatList, ScrollView} from 'react-native';

const RecipeDetailsScreen = ({navigation, route}) => {
  const recipe = route.params;

  return (
    <ScrollView>
      <Image style={styles.image} source={{uri: recipe.imageUrl}} />
      <View style={styles.informations}>
        <Text style={styles.title}>{recipe.title}</Text>
        <Text style={styles.text}>
          {recipe.duration}m {recipe.complexity} {recipe.affordability}
        </Text>

        {/* Liste des ingrédients */}        
        <Text style={styles.textChapter}>Ingredients</Text>        
        <FlatList
          data={recipe.ingredients}
          renderItem={ingredient => <Text style={[styles.text, styles.textFlat]}>{ingredient.item}</Text>}
          keyExtractor={(_ingredient, index) => {
            return index;
          }}
          scrollEnabled={false}
        />

        {/* Liste des étapes */}
        <Text style={styles.textChapter}>Etapes</Text>        
        <FlatList
          data={recipe.steps}
          renderItem={step => <Text  style={[styles.text, styles.textFlat]}>{step.item}</Text>}
          keyExtractor={(_step, index) => {
            return index;
          }}
          scrollEnabled={false}
        />
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  image: {
    width: '100%',
    height: 350,
  },
  informations: {
    alignItems: "center"
  },
  title: {
    fontWeight: 'bold',
    fontSize: 21,
    marginVertical: 10,
    color: 'black',
  },
  text: {
    color:"black"
  },
  textChapter: {
    color: "#e1b497",
    marginVertical: 5,
    fontSize: 17,
    fontWeight: 'bold',
    borderBottomColor: '#e1b497',
    borderBottomWidth: 3, 
    width: 300, 
    textAlign:"center",
    paddingBottom: 5,
  },
  textFlat: {
    backgroundColor:"#e1b497",
    marginVertical:3,
    width: 300,
    textAlign: "center",
    padding:2,
    borderRadius:5,
    elevation: 1
  }
});

export default RecipeDetailsScreen;
