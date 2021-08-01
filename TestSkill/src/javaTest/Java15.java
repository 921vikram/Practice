package javaTest;

public class Java15 {
/**
 * public sealed interface Service permits Car, Truck {
 *
 *     int getMaxServiceIntervalInMonths();
 *
 *     default int getMaxDistanceBetweenServicesInKilometers() {
 *         return 100000;
 *     }
 *
 * }
 *
 *
 * public abstract sealed class Vehicle permits Car, Truck {
 *
 *     protected final String registrationNumber;
 *
 *     public Vehicle(String registrationNumber) {
 *         this.registrationNumber = registrationNumber;
 *     }
 *
 *     public String getRegistrationNumber() {
 *         return registrationNumber;
 *     }
 *
 * }
 *
 * public final class Truck extends Vehicle implements Service {
 *
 *     private final int loadCapacity;
 *
 *     public Truck(int loadCapacity, String registrationNumber) {
 *         super(registrationNumber);
 *         this.loadCapacity = loadCapacity;
 *     }
 *
 *     public int getLoadCapacity() {
 *         return loadCapacity;
 *     }
 *
 *     @Override
 *     public int getMaxServiceIntervalInMonths() {
 *         return 18;
 *     }
 *
 * }
 *
 * public non-sealed class Car extends Vehicle implements Service {
 *
 *     private final int numberOfSeats;
 *
 *     public Car(int numberOfSeats, String registrationNumber) {
 *         super(registrationNumber);
 *         this.numberOfSeats = numberOfSeats;
 *     }
 *
 *     public int getNumberOfSeats() {
 *         return numberOfSeats;
 *     }
 *
 *     @Override
 *     public int getMaxServiceIntervalInMonths() {
 *         return 12;
 *     }
 *
 * }
 *
 *
 *
 * if (vehicle instanceof Car car) {
 *     return car.getNumberOfSeats();
 * } else if (vehicle instanceof Truck truck) {
 *     return truck.getLoadCapacity();
 * } else {
 *     throw new RuntimeException("Unknown instance of Vehicle");
 * }
 *
 *
 *
 * public sealed interface Vehicle permits Car, Truck {
 *
 *     String getRegistrationNumber();
 *
 * }
 *
 * public record Car(int numberOfSeats, String registrationNumber) implements Vehicle {
 *
 *     @Override
 *     public String getRegistrationNumber() {
 *         return registrationNumber;
 *     }
 *
 *     public int getNumberOfSeats() {
 *         return numberOfSeats;
 *     }
 *
 * }
 *
 * public record Truck(int loadCapacity, String registrationNumber) implements Vehicle {
 *
 *     @Override
 *     public String getRegistrationNumber() {
 *         return registrationNumber;
 *     }
 *
 *     public int getLoadCapacity() {
 *         return loadCapacity;
 *     }
 *
 * }
 *
 *
 *
 *
 *
 *
 *
 *
 */

}
