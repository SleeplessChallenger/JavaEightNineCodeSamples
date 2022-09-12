package fifthchapter;

interface Company {
    default String getName() {
        return "Initech";
    }
}

interface Employee {
    String getFirst();

    String getLast();

    void convertCaffeineForMoney();

    default String getName() {
        return String.format("%s %s", getFirst(), getLast());
    }
}

// Initially two interfaces are not connected => `getName()` method will cause compilation error => use `super()` and leverage both
public class DefaultMethodConflict implements Company, Employee {
    private String firstName;
    private String lastName;

    @Override
    public void convertCaffeineForMoney() {
        System.out.println("Coding...");
    }

    @Override
    public String getFirst() {
        return "first";
    }

    @Override
    public String getLast() {
        return "last";
    }

    @Override
    public String getName() {
        return String.format(
                "%s %s", Company.super.getName(), Employee.super.getName()
        );
    }
}
