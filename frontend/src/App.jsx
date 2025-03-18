import { useEffect, useState } from "react";

function App() {
    const [usuarios, setUsuarios] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/usuarios")
            .then(response => response.json())
            .then(data => setUsuarios(data));
    }, []);

    return (
        <div>
            <h1>Lista de Usuarios</h1>
            <ul>
                {usuarios.map(user => (
                    <li key={user.id}>{user.nombre} {user.apellido} - {user.email}</li>
                ))}
            </ul>
        </div>
    );
}

export default App;
