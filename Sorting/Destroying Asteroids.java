/*
    Approach - condition => AstrdMass <= planetMass --> planetMass += astrdMass
              1. sort the array that contains masses of asteroid. -> We want to encounter the smaller masses asteroids first to enlarge the planetMass that will encounter bigger mass Asteroid later 
              2. traverse the array and check the given condition.
*/
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long planetMass = mass;
        for(int massA : asteroids){
            if(planetMass < massA){
                return false;
            }

            planetMass += massA;
        }
        return true;
    }
}
