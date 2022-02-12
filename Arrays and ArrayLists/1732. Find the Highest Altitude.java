class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int altitude = 0, maxAltitude = 0;
        for(int i=0; i<n; i++){
            altitude = altitude + gain[i];
            if(altitude > maxAltitude){
                maxAltitude = altitude;
            }
        }
        
        return maxAltitude;
    }
}