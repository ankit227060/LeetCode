import java.util.*;

class Bank {
    private long[] balances;
    private int n;

    public Bank(long[] balance) {
        this.balances = balance;
        this.n = balance.length;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= n;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }
        int i1 = account1 - 1;
        int i2 = account2 - 1;
        if (balances[i1] < money) return false;

        balances[i1] -= money;
        balances[i2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;
        balances[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) return false;
        int idx = account - 1;
        if (balances[idx] < money) return false;
        balances[idx] -= money;
        return true;
    }
}

/*
Usage:
Bank obj = new Bank(new long[]{100, 200, 300});
boolean a = obj.transfer(1, 2, 50);
boolean b = obj.deposit(2, 100);
boolean c = obj.withdraw(3, 150);
*/