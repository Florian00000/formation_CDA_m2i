import React, { useState } from 'react';
import Modal from './modal/Modal';
import LoginForm from './auth/LoginForm';

const Header = () => {
    const [modalAuth, setModalAuth] = useState(false);

    const changeModal = () => {
        setModalAuth(!modalAuth)
    }

    return (
        <nav>
            <span>Header</span>
            <button onClick={changeModal}>Connexion</button>
            {modalAuth && <Modal changeModal={changeModal}> <LoginForm changeModal={changeModal}/> </Modal>}
        </nav>        
    );
}

export default Header;
