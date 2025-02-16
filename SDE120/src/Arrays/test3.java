package Arrays;

public class test3 {

        public static int minStartingHealth(int[] power, int armor) {
            long totalDamage = 0;
            long maxDamage = 0;

            for (int p : power) {
                totalDamage += p;
                maxDamage = Math.max(maxDamage, p);
            }

            return (int)(totalDamage - Math.min(maxDamage, armor) + 1);
        }

        public static void main(String[] args) {
            int[] power = {1,2,3};
            int armor = 4;
            System.out.println(minStartingHealth(power, armor)); // Output: 12
        }
    }


