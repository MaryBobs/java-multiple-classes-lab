import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Station", 3);
        busStop = new BusStop("Castle");
        busStop.addPersonToQueue(person);
    }

    @Test
    public void busHasDestination(){
        assertEquals("Station", bus.getDestination());
    }

    @Test
    public void busHasCapacity(){
        assertEquals(3, bus.getCapacity());
    }

    @Test
    public void busStartsEmpty(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassengerToBus(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void cannotAddPassengerIfBusFull(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(3, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger();
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void busCanPickUpPassengers(){
        bus.pickUp(busStop);
        assertEquals(0, busStop.countQueue());
        assertEquals(1, bus.passengerCount());
    }
}

