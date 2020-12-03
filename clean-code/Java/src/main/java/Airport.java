import plane.ExperimentalPlane;
import type.MilitaryType;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planeList;

    public Airport(List<? extends Plane> planesList) {
        this.planeList = planesList;
    }

    public List<? extends Plane> getPlanes() {
        return planeList;
    }

    public List<PassengerPlane> getPassengerPlaneList() {
        return this.planeList.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return this.planeList.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlaneList()
                .stream()
                .max(Comparator.comparing(PassengerPlane::getPassengersCapacity))
                .get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getType().equals(MilitaryType.TRANSPORT))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getType().equals(MilitaryType.BOMBER))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.planeList.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Airport sortByMaxDistance() {
        planeList.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planeList.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planeList.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }


    private void print(Collection<? extends Plane> planes) {
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planeList.toString() +
                '}';
    }
}
