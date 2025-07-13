/* Author: Jack Williams
 * Date: July 10th - July 13th, 2025
 * Description: This is the main part of the assignment, the
 * AdoptionQueue. It is made using an array and has all needed
 * methods including enqueue, dequeueAny, dequeueDog, dequeueCat,
 * peek, isFull and isEmpty. The queue stores the size, front, and
 * back of the queue as int values that are moved up or down
 * depending on the method that is run to add and remove Pet objects.
 *
 * From here on out, I will not be inserting lots of comments. When
 * I looked back at my previous assignments, the code looked messier
 * with all the comments, and detailed JavaDocs will produce the
 * same value anyway. */

import java.util.Scanner;

public class AdoptionQueue {

    private Pet[] queueArray;
    private int frontOfQueue;
    private int backOfQueue;
    private int numberOfAnimals;

    public AdoptionQueue(int size) {
        this.queueArray = new Pet[size];
        this.frontOfQueue = -1;
        this.backOfQueue = -1;
        this.numberOfAnimals = 0;
        System.out.println("Queue created with size of " + size);
    }

    public boolean isFull() {
        if (backOfQueue == queueArray.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return (numberOfAnimals == 0);
    }

    public void enqueue(Pet pet) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            frontOfQueue = 0;
            backOfQueue++;
            queueArray[backOfQueue] = pet;
            numberOfAnimals++;
        } else {
            backOfQueue++;
            numberOfAnimals++;
            queueArray[backOfQueue] = pet;
        }
    }

    public Pet peek() {
        if (!isEmpty()) {
            return queueArray[frontOfQueue];
        } else {
            return null;
        }
    }

    public Pet dequeueAny() {
        Pet result = null;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            result = queueArray[frontOfQueue];
            frontOfQueue++;
            if (frontOfQueue > backOfQueue) {
                frontOfQueue = backOfQueue = -1;
            }
            numberOfAnimals--;
        }
        return result;
    }

    public Pet dequeueDog() {
        Pet result = null;
        boolean continueLoop = true;
        int tempQueueNumber = frontOfQueue;

        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            while (continueLoop) {
                if (queueArray[tempQueueNumber].getPetType()) {
                    result = queueArray[tempQueueNumber];

                    if (tempQueueNumber == frontOfQueue) {
                        frontOfQueue++;
                        numberOfAnimals--;
                    } else if (tempQueueNumber == backOfQueue) {
                        backOfQueue--;
                        numberOfAnimals--;
                    } else {
                        for (int i = tempQueueNumber; i < backOfQueue; i++) {
                            queueArray[i] = queueArray[i + 1];
                        }

                        queueArray[backOfQueue] = null;
                        backOfQueue--;
                        numberOfAnimals--;
                    }
                    if (frontOfQueue > backOfQueue) {
                        frontOfQueue = backOfQueue = -1;
                    }
                    continueLoop = false;
                } else {
                    tempQueueNumber++;
                }
            }
        }
        return result;
    }

    public Pet dequeueCat() {
        Pet result = null;
        boolean continueLoop = true;
        int tempQueueNumber = frontOfQueue;

        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            while (continueLoop) {
                if (!queueArray[tempQueueNumber].getPetType()) {
                    result = queueArray[tempQueueNumber];

                    if (tempQueueNumber == frontOfQueue) {
                        frontOfQueue++;
                        numberOfAnimals--;
                    } else if (tempQueueNumber == backOfQueue) {
                        backOfQueue--;
                        numberOfAnimals--;
                    } else {
                        for (int i = tempQueueNumber; i < backOfQueue; i++) {
                            queueArray[i] = queueArray[i + 1];
                        }


                        backOfQueue--;
                        numberOfAnimals--;
                    }
                    if (frontOfQueue > backOfQueue) {
                        frontOfQueue = backOfQueue = -1;
                    }
                    continueLoop = false;
                } else {
                    tempQueueNumber++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdoptionQueue adoptionQueue = new AdoptionQueue(6);

        for (int i = 0; i < 3; i++) {
            Pet addDogs = new Pet(true, "Dog" + i, "Breed" + i, "N/A", i + 1);
            adoptionQueue.enqueue(addDogs);
        }

        for (int i = 0; i < 3; i++) {
            Pet addCats = new Pet(false, "Cat" + i, "Breed" + i, "N/A", i + 1);
            adoptionQueue.enqueue(addCats);
        }

        boolean runProgram = true;

        while (runProgram) {
            System.out.println("Pet Adoption Service");
            System.out.println("Type the number of the action you would like to do");
            System.out.println();
            System.out.println("1. Adopt first in queue");
            System.out.println("2. Adopt a dog");
            System.out.println("3. Adopt a cat");
            System.out.println("4. Print pet queue");
            System.out.println("5. Exit");
            System.out.println();

            int choice = scanner.nextInt();

            if (choice == 1) {
                adoptionQueue.dequeueAny();
                System.out.println("Pet adopted!");
                System.out.println();
            } else if (choice == 2) {
                adoptionQueue.dequeueDog();
                System.out.println("Dog adopted!");
                System.out.println();
            } else if (choice == 3) {
                adoptionQueue.dequeueCat();
                System.out.println("Cat adopted!");
                System.out.println();
            } else if (choice == 4) {
                for (int i = adoptionQueue.frontOfQueue; i < adoptionQueue.backOfQueue; i++) {
                    System.out.println(adoptionQueue.queueArray[i]);
                }
                System.out.println();
            } else if (choice == 5) {
                System.out.println("Thanks for using our service!");
                runProgram = false;
            } else {
                System.out.println("Please input one of the listed numbers");
            }
        }
    }
}
