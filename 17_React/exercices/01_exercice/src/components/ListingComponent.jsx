import React from 'react';

const  ListingComponent = () => {
    const maListe = ["Alexandre", "Kiria", "yaourt", "<3"]

    return ( 
        <div>
            <h1>ListingComponent</h1>
            <hr />
            <ul>
                {maListe.map((prenom, index) => <li key={index}>{prenom}</li>)}
            </ul>
        </div>
     );
}
 
export default ListingComponent;