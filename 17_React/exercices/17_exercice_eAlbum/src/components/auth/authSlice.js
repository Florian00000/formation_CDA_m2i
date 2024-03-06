import {createSlice} from "@reduxjs/toolkit";

const authSlice = createSlice({
    name: "auth",
    initialState: {      
        
        user: localStorage.getItem('token') || null,
        authMode: "Se connecter",
    },
    reducers: {
        setUser: (state, action) => {
            state.user = action.payload;
        },
        removeUser: (state, action) => {
            state.user = null;
            localStorage.removeItem("token");
        },
        
    }
});

export const { setUser, removeUser} = authSlice.actions;
export default authSlice.reducer