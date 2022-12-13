package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * class Wolf for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 1.0.0
 */
@JsonDeserialize(builder = lab1.Wolf.Builder.class)
public class Wolf extends lab1.Animal {
    /**
     * Internal attribute: color is color of wolf
     */
    protected String color;
    /**
     * Getter method
     * @return color
     */
    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Wolf: \n"
                + "    Name: " + name + '\n'
                + "    Sex: " + sex + '\n'
                + "    Age: " + age + " y.o\n"
                + "    Color: " + color + '\n';
    }
    /**
     * equals is override method for class Animals
     * <p>
     * @param o is object that is compared to the current object
     * @return true if wolves is equals or false if wolves isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Wolf animal = (Wolf) o;

        if (getAge() != animal.getAge()) {
            return false;
        } else if (!getSex().equals(animal.getSex())) {
            return false;
        } else if (!getColor().equals(animal.getColor())) {
            return false;
        } else return getName().equals(animal.getName());
    }
    public static class Builder {
        private final Wolf newWolf;

        public Builder() {
            newWolf = new Wolf();
        }

        public Builder withName(String name){
            newWolf.name = name;
            return this;
        }
        public Builder withSex(String sex){
            newWolf.sex = sex;
            return this;
        }
        public Builder withAge(int age){
            newWolf.age = age;
            return this;
        }
        public Builder withColor(String color){
            newWolf.color = color;
            return this;
        }
        public Wolf build(){
            return newWolf;
        }
    }
    /**
     * Setter method
     * @param name is name of wolf
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * addAge is method that increases age by one
     */
    public void addAge() {
        age = this.age + 1;
    }
    /**
     * Setter method
     * @param sex is sex of wolf
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * Setter method
     * @param color is color of wolf
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * voice is method which print line that wolf howls
     */
    public void voice() {
        System.out.print(name);
        System.out.println(" howls");
    }

    public static void main(String... strings) {
        Wolf animal1 = new Wolf.Builder()
                .withName("Virginia")
                .withSex("Female")
                .withAge(6)
                .withColor("grey")
                .build();
        System.out.println(animal1);
        animal1.setColor("brown");
        System.out.println(animal1);
        animal1.eat("apple");
        animal1.run();
        animal1.setName("Laura");
        animal1.voice();
    }
}