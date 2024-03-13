import { Button, FlatList, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import Article from './component/Article';
import ModalForm from './component/ModalForm';

export default function App() {

  const [modalIsVisible,setModalIsVisible] = useState(false);
  const [articles,setArticles] = useState([])

  function openModale(){
    setModalIsVisible(true)
  }

  function closeModale(){
    setModalIsVisible(false)
  }

  function addArticle(article){
    setArticles((articlesCurrent) => {
        return [...articlesCurrent,{ text : article , id: Math.random().toString()}]
    })
    closeModale() // setModalIsVisible(false)
  }

  function deleteArticle(id){
    setArticles((articlesCurrent) => {
      return articlesCurrent.filter((item) => item.id != id)
    })
  }


  return (
    <View style={styles.container}>
      <Text style={styles.title}>Ma liste de course :</Text>
      <FlatList
      data={articles}
      renderItem={(itemData) => {
        return(
          <Article text={itemData.item.text} id={itemData.item.id} deleteArticle={deleteArticle}/>
        )
      }}
      keyExtractor={(item,index) => {
        return item.id
      }}
      ListEmptyComponent={() => <Text style={styles.message}>Aucun article dans la liste</Text>}
      />
      <Button title='Ajouter article' onPress={openModale}/>
      <ModalForm visible={modalIsVisible} closeModale={closeModale} addArticle={addArticle}/> 
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 20,
    paddingHorizontal: 16,
    paddingBottom : 20,
  },
  title: {
    fontSize : 34,
    textAlign: 'center'
  },
  message : {
    textAlign: 'center',
    fontWeight: 'bold',
    fontSize: 20
  }

})