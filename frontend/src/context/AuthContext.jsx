import { createContext, useState, useEffect } from "react";

// Crear el contexto de autenticación
export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem("token") || null);
  const [role, setRole] = useState(localStorage.getItem("role") || null);

  // Función para iniciar sesión
  const login = (jwtToken, userRole) => {
    setToken(jwtToken);
    setRole(userRole);
    localStorage.setItem("token", jwtToken);
    localStorage.setItem("role", userRole);
  };

  // Función para cerrar sesión
  const logout = () => {
    setToken(null);
    setRole(null);
    localStorage.removeItem("token");
    localStorage.removeItem("role");
  };

  return (
    <AuthContext.Provider value={{ token, role, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};
