package programmers;

import java.util.*;

public class Marathon {

    public String solution(String[] participant, String[] completion) {
        // TODO: 풀이 작성
        return "";
    }

    public static void main(String[] args) {
        Marathon sol = new Marathon();

        // TC 1: 기본
        String result1 = sol.solution(
            new String[]{"leo", "kiki", "eden"},
            new String[]{"eden", "kiki"}
        );
        System.out.println("TC1: " + result1); // 예상: "leo"

        // TC 2: 동명이인
        String result2 = sol.solution(
            new String[]{"mislav", "stanko", "mislav", "ana"},
            new String[]{"stanko", "ana", "mislav"}
        );
        System.out.println("TC2: " + result2); // 예상: "mislav"

        // TC 3: 동명이인 여러명
        String result3 = sol.solution(
            new String[]{"a", "a", "a", "b"},
            new String[]{"a", "a", "b"}
        );
        System.out.println("TC3: " + result3); // 예상: "a"
    }
}
