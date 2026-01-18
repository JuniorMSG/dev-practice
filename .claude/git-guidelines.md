# Git 커밋 및 PR 가이드라인

> Claude가 Git 작업을 수행할 때 따라야 하는 규칙

## 커밋 메시지 규칙

### 언어
- **모든 커밋 메시지는 한글로 작성**
- 제목과 본문 모두 한글 사용

### 형식
```
제목: 간결한 한글 요약 (50자 이내)

본문:
- 변경 사항 1
- 변경 사항 2
- 변경 사항 3

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
```

### 예시
```
✅ 좋은 예:
구간합(Prefix Sum) 알고리즘 문서 작성

- 1차원/2차원 구간합 개념 및 구현 추가
- Java, Kotlin 예제 코드 포함
- 백준 문제 추천 및 주의사항 정리

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>

❌ 나쁜 예:
Add prefix sum documentation

- Added 1D/2D prefix sum concepts
- Java and Kotlin examples included
```

### 커밋 제목 가이드
- 동사로 시작: "추가", "수정", "삭제", "리팩토링", "문서 작성" 등
- 명확하고 구체적으로
- 이모지 사용하지 않음

## Pull Request 규칙

### 언어
- **모든 PR 제목과 본문은 한글로 작성**

### PR 제목 형식
```
[카테고리] 간결한 설명
```

예시:
- `[문서] 구간합 알고리즘 문서 추가`
- `[알고리즘] BFS 구현 및 테스트 코드 작성`
- `[자료구조] 스택과 큐 개념 정리`

### PR 본문 형식
```markdown
## 요약
변경 사항을 1-3개 bullet point로 요약

## 상세 내용
구체적인 변경 사항 설명

## 테스트 계획
- [ ] 테스트 항목 1
- [ ] 테스트 항목 2

🤖 Generated with [Claude Code](https://claude.com/claude-code)
```

### PR 본문 예시
```markdown
## 요약
- 구간합(Prefix Sum) 알고리즘 문서 작성
- 1차원 및 2차원 구간합 구현 포함
- Java, Kotlin 예제 코드 및 연습 문제 추가

## 상세 내용
### 추가된 내용
- `docs/algorithms/구간합.md` 파일 생성
  - 개념 설명 및 동작 원리
  - 시간/공간 복잡도 분석
  - Java, Kotlin 구현 예제
  - 2차원 구간합 구현
  - 문제 유형별 패턴 및 솔루션
  - 백준/LeetCode 연습 문제 추천

- `docs/README.md` 업데이트
  - 알고리즘 목록에 구간합 추가
  - 최근 업데이트 목록 갱신

### 주요 특징
- 1-based 인덱싱을 통한 예외 처리 최적화 방법 포함
- 오버플로우 방지를 위한 Long 타입 사용법 설명
- 나머지 합 문제 패턴 및 해시맵 활용법 추가

## 테스트 계획
- [ ] 예제 코드가 모두 컴파일되고 실행되는지 확인
- [ ] 문서 링크가 정상적으로 작동하는지 확인
- [ ] 백준 문제 링크 유효성 검증

🤖 Generated with [Claude Code](https://claude.com/claude-code)
```

## 브랜치 명명 규칙

### 형식
```
<타입>/<간단한-설명>
```

### 타입
- `feature/` - 새로운 기능 추가
- `docs/` - 문서 작성 또는 수정
- `fix/` - 버그 수정
- `refactor/` - 리팩토링
- `test/` - 테스트 코드
- `solve/` - 코딩테스트 문제 풀이

### 예시
```
✅ 좋은 예:
feature/docs-prefix-sum
docs/data-structures
fix/array-index-error
refactor/optimize-search
solve/boj-1234
solve/programmers-42576

❌ 나쁜 예:
add-docs
my-branch
temp
problem-1234
```

## PR 머지 규칙

### 기본 원칙
- **모든 PR은 스쿼시 머지(Squash Merge)로 진행**
- 머지 후 자동으로 브랜치 삭제
- 깔끔한 커밋 히스토리 유지

