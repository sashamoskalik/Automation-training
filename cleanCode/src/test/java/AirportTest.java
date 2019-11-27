import airport.Airport;
import planes.ExperimentalPlane;
import types.ClassificationLevel;
import types.ExperimentalTypes;
import types.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class AirportTest {

    private Airport airport = new Airport(planes);

    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void isMilitaryPlaneIsTransport() {
        Assert.assertTrue(airport.getTransportMilitaryPlanes().stream().allMatch(militaryPlane -> MilitaryType.TRANSPORT.equals(militaryPlane.getType())));
    }

    @Test
    public void isAirportHasMaxPassengerCapacity() {
        logger.log(Level.INFO, "TEST testGetPassengerPlaneWithMaxCapacity started!");
        Assert.assertEquals(new Airport(planes).getPassengerPlaneWithMaxPassengersCapacity(), planeWithMaxPassengerCapacity);
    }

    @Test
    public void testPlanesSortedByMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Assert.assertTrue(planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity()
                    <= planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity());
        }
    }

    @Test
    public void isAirportHasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean bomberPlanesExists = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                bomberPlanesExists = true;
            }
            Assert.assertTrue(bomberPlanesExists);
        }

    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        airport.getExperimentalPlanes().forEach(experimental ->
                Assert.assertNotSame(experimental.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED));
    }
}
