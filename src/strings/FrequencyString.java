package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Element implements Comparable<Element>{
    char c;
    int freq;
    @Override
    public int compareTo(Element o) {
        return o.freq - this.freq;
    }

    public Element(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}


public class FrequencyString {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //Convert this map to a priority queue
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Element element = new Element(entry.getKey(), entry.getValue());
            pq.offer(element);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Element element = pq.poll();
            String c = element.c + "";
            sb.append(c.repeat(element.freq));

        }
        return sb.toString();

    }

}