### 스쿼시 머지를 사용하는 이유
- ✅ 여러 커밋을 하나로 합쳐 히스토리가 깔끔함
- ✅ main 브랜치에 의미 있는 단위의 커밋만 남음
- ✅ 되돌리기가 쉬움 (하나의 커밋만 revert)
- ✅ 작업 중 생긴 수정 커밋들이 히스토리를 어지럽히지 않음

### 자동 머지 명령어
```bash
# 사용자가 "머지해줘" 또는 "PR 머지" 요청 시:
gh pr merge <PR번호> --squash --delete-branch
```

### 예시
```bash
# PR #5를 스쿼시 머지하고 브랜치 삭제
gh pr merge 5 --squash --delete-branch
```

### 머지 시 주의사항
- ✅ CI/CD 체크가 모두 통과했는지 확인
- ✅ 코드 리뷰가 완료되었는지 확인 (필요한 경우)
- ✅ 충돌이 없는지 확인
- ❌ main/master 브랜치에 직접 푸시 금지

## 자동화 워크플로우

### 1. 문서 작성 후 자동 커밋 및 푸시
사용자가 "문서로 정리해줘" 요청 시:

1. 문서 작성 완료
2. 적절한 브랜치명으로 새 브랜치 생성
3. 관련 파일만 스테이징
4. **한글 커밋 메시지**로 커밋
5. 원격 저장소에 푸시
6. **자동으로 PR 생성** (한글 제목/본문)
7. PR 링크 안내

### 2. PR 자동 머지
사용자가 "머지해줘" 또는 "PR 머지" 요청 시:

1. 열린 PR 목록 확인
2. 해당 PR을 **스쿼시 머지**로 병합
3. 자동으로 브랜치 삭제
4. 머지 완료 알림

### 커밋 시 포함할 파일
- 새로 작성한 문서 파일
- `docs/README.md` (인덱스 업데이트)
- 관련된 변경 사항만 포함 (무관한 파일 제외)

## 주의사항

### 반드시 지킬 것
- ✅ 커밋 메시지는 항상 한글
- ✅ PR 제목과 본문도 항상 한글
- ✅ 브랜치명은 영어로 (kebab-case)
- ✅ 한 커밋에는 하나의 논리적 변경사항만
- ✅ 민감 정보(.env, credentials 등) 절대 커밋 금지

### 하지 말 것
- ❌ 영어로 커밋 메시지 작성
- ❌ "update", "fix", "change" 같은 영어 제목
- ❌ 무의미한 커밋 메시지 ("수정", "변경" 등)
- ❌ 여러 개의 무관한 변경사항을 한 커밋에 포함
- ❌ force push to main/master

## 코딩테스트 워크플로우

### 개요

코딩테스트 문제 풀이를 **이슈로 관리**하고, 풀이를 **PR로 제출**하는 체계적인 워크플로우입니다.

**장점:**
- ✅ 풀어야 할 문제를 To-Do 리스트처럼 관리
- ✅ 진행 상황 추적 (Open/In Progress/Closed)
- ✅ 문제별로 난이도, 알고리즘 태그 라벨 붙이기
- ✅ PR과 자동 연결로 풀이 완료 시 이슈 자동 닫힘
- ✅ 나중에 풀이 히스토리 확인 용이

### 워크플로우

#### Step 1: 이슈 생성 (문제 등록)

풀고 싶은 문제를 이슈로 등록합니다.

**이슈 제목 형식:**
```
[플랫폼 번호] 문제 이름
```

**예시:**
- `[백준 1234] 최단경로`
- `[프로그래머스 42576] 완주하지 못한 선수`
- `[LeetCode 1] Two Sum`

