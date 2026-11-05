import java.util.*;

class Solution {    
    record InOutRecord(String uid, boolean inout) {}
    public String[] solution(String[] record) {
        
        List<InOutRecord> inOutList = new ArrayList<>();
        Map<String, String> uidName = new HashMap<>();
        
        
        for (String user : record) {
            String[] cols = user.split(" ");
            
            String operation = cols[0];
            
            if (operation.equals("Enter")) {
                inOutList.add(new InOutRecord(cols[1], true));
                uidName.put(cols[1], cols[2]);
            }
            else if (operation.equals("Leave")) {
                inOutList.add(new InOutRecord(cols[1], false));
            }
            else {
                uidName.put(cols[1], cols[2]);
            }
        }
        
        String[] answer = new String[inOutList.size()];
        for (int i = 0; i < inOutList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            InOutRecord ior = inOutList.get(i);
            String userName = uidName.get(ior.uid());
            sb.append(userName);
            sb.append("님이");
            sb.append(ior.inout() ? " 들어왔습니다." : " 나갔습니다.");
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}