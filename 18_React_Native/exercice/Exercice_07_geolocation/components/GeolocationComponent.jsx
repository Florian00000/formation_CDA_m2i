import React, { useEffect, useLayoutEffect, useState } from 'react';
import {View, StyleSheet, Text, Button} from 'react-native';
import Geolocation from '@react-native-community/geolocation'

import { fetchPosition } from '../config';

const GeolocationComponent = () => {

    const [latitude, setLatitude] = useState(null);
    const [longitude, setLongitude] = useState(null); 

    const [position, setPosition] = useState(null);

    useEffect(() => {
        Geolocation.requestAuthorization()
        Geolocation.getCurrentPosition(position => {
           setLatitude(position.coords.latitude)
           setLongitude(position.coords.longitude)            
        },
        error => console.log(error),
        {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000}
        )
        
    },[])

    const testFunction = async() => {
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
            <Button title='Actualiser' onPress={testFunction}/>
        </View>
    );
}

const styles = StyleSheet.create({})

export default GeolocationComponent;
