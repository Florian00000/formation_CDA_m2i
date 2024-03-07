import { configureStore } from "@reduxjs/toolkit";
import cardSlice from "./components/card/cardSlice";

export default configureStore({
    reducer: {
        card: cardSlice,
    }
})