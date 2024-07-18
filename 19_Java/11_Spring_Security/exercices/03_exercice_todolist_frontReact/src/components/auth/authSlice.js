import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import api from "../../services/api";
import { jwtDecode } from "jwt-decode";

export const postLogin = createAsyncThunk("auth/login", async (credentials) => {    
    const response = await api.post(`/auth/login`, credentials);
    const token = await response.data.data.token

    return token
}) 

const authSlice = createSlice({
    name: "auth",
    initialState: {      
        
        token: localStorage.getItem('token') || null,
        authMode: "Se connecter",
        user: null
    },
    reducers: {
        // setUser: (state, action) => {
        //     state.user = action.payload;
        // },
        // removeUser: (state, action) => {
        //     state.user = null;
        //     localStorage.removeItem("token");
        // },        
    },
    extraReducers: (builder) => {
        builder.addCase(postLogin.fulfilled, (state, actions) => {
            localStorage.setItem('token', actions.payload);
            state.token = actions.payload;
            console.log(actions.payload);
            state.user = jwtDecode(localStorage.getItem('token')) 
            console.log(state.user);
        })
    }
});

// export const { setUser, removeUser} = authSlice.actions;
export default authSlice.reducer