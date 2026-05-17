class Solution {
    public boolean find(int index,int[] arr,boolean[] visited){
        if(index<0 || index>=arr.length) return false;
        if(visited[index]) return false;
        if (arr[index]==0)  return true;
        visited[index]=true;
        return (find(index+arr[index],arr,visited) || find(index-arr[index],arr,visited));
    }
    public boolean canReach(int[] arr, int start) {
        boolean[] visited=new boolean[arr.length];
        return find(start,arr,visited);
    }
}    