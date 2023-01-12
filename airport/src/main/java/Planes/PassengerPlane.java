<<<<<<< HEAD
package planes;
=======
package Planes;
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843

import java.util.Objects;

public class PassengerPlane extends Plane{

<<<<<<< HEAD
    private int passengersCapacity;

=======
    //=================FIELDS=================
    private int passengersCapacity;

    //=================CONSTRUCTORS=================
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

<<<<<<< HEAD
=======

    //=================METHODS=================
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

<<<<<<< HEAD
=======
//    @Override
//    public String toString() {
//        return super.toString().replace("}",
//                ", passengersCapacity=" + passengersCapacity +
//                        '}');
//    }

>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
