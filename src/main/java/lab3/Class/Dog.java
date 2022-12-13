package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * class Dog for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 1.0.0
 */
@JsonDeserialize(builder = lab1.Dog.Builder.class)
public class Dog extends lab1.Wolf {
    /**
     * Internal attribute: isMongrel is a variable that indicates whether the dog is a mongrel
     */
    protected boolean isMongrel;
    /**
     * Getter method
     * @return isMongrel
     */
    private Boolean isMongrel() {
        return isMongrel;
    }
    @Override
    public String toString() {
        return "Dog: \n"
                + "    Name: " + name + '\n'
                + "    Sex: " + sex + '\n'
                + "    Age: " + age + " y.o\n"
                + "    Color: " + color + '\n'
                + "    Dog is a mongrel: " + isMongrel + '\n';
    }
    /**
     * equals is override method for class Wolf
     * <p>
     * @param o is object that is compared to the current object
     * @return true if dogs is equals or false if dogs isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Dog animal = (Dog) o;

        if (getAge() != animal.getAge()) {
            return false;
        } else if (!getSex().equals(animal.getSex())) {
            return false;
        } else if (!getColor().equals(animal.getColor())) {
            return false;
        } else if (!isMongrel().equals(animal.isMongrel())) {
            return false;
        } else return getName().equals(animal.getName());
    }
    public static class Builder {
        private final Dog newDog;

        public Builder() {
            newDog = new Dog();
        }


        public Dog.Builder withName(String name){
            newDog.name = name;
            return this;
        }
        public Dog.Builder withSex(String sex){
            newDog.sex = sex;
            return this;
        }
        public Dog.Builder withAge(int age){
            newDog.age = age;
            return this;
        }
        public Dog.Builder withColor(String color){
            newDog.color = color;
            return this;
        }
        public Dog.Builder isMongrel(Boolean isMongrel){
            newDog.isMongrel = isMongrel;
            return this;
        }
        public Dog build(){
            return newDog;
        }
    }
    /**
     * Setter method
     * @param isMongrel is a variable that indicates whether the dog is a mongrel
     */
    public void changeMongrel(Boolean isMongrel) {
        this.isMongrel = isMongrel;
    }
    /**
     * voice is override method which print line that dog howls and barks
     */
    @Override
    public void voice() {
        super.voice();
        System.out.print(name);
        System.out.println(" barks");
    }

    public static void main(String... strings) {
        Dog animal1 = new Dog.Builder()
                .withName("Virginia")
                .withSex("Female")
                .withAge(6)
                .withColor("grey")
                .isMongrel(false)
                .build();
        System.out.println(animal1);
        animal1.changeMongrel(true);
        System.out.println(animal1);
        animal1.eat("apple");
        animal1.run();
        animal1.setName("Laura");
        animal1.voice();
    }
}
