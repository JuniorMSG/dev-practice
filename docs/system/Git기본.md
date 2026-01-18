# Git 기본

> 한 줄 요약: 분산 버전 관리 시스템으로, 코드 변경 이력을 추적하고 협업을 지원하는 필수 개발 도구

## 📌 목차

- [개요](#개요)
- [핵심 개념](#핵심-개념)
- [주요 명령어](#주요-명령어)
- [브랜치 전략](#브랜치-전략)
- [실전 활용](#실전-활용)
- [주의사항](#주의사항)

---

## 개요

### Git이란?

**Git**은 리누스 토르발스가 2005년에 개발한 분산 버전 관리 시스템(VCS)입니다.

### 주요 특징

- ✅ **분산형 구조**: 중앙 서버 없이도 로컬에서 완전한 작업 가능
- ✅ **빠른 성능**: 대부분의 작업이 로컬에서 진행
- ✅ **브랜치**: 가볍고 빠른 브랜치 생성/병합
- ✅ **무결성**: SHA-1 해시로 모든 데이터 체크섬 관리
- ✅ **협업 지원**: 여러 개발자가 동시에 작업 가능

### 왜 Git을 사용하는가?

| 상황       | Git 없이     | Git 사용         |
|----------|------------|----------------|
| 코드 백업    | 파일 복사, ZIP | 커밋으로 이력 관리     |
| 이전 버전 복구 | 파일명에 날짜 표시 | `git checkout` |
| 협업       | 이메일, USB   | GitHub/GitLab  |
| 실험적 기능   | 주석 처리      | 브랜치 생성         |
| 충돌 해결    | 수동 비교      | 자동 머지 지원       |

---

## 핵심 개념

### 1. 작업 영역 (Working Areas)

Git은 3가지 주요 영역으로 구성됩니다:

```
┌─────────────────┐
│ Working Directory│  ← 실제 작업하는 파일들
└────────┬────────┘
         │ git add
         ↓
┌─────────────────┐
│  Staging Area   │  ← 커밋 준비 영역 (Index)
└────────┬────────┘
         │ git commit
         ↓
┌─────────────────┐
│   Repository    │  ← Git 데이터베이스 (.git)
└─────────────────┘
```

**예시:**

```bash
# 1. Working Directory에서 파일 수정
echo "Hello Git" > README.md

# 2. Staging Area에 추가
git add README.md

# 3. Repository에 커밋
git commit -m "Add README"
```

### 2. 파일 상태

```
Untracked  →  Unmodified  →  Modified  →  Staged
   ↑            │                           │
   └────────────┴───────────────────────────┘
              (git add / git commit)
```

| 상태         | 의미                | 명령어          |
|------------|-------------------|--------------|
| Untracked  | Git이 추적하지 않는 파일   | `git add`    |
| Unmodified | 수정되지 않은 파일        | -            |
| Modified   | 수정되었지만 staged 안 됨 | `git add`    |
| Staged     | 커밋 준비된 파일         | `git commit` |

### 3. 커밋 (Commit)

**커밋**은 프로젝트의 스냅샷입니다.

```
커밋 구조:
┌──────────────────┐
│ Commit Hash      │ ← SHA-1 해시 (고유 ID)
│ Author & Date    │ ← 작성자 정보
│ Commit Message   │ ← 커밋 메시지
│ Parent Commit(s) │ ← 이전 커밋 참조
│ Tree (Files)     │ ← 파일 트리 스냅샷
└──────────────────┘
```

### 4. 브랜치 (Branch)

**브랜치**는 커밋을 가리키는 포인터입니다.

```
main:    A ← B ← C
              ↖
feature:       D ← E

HEAD → feature (현재 작업 중인 브랜치)
```

---

## 주요 명령어

### 초기 설정

```bash
# 사용자 정보 설정 (최초 1회)
git config --global user.name "민순기"
git config --global user.email "your@email.com"

# 설정 확인
git config --list
```

### 저장소 생성 및 복제

```bash
# 새 저장소 초기화
git init

# 기존 저장소 복제
git clone https://github.com/username/repo.git

# 특정 브랜치 복제
git clone -b develop https://github.com/username/repo.git
```

### 기본 작업 흐름

#### 1. 상태 확인

```bash
# 현재 상태 확인
git status

# 간략하게 보기
git status -s
```

#### 2. 변경사항 추가

```bash
# 특정 파일 추가
git add README.md

# 모든 변경사항 추가
git add .

# 확장자별 추가
git add *.java

# 대화형 추가
git add -i
```

#### 3. 커밋

```bash
# 커밋 메시지와 함께
git commit -m "Add feature"

# 여러 줄 메시지
git commit -m "Add login feature

- Add user authentication
- Implement session management
- Add login UI"

# add + commit 동시에 (tracked 파일만)
git commit -am "Update docs"
```

#### 4. 변경사항 확인

```bash
# Working Directory vs Staging Area
git diff

# Staging Area vs Repository
git diff --staged

# 특정 파일만
git diff README.md

# 브랜치 간 비교
git diff main feature
```

#### 5. 히스토리 확인

```bash
# 커밋 로그
git log

# 한 줄로 보기
git log --oneline

# 그래프로 보기
git log --graph --oneline --all

# 최근 n개 커밋
git log -3

# 특정 파일 히스토리
git log -- README.md

# 변경 내용 포함
git log -p
```

### 브랜치 관리

```bash
# 브랜치 목록
git branch

# 원격 브랜치 포함
git branch -a

# 새 브랜치 생성
git branch feature/login

# 브랜치 생성 + 전환
git checkout -b feature/signup
# 또는 (Git 2.23+)
git switch -c feature/signup

# 브랜치 전환
git checkout main
# 또는
git switch main

# 브랜치 삭제
git branch -d feature/login

# 강제 삭제 (머지 안 된 브랜치)
git branch -D feature/old

# 브랜치 이름 변경
git branch -m old-name new-name
```

### 병합 (Merge)

```bash
# feature 브랜치를 현재 브랜치에 병합
git merge feature/login

# Fast-forward 방지 (머지 커밋 생성)
git merge --no-ff feature/login

# 충돌 발생 시
# 1. 충돌 파일 수정
# 2. git add <파일>
# 3. git commit

# 머지 취소
git merge --abort
```

### 원격 저장소

```bash
# 원격 저장소 확인
git remote -v

# 원격 저장소 추가
git remote add origin https://github.com/user/repo.git

# 원격 저장소 URL 변경
git remote set-url origin https://github.com/user/new-repo.git

# 원격 브랜치 확인
git branch -r

# 원격에서 가져오기 (머지 안 함)
git fetch origin

# 원격에서 가져오기 + 머지
git pull origin main

# 원격으로 푸시
git push origin main

# 새 브랜치 푸시 + 추적 설정
git push -u origin feature/new

# 강제 푸시 (위험!)
git push --force origin main
```

### 되돌리기

```bash
# Working Directory 변경 취소
git restore README.md
# 또는 (구버전)
git checkout -- README.md

# Staging 취소
git restore --staged README.md
# 또는
git reset HEAD README.md

# 마지막 커밋 수정 (메시지 변경)
git commit --amend -m "New message"

# 마지막 커밋 수정 (파일 추가)
git add forgotten-file.txt
git commit --amend --no-edit

# 특정 커밋으로 되돌리기 (커밋 이력 유지)
git revert <commit-hash>

# 특정 커밋으로 되돌리기 (이력 삭제, 위험!)
git reset --hard <commit-hash>

# 최근 n개 커밋 취소
git reset --soft HEAD~3  # 파일은 staged 상태 유지
git reset --mixed HEAD~3 # 파일은 modified 상태로 (기본)
git reset --hard HEAD~3  # 파일까지 삭제 (위험!)
```

### Stash (임시 저장)

```bash
# 현재 작업 임시 저장
git stash

# 메시지와 함께 저장
git stash save "WIP: login feature"

# stash 목록
git stash list

# 가장 최근 stash 적용
git stash apply

# 가장 최근 stash 적용 + 삭제
git stash pop

# 특정 stash 적용
git stash apply stash@{2}

# stash 삭제
git stash drop stash@{0}

# 모든 stash 삭제
git stash clear
```

### 태그 (Tag)

```bash
# 태그 목록
git tag

# 경량 태그 생성
git tag v1.0.0

# 주석 태그 생성
git tag -a v1.0.0 -m "Release version 1.0.0"

# 특정 커밋에 태그
git tag v1.0.0 9fceb02

# 태그 푸시
git push origin v1.0.0

# 모든 태그 푸시
git push origin --tags

# 태그 삭제
git tag -d v1.0.0
git push origin :refs/tags/v1.0.0
```

---

## 브랜치 전략

### Git Flow

가장 널리 사용되는 브랜치 전략입니다.

```
main        ─────────────●───────────●──────
             (release)    ↑           ↑
develop     ─●─●─●─●─●─●─┴─●─●─●─●─●─┴──●─●─
             │   ↑   ↑       │
feature     ─┴─●─┘   │       │
hotfix              ─┴─●─────┘
```

**브랜치 종류:**

| 브랜치           | 용도        | 생명주기 |
|---------------|-----------|------|
| `main`        | 배포 가능한 상태 | 영구   |
| `develop`     | 개발 브랜치    | 영구   |
| `feature/xxx` | 새 기능 개발   | 임시   |
| `release/x.x` | 릴리스 준비    | 임시   |
| `hotfix/xxx`  | 긴급 버그 수정  | 임시   |

**워크플로우:**

```bash
# 1. 기능 개발
git checkout -b feature/login develop
# ... 개발 ...
git checkout develop
git merge --no-ff feature/login
git branch -d feature/login

# 2. 릴리스 준비
git checkout -b release/1.0 develop
# ... 버그 수정 ...
git checkout main
git merge --no-ff release/1.0
git tag -a v1.0.0
git checkout develop
git merge --no-ff release/1.0
git branch -d release/1.0

# 3. 긴급 수정
git checkout -b hotfix/critical-bug main
# ... 수정 ...
git checkout main
git merge --no-ff hotfix/critical-bug
git tag -a v1.0.1
git checkout develop
git merge --no-ff hotfix/critical-bug
git branch -d hotfix/critical-bug
```

### GitHub Flow

Git Flow보다 단순한 전략입니다.

```
main    ─●───────●─────●───────●──
          ↖     ↗ ↖   ↗ ↖     ↗
feature    ●─●─●   ●─●   ●─●─●
```

**특징:**

- `main` 브랜치만 영구 유지
- 모든 작업은 feature 브랜치에서
- PR(Pull Request)로 코드 리뷰 후 머지

**워크플로우:**

```bash
# 1. 브랜치 생성
git checkout -b feature/new-ui main

# 2. 작업 + 커밋
git add .
git commit -m "Add new UI"

# 3. 푸시
git push -u origin feature/new-ui

# 4. GitHub에서 Pull Request 생성

# 5. 리뷰 후 main에 머지 (GitHub UI)

# 6. 로컬에서 동기화
git checkout main
git pull
git branch -d feature/new-ui
```

### Trunk-Based Development

매우 빠른 릴리스 주기에 적합합니다.

```
main    ─●─●─●─●─●─●─●─●─●─●─
          ↖ ↗ ↖ ↗ ↖ ↗
feature    ●   ●   ●  (짧은 수명)
```

**특징:**

- main 브랜치에 직접 커밋 또는 짧은 수명의 브랜치
- 자주 통합 (최소 하루 1회)
- Feature Flag로 미완성 기능 숨김

---

## 실전 활용

### 좋은 커밋 메시지 작성법

#### 커밋 메시지 구조

```
<타입>: <제목>

<본문>

<꼬리말>
```

#### 타입

- `feat`: 새 기능
- `fix`: 버그 수정
- `docs`: 문서 수정
- `style`: 코드 포맷팅 (동작 변경 없음)
- `refactor`: 코드 리팩토링
- `test`: 테스트 코드
- `chore`: 빌드, 설정 변경

#### 예시

```bash
git commit -m "feat: Add user login feature

- Implement JWT authentication
- Add login API endpoint
- Create login UI component

Closes #123"
```

#### 규칙

- ✅ 제목은 50자 이내
- ✅ 제목 첫 글자는 대문자
- ✅ 제목 끝에 마침표 없음
- ✅ 제목은 명령형 (Add, Fix, Update)
- ✅ 본문은 72자마다 줄바꿈
- ✅ 본문은 "무엇을", "왜" 했는지 설명

### .gitignore 설정

프로젝트에 포함하지 않을 파일을 지정합니다.

```bash
# .gitignore 파일 생성
touch .gitignore
```

**Java 프로젝트 예시:**

```gitignore
# 컴파일된 파일
*.class
*.jar
*.war
*.ear

# 빌드 디렉토리
target/
build/
out/

# IDE 설정
.idea/
.vscode/
*.iml
*.swp

# OS 파일
.DS_Store
Thumbs.db

# 로그 파일
*.log

# 환경 변수
.env
.env.local

# 의존성
node_modules/
vendor/
```

**적용:**

```bash
# .gitignore 추가
git add .gitignore
git commit -m "chore: Add .gitignore"

# 이미 추적 중인 파일 제거
git rm --cached <file>
git commit -m "chore: Remove sensitive file"
```

### 협업 시나리오

#### 시나리오 1: 동료가 main을 업데이트했을 때

```bash
# 1. 현재 작업 stash
git stash

# 2. main 업데이트
git checkout main
git pull

# 3. feature 브랜치로 돌아가서 rebase
git checkout feature/my-work
git rebase main

# 4. stash 복원
git stash pop
```

#### 시나리오 2: Pull Request 리뷰 반영

```bash
# 1. 리뷰 피드백 수정
# ... 코드 수정 ...

# 2. 커밋
git add .
git commit -m "refactor: Apply code review feedback"

# 3. 푸시 (PR 자동 업데이트)
git push
```

#### 시나리오 3: 충돌 해결

```bash
# 1. main 변경사항 가져오기
git checkout feature/my-work
git merge main

# 2. 충돌 발생
Auto-merging src/Main.java
CONFLICT (content): Merge conflict in src/Main.java

# 3. 충돌 파일 확인
git status

# 4. 파일 열어서 충돌 해결
<<<<<<< HEAD
// 내 코드
=======
// main의 코드
>>>>>>> main

# 5. 해결 후 추가
git add src/Main.java

# 6. 머지 완료
git commit
```

### GitHub/GitLab 활용

#### Pull Request (PR) / Merge Request (MR)

**생성:**

1. feature 브랜치 푸시
2. GitHub/GitLab에서 "New Pull Request"
3. 제목, 설명, 리뷰어 지정
4. "Create Pull Request"

**PR 템플릿 예시:**

```markdown
## 변경 사항

- 로그인 기능 추가
- JWT 인증 구현

## 관련 이슈

Closes #123

## 테스트 방법

1. 서버 실행
2. `/login` 접속
3. 테스트 계정으로 로그인

## 체크리스트

- [x] 테스트 코드 작성
- [x] 문서 업데이트
- [ ] 성능 테스트
```

#### Issue 활용

```markdown
제목: [Bug] 로그인 시 세션 만료 문제

## 문제 설명

로그인 후 1분만 지나면 세션이 끊김

## 재현 방법

1. 로그인
2. 1분 대기
3. 페이지 새로고침
4. 로그아웃됨

## 예상 동작

30분 동안 세션 유지되어야 함

## 환경

- OS: macOS 14.0
- 브라우저: Chrome 120
- 버전: v1.2.3
```

---

## 주의사항

### ⚠️ 절대 하면 안 되는 것

#### 1. **민감 정보 커밋 금지**

```bash
# ❌ 절대 커밋하면 안 됨
git add .env
git add config/credentials.yml
git add private_key.pem
```

**만약 이미 커밋했다면:**

```bash
# 히스토리에서 완전히 제거
git filter-branch --force --index-filter \
  "git rm --cached --ignore-unmatch .env" \
  --prune-empty --tag-name-filter cat -- --all

# 또는 BFG Repo-Cleaner 사용 (권장)
# https://rtyley.github.io/bfg-repo-cleaner/
```

#### 2. **공개 히스토리 변경 금지**

```bash
# ❌ 다른 사람이 사용 중인 브랜치에서
git push --force origin main  # 위험!

# ✅ 대신 revert 사용
git revert <commit-hash>
git push origin main
```

#### 3. **큰 파일 커밋 금지**

```bash
# ❌ 대용량 파일 (>100MB)
git add large-file.zip
git add video.mp4

# ✅ Git LFS 사용
git lfs track "*.zip"
git lfs track "*.mp4"
```

### 💡 베스트 프랙티스

#### 1. 자주 커밋하기

```bash
# ❌ 하루 종일 작업 후 1개 커밋
git commit -m "Implement everything"

# ✅ 의미 있는 단위로 작업
git commit -m "Add user model"
git commit -m "Add user repository"
git commit -m "Add user service"
```

#### 2. 푸시 전에 Pull 하기

```bash
# ✅ 충돌 방지
git pull origin main
git push origin main
```

#### 3. 브랜치 이름 규칙

```bash
# ✅ 명확한 브랜치명
feature/user-authentication
fix/login-session-bug
refactor/database-connection
docs/api-documentation

# ❌ 모호한 브랜치명
test
fix
my-branch
```

#### 4. main 보호

```bash
# GitHub Settings → Branches → Add rule
- Require pull request reviews
- Require status checks to pass
- Include administrators
```

### 🔧 문제 해결

#### "fatal: not a git repository"

```bash
# 원인: Git 저장소가 아닌 곳에서 명령어 실행
# 해결:
git init
# 또는
cd <git-repository-directory>
```

#### "Please commit your changes or stash them"

```bash
# 원인: 변경사항이 있는 상태에서 pull/checkout
# 해결:
git stash
git pull
git stash pop
```

#### "CONFLICT (content): Merge conflict"

```bash
# 해결:
# 1. 충돌 파일 열기
# 2. <<<<<<< ======= >>>>>>> 마커 찾기
# 3. 원하는 코드만 남기고 마커 삭제
# 4. git add <file>
# 5. git commit
```

#### "Your branch is ahead of 'origin/main' by X commits"

```bash
# 원인: 로컬 커밋이 원격보다 앞섬
# 해결:
git push origin main
```

#### "Your branch is behind 'origin/main' by X commits"

```bash
# 원인: 원격에 새 커밋이 있음
# 해결:
git pull origin main
```

---

## 참고 자료

### 공식 문서

- [Pro Git Book (한글)](https://git-scm.com/book/ko/v2) - 공식 Git 가이드
- [GitHub Docs](https://docs.github.com) - GitHub 공식 문서

### 추천 학습 자료

- [Learn Git Branching](https://learngitbranching.js.org/?locale=ko) - 인터랙티브 Git 학습
- [Git 입문](https://backlog.com/git-tutorial/kr/) - 초보자용 튜토리얼
- [생활코딩 Git](https://opentutorials.org/course/3837) - 한국어 동영상 강의

### 유용한 도구

- [GitHub Desktop](https://desktop.github.com/) - Git GUI 도구
- [GitKraken](https://www.gitkraken.com/) - 고급 Git 클라이언트
- [tig](https://jonas.github.io/tig/) - 터미널 Git UI

### Cheat Sheet

```bash
# 자주 쓰는 명령어 모음
git status              # 상태 확인
git add .               # 모든 변경사항 추가
git commit -m "msg"     # 커밋
git push                # 푸시
git pull                # 풀
git log --oneline       # 로그 확인
git branch              # 브랜치 목록
git checkout -b name    # 브랜치 생성+전환
git merge branch        # 브랜치 병합
git stash / pop         # 임시 저장/복원
```

---

**작성일:** 2026-01-18
**최종 수정일:** 2026-01-18
**작성자:** 민순기
