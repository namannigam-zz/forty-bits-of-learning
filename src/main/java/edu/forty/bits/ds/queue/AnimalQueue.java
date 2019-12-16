package edu.forty.bits.ds.queue;

import java.util.LinkedList;

// maintain an animal shelter, where people can adopt either the oldest(basis arrival time)
// or they can choose to prefer dog or a cat(oldest of that type)...
// create a data structure for this system and provide operations like enqueue , dequeueAny,
// dequeueDog, dequeueCat
// (can use linked-list data structure)
public class AnimalQueue {

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
    // the last elements of both the queues while dequeueing overall
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
