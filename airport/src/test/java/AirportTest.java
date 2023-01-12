<<<<<<< HEAD
import planes.ExperimentalPlane;
=======
import Planes.experimentalPlane;
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
import models.ClassificationLevel;
import models.ExperimentalPlaneTypes;
import models.MilitaryPlainTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
<<<<<<< HEAD
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
=======
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlainTypes.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlainTypes.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlainTypes.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlainTypes.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlainTypes.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlainTypes.TRANSPORT),
<<<<<<< HEAD
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneTypes.VTOL, ClassificationLevel.TOP_SECRET)
=======
            new experimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new experimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneTypes.VTOL, ClassificationLevel.TOP_SECRET)
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
<<<<<<< HEAD
        boolean isTransportPlanesListNotEmpty = false;
        int transportPlanesCount = 0;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getPlaneType() == MilitaryPlainTypes.TRANSPORT)) {
                isTransportPlanesListNotEmpty = true;
                transportPlanesCount++;
            }
        }
        Assert.assertTrue(isTransportPlanesListNotEmpty);
        Assert.assertEquals(transportPlanesCount, transportMilitaryPlanes.size());
=======
        boolean flag = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getPlaneType() == MilitaryPlainTypes.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertEquals(flag, true);
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
<<<<<<< HEAD
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
=======
        System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void test3() {
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanesInAirport();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
<<<<<<< HEAD
        Assert.assertTrue(bomberMilitaryPlanes.size() >= 1);
=======
        boolean flag = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getPlaneType() == MilitaryPlainTypes.BOMBER)) {
                flag = true;
            }
            else {
                Assert.fail("Test failed!");
            }
        }
        // if not failed
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
<<<<<<< HEAD
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
=======
        List<experimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(experimentalPlane experimentalPlane : experimentalPlanes){
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
