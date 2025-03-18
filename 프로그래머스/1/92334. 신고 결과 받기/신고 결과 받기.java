import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportedMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (String id : id_list) {
            reportedMap.put(id, 0);
            answer.add(0);
        }

        for (String r : report) {
            String[] rSplit = r.split(" ");
            reportMap.put(rSplit[0], reportMap.getOrDefault(rSplit[0], new HashSet<>()));
            reportMap.get(rSplit[0]).add(rSplit[1]);
        }

        for (Set<String> reportedUsers : reportMap.values()) {
            for (String user : reportedUsers) {
                reportedMap.put(user, reportedMap.get(user) + 1);
            }

        }


        for (int i = 0; i < id_list.length; i++) {
            String reportedUser = id_list[i];
            if (reportedMap.get(reportedUser) >= k) {
                // answer.set(i, answer.get(i) + 1);

                for (String user : reportMap.keySet()) {
                    if (reportMap.get(user).contains(reportedUser)) {
                        for (int j = 0; j < id_list.length; j++) {
                            if (id_list[j].equals(user)) {
                                answer.set(j, answer.get(j) + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}