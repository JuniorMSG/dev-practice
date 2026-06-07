package src.interview;

// 라이브 코딩 (면접형) - 항공권 추세 판단
//
// 문제
// 며칠간의 항공권 가격 배열이 주어진다. 추세를 보고 "BUY"(지금 사라) 또는
// "WAIT"(기다려라)를 반환하라.
//
// 합의한 기준 (면접관과 정의)
//   오름(이전보다 ↑) = +1
//   내림(이전보다 ↓) = -1
//   동일(이전과 같음) = 0
//   합 >= 0  -> "BUY"   (동점 0 포함 BUY)
//   합 <  0  -> "WAIT"
//
// 엣지케이스 정책
//   - 가격 동일 시: ±0 (카운트 변화 없음)
//   - 카운트 동점(합 0): BUY
//
/* 예제:
   [100, 150, 180, 200, 190] -> 오름3 내림1 = +2 >= 0 -> "BUY"
   [200, 180, 150, 100]      -> 내림3        = -3 <  0 -> "WAIT"
*/

public class AirfareTrend {

  public static String solution(int[] prices) {
    // TODO: MSG가 채울 부분
    // 1. count 변수
    // 2. i=1부터 prices[i] vs prices[i-1] 비교 -> +1 / -1 / 0
    // 3. 합 >= 0 ? "BUY" : "WAIT"
    int count = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        count++;
      } else if (prices[i] < prices[i - 1]) {
        count--;
      }
    }

    if (count >= 0) {
      return "BUY";
    } else {
      return "WAIT";
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{100, 150, 180, 200, 190})); // BUY
    System.out.println(solution(new int[]{200, 180, 150, 100}));      // WAIT
    System.out.println(solution(new int[]{100, 100, 100}));           // BUY (동일)
    System.out.println(solution(new int[]{100, 90, 110}));            // BUY (동점 0)
  }
}
