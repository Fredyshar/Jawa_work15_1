package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 2500, "OVB", "LED", 300);
    Ticket ticket2 = new Ticket(2, 3700, "SVO", "AlA", 400);
    Ticket ticket3 = new Ticket(3, 12000, "ALA", "LED", 430);
    Ticket ticket4 = new Ticket(4, 1500, "LED", "SVO", 90);
    Ticket ticket5 = new Ticket(5, 3900, "SVO", "KZN", 120);

    @Test
    public void showAllTickets() {                          //показать все билеты
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));

    }

    @Test
    public void deleteExistingById() {                         //удалить по Id билет
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        repo.removeByIdTicket(2);

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }
}
