import React, { Suspense } from "react";
import "./App.css";
import Generate from "./components/Generate/Generate.js";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <Suspense>
      <Router>
        <Routes>
          <Route exact path="/" Component={Generate} />
        </Routes>
      </Router>
    </Suspense>
  );
}

export default App;
