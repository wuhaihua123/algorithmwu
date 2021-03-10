package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Choujiang {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> compare(int[] arr, boolean[] op, int k) {
        HashMap<Integer, Customer> map = new HashMap<>();
        ArrayList<Customer> candis = new ArrayList<>();
        ArrayList<Customer> daddies = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
            boolean buyOrRefund = op[i];

        }
        return ans;
    }

    public static class Customer {
        public Integer id;
        public Integer buy;
        public Integer enterTime;

        public Customer(Integer id, Integer buy, Integer enterTime) {
            this.id = id;
            this.buy = buy;
            this.enterTime = enterTime;
        }
    }
}
