import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { BASE_DB_URL } from "../../firebaseConfig";
import axios from "axios";

export const fetchAlbums = createAsyncThunk("albums/fetchAlbums", async () => {
    const response = await axios.get(`${BASE_DB_URL}/albums.json`);
    const data = await response.data;    
    const albums = [];

    for (const key in data) {
        albums.push({ id:key, ...response.data[key]});
    } 

    return albums;
});

export const postAlbum = createAsyncThunk("albums/postAlbum", async (request) => {
    const response = await axios.post(`${BASE_DB_URL}/albums.json?auth=${request.token}`, request.album);
    const data = await response.data;        

    return {
        id: data.name,
        ...request.album,
    };
})

export const removeAlbum = createAsyncThunk("albums/deleteAlbum", async (request) => {
    const response = await axios.delete(`${BASE_DB_URL}/albums/${request.album.id}.json?auth=${request.token}`);
    console.log(response); 
    console.log(request.album);

    return request.album;
})

export const updateAlbum = createAsyncThunk("albums/updateAlbums", async (request) => {
    const response = await axios.put(`${BASE_DB_URL}/albums/${request.album.id}.json?auth=${request.token}`, request.album);
    console.log(response.data);
    return response.data
})

const albumSlice = createSlice({
    name: "album",
    initialState: {
        albums: [],        
    },
    reducers: {
        
    },
    extraReducers: (builder) => {
        builder.addCase(fetchAlbums.fulfilled, (state, action) => {
            state.albums = action.payload;
            console.log(action.payload);
        });
        builder.addCase(postAlbum.fulfilled, (state, action) => {
            state.albums.push(action.payload);
            console.log(action.payload);
        });
        builder.addCase(removeAlbum.fulfilled, (state, action) => {
            state.albums = state.albums.filter((album) => album.id !== action.payload.id)            
        });
        builder.addCase(updateAlbum.fulfilled, (state, action) => {
            const indexUpdate = state.albums.findIndex((album)=> album.id === action.payload.id);
            state.albums.splice(indexUpdate, 1, action.payload )            
        })
    }
});

export default albumSlice.reducer;
