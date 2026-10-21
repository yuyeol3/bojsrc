import java.util.*;

class Solution {
    record ParseResults(
        List<String> spoilerPrevent,
        Map<String, Integer> wordCounts
    ) {}
    
    ParseResults parseMessage(String message, int[][] spoiler_ranges) {
        List<String> spoilerPrevent = new ArrayList<>();
        Map<String, Integer> wordCounts = new HashMap<>();

        int idx = 0;
        for (String s : message.split(" ")) {
            if (s.equals("")) {
                idx += s.length() + 1;
                continue;
            }
            
            int st = idx;
            int ed = idx + s.length() - 1;
            IO.println(s);
            
            boolean added = false;
            for (int[] range : spoiler_ranges) {
                if (
                    (st >= range[0] && st <= range[1]) ||
                    (ed >= range[0] && ed <= range[1]) ||
                    (range[0] >= st && range[0] <= ed) ||
                    (range[1] >= st && range[1] <= ed)
                ) {
                    spoilerPrevent.add(s);
                    added = true;
                    break;
                }
            }
            if (!added) {
                wordCounts.put(s, wordCounts.getOrDefault(s, 0) + 1);            
            }
            idx += s.length() + 1;
        }
        
        return new ParseResults(spoilerPrevent, wordCounts);
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        ParseResults r = parseMessage(message, spoiler_ranges);        
        IO.println(r);
        
        Set<String> p = new HashSet<>(r.spoilerPrevent());
        return (int) p.stream()
            .filter(v->r.wordCounts().getOrDefault(v, 0) == 0)
            .count();
    }
}