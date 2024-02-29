import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

const BookDetail = () => {
    const {idlivre} = useParams();

    const [detailLivre, setDetailLivre] = useState();  
    const [auteur, setAuteur] = useState()

    useEffect(() => {
        axios.get(`https://openlibrary.org/books/${idlivre}.json`)
        .then((response) => {
            setDetailLivre(response.data)
        })
        .catch((error) => console.error(error))
    }, [])
    

    

   useEffect(() => {
    if (detailLivre) {
        
        axios.get(`https://openlibrary.org${detailLivre.authors[0].key}.json`)
        .then((response) => {
            setAuteur(response.data)
        })
        .catch((error) => console.error(error))
    }
   }, [detailLivre])

   console.log(detailLivre);


    return (
        <>
            {
                detailLivre && (
        <article>
            { detailLivre.covers[0] && (<img src={`https://covers.openlibrary.org/b/id/${detailLivre.covers[0]}-L.jpg`} alt="" />)}             
            <p>Titre: {detailLivre.title}</p>
            { auteur && ( <p>auteur: {auteur.name} </p>)}
            {/* { detailLivre.publish_date && ( <p>Date de la première publication: {detailLivre.publish_date} </p> ) } */}
            <p>Date de la première publication: {detailLivre?.publish_date} </p>
        </article>

                )
            }
        </>

    );
}

export default BookDetail;
