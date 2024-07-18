import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import api from "../../services/api";
import { jwtDecode } from "jwt-decode";

export const postLogin = createAsyncThunk("auth/login", async (credentials) => {    
    const response = await api.post(`/auth/login`, credentials);
    const token = await response.data.data.token

    return token
})

export const postRegisterUser = createAsyncThunk("auth/registerUser", async(credentials) => {
    const response = await api.post(`/auth/register/user`, credentials);
    const status = await response.status;
    return status
})

export const postRegisterAdmin = createAsyncThunk("auth/registerAdmin", async(credentials) => {
    const response = await api.post(`/auth/register/admin`, credentials);
    const status = await response.status;
    return status
})

const authSlice = createSlice({
    name: "auth",
    initialState: {      
        
        token: localStorage.getItem('token') || null,        
        user: null,
        registerSuccess: false
    },
    reducers: {
        permutRegisteSucces: (state, action) => {
            state.registerSuccess = !state.registerSuccess
        }
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
        });
        builder.addCase(postRegisterUser.fulfilled, (state, actions) => {
            console.log(actions.payload);
            if(actions.payload === 200){
                state.registerSuccess = true
            }            
        });
        builder.addCase(postRegisterAdmin.fulfilled, (state, actions) => {
            console.log(actions.payload);
            if(actions.payload === 200){
                state.registerSuccess = true
            }            
        });
    }
});

 export const { permutRegisteSucces} = authSlice.actions;
export default authSlice.reducer