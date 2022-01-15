package HashMapandHeap;
//VERY IMPORTANT QUESTION : Create a HashMap using LinkedList
import java.io.*;
import java.util.*;

public class WriteHashMapUsingLinkedList {

    public static class HashMap1<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap1() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getElementwithInBucket(key, bucketIndex);
            if(dataIndex != -1)
            {
                HMNode hm = buckets[bucketIndex].get(dataIndex);
                hm.value = value;
            }
            else {
                HMNode hm1 = new HMNode(key, value);
                buckets[bucketIndex].add(hm1);
                size++;
            }
            double lambda = size * 1.0 / buckets.length;

            if (lambda > 2.0) {
                reHash();
            }
            return;
        }
         void reHash() throws Exception {
            LinkedList<HMNode> []extra = buckets;

            initbuckets(buckets.length*2);
            size = 0;
            for(int i = 0;i<extra.length;i++)
                for(HMNode hm : extra[i])
                {
                    put(hm.key, hm.value);
                }

        }
        private int hashFunction(K key)
        {
            int hcode = key.hashCode();
            return Math.abs(hcode) % buckets.length;
        }
        private int getElementwithInBucket(K key, int bucketIndex)
        {
            int dataIndex = 0;
            for(HMNode hi : buckets[bucketIndex])
            {
                if(hi.key.equals(key))
                    return  dataIndex;

                dataIndex++;
            }
            return -1;

        }

        public V get(K key) throws Exception {
            int buckeIndex = hashFunction(key);
            int dataIndex = getElementwithInBucket(key, buckeIndex);
            if(dataIndex!=-1)
            {
                return buckets[buckeIndex].get(dataIndex).value;
            }
            return  null;
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = getElementwithInBucket(key, bucketIndex);
            if(dataIndex != -1)
                return  true;

            return  false;
        }

        public V remove(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getElementwithInBucket(key, bucketIndex);
            if(dataIndex != -1)
            {
                V vi = buckets[bucketIndex].remove(dataIndex).value;
                size--;
                return  vi;
            }
            return  null;
        }

        public ArrayList<K> keyset() throws Exception {
            ArrayList<K>  list = new ArrayList<>();
            for(int i  =0;i<buckets.length;i++)
                for(HMNode hm : buckets[i])
                    list.add(hm.key);

            return  list;
        }

        public int size() {
            // write your code here
            return  size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print( node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap1<String, Integer> map = new HashMap1();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}