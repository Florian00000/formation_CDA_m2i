import './App.css'
import AddProduct from './components/product/AddProduct'
import ProductList from './components/product/ProductList'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  

  return (
    <main>
      <h1>Application de gestion de produits</h1>
      <AddProduct/>      
      <ProductList/>
    </main>
  )
}

export default App
