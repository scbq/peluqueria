import { BrowserRouter as Router, Route, Routes, useLocation } from "react-router-dom";
import { AuthProvider, AuthContext } from "./context/AuthContext";
import PrivateRoute from "./components/PrivateRoute";
import Login from "./pages/Login";
import Usuarios from "./pages/Usuarios";
import AdminDashboard from "./pages/AdminDashboard";
import Navbar from "./components/Navbar";
import { useContext } from "react";

function AppRoutes() {
  const location = useLocation();
  const { user } = useContext(AuthContext);

  const showNavbar = user && location.pathname !== "/";

  return (
    <>
      {showNavbar && <Navbar />}
      <Routes>
        <Route path="/" element={<Login />} />
        <Route element={<PrivateRoute />}>
          <Route path="/admin" element={<AdminDashboard />} />
          <Route path="/usuarios" element={<Usuarios />} />
          {/* Puedes agregar más rutas privadas aquí */}
        </Route>
      </Routes>
    </>
  );
}

function App() {
  return (
    <AuthProvider>
      <Router>
        <AppRoutes />
      </Router>
    </AuthProvider>
  );
}

export default App;
