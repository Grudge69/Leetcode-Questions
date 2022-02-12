class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(String op: ops){
            if(op.equals("+")){
                //add prev 2 val in arr
                arr.add(arr.get(arr.size()-1)+arr.get(arr.size()-2));
                
            }else if(op.equals("C")){
                //remove prev
                arr.remove(arr.size()-1);
                
            }else if(op.equals("D")){
                //double
                arr.add(2*arr.get(arr.size()-1));
                
            }else{
                //number
                arr.add(Integer.parseInt(op));
            }
        }
        
        int score = 0;
        //calculate score stored in arr
        for(int val: arr){
            score += val;
        }
        
        return score;
    }
}