class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        //start point of event1
        String e1_start = event1[0];

        //end point of event1
        String e1_end = event1[1];

        // start point of event2
        String e2_start = event2[0];

        //end point of event2
        String e2_end = event2[1];

        //if it has conflict then
        //e2_start <= e1_end and e1_start <= e2_end

        /**
            case 1: event1   e1_start ---------------- e1_end
                    event2             e2_start -----------------e2_end

                    Here e2_start must be <= e1_end

            case 2: event1          e1_start -------------------- e1_end
                    event2   e2_start-------------------e2_end

                    Here  e1_start must be <= e2_end                        
         */

        return e2_start.compareTo(e1_end) <= 0 && e1_start.compareTo(e2_end) <= 0;
    }
}
