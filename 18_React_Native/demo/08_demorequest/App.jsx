import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import axios from 'axios'

export default function App() {



    function getApiWithFetch(){
        fetch("https://jsonplaceholder.typicode.com/users")
        .then(response => response.json())
        .then(data => console.log(data))
    }

    function getApiWithAxios(){
        axios.get("https://jsonplaceholder.typicode.com/users")
        .then(response => console.log(response.data))
        .catch(error => console.log(error))
    }




  return (
    <View>
      <Text>App</Text>
      <Button title='test Fetch' onPress={getApiWithFetch}/>
      <Button title='test Axios' onPress={getApiWithAxios} />
    </View>
  )
}

const styles = StyleSheet.create({})