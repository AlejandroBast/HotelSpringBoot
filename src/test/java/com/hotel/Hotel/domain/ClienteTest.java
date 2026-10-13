package com.hotel.Hotel.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {
    @Test
    @DisplayName("verifiar que si se registran las penalizaciones")
    void registrarPenalizacionCliente() {
        Cliente clienteTest = new Cliente("pedro pascal", "pedro@pascal.com");
        clienteTest.registrarPenalizacion();
        clienteTest.registrarPenalizacion();
        assertEquals(2, clienteTest.getPenalizaciones());
    }

    @Test
    @DisplayName("Verifical  que al pasar el numero maximo de penalizaciones se desactiva al cliente")
    void sobrepasarLimitePenalizaciones() {
        Cliente clienteTest2 = new Cliente("juan chotazo", "juan@chotazo.com");
        clienteTest2.registrarPenalizacion();
        clienteTest2.registrarPenalizacion();
        clienteTest2.registrarPenalizacion();
        clienteTest2.registrarPenalizacion();

        assertEquals(false, clienteTest2.puedeRealizarReservas());
    }
}