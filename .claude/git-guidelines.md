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

### 예시
```
✅ 좋은 예:
feature/docs-prefix-sum
docs/data-structures
fix/array-index-error
refactor/optimize-search

❌ 나쁜 예:
add-docs
my-branch
temp
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
