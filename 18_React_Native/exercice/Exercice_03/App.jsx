import React from 'react';
import {View, StyleSheet} from 'react-native';
import CalcExercice3 from './src/components/exercice3/CalcExercice3';

const App = () => {
    return (
        <View style={styles.flex1}>
            <CalcExercice3/>
        </View>
    );
}

const styles = StyleSheet.create({
    flex1: {
        flex: 1
    }
})

export default App;
