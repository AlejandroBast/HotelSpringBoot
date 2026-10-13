package com.hotel.Hotel.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}