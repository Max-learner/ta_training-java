package planes;

import models.ClassificationLevel;
import models.ExperimentalPlaneTypes;

public class ExperimentalPlane extends Plane{
    // test comment
    private ExperimentalPlaneTypes planeType;
    private ClassificationLevel planeClassificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.planeType = type;
        this.planeClassificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return planeClassificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.planeClassificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model = '" + getModel() + '\'' +
                '}';
    }
}
