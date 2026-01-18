# 지침
- 답변은 한국어로 한다.
- 민감 정보(DB, API 토큰 등)는 .claude/credentials.sh에 있으니 필요할 때 확인한다.

# 내 정보
- 담당자명: 민순기

# 문서 작성 규칙

## 문서 구조
- `docs/` 폴더에 개발 개념 정리 문서를 관리
- 카테고리: algorithms, data-structures, language-basics, oop, design-patterns, system
- 템플릿: `docs/templates/concept-template.md` 또는 `algorithm-template.md`

## 자동 문서화 워크플로우
사용자가 "이거 문서로 정리해줘" 또는 유사한 요청을 하면:

1. **템플릿 선택**
   - 알고리즘 설명 → `algorithm-template.md` 사용
   - 개념 설명 → `concept-template.md` 사용

2. **카테고리 분류**
   - 정렬, 탐색, DP, 그리디 등 → `algorithms/`
   - 배열, 스택, 큐, 트리, 그래프 → `data-structures/`
   - 변수, 타입, 컬렉션, 람다, 제네릭 → `language-basics/`
   - SOLID, 상속, 다형성, 추상화 → `oop/`
   - 싱글톤, 팩토리, 옵저버 등 → `design-patterns/`
   - 네트워크, DB, OS 관련 → `system/`

3. **문서 작성**
   - 템플릿의 모든 섹션 채우기
   - Java와 Kotlin 예제 모두 포함
   - 실전 활용 예시 필수
   - 주의사항과 팁 포함
   - 연습 문제 추천 (가능한 경우)

4. **인덱스 업데이트 (필수)**
   - `docs/README.md` 열어서 해당 카테고리 섹션 찾기
   - 기존 항목이 있으면: 체크박스 업데이트 ([ ] → [x])
   - **신규 항목인 경우: 반드시 새 항목 추가**
     ```markdown
     - [x] 새로운개념이름
     ```
   - 카테고리 내 알파벳/가나다순 정렬 유지

5. **Git 커밋 및 푸시 (자동)**
   - 새 브랜치 생성 (예: `feature/docs-prefix-sum`)
   - 문서 파일과 `docs/README.md`만 스테이징
   - **한글로 커밋 메시지 작성** (상세 규칙은 `.claude/git-guidelines.md` 참조)
   - 원격 저장소에 푸시
   - PR 생성 안내

6. **완료 보고**
   - 생성된 파일 경로 알림
   - 문서 요약 제공
   - PR 링크 제공

## 작성 원칙
- ✅ 간결하고 명확한 설명
- ✅ 실제 동작하는 코드만 포함
- ✅ 표와 비교 적극 활용
- ✅ 실무/코테 활용법 구체적으로
- ❌ 템플릿 섹션을 비워두지 말 것
- ❌ 동작 안 하는 코드 금지

## 예시
```
사용자: "접근 제어자에 대해 설명해줘. 이해했으니 문서로 정리해줘"
→ concept-template.md 사용
→ docs/language-basics/접근제어자.md 생성
→ docs/README.md 체크리스트 업데이트
→ Git 커밋 및 푸시 (한글 커밋 메시지)
→ PR 생성 안내
```

# Git 작업 규칙

**중요: 모든 Git 관련 규칙은 `.claude/git-guidelines.md`를 참조하세요**

## 핵심 원칙
- ✅ **커밋 메시지는 항상 한글로 작성**
- ✅ **PR 제목과 본문도 항상 한글로 작성**
- ✅ 브랜치명은 영어로 (예: `feature/docs-prefix-sum`)
- ✅ 문서 작성 후 자동으로 커밋 및 푸시 수행

## 커밋 메시지 형식 (한글)
```
제목: 간결한 한글 요약

- 변경 사항 1
- 변경 사항 2

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
```

상세한 가이드라인은 `.claude/git-guidelines.md` 파일을 확인하세요.
