package edu.forty.bits.datastructures.queue;

import java.util.LinkedList;

/**
 * An animal shelter which holds only dogs and cats, operates on a strictly "first in first out" basis.
 * People must adopt either the oldest(basis arrival time) of all the animals in the shelter,
 * or they can choose to prefer dog or a cat(and will receive the oldest of that type). They cannot select
 * which specific animal they would like. Create the data structures to maintain this system and implement
 * operations such as enqueue , dequeueAny, dequeueDog, dequeueCat.
 * You can use built-in linked-list data structure
 */
public class AnimalShelter {

    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // acts as a timestamp;

    // one could follow two approaches here, either use two separate queues for each type and then
    // perform operations
    // or implement single queue and then perform operations (tough would be dequeue<specific> in this
    // case)

    public void enqueue(Animal a) {
        a.setOrder(order); // compare insertion order across types of animal
        order++;
        if (a instanceof Dog) dogs.add((Dog) a);
        else if (a instanceof Cat) cats.add((Cat) a);
    }

    // maintaining two separate queues would make this operation tough since one would have to compare
    // the last elements of both the queues while performing dequeueAny
    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek(); // last elements from both

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    private Dog dequeueDog() {
        return dogs.poll();
    }

    private Cat dequeueCat() {
        return cats.poll();
    }

    class Animal {
        protected String name;
        private int order; // sequence number maintained

        Animal(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        boolean isOlderThan(Animal animal) {
            return this.order < animal.order;
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
}