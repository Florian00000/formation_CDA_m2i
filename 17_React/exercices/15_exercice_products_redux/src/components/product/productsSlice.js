import {createSlice} from "@reduxjs/toolkit"

const productsSlice = createSlice({
    name: "product",
    initialState: {
        products: []
    },
    reducers: {
        addProduct: (state, action) => {            
            
            state.products.push(action.payload)
        },
        deleteProduct: (state, action) => {
            state.products = state.products.filter((product) => product.id !== action.payload);
        },
        updateProduct: (state, action) => {
            const product = state.products.find((product) => product.id === action.payload.id);
            product.name = action.payload.name;
            product.description = action.payload.description;
        }
    }
});

export const { addProduct, deleteProduct, updateProduct } = productsSlice.actions;
export default productsSlice.reducer;