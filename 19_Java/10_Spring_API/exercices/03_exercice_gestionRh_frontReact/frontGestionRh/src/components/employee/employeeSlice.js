import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from 'axios'

export const fetchAllEmployee = createAsyncThunk("employee/fetchAllEmployee", async () => {
    const response = await axios.get(`http://localhost:8080/api/employee`);
    const data = await response.data;
    
    return data
});

const employeeSlice = createSlice({
    name:"employee",
    initialState: {
        employees: [],
        isPending: false,
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchAllEmployee.fulfilled, (state, actions) => {
            state.isPending = false;
            state.employees = actions.payload;
            console.log(actions.payload);
        });
        builder.addCase(fetchAllEmployee.pending, (state, action) => {
            state.isPending = true;
        })
    }
})

export default employeeSlice.reducer;