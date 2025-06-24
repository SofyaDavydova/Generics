import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {


    //Тесты для CompareTo
    @Test
    public void ShouldFirstTicketBeLessThanSecond() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Москва",
                5_000,
                10,
                11
        );

        Ticket ticket2 = new Ticket(
                "Самара",
                "Иркутск",
                12_000,
                7,
                11
        );

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(1, ticket2.compareTo(ticket1));
    }

    @Test
    public void ShouldFirstTicketBeMoreThanSecond() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Екаьеринбург",
                10_000,
                19,
                21
        );

        Ticket ticket2 = new Ticket(
                "Самара",
                "Саратов",
                4_000,
                22,
                23
        );

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(-1, ticket2.compareTo(ticket1));
    }

    @Test
    public void ShouldTicketsBeEqual() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Москва",
                5_000,
                10,
                11
        );

        Ticket ticket2 = new Ticket(
                "Самара",
                "Казань",
                5_000,
                7,
                8
        );

        Assertions.assertEquals(0, ticket1.compareTo(ticket2));
        Assertions.assertEquals(0, ticket2.compareTo(ticket1));
    }

    //Тест для search
    @Test
    public void ShouldSortSearchedTickets() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Москва",
                5_000,
                10,
                11
        );

        Ticket ticket2 = new Ticket(
                "Саратов",
                "Казань",
                5_000,
                7,
                8
        );

        Ticket ticket3 = new Ticket(
                "Самара",
                "Москва",
                12_000,
                7,
                11
        );

        Ticket ticket4 = new Ticket(
                "Самара",
                "Москва",
                10_000,
                19,
                20
        );

        Ticket ticket5 = new Ticket(
                "Москва",
                "Саратов",
                4_000,
                22,
                23
        );

        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        Ticket[] actual = tickets.search("Самара", "Москва");
        Ticket[] expected = {ticket1, ticket4, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    //Тесты для Comparator
    @Test
    public void ShouldFirstTicketTimeBeLessThanSecond() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Москва",
                5_000,
                10,
                11
        );

        Ticket ticket2 = new Ticket(
                "Самара",
                "Иркутск",
                12_000,
                7,
                11
        );

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Assertions.assertEquals(-1, timeComparator.compare(ticket1, ticket2));
        Assertions.assertEquals(1, timeComparator.compare(ticket2, ticket1));
    }

    @Test
    public void ShouldSecondTicketTimeBeLessThanFirst() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Новокузнецк",
                20_000,
                9,
                14
        );

        Ticket ticket2 = new Ticket(
                "Самара",
                "Екатеринбург",
                12_000,
                17,
                19
        );

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Assertions.assertEquals(1, timeComparator.compare(ticket1, ticket2));
        Assertions.assertEquals(-1, timeComparator.compare(ticket2, ticket1));
    }

    @Test
    public void ShouldTicketsTimeBeEqual() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Санкт-Петербург",
                13_000,
                9,
                11
        );

        Ticket ticket2 = new Ticket(
                "Самара",
                "Екатеринбург",
                12_000,
                17,
                19
        );

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Assertions.assertEquals(0, timeComparator.compare(ticket1, ticket2));
        Assertions.assertEquals(0, timeComparator.compare(ticket2, ticket1));
    }

    //тест для searchAndSortBy
    @Test
    public void ShouldSortSearchedAndSortedTickets() {

        Ticket ticket1 = new Ticket(
                "Самара",
                "Москва",
                5_000,
                10,
                12
        );

        Ticket ticket2 = new Ticket(
                "Саратов",
                "Казань",
                5_000,
                7,
                8
        );

        Ticket ticket3 = new Ticket(
                "Самара",
                "Москва",
                12_000,
                7,
                10
        );

        Ticket ticket4 = new Ticket(
                "Самара",
                "Москва",
                10_000,
                19,
                20
        );

        Ticket ticket5 = new Ticket(
                "Москва",
                "Хабаровск",
                4_000,
                2,
                10
        );

        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = tickets.searchAndSortBy("Самара", "Москва", timeComparator);
        Ticket[] expected = {ticket4, ticket1, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }
}
