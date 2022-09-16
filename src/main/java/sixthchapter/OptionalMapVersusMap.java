package sixthchapter;

import java.util.Optional;

public class OptionalMapVersusMap {

    public static class Manager {
        private String name;

        public Manager(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Department {
        private Manager boss;

        public Optional<Manager> getBoss() {
            return Optional.ofNullable(boss);
        }

        public void setBoss(Manager boss) {
            this.boss = boss;
        }
    }

    public static class Company {
        private Department department;

        public Optional<Department> getDepartment() {
            return Optional.ofNullable(department);
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
    }

    public void callClassesAbove() {
        Manager mrSlate = new Manager("Mr. Slate");

        Department d = new Department();
        d.setBoss(mrSlate);
        System.out.println("Boss: " + d.getBoss());

        Department d1 = new Department();
        System.out.println("Boss " + d1.getBoss());

        //
        System.out.println("Name " +
                d.getBoss().orElse(new Manager("Unknown")).getName());
        System.out.println("Name: " +
                d1.getBoss().orElse(new Manager("Unknown")).getName());

        System.out.println("Name " + d.getBoss().map(Manager::getName));
        System.out.println("Name " + d1.getBoss().map(Manager::getName));
    }

    public static void main(String[] args) {
        Manager mrSlate = new Manager("Mr. Slate");
        Department d = new Department();
        d.setBoss(mrSlate);
        Company co = new Company();
        co.setDepartment(d);

        System.out.println("Company dept: " + co.getDepartment());

        System.out.println("Company dept manager: " + co.getDepartment()
                .map(Department::getBoss)); // map only executes if supplied is not null

        System.out.println(
                co.getDepartment()
                        .flatMap(Department::getBoss) // gives only single Optional instead of nested
                        .map(Manager::getName));

        // wrap Company in Optional as well
        Optional<Company> company = Optional.of(co);
        System.out.println(
                company
                    .flatMap(Company::getDepartment)
                    .flatMap(Department::getBoss)
                    .map(Manager::getName)
        );
    }
}
