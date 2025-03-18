import { useEffect, useState } from "react";

export default function Usuarios() {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/usuarios")
      .then(response => response.json())
      .then(data => setUsuarios(data))
      .catch(error => console.error("Error al obtener usuarios:", error));
  }, []);

  return (
    <div className="p-6 max-w-4xl mx-auto">
      <h1 className="text-2xl font-bold text-center mb-4">Lista de Usuarios</h1>
      <ul className="bg-white shadow-md rounded-lg p-4">
        {usuarios.length > 0 ? (
          usuarios.map(user => (
            <li
              key={user.id}
              className="border-b last:border-none p-2 hover:bg-gray-50"
            >
              {user.nombre} {user.apellido} - {user.email}
            </li>
          ))
        ) : (
          <p className="text-center text-gray-500">No hay usuarios registrados.</p>
        )}
      </ul>
    </div>
  );
}
