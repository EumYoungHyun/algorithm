package jongho;

import java.util.*;

public class Solution_prog_42579_베스트앨범 {
	public static void main(String[] args) {
		String[] s = new String[] { "classic", "pop", "classic", "classic", "pop" };
		int[] s2 = new int[] { 500, 600, 150, 800, 2500 };
		System.out.println(Arrays.toString(solution(s, s2)));
	}

	public static int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> indexMap = new HashMap<>();
		List<Genre> genreList = new ArrayList<>();

		for (int i = 0; i < genres.length; i++) {
			Genre genre;
			Integer index = indexMap.get(genres[i]);

			if (index == null) {
				genre = new Genre();
				genreList.add(genre);

				indexMap.put(genres[i], genreList.size() - 1);
			} else {
				genre = genreList.get(index);
			}

			Song song = new Song();
			song.id = i;
			song.play = plays[i];

			genre.songs.add(song);
			genre.sum += plays[i];
		}

		Collections.sort(genreList);

		int count = 0;

		for (Genre genre : genreList) {
			Collections.sort(genre.songs);

			if (genre.songs.size() > 1) {
				count += 2;
			} else {
				count += 1;
			}
		}

		int[] answer = new int[count];
		int answerIdx = 0;

		for (Genre genre : genreList) {
			for (int i = 0; i < genre.songs.size() && i < 2; i++) {
				answer[answerIdx] = genre.songs.get(i).id;
				answerIdx++;
			}
		}

		return answer;
	}

	private static class Genre implements Comparable<Genre> {
		int sum;
		List<Song> songs;

		public Genre() {
			sum = 0;
			songs = new ArrayList<>();
		}

		@Override
		public int compareTo(Genre that) {
			return Integer.compare(that.sum, this.sum); // order by sum desc
		}
	}

	private static class Song implements Comparable<Song> {
		int id;
		int play;

		@Override
		public int compareTo(Song that) {
			if (this.play == that.play) {
				return Integer.compare(this.id, that.id); // order by id asc
			}

			return Integer.compare(that.play, this.play); // order by play desc
		}
	}
}
