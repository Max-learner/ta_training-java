import Planes.experimentalPlane;
import models.MilitaryPlainTypes;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planesInAirport;

    public Airport(List<? extends Plane> planes) {
        this.planesInAirport = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> planesList = this.planesInAirport;
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planesList) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planesInAirport) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planesInAirport) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getPlaneType() == MilitaryPlainTypes.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getPlaneType() == MilitaryPlainTypes.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<MilitaryPlane> getFighterMilitaryPlanes() {
        List<MilitaryPlane> fighterMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getPlaneType() == MilitaryPlainTypes.FIGHTER) {
                fighterMilitaryPlanes.add(militaryPlane);
            }
        }
        return fighterMilitaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane plane : passengerPlanes) {
            if (plane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = plane;
            }
        }
        return planeWithMaxCapacity;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planesInAirport, new Comparator<Plane>() {
            public int compare(Plane planeA, Plane planeB) {
                return planeA.getMaxFlightDistance() - planeB.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planesInAirport, new Comparator<Plane>() {
            public int compare(Plane planeA, Plane planeB) {
                return planeA.getMaxSpeed() - planeB.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planesInAirport, new Comparator<Plane>() {
            public int compare(Plane planeA, Plane planeB) {
                return planeA.getMaxLoadCapacity() - planeB.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanesInAirport() {
        return planesInAirport;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planesInAirport.toString() +
                '}';
    }
}
