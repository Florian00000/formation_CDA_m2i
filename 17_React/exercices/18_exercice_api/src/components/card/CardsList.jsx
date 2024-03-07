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
  
  
  useEffect(() => {
      if (!idPage) {
        idPage = 1;
        navigate("/1")
      }
    
    dispatch(fetchAllCards(+idPage));
  }, [idPage]);

  const idPageRef = useRef();  

  const redirect = (e) => {
    e.preventDefault();    
    navigate(`/${idPageRef.current.value}`);
  };


  return (
    <>
      {!!cards.length && (
        <main>
          <section>
            <button onClick={() => navigate(`/${--idPage}`)}>{"<<"}</button>
            <form onSubmit={redirect}>
              <input type="text" defaultValue={idPage} ref={idPageRef} />
            </form>
            <button onClick={() => navigate(`/${++idPage}`)}>{">>"}</button>
          </section>

          <section className="d-flex flex-wrap">
            {cards.map((card, index) => (
              <CardDetails card={card} key={index} />
            ))}
          </section>

          <section>
            <button onClick={() => navigate(`/${--idPage}`)}>{"<<"}</button>
            <form onSubmit={redirect}>
            <input type="text" defaultValue={idPage} ref={idPageRef}/>
            </form>
            <button onClick={() => navigate(`/${++idPage}`)} >{">>"}</button>
            </section>
        </main>
      )}
    </>
  );
};

export default CardsList;
