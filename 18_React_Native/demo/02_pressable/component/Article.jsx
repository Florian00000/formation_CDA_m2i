import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function Article(props) {
  return (
    <View style={styles.articleItem}>
      <Button title={props.text} onPress={() => props.deleteArticle(props.id)} color={'#5e0acc'}/>
    </View>
  )
}

const styles = StyleSheet.create({
  articleItem: {
    margin : 8,
    padding: 8,
    borderRadius: 6,
    backgroundColor : '#5e0acc'
  }
})