
public class 패턴매칭_01_BruteForce {
	// 브루트포스
	// 해당 패턴이 본문안에 들어있는지 / 들어있다면 몇번째 인덱스부터 시작하는지
	public static void main(String[] args) {
		String t = "This iss a book";
		String p = "iss";

//			System.out.println(t.contains(p));

		System.out.println(bruteForceFor(t, p));

	}

	public static int bruteForceWhile(String t, String p) {
		int N = t.length();
		int M = p.length();

		int i = 0; // 본문의 인덱스
		int j = 0; // 패턴의 인덱스

		// 구현 방법은 다양하고 그 중에 하나의 예시일 뿐이다.!
		while (j < M && i < N) {
			if (t.charAt(i) != p.charAt(j)) {
				i -= j;
				j = -1;
			}
			i++;
			j++;
		}
		if (j == M)
			return i - M;
		return -1;
	}

	public static int bruteForceFor(String t, String p) {
		int N = t.length(); // 본문의 길이
		int M = p.length(); // 패턴의 길이

		// 구현방법은 엄청나게 많아~~
		for (int i = 0; i < N - M + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < M; j++) {
				if (p.charAt(j) != t.charAt(i + j)) {
					flag = false;
					break;
				}
			} // 패턴 매칭 수행하는 for문

			if (flag) {
				return i;
			}
		} // 패턴 검사의 시작점 위치

		return -1; // 못 찾았을 경우 (없을 경우)
	}
}
