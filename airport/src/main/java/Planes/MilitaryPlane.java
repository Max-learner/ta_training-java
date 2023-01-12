<<<<<<< HEAD
package planes;
=======
package Planes;
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843

import models.MilitaryPlainTypes;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryPlainTypes planeType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlainTypes type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.planeType = type;
    }

    public MilitaryPlainTypes getPlaneType() {
        return planeType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + planeType +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        return planeType == ((MilitaryPlane) o).getPlaneType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planeType);
    }
}
