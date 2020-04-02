package Lab7;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Predicate;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();
    Map<Long, AdminUnit> idToUnit = new HashMap<>();
    Map<AdminUnit, Long> unitToParentId = new HashMap<>();
    Map<Long, List<AdminUnit>> parentIdToChildren = new HashMap<>();

    public void read(String filename) throws IOException {
        CSVReader reader = new CSVReader(filename);
        boolean hasParent = false;
        while(reader.next()) {
            AdminUnit adminu = new AdminUnit();
            adminu.name = reader.get("name");
            adminu.adminLevel = reader.getInt0("admin_level");
            adminu.population = reader.getDouble0("population");
            adminu.area = reader.getDouble0("area");
            adminu.density = reader.getDouble0("density");
            idToUnit.put(reader.getLong(0), adminu);
            try {
                hasParent = true;
                unitToParentId.put(adminu, reader.getLong("parent"));
            } catch (NumberFormatException e) {
                hasParent = false;
                unitToParentId.put(adminu, null);
            }
            if (hasParent) {
                try {
                    parentIdToChildren.get(reader.getLong("parent")).add(adminu);
                } catch (NullPointerException ex) {
                    List<AdminUnit> children = new ArrayList<>();
                    children.add(adminu);
                    parentIdToChildren.put(reader.getLong("parent"), children);
                }
            }
            units.add(adminu);
        }
        for (AdminUnit unit: units) {   //typ obiektu nazwa abiektu: tablica
            unit.parent = idToUnit.get(unitToParentId.get(unit));
        }
        for (long id: parentIdToChildren.keySet()) {
            idToUnit.get(id).children = parentIdToChildren.get(id);
        }
        fixMissingValues();
    }

    void list(PrintStream out) {
        for (AdminUnit unit: units)
            out.println(unit);
    }

    void list(PrintStream out, int offset, int limit) {
        for (int i=offset; i<limit; i+=1) {
            out.println(units.get(i));
        }
    }

    AdminUnitList selectByName(String pattern, boolean regex) {
        AdminUnitList ret = new AdminUnitList();
        for (AdminUnit unit: units) {
            if (regex) {
                if (unit.name.matches(pattern))
                    ret.units.add(unit);
            } else {
                if (unit.name.contains(pattern))
                    ret.units.add(unit);
            }
        }
        return ret;
    }
    private void fixMissingValues() {
        for (AdminUnit unit: units)
            unit.fixMissingValues();
    }

    AdminUnitList filter(Predicate<AdminUnit> pred, int offset, int limit) {
        AdminUnitList result = new AdminUnitList();

        for (int i=offset; i<units.size(); i++) {
            if (pred.test(units.get(i)) && result.units.size() < limit)
                result.units.add(units.get(i));
            else if (result.units.size() >= limit)
                break;
        }

        return result;
    }
}