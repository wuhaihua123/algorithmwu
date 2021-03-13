package dp;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 2;
        System.out.println(coinChange(coins, amount, new int[amount + 1]));

    }

    public static int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int current = coinChange(coins, amount - coins[i], dp);
            if (current < min && current != -1) {
                min = current + 1;
            }
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }


}
