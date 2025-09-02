
import java.util.*;

class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
        this.maxOccupancy = maxOccupancy;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public int getMaxOccupancy() { return maxOccupancy; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}

class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory;
    private int bookingCount;

    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[10];
        this.bookingCount = 0;
    }

    public String getGuestId() { return guestId; }
    public String getGuestName() { return guestName; }
    public void addBooking(String bookingId) {
        if (bookingCount < bookingHistory.length) {
            bookingHistory[bookingCount++] = bookingId;
        }
    }
}

class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    private static int totalBookings = 0;
    private static double hotelRevenue = 0.0;
    private static String hotelName = "Default Hotel";

    public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = 0.0;
        totalBookings++;
    }

    public boolean makeReservation() {
        if (!room.isAvailable()) {
            System.out.println("Room not available.");
            return false;
        }
        room.setAvailable(false);
        guest.addBooking(bookingId);
        System.out.println("Reservation successful for " + guest.getGuestName() + " in room " + room.getRoomNumber());
        return true;
    }

    public void cancelReservation() {
        room.setAvailable(true);
        System.out.println("Reservation " + bookingId + " cancelled.");
    }

    public boolean checkAvailability() {
        return room.isAvailable();
    }

    public void calculateBill(int nights) {
        totalAmount = room.getPricePerNight() * nights;
        hotelRevenue += totalAmount;
        System.out.println("Total bill for booking " + bookingId + ": " + totalAmount);
    }

    // Static reporting methods
    public static double getOccupancyRate(Room[] rooms) {
        int occupied = 0;
        for (Room r : rooms) {
            if (!r.isAvailable()) occupied++;
        }
        return (rooms.length == 0) ? 0 : (double) occupied / rooms.length * 100;
    }

    public static double getTotalRevenue() {
        return hotelRevenue;
    }

    public static String getMostPopularRoomType(Booking[] bookings) {
        Map<String, Integer> typeCount = new HashMap<>();
        for (Booking b : bookings) {
            if (b != null) {
                String type = b.room.getRoomType();
                typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
            }
        }
        String popular = null;
        int max = 0;
        for (String type : typeCount.keySet()) {
            if (typeCount.get(type) > max) {
                max = typeCount.get(type);
                popular = type;
            }
        }
        return popular;
    }

    public static void setHotelName(String name) {
        hotelName = name;
    }
    public static String getHotelName() { return hotelName; }
}

public class Assignment3_YourName {
    public static void main(String[] args) {
        // Set hotel name
        Booking.setHotelName("Sunrise Hotel");

        // Create rooms
        Room[] rooms = {
            new Room("101", "Single", 100, 1),
            new Room("102", "Double", 150, 2),
            new Room("201", "Suite", 300, 4),
            new Room("202", "Double", 150, 2)
        };

        // Create guests
        Guest guest1 = new Guest("G001", "Alice", "1234567890", "alice@mail.com");
        Guest guest2 = new Guest("G002", "Bob", "0987654321", "bob@mail.com");

        // Bookings
        Booking[] bookings = new Booking[5];
        bookings[0] = new Booking("B001", guest1, rooms[0], "2025-09-01", "2025-09-03");
        bookings[1] = new Booking("B002", guest2, rooms[1], "2025-09-02", "2025-09-05");

        // Make reservations
        bookings[0].makeReservation();
        bookings[1].makeReservation();

        // Calculate bills
        bookings[0].calculateBill(2);
        bookings[1].calculateBill(3);

        // Cancel one reservation
        bookings[1].cancelReservation();

        // Reporting
        System.out.println("\nHotel Name: " + Booking.getHotelName());
        System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
        System.out.println("Total Revenue: " + Booking.getTotalRevenue());
        System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType(bookings));
    }
}
