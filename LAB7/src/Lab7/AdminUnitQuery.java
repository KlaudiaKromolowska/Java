package Lab7;
import java.util.function.Predicate;
import java.util.Comparator;

public class AdminUnitQuery {
    AdminUnitList src;
    Predicate<AdminUnit> p = a->true;
    Comparator<AdminUnit> cmp;
    int limit = Integer.MAX_VALUE;
    int offset = 0;

    AdminUnitQuery selectFrom(AdminUnitList src){
        this.src = src;
        return this;
    }
    AdminUnitQuery where(Predicate<AdminUnit> pred){
        p = pred;
        return this;
    }
    AdminUnitQuery or(Predicate<AdminUnit> pred){
        p = p.or(pred);
        return this;
    }
    AdminUnitQuery limit(int limit){
        this.limit = limit;
        return this;
    }
    AdminUnitQuery offset(int offset){
        this.offset = offset;
        return this;
    }
    AdminUnitList execute(){
        return src.filter(p, offset, limit);
    }
}