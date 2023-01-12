<<<<<<< HEAD
package planes;
=======
package Planes;
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843

import models.ClassificationLevel;
import models.ExperimentalPlaneTypes;

<<<<<<< HEAD
public class ExperimentalPlane extends Plane{
=======
public class experimentalPlane extends Plane{
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843

    private ExperimentalPlaneTypes planeType;
    private ClassificationLevel planeClassificationLevel;

<<<<<<< HEAD
    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneTypes type, ClassificationLevel classificationLevel) {
=======
    public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneTypes type, ClassificationLevel classificationLevel) {
>>>>>>> 2bedb236a3ff0ef6451ce0aac69e57795887d843
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
