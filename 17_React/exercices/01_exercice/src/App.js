import logo from './logo.svg';
import './App.css';
import FirstComponent from './components/FirstComponent';
import ListingComponent from './components/ListingComponent';
import TableRow from './components/TableRow';
import TableExercice1 from './components/TableExercice1';
import 'bootstrap/dist/css/bootstrap.min.css';
import DemoProps from './components/DemoProps';

function App() {
  return (
    <div className="App">

      <header className="App-header">
        <h1>J'aimerai avoir les cheveux d'Alexandre!!!</h1>
        <img src="./yaourt.jpg" className="App-logo" alt="logo" />
                
      <FirstComponent/>
      <ListingComponent/>   
      <TableRow/>   
      </header>

      <TableExercice1/>

      <DemoProps/>
    </div>
  );
}

export default App;
