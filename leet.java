class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        //Arrays.sort(heaters);
        int result = 0;
        int distant = 0;
        if(heaters.length == 1){
            int toLeft = Math.abs(heaters[0] - houses[0]);
            int toRight = Math.abs(heaters[0] - houses[houses.length -1]);
            return Math.max(toLeft, toRight);
        }
        for(int i = 0; i < houses.length; i++){

            if(houses[i]< heaters[0]){
                distant = heaters[0] - houses[i];
            }else if(houses[i] >= heaters[heaters.length -1]){
                distant = houses[i] - heaters[heaters.length -1];
            }else{
                int left = 0; int right = heaters.length -1;  int index = 0;
                while(left <= right){
                    int mid = (right - left)/2 +left;
                    if(heaters[mid] == houses[i]){
                        index = mid +1;
                        break;
                    }else if(heaters[mid] > houses[i]){
                        right = mid - 1;
                    }
                    else{

                        left = mid + 1;
                        index = left;
                    }
                }


                distant = Math.min((houses[i] - heaters[index-1]), (heaters[index] - houses[i]));
            }
            result = Math.max(result, distant);
        }

        return result;
    }

}