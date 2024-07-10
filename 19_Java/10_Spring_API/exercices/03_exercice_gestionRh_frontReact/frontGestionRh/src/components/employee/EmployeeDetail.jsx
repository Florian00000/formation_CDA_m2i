import React from 'react';

const EmployeeDetail = (props) => {
    const {employee} = props;

    return (
        <div>
            <p>prénom: {employee?.firstname} </p>
            <p>nom:  {employee?.lastname} </p>
            <p>poste: {employee?.occupation} </p>
        </div>
    );
}

export default EmployeeDetail;
