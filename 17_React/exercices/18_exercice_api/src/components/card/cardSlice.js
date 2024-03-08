import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from 'axios'

export const fetchAllCards = createAsyncThunk("cards/fetchAllCards", async (idPage) => {
    const response = await axios.get(`https://api.magicthegathering.io/v1/cards?page=${idPage}`, {
        params: {
            contains: "imageUrl",
            pageSize: 50
        }
    });
    const data = await response.data;

    // return data.cards.filter((card) => card.imageUrl);
    return data.cards
});

const cardSlice = createSlice({
    name:"card",
    initialState: {
        cards: [],
        isPending: false,
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchAllCards.fulfilled, (state, actions) => {
            state.isPending = false;
            state.cards = actions.payload;
            console.log(actions.payload);
        });
        builder.addCase(fetchAllCards.pending, (state, action) => {
            state.isPending = true;
        })
    }
})

export default cardSlice.reducer;