import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LandingPage from "./pages/LandingPage";
import SignIn from "./pages/SignIn";
import Navbar from "./components/Navbar";
import Claims from "./pages/Claims";

const routes = [
  {
    path: "/",
    component: LandingPage,
    title : "Home"
  },
  {
    path: "/sign-in",
    component: SignIn,
    title : "Sign in"
  },
  {
    path: "/claim",
    component: Claims,
    title : "Claims"
  }
];

function App() {
  return (
    <Router>
      <Routes>
        {routes.map((route, index) => {
          return (
            <Route
              key={index}
              path={route.path}
              element={
                <>
                  <Navbar routes={routes}/>
                  {<route.component />}
                </>
              }
            ></Route>
          );
        })}
      </Routes>
    </Router>
  );
}

export default App
