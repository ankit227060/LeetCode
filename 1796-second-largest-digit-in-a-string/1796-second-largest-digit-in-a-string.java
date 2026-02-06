class Solution {
    public int secondHighest(String s) {
        int largest =-1;
        int secondlargest =-1;

        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                int digit =ch-'0';
                if(digit>largest){
                    secondlargest=largest;
                    largest=digit;
                }else if(digit<largest && digit>secondlargest){
                    secondlargest= digit;
                }
            }
        }
        return secondlargest;
    }
}

//time : O(n)
//space : O(1)