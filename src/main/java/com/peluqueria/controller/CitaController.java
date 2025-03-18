package com.peluqueria.controller;

import com.peluqueria.model.Cita;
import com.peluqueria.model.Peluquera;
import com.peluqueria.model.Usuario;
import com.peluqueria.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> listarCitas() {
        return citaService.listarCitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarPorId(@PathVariable Long id) {
        Optional<Cita> cita = citaService.buscarPorId(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Cita> listarCitasPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario(usuarioId); // ✅ Usa el constructor correcto
        return citaService.listarCitasPorUsuario(usuario);
    }

    @GetMapping("/peluquera/{peluqueraId}")
    public List<Cita> listarCitasPorPeluquera(@PathVariable Long peluqueraId) {
        Peluquera peluquera = new Peluquera(peluqueraId); // ✅ Usa el constructor correcto
        return citaService.listarCitasPorPeluquera(peluquera);
    }

    @PostMapping
    public ResponseEntity<Cita> agendarCita(@RequestBody Cita cita) {
        if (citaService.existeCita(cita.getPeluquera(), cita.getFechaHora())) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(citaService.agendarCita(cita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarCita(@PathVariable Long id) {
        citaService.cancelarCita(id);
        return ResponseEntity.noContent().build();
    }
}
