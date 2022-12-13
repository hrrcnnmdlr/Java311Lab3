package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * class Duck for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 1.0.0
 */
@JsonDeserialize(builder = lab1.Duck.Builder.class)
public class Duck extends lab1.Animal {
    /**
     * Internal attribute: color is color of duck
     */
    protected String color;
    /**
     * Getter method
     * @return color
     */
    private String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Duck: \n"
                + "    Name: " + name + '\n'
                + "    Sex: " + sex + '\n'
                + "    Age: " + age + " y.o\n"
                + "    Color: " + color + '\n';
    }
    /**
     * equals is override method for class Animals
     * <p>
     * @param o is object that is compared to the current object
     * @return true if ducks is equals or false if ducks isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Duck animal = (Duck) o;

        if (getAge() != animal.getAge()) {
            return false;
        } else if (!getSex().equals(animal.getSex())) {
            return false;
        } else if (!getColor().equals(animal.getColor())) {
            return false;
        } else return getName().equals(animal.getName());
    }
    public static class Builder {
        private final Duck newDuck;

        public Builder() {
            newDuck = new Duck();
        }

        public Duck.Builder withName(String name) {
            newDuck.name = name;
            return this;
        }

        public Duck.Builder withSex(String sex) {
            newDuck.sex = sex;
            return this;
        }

        public Duck.Builder withAge(int age) {
            newDuck.age = age;
            return this;
        }

        public Duck.Builder withColor(String color) {
            newDuck.color = color;
            return this;
        }

        public Duck build() {
            return newDuck;
        }
    }
    /**
     * Setter method
     * @param color is color of duck
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * voice is method which print line that duck croaks
     */
    public void voice() {
        System.out.print(name);
        System.out.println(" croaks");
    }

    public static void main(String... strings) {
        Duck animal1 = new Duck.Builder()
                .withName("Donald")
                .withSex("Male")
                .withAge(6)
                .withColor("grey")
                .build();
        System.out.println(animal1);
        animal1.setColor("brown");
        System.out.println(animal1);
        animal1.eat("apple");
        animal1.run();
        animal1.setName("Mario");
        animal1.voice();
    }
}
