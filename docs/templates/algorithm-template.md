# [알고리즘 이름]

> 한 줄 요약: 알고리즘이 해결하는 문제

## 📌 목차
- [개요](#개요)
- [동작 원리](#동작-원리)
- [시간/공간 복잡도](#시간공간-복잡도)
- [구현 (Java)](#구현-java)
- [구현 (Kotlin)](#구현-kotlin)
- [적용 문제 유형](#적용-문제-유형)
- [최적화 기법](#최적화-기법)
- [관련 알고리즘](#관련-알고리즘)

---

## 개요

### 문제 상황
- 어떤 문제를 해결하는가?
- 입력과 출력은 무엇인가?

### 핵심 아이디어
- 알고리즘의 핵심 원리 설명
- 어떻게 문제를 해결하는가?

### 언제 사용하는가?
- ✅ 적합한 상황
- ❌ 부적합한 상황

---

## 동작 원리

### 단계별 설명

#### Step 1: [단계 이름]
```
설명 작성
```

#### Step 2: [단계 이름]
```
설명 작성
```

#### Step 3: [단계 이름]
```
설명 작성
```

### 시각화 예제

```
입력: [1, 5, 3, 2, 4]

Step 1: [1, 5, 3, 2, 4]
        ↓
Step 2: [1, 3, 5, 2, 4]
        ↓
Step 3: [1, 2, 3, 4, 5]
```

---

## 시간/공간 복잡도

| 케이스 | 시간 복잡도 | 공간 복잡도 |
|--------|-----------|-----------|
| 최선 (Best) | O(n) | O(1) |
| 평균 (Average) | O(n log n) | O(1) |
| 최악 (Worst) | O(n²) | O(n) |

### 복잡도 분석
- **시간 복잡도**: 왜 이런 복잡도인지 설명
- **공간 복잡도**: 메모리 사용량 설명

---

## 구현 (Java)

### 기본 구현
```java
public class Algorithm {
    /**
     * 알고리즘 설명
     * @param arr 입력 배열
     * @return 결과
     */
    public int solve(int[] arr) {
        // 구현
        return 0;
    }
}
```

### 재귀 버전 (필요시)
```java
public class RecursiveAlgorithm {
    public int solveRecursive(int[] arr, int left, int right) {
        // 재귀 구현
        return 0;
    }
}
```

### 반복문 버전 (필요시)
```java
public class IterativeAlgorithm {
    public int solveIterative(int[] arr) {
        // 반복문 구현
        return 0;
    }
}
```

---

## 구현 (Kotlin)

### 기본 구현
```kotlin
class Algorithm {
    /**
     * 알고리즘 설명
     * @param arr 입력 배열
     * @return 결과
     */
    fun solve(arr: IntArray): Int {
        // 구현
        return 0
    }
}
```

### 함수형 스타일 (Kotlin)
```kotlin
fun solve(arr: IntArray): Int {
    // Kotlin 함수형 스타일 구현
    return arr.asSequence()
        .filter { it > 0 }
        .sum()
}
```

---

## 적용 문제 유형

### 전형적인 문제 패턴

#### 패턴 1: [패턴 이름]
**문제 특징:**
- 특징 1
- 특징 2

**예시 문제:**
```
문제: 배열에서 최댓값 찾기
입력: [3, 1, 4, 1, 5]
출력: 5
```

**솔루션:**
```java
public int findMax(int[] arr) {
    // 솔루션 코드
    return 0;
}
```

#### 패턴 2: [패턴 이름]
**문제 특징:**
- 특징 1
- 특징 2

**예시 문제:**
```
문제 설명
```

**솔루션:**
```kotlin
fun solution(arr: IntArray): Int {
    // 솔루션 코드
    return 0
}
```

---

## 최적화 기법

### 1. 메모이제이션
```java
// 최적화 전
public int slow(int n) {
    // 느린 코드
    return 0;
}

// 최적화 후
private Map<Integer, Integer> memo = new HashMap<>();

public int fast(int n) {
    if (memo.containsKey(n)) return memo.get(n);
    // 빠른 코드
    return 0;
}
```

### 2. 조기 종료
```kotlin
fun optimized(arr: IntArray): Int {
    for (i in arr.indices) {
        if (/* 조건 */) {
            return i  // 조기 종료
        }
    }
    return -1
}
```

### 3. 공간 최적화
- 공간을 줄이는 방법
- Trade-off 설명

---

## 주의사항

### ⚠️ 흔한 실수

1. **실수 1: [실수 이름]**
   ```java
   // 잘못된 코드
   ```
   ❌ 문제점: 설명

   ```java
   // 올바른 코드
   ```
   ✅ 해결: 설명

2. **실수 2: [실수 이름]**
   - 설명

### 💡 팁

- 팁 1
- 팁 2
- 팁 3

### Edge Cases
- [ ] 빈 배열
- [ ] 크기가 1인 배열
- [ ] 모든 원소가 같은 경우
- [ ] 음수가 포함된 경우
- [ ] 오버플로우

---

## 관련 알고리즘

### 비슷한 알고리즘
- [알고리즘 A](링크) - 차이점 설명
- [알고리즘 B](링크) - 차이점 설명

### 함께 사용되는 기법
- [기법 A](링크)
- [기법 B](링크)

---

## 연습 문제

### 난이도별 추천 문제

#### 🟢 Easy
1. [백준 XXXX](링크) - 문제 설명
2. [프로그래머스 XXXX](링크) - 문제 설명

#### 🟡 Medium
1. [백준 XXXX](링크) - 문제 설명
2. [LeetCode XXXX](링크) - 문제 설명

#### 🔴 Hard
1. [백준 XXXX](링크) - 문제 설명
2. [Codeforces XXXX](링크) - 문제 설명

### 문제 풀이 체크리스트
- [ ] Easy 문제 1개 이상 해결
- [ ] Medium 문제 1개 이상 해결
- [ ] 시간 복잡도 분석 연습
- [ ] Edge Case 처리 연습

---

## 참고 자료

### 공식 문서 및 논문
- 원본 논문 링크 (있는 경우)
- 공식 문서

### 추천 학습 자료
- 블로그 아티클
- 유튜브 영상
- 관련 서적

---

**작성일:** YYYY-MM-DD
**최종 수정일:** YYYY-MM-DD
**작성자:** 민순기
