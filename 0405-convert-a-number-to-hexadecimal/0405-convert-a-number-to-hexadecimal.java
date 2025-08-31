class Solution {
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }

        String alp = "0123456789abcdef";
        String hex = "";

        if(num < 0){
            long unsigned = num + 0x100000000L; 
            while(unsigned > 0){
                hex = alp.charAt((int)(unsigned % 16)) + hex;
                unsigned /= 16;
            }
        }else{
            while(num > 0){
                hex = alp.charAt(num % 16) + hex;
                num /= 16;
            }
        }

        return hex;
    }
}