**이슈 본문 템플릿:**
```markdown
## 📋 문제 정보
- **플랫폼**: 백준 / 프로그래머스 / LeetCode
- **번호**: 1234
- **난이도**: 골드 3 / Level 2 / Medium
- **링크**: https://www.acmicpc.net/problem/1234

## 🏷️ 분류
- 알고리즘: DP, 그리디, DFS/BFS 등
- 자료구조: 배열, 스택, 큐, 트리 등

## 🎯 목표
- [ ] 문제 이해 및 분석
- [ ] 알고리즘 설계
- [ ] 코드 작성
- [ ] 테스트 케이스 통과
- [ ] 시간/공간 복잡도 분석

## 💡 힌트 (선택)
- 핵심 아이디어나 접근 방법 메모
```

**라벨 추천:**
- 난이도: `easy`, `medium`, `hard`, `bronze`, `silver`, `gold`, `platinum`
- 알고리즘: `DP`, `greedy`, `DFS/BFS`, `binary-search`, `two-pointer`
- 자료구조: `array`, `stack`, `queue`, `tree`, `graph`
- 상태: `todo`, `in-progress`, `solved`

#### Step 2: 브랜치 생성 및 문제 풀이

이슈를 할당받았으면 브랜치를 생성하고 문제를 풉니다.

**브랜치 명명 규칙:**
```
solve/<플랫폼>-<번호>
```

**예시:**
```bash
# 백준 1234번 문제
git checkout -b solve/boj-1234

# 프로그래머스 42576번 문제
git checkout -b solve/programmers-42576

# LeetCode 1번 문제
git checkout -b solve/leetcode-1
```

**파일 위치:**
```
java/src/
├── boj/
│   ├── Boj1234.java
│   └── Boj1234Main.java
├── programmers/
│   └── Programmers42576.java
└── leetcode/
    └── LeetCode1.java
```

**커밋 메시지:**
```
[플랫폼 번호] 문제 이름 풀이

- 알고리즘: DP
- 시간복잡도: O(N²)
- 공간복잡도: O(N)

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
```

#### Step 3: PR 생성 및 이슈 연결

풀이가 완료되면 PR을 생성하고 이슈를 연결합니다.

**PR 제목 형식:**
```
[풀이] 플랫폼 번호 - 문제 이름
```

**예시:**
- `[풀이] 백준 1234 - 최단경로`
- `[풀이] 프로그래머스 42576 - 완주하지 못한 선수`

**PR 본문 템플릿:**
```markdown
Closes #이슈번호

## 📊 풀이 요약
- **알고리즘**: DP / 그리디 / DFS/BFS
- **시간복잡도**: O(N²)
- **공간복잡도**: O(N)
- **소요 시간**: 30분

## 💡 핵심 아이디어
문제를 어떻게 접근했고, 어떤 알고리즘/자료구조를 사용했는지 간략히 설명

예시:
- 2차원 DP 배열을 사용하여 부분 문제의 최적해를 저장
- Bottom-up 방식으로 작은 문제부터 해결
- 점화식: dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + cost[i][j]

## 🧪 테스트 결과
- [ ] 예제 테스트 케이스 통과
- [ ] 엣지 케이스 테스트 (빈 배열, 크기 1, 최대 크기 등)
- [ ] 제출 결과: 통과 / 시간초과 / 메모리초과

## 📝 배운 점
이 문제를 풀면서 배운 점, 어려웠던 점, 개선할 점 등

예시:
- DP 배열 초기화 시 INF 값 설정 방법
- 메모이제이션을 통한 중복 계산 방지
- 시간복잡도 개선을 위한 최적화 기법

## 🔗 참고 자료 (선택)
- 관련 알고리즘 문서 링크
- 참고한 풀이나 블로그 (있는 경우)

🤖 Generated with [Claude Code](https://claude.com/claude-code)
```

**이슈 자동 닫기 키워드:**
- `Closes #123` - PR 머지 시 이슈 자동 닫힘
- `Fixes #123` - 동일
- `Resolves #123` - 동일

#### Step 4: 머지 및 완료

```bash
# PR 스쿼시 머지 (자동으로 이슈 닫힘)
gh pr merge <PR번호> --squash --delete-branch
```

### 전체 플로우 예시

