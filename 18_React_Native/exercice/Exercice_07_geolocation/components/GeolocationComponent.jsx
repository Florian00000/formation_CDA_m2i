import React, { useEffect, useLayoutEffect, useState } from 'react';
import {View, StyleSheet, Text, Button} from 'react-native';
import Geolocation from '@react-native-community/geolocation';
import axios from "axios";

import { BASE_URL, API_KEY } from '../config';

const GeolocationComponent = () => {

    const [latitude, setLatitude] = useState(null);
    const [longitude, setLongitude] = useState(null); 

    const [position, setPosition] = useState(null);
    const [getPosion, setGetPosition] = useState(false);

    useEffect(() => {
        Geolocation.requestAuthorization()
        Geolocation.getCurrentPosition(position => {
           setLatitude(position.coords.latitude)
           setLongitude(position.coords.longitude)            
        },
        error => console.log(error),
        {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000}
        )
        
    },[getPosion])

    const fetchPosition = async (latitude, longitude) => {
        try {
            const response = await axios.get(`${BASE_URL}?apikey=${API_KEY}&q=${latitude},${longitude}&language=fr-fr&toplevel=true`)
            console.log(response.data);
            return response.data
        } catch (error) {
            console.error(error)
        }    
    }

    const actualizeCoords = () => {
        setGetPosition(!getPosion)
    } 

    const actualizePosition = async() => {
        setGetPosition(!getPosion)
        const data = await fetchPosition(latitude, longitude)
        setPosition(data)
    }

    return (
        <View>
            <Text>Latitude: {latitude} </Text>
            <Text>Longitude: {longitude} </Text>

            <View>
                <Text>Pays: {position?.Country?.LocalizedName}</Text>
                <Text>Ville: {position?.LocalizedName}</Text>
            </View>
            <Button title='Actualiser Coordonnées' onPress={actualizeCoords}/>
            <Text>test</Text>
            <Button title='Actualiser' onPress={actualizePosition}/>
        </View>
    );
}

const styles = StyleSheet.create({})

export default GeolocationComponent;
