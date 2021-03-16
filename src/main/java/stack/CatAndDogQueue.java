package stack;

import java.util.LinkedList;
import java.util.Queue;

public class CatAndDogQueue {

    private Queue<PetQueue> dogQueue;

    private Queue<PetQueue> catQueue;

    private long timeStamp;

    public CatAndDogQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.timeStamp = 0;
    }

    /**
     * 添加宠物
     *
     * @param pet
     */
    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQueue.add(new PetQueue(pet, this.timeStamp++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQueue.add(new PetQueue(pet, this.timeStamp++));
        } else {
            throw new RuntimeException("no cat and dog");
        }
    }

    /**
     * 取出宠物
     *
     * @return
     */
    public Pet poll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (this.dogQueue.peek().getTimeStamp() < this.catQueue.peek().getTimeStamp()) {
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("no cat and dog");
        }

    }

    /**
     * 取出狗
     * @return
     */
    public Dog pollDog() {
        if (!dogQueue.isEmpty()) {
            return (Dog) dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    /**
     * 取出猫
     * @return
     */

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            return (Cat)catQueue.poll().getPet();
        }else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    /**
     * 总队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    /**
     * 狗队列是否为空
     * @return
     */
    public boolean isDogQueueEmpty(){
        return this.dogQueue.isEmpty();
    }

    /**
     * 猫队列是否为空
     * @return
     */
    public boolean isCatQueueEmpty(){
        return this.catQueue.isEmpty();
    }

    /**
     * 封装了宠物和加入时的时间
     */
    private class PetQueue {

        private Pet pet;
        private long timeStamp;

        public PetQueue(Pet pet, long timeStamp) {
            this.pet = pet;
            this.timeStamp = timeStamp;
        }


        public long getTimeStamp() {
            return this.timeStamp;
        }

        public Pet getPet() {
            return this.pet;
        }
    }

    private class Pet {
        private String petType;

        public String getPetType() {
            return petType;
        }
    }

    private class Dog extends Pet {
    }

    private class Cat extends Pet{
    }
}
