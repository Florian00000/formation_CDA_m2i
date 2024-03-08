import React, { useEffect, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { fetchAllCards } from "./cardSlice";
import CardDetails from "./CardDetails";

const CardsList = () => {
  let { idPage } = useParams();
  const navigate = useNavigate();

  
  const dispatch = useDispatch();
  const cards = useSelector((state) => state.card.cards);
  const isPending = useSelector((state) => state.card.isPending);
  
  const idPageRef = useRef(idPage ||1);  
  
  useEffect(() => {
    if (!idPage) {
      idPage = 1;
      navigate("/1")
    }
    
    dispatch(fetchAllCards(+idPage));
  }, [idPage]);

  

  const redirect = (e) => {
    e.preventDefault();    
    navigate(`/${idPageRef.current.value}`);
  };

  const redirectClose = (newPage) => {    
    idPageRef.current.value = newPage;
    navigate(`/${newPage}`);
  }


  return (
    <>
      { isPending && ( <h3>Chargement en cours...</h3>)}

      {!!cards.length && (
        <main>
          <section>
            <button onClick={() => redirectClose(--idPage)}>{"<<"}</button>
            <form onSubmit={redirect}>
              <input type="text" defaultValue={idPage} ref={idPageRef} />
            </form>
            <button onClick={() =>redirectClose(++idPage)}>{">>"}</button>
          </section>

          <section className="d-flex flex-wrap">
            {cards.map((card, index) => (
              <CardDetails card={card} key={index} />
            ))}
          </section>
          
        </main>
      )}
    </>
  );
};

export default CardsList;