```bash
# 1. 이슈 생성 (GitHub 웹에서)
# Issue #10: [백준 1234] 최단경로
# 라벨: gold3, DP, graph

# 2. 브랜치 생성
git checkout -b solve/boj-1234

# 3. 문제 풀이
# java/src/boj/Boj1234.java 작성

# 4. 커밋
git add java/src/boj/Boj1234.java
git commit -m "[백준 1234] 최단경로 풀이

- 알고리즘: 다익스트라 (우선순위 큐)
- 시간복잡도: O(E log V)
- 공간복잡도: O(V)

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>"

# 5. 푸시 및 PR 생성
git push -u origin solve/boj-1234
gh pr create --title "[풀이] 백준 1234 - 최단경로" --body "..."

# 6. PR 머지 (이슈 #10 자동 닫힘)
gh pr merge <PR번호> --squash --delete-branch
```

### 유용한 GitHub CLI 명령어

```bash
# 이슈 생성
gh issue create --title "[백준 1234] 최단경로" --body "..." --label "gold3,DP"

# 이슈 목록 보기
gh issue list --label "todo"

# 이슈 할당
gh issue develop 10 --checkout

# PR과 이슈 연결 확인
gh pr view <PR번호>
```

### 팁

1. **주간 목표 설정**: 매주 월요일에 풀 문제를 이슈로 등록
2. **난이도별 라벨**: 쉬운 문제부터 차근차근 진행
3. **알고리즘별 분류**: 부족한 알고리즘 유형 집중 공략
4. **풀이 복습**: 나중에 PR 히스토리를 보며 복습
5. **통계 확인**: GitHub Insights에서 진행 상황 추적

---

## 문서 작성 후 학습 항목 이슈화

### 개요

문서를 작성한 후, 해당 문서의 **연습 문제**나 **학습 항목**을 이슈로 발행하여 체계적으로 관리합니다.

**적용 대상:**
- ✅ 알고리즘 문서의 연습 문제
- ✅ 자료구조 문서의 실습 문제
- ✅ 개념 문서의 학습 체크리스트
- ✅ 프로젝트 To-Do 리스트

**장점:**
- ✅ 학습 진행 상황을 GitHub 이슈로 추적
- ✅ 완료된 항목은 PR로 기록
- ✅ 라벨로 난이도/카테고리 분류
- ✅ 마일스톤으로 학습 단계 관리

### 워크플로우

#### Step 1: 라벨 생성 (최초 1회)

프로젝트에서 사용할 라벨을 미리 생성합니다.

**난이도 라벨:**
```bash
gh label create "easy" --color "0E8A16" --description "쉬운 난이도"
gh label create "medium" --color "FBCA04" --description "중간 난이도"
gh label create "hard" --color "D73A4A" --description "어려운 난이도"
```

**알고리즘/자료구조 라벨:**
```bash
gh label create "구간합" --color "1D76DB" --description "구간합 알고리즘"
gh label create "DP" --color "1D76DB" --description "동적 프로그래밍"
gh label create "그래프" --color "1D76DB" --description "그래프 알고리즘"
```

**플랫폼 라벨:**
```bash
gh label create "백준" --color "5319E7" --description "백준 온라인 저지"
gh label create "프로그래머스" --color "FF6B6B" --description "프로그래머스"
gh label create "LeetCode" --color "FFA500" --description "LeetCode"
```

**카테고리 라벨:**
```bash
gh label create "문서" --color "0075CA" --description "문서 작성/수정"
gh label create "코딩테스트" --color "D4C5F9" --description "코딩테스트 문제"
gh label create "개념학습" --color "C2E0C6" --description "개념 학습"
```

#### Step 2: 문서 작성 완료

문서를 작성하고 PR을 머지합니다. (기존 워크플로우)

**예시:**
- `docs/algorithms/구간합.md` 작성 완료
- 문서에 연습 문제 10개 포함

#### Step 3: 연습 문제를 이슈로 발행

문서의 연습 문제나 학습 항목을 이슈로 발행합니다.

