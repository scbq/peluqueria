import { useContext } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import {
  FaUsers,
  FaCalendarAlt,
  FaClipboardList, // ✅ en lugar de FaScissors
  FaSignOutAlt,
} from "react-icons/fa";

export default function AdminDashboard() {
  const { logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  const goTo = (path) => {
    navigate(path);
  };

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <h1 className="text-3xl font-bold mb-6 text-center text-blue-700">
        Panel de Administrador
      </h1>

      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 max-w-5xl mx-auto">
        <div
          onClick={() => goTo("/usuarios")}
          className="bg-white p-6 rounded-lg shadow hover:shadow-lg transition cursor-pointer text-center"
        >
          <FaUsers className="text-4xl mx-auto text-blue-500 mb-3" />
          <h2 className="text-lg font-semibold">Gestión de Usuarios</h2>
        </div>

        <div
          onClick={() => goTo("/citas")}
          className="bg-white p-6 rounded-lg shadow hover:shadow-lg transition cursor-pointer text-center"
        >
          <FaClipboardList className="text-4xl mx-auto text-green-500 mb-3" />
          <h2 className="text-lg font-semibold">Ver Citas</h2>
        </div>

        <div
          onClick={() => goTo("/calendario")}
          className="bg-white p-6 rounded-lg shadow hover:shadow-lg transition cursor-pointer text-center"
        >
          <FaCalendarAlt className="text-4xl mx-auto text-purple-500 mb-3" />
          <h2 className="text-lg font-semibold">Calendario</h2>
        </div>

        <div
          onClick={handleLogout}
          className="bg-white p-6 rounded-lg shadow hover:shadow-lg transition cursor-pointer text-center"
        >
          <FaSignOutAlt className="text-4xl mx-auto text-red-500 mb-3" />
          <h2 className="text-lg font-semibold">Cerrar Sesión</h2>
        </div>
      </div>
    </div>
  );
}
