package programmers.wintercoding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SkillTree2 {

    public static void main(String[] args) {

        execution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        execution("ABCD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        execution("DEF", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        execution("EFG", new String[]{"BACDE", "CBADF", "FECB", "BDA"});

    }

    public static void execution(String skill, String[] skill_trees) {
        int result3 = solution(skill, skill_trees);

        System.out.println(result3);
    }

    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Queue<Character> preSkill = new LinkedList<>();
        char[] skills = skill.toCharArray();

        for(String tree: skill_trees) {

            // reverse offer
            for(int i = skills.length - 1; i >= 0; i--) {
                preSkill.offer(skills[i]);
            }

            List<Character> treeToChars = new ArrayList<Character>();
            for(char ch: tree.toCharArray()) {
                treeToChars.add(ch);
            }

            boolean failFlag = false;

            while(!preSkill.isEmpty()) {
                // skill의 맨뒤임.
                char criteria = preSkill.poll();
                // 기준이 되는 스킬의 인덱스(위치)를 찾는다.
                int criteriaIndex = treeToChars.indexOf(criteria);
                // 현재 스킬이 스킬트리에 없는 경우
                if(criteriaIndex < 0) continue;

                // 인덱스(위치)보다 낮은 인덱스에 대한 tree 요소 중에
                // 큐에 들어가 있는 스킬이 있어야 가능한 스킬트리
                for(int i = 0; i < preSkill.size(); i++) {
                    // 하위스킬
                    char poll = preSkill.poll();
                    preSkill.offer(poll);
                    // 하위스킬의 위치
                    int index = treeToChars.indexOf(poll);
                    // 하위스킬이 현재스킬 위치보다 아래에 있는지
                    // 현재스킬위치 > 하위스킬위치 && 하위스킬이 존재하고
                    // 실패여건
                    // - 현재스킬위치 < 하위스킬위치
                    // - 하위스킬이 존재하지 않으면
                    if(index > criteriaIndex || index < 0) {
                        // fail
                        failFlag = true;
                        break;
                    }
                }
                if(failFlag) break;
            }
            if(!failFlag) {
                answer++;
            }

            preSkill.clear();
        }



        return answer;
    }
}
