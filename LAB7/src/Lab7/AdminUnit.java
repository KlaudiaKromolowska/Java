package Lab7;

import java.util.List;

public class AdminUnit {
    String name;
    int adminLevel;
    double population;
    double area;
    double density;
    AdminUnit parent;
    BoundingBox bbox = new BoundingBox();
    List<AdminUnit> children;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");
        sb.append("admin level: ").append(adminLevel).append("; ");
        sb.append("population: ").append(population).append("; ");
        sb.append("area: ").append(area).append("; ");
        sb.append("density: ").append(density).append("; ");
        return sb.toString();
    }

    void fixMissingValues() {
        if (density == 0) {
            if (parent != null && parent.density == 0)
                parent.fixMissingValues();
            this.density = parent.density;
        }
        if (population == 0)
            population = area*density;
    }
}