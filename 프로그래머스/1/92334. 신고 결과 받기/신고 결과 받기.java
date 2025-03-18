import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportedMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            reportedMap.put(id, 0);
            resultMap.put(id, 0);
        }

        for (String r : report) {
            String[] rSplit = r.split(" ");
            if (reportMap.get(rSplit[0]).add(rSplit[1])) {
                reportedMap.put(rSplit[1], reportedMap.get(rSplit[1]) + 1);
            }
        }

        List<String> bannedUsers = new ArrayList<>();
        for (String user : id_list) {
            if (reportedMap.get(user) >= k) {
                bannedUsers.add(user);
            }
        }

        for (String user : id_list) {
            int cnt = 0;
            for (String bannedUser : bannedUsers) {
                if (reportMap.get(user).contains(bannedUser)) {
                    cnt++;
                }
            }
            resultMap.put(user, cnt);
        }

        return Arrays.stream(id_list)
                .mapToInt(resultMap::get)
                .toArray();
    }
}