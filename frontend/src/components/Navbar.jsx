import { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../context/AuthContext";

export default function Navbar() {
  const { user, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  return (
    <nav className="bg-blue-600 p-4 text-white shadow-md">
      <div className="container mx-auto flex justify-between items-center">
        <h1 className="text-xl font-bold">Peluquería</h1>
        <div className="space-x-4">
          {user?.role === "ADMIN" && (
            <>
              <Link to="/admin" className="hover:underline">
                Dashboard
              </Link>
              <Link to="/usuarios" className="hover:underline">
                Usuarios
              </Link>
            </>
          )}
          <Link to="/calendario" className="hover:underline">
            Calendario
          </Link>
          <button
            onClick={handleLogout}
            className="bg-red-500 hover:bg-red-600 px-3 py-1 rounded text-white"
          >
            Cerrar sesión
          </button>
        </div>
      </div>
    </nav>
  );
}
