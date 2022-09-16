package sixthchapter;

import java.io.Serializable;
import java.util.Optional;

// We can use `Optional` in getters, but not in setters as `Optional` is not serializable
public class OptionalInGettersAndSetters {
    public OptionalInGettersAndSetters(Manager boss) {
        this.boss = boss;
    }

    private static class Manager {
        private String name;

        public String getName() {
            return name;
        }
    }

    private Manager boss;

    public Optional<Manager> getBoss() {
        return Optional.ofNullable(boss);
    }

    public void setBoss(Optional<Manager> boss) {
        this.boss = boss.get(); // if serializable not required
    }
}
