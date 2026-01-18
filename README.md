# 코딩테스트 연습

Java, Kotlin, Python으로 코딩테스트를 연습하는 프로젝트입니다.

## 프로젝트 구조

```
coding_test/
├── java/           # Java 솔루션
│   └── src/
│       └── Solution.java
├── kotlin/         # Kotlin 솔루션 (Gradle 프로젝트)
│   ├── src/main/kotlin/
│   │   └── Solution.kt
│   ├── build.gradle.kts
│   └── settings.gradle.kts
└── python/         # Python 솔루션
    └── src/
        └── solution.py
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
