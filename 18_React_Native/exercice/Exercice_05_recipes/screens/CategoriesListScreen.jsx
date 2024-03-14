import React from 'react';
import {View, StyleSheet, Text, FlatList, ScrollView} from 'react-native';
import {CATEGORIES} from '../recettes/data/data';
import CategoryCube from '../components/CategoryCube';

const CategoriesListScreen = ({navigation}) => {
  return (
    <View style={styles.main}>
      <FlatList
        data={CATEGORIES}
        renderItem={categorie => (
          <CategoryCube categorie={categorie.item} navigation={navigation} />
        )}
        keyExtractor={(_categorie, index) => {
          return index;
        }}
        numColumns={2}
        columnWrapperStyle={{justifyContent: 'center'}}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  main: {
    backgroundColor: '#f2f2f2',
    flex: 1,
  },
});

export default CategoriesListScreen;
