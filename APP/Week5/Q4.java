import java.util.ArrayList;

public class Q4 {
        private static class Room {
            private int roomNumber;
            private String type;
            private double price;
            private boolean available;

            public Room(int roomNumber, String type, double price) {
                this.roomNumber = roomNumber;
                this.type = type;
                this.price = price;
                this.available = true;
            }
        }

        private static class Customer {
            private String name;
            private String contact;

            public Customer(String name, String contact) {
                this.name = name;
                this.contact = contact;
            }
        }

        private static class Reservation {
            private Customer customer;
            private Room room;
            private String date;

            public Reservation(Customer customer, Room room, String date) {
                this.customer = customer;
                this.room = room;
                this.date = date;
            }
        }

        public static void main(String[] args) {
            Room[] rooms = {
                new Room(101, "Single", 100.0),
                new Room(102, "Double", 150.0)
            };

            ArrayList<Reservation> reservations = new ArrayList<>();

            // Basic functionality demo
            Customer customer = new Customer("John Doe", "123-456-7890");
            if (rooms[0].available) {
                rooms[0].available = false;
                reservations.add(new Reservation(customer, rooms[0], "2023-12-25"));
            }
        }
}
