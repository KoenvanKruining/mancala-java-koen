import "./App.css";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import { Header } from "../components/Header/Header";
import { About } from "./About";
import { Mancala } from "../components/Mancala/Mancala";

export default function App() {
  return (
    <Router>
      <Header />

      <div className="main-content">
        <Routes>
          <Route path="/about" element={<About />} />
          <Route path="/" element={<Mancala />} />
        </Routes>
      </div>
    </Router>
  );
}
