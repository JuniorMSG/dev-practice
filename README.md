# Dev Practice

코딩테스트 연습 + 개발 개념 정리 프로젝트

## 프로젝트 구조

```
dev-practice/
├── java/src/boj/          # 백준 문제 풀이 (Java)
│   ├── dfs/               # DFS 완료 문제
│   └── *.java             # 진행 중(ING) 문제
├── java/src/leetcode/     # LeetCode 문제 풀이
├── java/src/programmers/  # 프로그래머스 문제 풀이
├── kotlin/                # Kotlin 솔루션
├── python/                # Python 솔루션
└── docs/                  # 개발 개념 정리 문서
    ├── algorithms/        # 알고리즘
    ├── data-structures/   # 자료구조
    ├── language-basics/   # 언어 기본
    ├── oop/               # 객체지향
    ├── design-patterns/   # 디자인 패턴
    ├── system/            # 시스템
    └── templates/         # 문서 템플릿
```

## 파일 명명 규칙

```
{유형}_{난이도}_{문제번호}_{회차}_{상태}.java
```

- 예: `DFS_S3_BOJ2606_1_COM.java`, `BFS_S2_BOJ5567_1_ING.java`
- 상태: `ING`(진행중) → `COM`(완료)
- 완료된 문제는 알고리즘별 폴더(`dfs/`, `bfs/` 등)로 이동

## 워크플로우

1. 스켈레톤 파일 생성 + GitHub 이슈 생성
2. 문제 풀이
3. 풀이 완료 → 파일 상태 COM으로 변경 + 알고리즘 폴더로 이동 + 이슈 close

## 풀이 현황

### 완료 (COM)

| # | 문제 | 난이도 | 알고리즘 |
|---|------|--------|---------|
| BOJ 2606 | 바이러스 | 실버 3 | DFS |
| BOJ 10451 | 순열 사이클 | 실버 3 | DFS |
| BOJ 1012 | 유기농 배추 | 실버 2 | DFS |
| BOJ 11123 | 양 한마리... 양 두마리... | 실버 2 | DFS |
| BOJ 11724 | 연결 요소의 개수 | 실버 2 | DFS |
| BOJ 11725 | 트리의 부모 찾기 | 실버 2 | DFS |
| BOJ 2644 | 촌수계산 | 실버 2 | DFS |
| BOJ 4963 | 섬의 개수 | 실버 2 | DFS |
| BOJ 1743 | 음식물 피하기 | 실버 1 | DFS |
| BOJ 1926 | 그림 | 실버 1 | DFS |
| BOJ 2667 | 단지번호붙이기 | 실버 1 | DFS |

### 진행 중 (ING)

| # | 문제 | 난이도 | 알고리즘 | 이슈 |
|---|------|--------|---------|------|
| BOJ 1388 | 바닥 장식 | 실버 4 | DFS | [#19](https://github.com/JuniorMSG/dev-practice/issues/19) |
| BOJ 2331 | 반복수열 | 실버 4 | DFS | [#20](https://github.com/JuniorMSG/dev-practice/issues/20) |
| BOJ 1260 | DFS와 BFS | 실버 2 | DFS | [#21](https://github.com/JuniorMSG/dev-practice/issues/21) |
| BOJ 24479 | 알고리즘 수업 - 깊이 우선 탐색 1 | 실버 2 | DFS | [#22](https://github.com/JuniorMSG/dev-practice/issues/22) |
| BOJ 5567 | 결혼식 | 실버 2 | BFS | [#23](https://github.com/JuniorMSG/dev-practice/issues/23) |
| BOJ 1012 | 유기농 배추 (재풀이) | 실버 2 | DFS | [#24](https://github.com/JuniorMSG/dev-practice/issues/24) |
| BOJ 11403 | 경로 찾기 | 실버 1 | DFS | [#25](https://github.com/JuniorMSG/dev-practice/issues/25) |
| BOJ 13023 | ABCDE | 실버 1 | DFS | [#26](https://github.com/JuniorMSG/dev-practice/issues/26) |
| BOJ 1303 | 전쟁 - 전투 | 실버 1 | DFS | [#27](https://github.com/JuniorMSG/dev-practice/issues/27) |
| BOJ 1325 | 효율적인 해킹 | 실버 1 | DFS | [#28](https://github.com/JuniorMSG/dev-practice/issues/28) |
| BOJ 2468 | 안전 영역 | 실버 1 | DFS | [#29](https://github.com/JuniorMSG/dev-practice/issues/29) |
| BOJ 2583 | 영역 구하기 | 실버 1 | DFS | [#30](https://github.com/JuniorMSG/dev-practice/issues/30) |
| BOJ 10026 | 적록색약 | 골드 5 | DFS | [#31](https://github.com/JuniorMSG/dev-practice/issues/31) |
| BOJ 1707 | 이분 그래프 | 골드 4 | DFS | [#32](https://github.com/JuniorMSG/dev-practice/issues/32) |

## 개발 개념 문서

상세 목록은 [docs/README.md](docs/README.md) 참고

| 카테고리 | 작성 완료 |
|---------|----------|
| 알고리즘 | BFS, DFS, 구간합 |
| 자료구조 | 배열과 리스트, 스택 |
| 언어 기본 | 접근 제어자 |
| 시스템 | Git 기본 |
