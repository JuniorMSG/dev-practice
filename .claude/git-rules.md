# Git 기본 규칙

> 커밋, PR, 브랜치, 머지에 대한 기본 규칙

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

---

## Pull Request 규칙

### 언어
- **모든 PR 제목과 본문은 한글로 작성**

### PR 제목 형식
```
[카테고리] 간결한 설명
```

**예시:**
- `[문서] 구간합 알고리즘 문서 추가`
- `[알고리즘] BFS 구현 및 테스트 코드 작성`
- `[자료구조] 스택과 큐 개념 정리`
- `[풀이] 백준 1234 - 최단경로`

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

---

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

---

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

---

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

---

**작성일:** 2026-01-19
**담당자:** 민순기
