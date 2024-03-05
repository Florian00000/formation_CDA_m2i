import React from 'react';
import { useSearchParams } from 'react-router-dom';

const AuthForm = () => {
    const [searchParams] = useSearchParams
    const mode = searchParams.get("mode")

    const authSubmit = (e) => {
        e.preventDefault();
    }
    return (        
        <>
        <form onSubmit={authSubmit}>

        </form>
        </>
    );
}

export default AuthForm;
