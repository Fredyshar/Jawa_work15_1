package ru.netology;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    // public void add(Ticket ticket) {
    //     repo.save(ticket);
    // }

    public void add(Ticket ticket) {
        repo.save(ticket);

    }
    public Ticket[] searchByToAndFrom(String to, String from) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, to) || matches(ticket, from) ) {

                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }

        return result;
    }

    public Ticket[] searchBy(String text) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, text)) {

                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }

        return result;
    }

    public boolean matches(Ticket ticket, String search) {
        if (ticket.getFrom().contains(search)) {
            return true;
        } else if (ticket.getTo().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
//    public boolean matchesTo(Ticket ticket, String search) {
//        if (ticket.getTo().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
    }
    // public Ticket[] searchByfrom(String text) {
    //     Ticket[] result = new Ticket[0];

    //     for (Ticket ticket : repo.getTickets()) {
    //         if (matchesFrom(ticket, text)) {

    //             Ticket[] tmp = new Ticket[result.length + 1];
    //             for (int i = 0; i < result.length; i++) {
    //                 tmp[i] = result[i];
    //             }
    //             tmp[tmp.length - 1] = ticket;
    //             result = tmp;
    //         }

    //     }

    //     return result;
    // }

    // public Ticket[] searchByTo(String text) {
    //     Ticket[] result = new Ticket[0];

    //     for (Ticket ticket : repo.getTickets()) {
    //         if (matchesTo(ticket, text)) {

    //             Ticket[] tmp = new Ticket[result.length + 1];
    //             for (int i = 0; i < result.length; i++) {
    //                 tmp[i] = result[i];
    //             }
    //             tmp[tmp.length - 1] = ticket;
    //             result = tmp;
    //         }

    //     }

    //     return result;
    // }

    // public boolean matchesFrom(Ticket ticket, String search) {
    //     if (ticket.getFrom().contains(search)) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    // public boolean matchesTo(Ticket ticket, String search) {
    //     if (ticket.getTo().contains(search)) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }


