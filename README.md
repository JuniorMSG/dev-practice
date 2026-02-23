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

## 개발 개념 문서

상세 목록은 [docs/README.md](docs/README.md) 참고

| 카테고리  | 작성 완료         |
|-------|---------------|
| 알고리즘  | BFS, DFS, 구간합 |
| 자료구조  | 배열과 리스트, 스택   |
| 언어 기본 | 접근 제어자        |
| 시스템   | Git 기본        |
