import React from 'react';
import { useSelector } from 'react-redux';
import { Navigate, useNavigate } from 'react-router-dom';

const ProtectedRoute = (props) => {
    const navigate = useNavigate();
    const user = useSelector((state) => state.auth.user);

    if (user) {
        return (
            <>
               {props.children} 
            </>
        );
        
    } else {
        return <Navigate to={"/auth/login"}/>
    }
}

export default ProtectedRoute;
