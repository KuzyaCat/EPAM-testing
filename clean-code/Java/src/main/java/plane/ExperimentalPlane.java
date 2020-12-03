package plane;

import type.ClassificationLevel;
import type.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalType experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            ExperimentalType type,
            ClassificationLevel classificationLevel
    ) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ExperimentalPlane)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        ExperimentalPlane plane = (ExperimentalPlane) object;
        return experimentalType == plane.experimentalType && classificationLevel == plane.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + experimentalType +
                        ", classificationLevel=" + classificationLevel +
                        '}');
    }
}
