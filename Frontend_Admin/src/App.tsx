import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LandingPage from "./pages/LandingPage";
import SignIn from "./pages/SignIn";
import Navbar from "./components/Navbar";
import Claims from "./pages/AdminClaims";
import UserClaims from "./pages/UserClaims";

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
    component: UserClaims,
    title : "User Claim"
  },
  {
    path: "/admin_claim",
    component: Claims,
    title : "Admin Claim"
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
