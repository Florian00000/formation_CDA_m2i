import { Button, Image, Modal, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useState } from 'react'

export default function ModalForm(props) {

  const [texteArticle,setTexteArticle] = useState('')

  function changeText(enteredText){
    setTexteArticle(enteredText)
  }



  return (
    <Modal visible={props.visible}>
    <View style={styles.container}>
      <Image  style={styles.image} source={require('./assets/caddie.png')} resizeMode='contain'/>
    
  
      <TextInput style={styles.textInput} placeholder='Ajouter votre article' onChangeText={changeText} value={texteArticle} />
 
    <View style={styles.buttonContainer}>
        <View style={styles.button}>
          <Button title='Ajouter article' onPress={() => props.addArticle(texteArticle)}/>
        </View>
        <View style={styles.button}>
          <Button title='cancel' onPress={props.closeModale} color="red"/>
        </View>
    </View>
    </View>
    </Modal>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },
  textInput: {
    borderWidth: 1,
    borderColor: '#cccccc',
    width: "70%",
    padding: 8,
    borderRadius: 12
  },
  buttonContainer: {
    marginTop: 16,
    flexDirection: 'row'
  },
  button : {
    width: "40%",
    height: 150
  },
  image : {
    width: 100,
    height: 150
  }
})