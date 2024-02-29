import { configureStore } from "@reduxjs/toolkit";
import productsSlice from "./components/product/productsSlice";

export default configureStore({
    reducer: {
        product: productsSlice,
    }
});