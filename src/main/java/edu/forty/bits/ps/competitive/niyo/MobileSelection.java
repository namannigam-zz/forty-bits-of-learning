package org.practice.learning.competitive.niyo;

import java.util.*;
import java.util.stream.*;

public class MobileSelection {

    /**
     * John has opened a new mobile shop. Each mobile is having following properties associated to it :
     * Operating System ( Windows, Android or iOS)
     * RAM Size (2, 4 or 8 GB)
     * Memory Space (32 or 64 GB)
     * Price
     * Rating (based on other features like camera, touch quality, etc)
     * Now a customer comes to the store and tells his choice of Operating System, RAM size, Memory Space and his budget that he is willing to spend on the mobile.
     * John will give the customer that mobile phone whose rating is maximum which also satisfies the criteria of Operating System, RAM size and Memory Space as specified by that customer and also whose price lies within the customer's budget.
     * If more than one eligible phone have maximum rating then, he can give any phone to the customer.
     * <p>
     * Note : All the queries are independent of each other.
     * <p>
     * <p>
     * Input Format
     * <p>
     * First line contains an integer
     * N
     * N denoting number of mobile phones in John's shop.
     * Each of the next
     * N
     * N lines contains a com.stackoverflow.nullpointer.string
     * S
     * S followed by four integers
     * A
     * A,
     * B
     * B,
     * C
     * C and
     * D
     * D respectively where
     * S
     * S denotes the operating system of the phone,
     * A
     * A denotes the ram size of the phone,
     * B
     * B denotes the memory space of the phone,
     * C
     * C denotes the price of the phone and
     * D
     * D denotes the rating of the phone.
     * Next line contains an integer
     * Q
     * Q denoting the number of customers who have visited John's shop.
     * Each of the next
     * Q
     * Q lines contains a com.stackoverflow.nullpointer.string
     * H
     * H followed by three integers
     * E
     * E,
     * F
     * F and
     * G
     * G respectively where
     * H
     * H denotes the choice of operating system of the phone required by the customer,
     * E
     * E denotes the choice of ram size of the phone required by the customer,
     * F
     * F denotes the choice of memory space of the phone required by the customer and
     * G
     * G denotes the budget of the customer.
     * <p>
     * Output Format
     * <p>
     * For each query print the rating of the mobile phone given to customer by John as specified by the rules mentioned above.
     * If there is no mobile phone available in John's shop following the customer's constraints, print
     * "
     * -
     * 1
     * "
     * "-1"
     * Answer for each query should be in new line.
     * <p>
     * Input Constraints
     * 1
     * <=
     * N
     * ,
     * Q
     * <=
     * 10
     * 6
     * 1<=N,Q<=106
     * S
     * ,
     * H
     * S,H beongs to { "windows", "android", "ios"}
     * A
     * ,
     * E
     * A,E belongs to {2, 4, 8}
     * B
     * ,
     * F
     * B,F belongs to {32, 64}
     * 1
     * <=
     * C
     * ,
     * D
     * ,
     * G
     * <=
     * 10
     * 9
     * 1<=C,D,G<=109
     * Sample Input
     * 5
     * windows 2 32 100 100
     * windows 4 64 10 52
     * android 2 32 56 9
     * ios 2 32 20 63
     * windows 2 32 452 50
     * 2
     * windows 2 32 500
     * ios 4 32 100
     * Sample Output
     * 100
     * -1
     * Explanation
     * For query 1, there are two phones which satisfies the given criteria having ratings 100 and 50. 100 being the max of these two values is the final answer of this query.
     * <p>
     * For query 2, none of the mobile satisfies the given criteria, hence answer is -1.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<Mobile> mobileList = IntStream.range(0, N)
                .mapToObj(i -> new Mobile(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
                        scanner.nextInt())).collect(Collectors.toList());

        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            String os = scanner.next();
            Integer ramSize = scanner.nextInt();
            Integer memorySpace = scanner.nextInt();
            Integer price = scanner.nextInt();

            List<Mobile> matching = mobileList.stream().filter(mobile -> mobile.getOperatingSystem().equals(os) &&
                    mobile.getRamSize().compareTo(ramSize) == 0 &&
                    mobile.getMemorySpace().compareTo(memorySpace) == 0 && mobile.getPrice() <= price)
                    .collect(Collectors.toList());

            if (matching.isEmpty()) {
                System.out.println("-1");
            } else {
                Integer rating = Integer.MIN_VALUE;
                for (int j = 0; j < matching.size(); j++) {
                    Integer rat = matching.get(i).getRating();
                    if (rat >= rating) {
                        rating = rat;
                    }
                }
                System.out.println(rating);
            }
        }
    }


    static class Mobile {
        String operatingSystem;
        Integer ramSize;
        Integer memorySpace;
        Integer price;
        Integer rating;

        Mobile(String operatingSystem, Integer ramSize, Integer memorySpace, Integer price,
               Integer rating) {
            this.operatingSystem = operatingSystem;
            this.ramSize = ramSize;
            this.memorySpace = memorySpace;
            this.price = price;
            this.rating = rating;
        }

        String getOperatingSystem() {
            return operatingSystem;
        }


        Integer getRamSize() {
            return ramSize;
        }

        Integer getMemorySpace() {
            return memorySpace;
        }


        Integer getPrice() {
            return price;
        }

        Integer getRating() {
            return rating;
        }

    }

    static class MobileComparator implements Comparator<Mobile> {

        @Override
        public int compare(Mobile o1, Mobile o2) {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

}