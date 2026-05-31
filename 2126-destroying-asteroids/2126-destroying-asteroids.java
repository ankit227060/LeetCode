class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int maxasteroid = 0;
        for(int a : asteroids) {
            if(a > maxasteroid) maxasteroid = a;
        }
        
        int[] freq = new int[maxasteroid + 1];
        for(int a : asteroids) {
            freq[a]++;
        }
        
        long currentmass = mass;
        for(int i = 1; i <= maxasteroid; i++) {
            if(freq[i] > 0) {
                if(i > currentmass) return false;
                currentmass += (long) i * freq[i];
            }
        }
        
        return true;
    }
}