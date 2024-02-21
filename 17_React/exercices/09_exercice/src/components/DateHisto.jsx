import React, { useState } from 'react';
import { DateHistoContext } from '../contexts/DateHistoContext';
import FormDateHisto from './FormDateHisto';

const DateHisto = () => {
    const [listDatesHisto, setListDatesHisto] = useState([])
    

    return (
        <>
        <DateHistoContext.Provider value={{listDatesHisto, setListDatesHisto }} >
            <FormDateHisto/>
        </DateHistoContext.Provider>
            
        </>
    );
}

export default DateHisto;
