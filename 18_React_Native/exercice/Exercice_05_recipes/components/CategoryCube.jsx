import React from 'react';
import {View, StyleSheet, Text, Pressable} from 'react-native';

const CategoryCube = ({categorie, navigation}) => {
  const styles = StyleSheet.create({
    cube: {
      backgroundColor: categorie.color,
      width: 190,
      height: 190,
      borderRadius: 10,
      margin: 15,
      justifyContent: 'center',
      alignItems: 'center',
    },
    textCube: {
      fontSize: 20,
      fontWeight: 'bold',
    },
  });

  const redirect = (categorieInfos) => {
    // console.log(categorieInfos.title);
    navigation.navigate("RecepiesList", categorieInfos)
  }

  return (
    <Pressable onPress={() => redirect(categorie)}>
      <View style={styles.cube}>
        <Text style={styles.textCube}>{categorie.title} </Text>
      </View>
    </Pressable>
  );
};

export default CategoryCube;
