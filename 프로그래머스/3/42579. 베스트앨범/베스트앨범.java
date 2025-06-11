import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> genTotal = new HashMap<>();
		Map<String, List<int[]>> genSong = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			genTotal.put(genres[i], genTotal.getOrDefault(genres[i], 0) + plays[i]);
			genSong.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] {plays[i], i});
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(genTotal.entrySet());
		list.sort((a, b) -> b.getValue() - a.getValue());

		List<Integer> result = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : list) {
			List<int[]> song = genSong.get(entry.getKey());
			song.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

			for (int i = 0; i < Math.min(2, song.size()); i++) {
				result.add(song.get(i)[1]);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}