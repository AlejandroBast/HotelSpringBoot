package com.hotel.Hotel.domain;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservaTest {

    @Test
    @DisplayName("Debe confirmar una reserva en estado PENDIENTE y cambiar estado de habitación")
    void debeConfirmarReservaPendiente() {
        // Arrange
        Cliente cliente = new Cliente("Carlos Gómez", "carlos@correo.com");

        // Instanciamos la subclase concreta
        Habitacion habitacion = new HabitacionEstandar("101", 2, 100.0, 1);

        RangoFechas periodo = new RangoFechas(
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(4));
        Reserva reserva = new Reserva(cliente, habitacion, periodo);

        // Act
        reserva.confirmar();

        // Assert
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertEquals(EstadoHabitacion.OCUPADA, habitacion.getEstado());
    }

    @Test
    @DisplayName("Verifica que al cancelar una reserva esta pasa a ser CANCELADA y la habitacion se habilita")
    void cancelarReserva() {

        Cliente tCliente = new Cliente("Carlos Gómez", "carlos@correo.com");
        Habitacion tHabitacion = new HabitacionEstandar("101", 2, 100.0, 1);
        RangoFechas tPeriodo = new RangoFechas(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(4));
        Reserva tReserva = new Reserva(tCliente, tHabitacion, tPeriodo);

        tReserva.confirmar();
        tReserva.cancelar();

        assertEquals(EstadoReserva.CANCELADA, tReserva.getEstado());
        assertEquals(EstadoHabitacion.DISPONIBLE, tHabitacion.getEstado());

    }

    @Test
    @DisplayName("una reserva nueva nace en estado pendiente")
    void crearReservaNueva() {
        Cliente tCliente = new Cliente("Carlos Gómez", "carlos@correo.com");
        Habitacion tHabitacion = new HabitacionEstandar("101", 2, 100.0, 1);
        RangoFechas tPeriodo = new RangoFechas(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(4));
        Reserva tReserva = new Reserva(tCliente, tHabitacion, tPeriodo); 

        assertEquals(EstadoReserva.PENDIENTE, tReserva.getEstado());
    }

}