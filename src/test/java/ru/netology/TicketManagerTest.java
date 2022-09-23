package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 2500, "OVB", "LED", 300);
    Ticket ticket2 = new Ticket(2, 3700, "SVO", "ALA", 400);
    Ticket ticket3 = new Ticket(3, 12000, "ALA", "LED", 430);
    Ticket ticket4 = new Ticket(4, 1500, "LED", "SVO", 90);
    Ticket ticket5 = new Ticket(5, 3900, "SVO", "KZN", 120);
    Ticket ticket6 = new Ticket(6, 500, "ALA", "OVB", 150);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }


    @Test
    public void searchByExistingAirport() {                     //поиск по названию аэропорта вылета/прилета

        Ticket[] expected = {ticket1, ticket3, ticket4};
        Ticket[] actual = manager.searchBy("LED");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByNonExistingAirport() {                     //поиск по названию не существующего аэропорта

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("AMF");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByExistingAirportDifferentOrder() {                     //поиск по названию аэропорта вылета/прилета (Другой порядок)

//
//        TicketRepository repo = new TicketRepository();
//        Arrays.sort(Ticket[get]);
//        Ticket[] expected = {ticket2, ticket3, ticket6};
//        Ticket[] actual = manager.searchBy("ALA");
//        Assertions.assertArrayEquals(expected, actual);
    }
}
