import React, { useRef, useState } from "react";
import { useDispatch } from "react-redux";
import { deleteProduct, updateProduct } from "./productsSlice";

const ProductItem = (props) => {
  const product = props.product;
  const [editForm, setEditForm] = useState(false);

  const nameRef = useRef();
    const descriptionRef = useRef();

  const dispatch = useDispatch();

  const deleteButton = () => {
    dispatch(deleteProduct(product.id));
  };

  const editButton = () => {
    const updatedProduct = {...product, name:nameRef.current.value, description: descriptionRef.current.value}
    dispatch(updateProduct(updatedProduct));
    setEditForm(false)
  }

  return (
    <tr>
      {editForm === false ? (
        <>
          <td>{product.name} </td>
          <td> {product.description}</td>
          <td>
            <button className="btn btn-success w-100" onClick={() => setEditForm(true)}>Editer</button>
            </td>

            <button className="btn btn-danger w-100 ms-1" onClick={deleteButton}>Supprmier</button>
            <td>
          </td>
        </>
      ) : (
        <>
             <td>                
                <input type="text" id='name' className="form-control bg-dark text-light" ref={nameRef} defaultValue={product.name} />
            </td>
            <td>                
                <input type="text" id='description' className="form-control bg-dark text-light" ref={descriptionRef} defaultValue={product.description} />
            </td>
            <td>
            <button className="btn btn-success w-100" onClick={editButton}>Valider</button>
          </td>
          <td>

            <button className="btn btn-danger w-100 ms-1" onClick={deleteButton}>Supprmier</button>
          </td>
        </>
      )}
    </tr>
  );
};

export default ProductItem;
