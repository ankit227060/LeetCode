class Solution {
    public long findKthSmallest(int[] c, int k) {
        Arrays.sort(c);
        if(c[0]==1)return k;

        long[] lcm = new long[(1<<c.length)];
        boolean[] odd = new boolean[lcm.length];
        for(int i=0; i<c.length; i++)lcm[1<<i]=c[i];
        for(int i=1; i<lcm.length; i++){
            odd[i]=odd(i);
            for(int j=0; lcm[i]==0&&j<c.length; j++){
                if((i&(1<<j))>0)lcm[i]=lcm(lcm[i-(1<<j)], c[j]);
            }
        }

        long l=k, r=(long)c[c.length-1]*k, m;
        while(l<r){
            m=(l+r)/2;
            if(count(m, odd, lcm)<k)l=m+1;
            else r=m;
        }
        return l;
    }
    private long count(long x, boolean[] odd, long[] lcm){
        long a=0;
        for(int i=1; i<lcm.length; i++){
            if(odd[i])a+=x/lcm[i];
            else a-=x/lcm[i];
        }
        return a;
    }
    private long lcm(long a, long b){
        return a*b/gcd(a, b);
    }
    private long gcd(long a, long b){
        if(b%a==0)return a;
        return gcd(b%a, a);
    }
    private boolean odd(int x){
        boolean odd = false;
        for(; x>0; x>>=1){
            if(x%2==1)odd=!odd;
        }
        return odd;
    }
}