class Fancy {
  public void append(int val) {
    final long x = (val - b + MOD) % MOD;
    vals.add(x * modPow(a, MOD - 2) % MOD);
  }
  public void addAll(int inc) {
    b = (b + inc) % MOD;
  }
  public void multAll(int m) {
    a = (a * m) % MOD;
    b = (b * m) % MOD;
  }
  public int getIndex(int idx) {
    return idx >= vals.size() ? -1 : (int) ((a * vals.get(idx) + b) % MOD);
  }
  private static final int MOD = 1_000_000_007;
  private List<Long> vals = new ArrayList<>();
  private long a = 1;
  private long b = 0;
  private int modPow(long x, long n) {
    if (n == 0)
      return 1;
    if (n % 2 == 1)
      return (int) (x * modPow(x % MOD, (n - 1)) % MOD);
    return modPow(x * x % MOD, (n / 2)) % MOD;
  }
}