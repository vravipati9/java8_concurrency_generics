package java8;

public class SortByUsing2Properties {
    /*
    list.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
     */

    /*
    public class MyObject {
    public String getString() { ... }
    public Date getDate() { ... }
    ...
}
    public int compare(Object obj1, Object obj2) {
        MyObject myObj1 = (MyObject)obj1;
        MyObject myObj2 = (MyObject)obj2;
        stringResult = myObj1.getString().compareTo(myObj2.getString());
        if (stringResult == 0) {
            // Strings are equal, sort by date
            return myObj1.getDate().compareTo(myObj2.getDate());
        }
        else {
            return stringResult;
        }
    }
     */
}
