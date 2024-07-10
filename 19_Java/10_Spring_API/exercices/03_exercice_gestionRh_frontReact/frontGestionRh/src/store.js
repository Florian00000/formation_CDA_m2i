import { configureStore } from "@reduxjs/toolkit";
import employeeSlice from "./components/employee/employeeSlice";

export default configureStore({
    reducer: {
        employee: employeeSlice
    }
})