**이슈 템플릿 (코딩테스트 문제):**
```bash
gh issue create \
  --title "[백준 11659] 구간 합 구하기 4" \
  --label "easy,구간합,백준,코딩테스트" \
  --body "## 📋 문제 정보
- **플랫폼**: 백준
- **번호**: 11659
- **난이도**: 실버 3
- **링크**: https://www.acmicpc.net/problem/11659

## 🏷️ 분류
- 알고리즘: 구간합
- 자료구조: 배열

## 📝 설명
1차원 기본 구간 합 문제

## 🎯 목표
- [ ] 문제 이해 및 분석
- [ ] 알고리즘 설계
- [ ] 코드 작성
- [ ] 테스트 케이스 통과

## 💡 힌트
- 누적 합 배열을 미리 계산
- 쿼리마다 O(1)에 답 계산"
```

**이슈 템플릿 (개념 학습):**
```bash
gh issue create \
  --title "[학습] SOLID 원칙 이해하기" \
  --label "medium,개념학습" \
  --body "## 📚 학습 목표
- [ ] SRP (단일 책임 원칙) 이해
- [ ] OCP (개방-폐쇄 원칙) 이해
- [ ] LSP (리스코프 치환 원칙) 이해
- [ ] ISP (인터페이스 분리 원칙) 이해
- [ ] DIP (의존성 역전 원칙) 이해

## 🔗 참고 자료
- docs/oop/SOLID원칙.md

## ✅ 완료 조건
- 각 원칙을 예제 코드로 설명할 수 있음
- 실제 프로젝트에 적용 가능"
```

#### Step 4: 이슈 관리

발행된 이슈들을 필터링하여 관리합니다.

```bash
# 난이도별 조회
gh issue list --label "easy"
gh issue list --label "medium"
gh issue list --label "hard"

# 카테고리별 조회
gh issue list --label "코딩테스트"
gh issue list --label "개념학습"

# 플랫폼별 조회
gh issue list --label "백준"
gh issue list --label "LeetCode"

# 상태별 조회
gh issue list --state open
gh issue list --state closed
```

### 실제 예시: 구간합 문서

#### 1. 문서 작성 및 머지
```bash
# docs/algorithms/구간합.md 작성
# PR 생성 및 머지 완료
```

#### 2. 연습 문제 10개를 이슈로 발행

**Easy 문제 (3개):**
```bash
gh issue create --title "[백준 11659] 구간 합 구하기 4" --label "easy,구간합,백준"
gh issue create --title "[백준 2559] 수열" --label "easy,구간합,백준"
gh issue create --title "[LeetCode 303] Range Sum Query" --label "easy,구간합,LeetCode"
```

**Medium 문제 (4개):**
```bash
gh issue create --title "[백준 11660] 구간 합 구하기 5" --label "medium,구간합,백준"
gh issue create --title "[백준 10986] 나머지 합" --label "medium,구간합,백준"
gh issue create --title "[백준 16713] Generic Queries" --label "medium,구간합,백준"
gh issue create --title "[LeetCode 304] Range Sum Query 2D" --label "medium,구간합,LeetCode"
```

**Hard 문제 (3개):**
```bash
gh issue create --title "[백준 2143] 두 배열의 합" --label "hard,구간합,백준"
gh issue create --title "[백준 1849] 순열" --label "hard,백준"
gh issue create --title "[LeetCode 363] Max Sum Rectangle" --label "hard,구간합,LeetCode"
```

#### 3. 이슈 목록 확인

```bash
$ gh issue list

17  [LeetCode 363] Max Sum of Rectangle    hard, 구간합, LeetCode
16  [백준 1849] 순열                        hard, 백준
15  [백준 2143] 두 배열의 합                hard, 구간합, 백준
14  [LeetCode 304] Range Sum Query 2D      medium, 구간합, LeetCode
13  [백준 16713] Generic Queries           medium, 구간합, 백준
12  [백준 10986] 나머지 합                  medium, 구간합, 백준
11  [백준 11660] 구간 합 구하기 5           medium, 구간합, 백준
10  [LeetCode 303] Range Sum Query         easy, 구간합, LeetCode
9   [백준 2559] 수열                        easy, 구간합, 백준
8   [백준 11659] 구간 합 구하기 4           easy, 구간합, 백준
```

