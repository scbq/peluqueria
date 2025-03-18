import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav className="bg-blue-500 p-4 text-white shadow-md">
      <div className="container mx-auto flex justify-between">
        <h1 className="text-lg font-bold">Peluquería</h1>
        <div>
          <Link to="/" className="mx-2 hover:underline">Login</Link>
          <Link to="/usuarios" className="mx-2 hover:underline">Usuarios</Link>
        </div>
      </div>
    </nav>
  );
}