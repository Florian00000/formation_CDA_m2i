import React from "react";
import { useSelector } from "react-redux";
import ProductItem from "./ProductItem";

const ProductList = () => {
  const products = useSelector((state) => state.product.products);

  return (
    <>
      {!products.length && <p>Pas de produits enregistrés pour le moments</p>}
      {products.length && (
        <table className="w-100">
          <thead>
            <tr className="w-100">
              <th >Nom</th>
              <th >Description</th>
              <th colSpan={2} >Actions</th>
            </tr>
          </thead>
          <tbody>            
            {products.map((product, index) => (
              <ProductItem product={product} key={index} />
            ))}
          </tbody>
        </table>
      )}
    </>
  );
};

export default ProductList;
