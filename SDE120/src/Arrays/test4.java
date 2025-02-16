package Arrays;
import java.util.*;

 class AmazonDatabaseOptimization {
     public static int findMaxSystemThroughput(int[] hostThroughput) {
         int n = hostThroughput.length;
         if (n < 3) return 0;

         // Sort in descending order
         Integer[] servers = new Integer[n];
         for (int i = 0; i < n; i++) {
             servers[i] = hostThroughput[i];
         }
         Arrays.sort(servers, Collections.reverseOrder());

         int maxThroughput = 0;
         boolean[] used = new boolean[n];

         // Try first cluster
         for (int i = 0; i < n-2; i++) {
             for (int j = i+1; j < n-1; j++) {
                 for (int k = j+1; k < n; k++) {
                     // Try second cluster with remaining servers
                     boolean[] tmpUsed = used.clone();
                     tmpUsed[i] = tmpUsed[j] = tmpUsed[k] = true;

                     // Get median of first cluster
                     int[] cluster1 = {servers[i], servers[j], servers[k]};
                     Arrays.sort(cluster1);
                     int throughput = cluster1[1];  // median of first cluster

                     // Try to form second cluster with remaining servers
                     List<Integer> remaining = new ArrayList<>();
                     for (int x = 0; x < n; x++) {
                         if (!tmpUsed[x]) {
                             remaining.add(servers[x]);
                         }
                     }

                     // If we have enough servers for second cluster
                     if (remaining.size() >= 3) {
                         for (int a = 0; a < remaining.size()-2; a++) {
                             for (int b = a+1; b < remaining.size()-1; b++) {
                                 for (int c = b+1; c < remaining.size(); c++) {
                                     int[] cluster2 = {remaining.get(a), remaining.get(b), remaining.get(c)};
                                     Arrays.sort(cluster2);
                                     throughput += cluster2[1];  // add median of second cluster
                                     maxThroughput = Math.max(maxThroughput, throughput);
                                     throughput -= cluster2[1];  // remove for next iteration
                                 }
                             }
                         }
                     } else {
                         maxThroughput = Math.max(maxThroughput, throughput);
                     }
                 }
             }
         }

         return maxThroughput;
     }
     public static void main(String[] args) {
         // Test case 1
         int[] test1 = {2, 3, 4, 3, 4};
         System.out.println("Test case 1 result: " + findMaxSystemThroughput(test1));
         // Expected output: 4

         // Test case 2
         int[] test2 = {8, 6, 3, 4, 4, 5, 6};
         System.out.println("Test case 2 result: " + findMaxSystemThroughput(test2));
         // Expected output: 11
     }
}
