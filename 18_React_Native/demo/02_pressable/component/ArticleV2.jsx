import { Button, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function ArticleV2(props) {


  function messageConsole(){
    console.log("appuie sur le pressable")
    props.deleteArticle(props.id)
  }

  return (
    <Pressable onPress={messageConsole}>
    <View style={styles.articleItem}>
    {/* <Button title={props.text} onPress={() => props.deleteArticle(props.id)} color={'#5e0acc'}/> */}
    <Text style={styles.articleText}>{props.text}</Text>
  </View>
  </Pressable>
  )
}

const styles = StyleSheet.create({
  articleItem: {
    margin : 8,
    padding: 8,
    borderRadius: 6,
    backgroundColor : '#5e0acc'
  },
  articleText: {
    color: "white",
    textAlign: "center",
    fontSize: 18,
    fontWeight: "bold"
  }
})