#### 4. 문제 풀이 시작

```bash
# 이슈 #8 선택
gh issue develop 8 --checkout

# solve/8 브랜치가 자동 생성되고 체크아웃
# 문제 풀이 진행...
```

### 자동화 팁

반복 작업을 스크립트로 자동화할 수 있습니다:

**`.claude/scripts/create-issues-from-doc.sh` (예시):**
```bash
#!/bin/bash
# 문서에서 추출한 문제들을 이슈로 발행

LABEL_BASE="구간합,코딩테스트"

# Easy 문제들
gh issue create --title "[백준 11659] 구간 합 구하기 4" \
  --label "easy,$LABEL_BASE,백준" --body "..."

gh issue create --title "[백준 2559] 수열" \
  --label "easy,$LABEL_BASE,백준" --body "..."

# ... 나머지 문제들
```

### 마일스톤 활용

학습 단계별로 마일스톤을 생성하여 관리할 수 있습니다:

```bash
# 마일스톤 생성
gh issue milestone create "구간합 마스터" \
  --description "구간합 알고리즘 완벽 정복" \
  --due-date "2026-02-01"

# 이슈에 마일스톤 할당
gh issue edit 8 --milestone "구간합 마스터"
gh issue edit 9 --milestone "구간합 마스터"
```

### 프로젝트 보드 활용

GitHub Projects로 칸반 보드를 만들어 관리:

```bash
# 프로젝트 보드 생성 (GitHub 웹에서)
# To Do / In Progress / Done 컬럼 생성

# 이슈를 보드에 추가
gh project item-add <프로젝트번호> --owner <소유자> --url <이슈URL>
```

### 학습 통계 확인

```bash
# 완료된 문제 수
gh issue list --state closed --label "코딩테스트" | wc -l

# 난이도별 완료 현황
gh issue list --state closed --label "easy" | wc -l
gh issue list --state closed --label "medium" | wc -l
gh issue list --state closed --label "hard" | wc -l

# 플랫폼별 완료 현황
gh issue list --state closed --label "백준" | wc -l
gh issue list --state closed --label "LeetCode" | wc -l
```

### 권장 워크플로우 정리

1. **문서 작성** → 알고리즘/개념 정리
2. **연습 문제 이슈화** → 학습 항목을 이슈로 등록
3. **라벨링** → 난이도, 카테고리 분류
4. **순차적 학습** → Easy부터 시작
5. **PR로 기록** → 풀이를 PR로 제출
6. **이슈 자동 닫힘** → PR 머지 시 완료
7. **통계 확인** → 진행 상황 추적

---

## 예시 시나리오

### 시나리오 1: 새 알고리즘 문서 작성
```bash
# 1. 브랜치 생성
git checkout -b feature/docs-dijkstra

# 2. 파일 추가
git add docs/algorithms/다익스트라.md docs/README.md

# 3. 한글 커밋
git commit -m "다익스트라 알고리즘 문서 작성

- 최단 경로 알고리즘 개념 설명
- 우선순위 큐를 활용한 구현
- Java, Kotlin 예제 코드 포함

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>"

# 4. 푸시
git push -u origin feature/docs-dijkstra
```

### 시나리오 2: 기존 문서 수정
```bash
# 1. 브랜치 생성
git checkout -b docs/update-bfs

# 2. 파일 추가
git add docs/algorithms/BFS.md

# 3. 한글 커밋
git commit -m "BFS 문서 예제 코드 개선

- 2차원 배열 탐색 예제 추가
- 방문 체크 최적화 방법 설명
- 주의사항 섹션 보강

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>"

# 4. 푸시
git push -u origin docs/update-bfs
```

---

**작성일:** 2026-01-19
**담당자:** 민순기
