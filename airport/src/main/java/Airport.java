<<<<<<< HEAD
import planes.ExperimentalPlane;
import models.MilitaryPlainTypes;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

import static java.util.Comparator.comparingInt;

=======
import Planes.experimentalPlane;
import models.MilitaryPlainTypes;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planesInAirport;

    public Airport(List<? extends Plane> planes) {
        this.planesInAirport = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
<<<<<<< HEAD
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planesInAirport) {
=======
        List<? extends Plane> planesList = this.planesInAirport;
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planesList) {
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

<<<<<<< HEAD
    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planesInAirport) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
=======
    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planesInAirport) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
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
<<<<<<< HEAD
        planesInAirport.sort(comparingInt(Plane::getMaxFlightDistance));
=======
        Collections.sort(planesInAirport, new Comparator<Plane>() {
            public int compare(Plane planeA, Plane planeB) {
                return planeA.getMaxFlightDistance() - planeB.getMaxFlightDistance();
            }
        });
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
        return this;
    }

    public Airport sortByMaxSpeed() {
<<<<<<< HEAD
        planesInAirport.sort(comparingInt(Plane::getMaxSpeed));
=======
        Collections.sort(planesInAirport, new Comparator<Plane>() {
            public int compare(Plane planeA, Plane planeB) {
                return planeA.getMaxSpeed() - planeB.getMaxSpeed();
            }
        });
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
<<<<<<< HEAD
        planesInAirport.sort(comparingInt(Plane::getMaxLoadCapacity));
=======
        Collections.sort(planesInAirport, new Comparator<Plane>() {
            public int compare(Plane planeA, Plane planeB) {
                return planeA.getMaxLoadCapacity() - planeB.getMaxLoadCapacity();
            }
        });
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
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
