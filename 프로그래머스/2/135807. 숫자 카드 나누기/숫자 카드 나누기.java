class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		int arrayAGCD = getArrayGCD(arrayA);
		int arrayBGCD = getArrayGCD(arrayB);

		boolean checkA = checkDivisible(arrayAGCD, arrayB);
		boolean checkB = checkDivisible(arrayBGCD, arrayA);

		if (checkA && checkB) {
			return Math.max(arrayAGCD, arrayBGCD);
		}

		if (checkA) {
			return arrayAGCD;
		}

		if (checkB) {
			return arrayBGCD;
		}

		return answer;
	}

	private boolean checkDivisible(int gcd, int[] arr) {
		for (int i : arr) {
			if (i % gcd == 0) {
				return false;
			}
		}

		return true;
	}

	private int getArrayGCD(int[] arr) {
		int gcd = arr[0];
		for (int i = 1; i < arr.length; i++) {
			gcd = getGCD(gcd, arr[i]);
		}

		return gcd;
	}

	private int getGCD(int a, int b) {
		if (a == b) {
			return a;
		}

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}

		return a;
	}
}