# Dev Practice

Java, Kotlin, Python으로 코딩테스트를 연습하고, 개발 개념을 체계적으로 정리하는 프로젝트입니다.

## 프로젝트 구조

```
dev-practice/
├── java/                # Java 솔루션
│   └── src/
│       └── Solution.java
├── kotlin/              # Kotlin 솔루션 (Gradle 프로젝트)
│   ├── src/main/kotlin/
│   │   └── Solution.kt
│   ├── build.gradle.kts
│   └── settings.gradle.kts
├── python/              # Python 솔루션
│   └── src/
│       └── solution.py
└── docs/                # 개발 개념 정리 문서
    ├── algorithms/      # 알고리즘
    ├── data-structures/ # 자료구조
    ├── language-basics/ # 언어 기본
    ├── oop/            # 객체지향
    ├── design-patterns/# 디자인 패턴
    ├── system/         # 시스템 (네트워크, DB, OS)
    └── templates/      # 문서 템플릿
```

## 사용 방법

### IntelliJ에서 실행 (권장)

1. IntelliJ에서 프로젝트 열기
2. 각 언어별 폴더의 소스 파일 열기:
   - Java: `java/src/Solution.java`
   - Kotlin: `kotlin/src/main/kotlin/Solution.kt`
   - Python: `python/src/solution.py`
3. main 함수 옆의 ▶ 실행 버튼 클릭

**Kotlin Gradle 프로젝트:**
- `kotlin` 폴더를 Gradle 프로젝트로 인식
- Gradle 새로고침 후 실행

### 터미널에서 실행

#### Java
```bash
cd java/src
javac Solution.java
java Solution
```

#### Kotlin
```bash
cd kotlin
./gradlew run
```

#### Python
```bash
cd python/src
python solution.py
# 또는
python3 solution.py
```

## 팁

- 각 언어별 src 폴더에서 새로운 문제마다 파일을 만들어서 사용하세요
- 문제 번호나 이름으로 파일명을 지정하면 관리가 편리합니다
  - Java: `java/src/Problem1234.java`
  - Kotlin: `kotlin/src/main/kotlin/Baekjoon1000.kt`
  - Python: `python/src/programmers_42840.py`
- IntelliJ에서 각 파일의 main 함수를 바로 실행할 수 있습니다

---

## 📚 개발 개념 문서 (docs/)

코딩 테스트부터 개발자 기본기까지 체계적으로 정리한 문서 모음입니다.

### 주요 카테고리

- **알고리즘** (algorithms/): 정렬, 탐색, DP, 그리디, DFS/BFS 등
- **자료구조** (data-structures/): 배열, 스택, 큐, 트리, 그래프, 해시 등
- **언어 기본** (language-basics/): Java/Kotlin 문법, 컬렉션, 람다 등
- **객체지향** (oop/): SOLID 원칙, 상속, 다형성, 추상화 등
- **디자인 패턴** (design-patterns/): 싱글톤, 팩토리, 옵저버 등
- **시스템** (system/): 네트워크, DB, OS, HTTP 등

### 문서 특징

✅ Java와 Kotlin 예제 코드 제공
✅ 실전 활용 및 코딩 테스트 적용법
✅ 주의사항과 함정 설명
✅ 관련 연습 문제 추천

### 시작하기

1. [docs/README.md](docs/README.md)에서 전체 문서 목록 확인
2. 카테고리별로 학습 진행
3. 체크리스트로 학습 진행도 관리

**상세 내용은 [docs/README.md](docs/README.md)를 참고하세요.**
