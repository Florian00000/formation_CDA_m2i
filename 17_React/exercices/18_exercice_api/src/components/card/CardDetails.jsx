import React from 'react';

const CardDetails = (props) => {
    const {card} = props;
   
    return (
        <div className='card' style={{width: "18rem"}}>
            <img src={card.imageUrl} className='card-img-top' alt="" />
            <div className='card-body'>            
            <h5 className='card-title'>{card?.name} </h5>
            <p className='card-text'>Edition: {card?.setName} </p>
            </div>
        </div>
    );
}

export default CardDetails;
