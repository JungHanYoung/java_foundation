package programmers.wintercoding;

import java.util.*;


public class SkillTree {

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

    /**
     *
     * @param skill - 선행스킬 순서   (C,B,D)
     * @param skill_trees - 유저가 배우려하는 스킬트리  [BACDE, CBADF, AECB, BDA]
     * @return - 가능한 스킬트리의 개수
     *
     * 문제풀이...
     * - 일단 스킬트리들 각각의 문자를 순회하여 처리해야겠다는 생각이 든다.
     * - 아니면 우선순위 큐?
     * - 스택?
     * - 스택으로 처리한다면 오른쪽부터 하나씩 스택에 넣고, ... 아니야 XX
     * -
     * - 선행스킬을 거꾸로 큐로 넣은 후, D<B<C , 각 스킬트리를 순회,
     * - 큐에서 값을 하나씩 꺼내며 순서를 찾아본다. D
     *
     *
     * TODO
     * - 선행스킬을 큐에 넣는다. - ( C<B<D )
     * - 각 스킬트리에서 해당 char를 찾는다.
     * - 찾았을 경우: 찾은 인덱스부터 아래로 내려가 다음 큐의 peek가 있는지 확인한다.
     * - 못찾았을 경우: 그냥 넘어간다.
     *
     * FIXED
     * - C B D 순서의 선행스킬이면
     *  D의 인덱스 뒤쪽의 요소에서 C, B가 나와선 안된다.
     *  B의 인덱스 뒤쪽의 요소에서 C가 나와선 안된다.
     *  C의 인덱스 뒤쪽의 요소에서는 어느 것이 나와도 된다.
     *      - 해당 조건들을 충족하면 반대 조건들인 앞쪽요소 체크는 할 필요가 없을 것.
     *
     * 스킬 순서에서 스킬이 스킬트리에 없을 경우에 indexOf가 -1을 리턴.
     *
     */

    static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Queue<Character> preSkill = new LinkedList<>();


//        for(char ch : skill.toCharArray()) {
//            skillStack.push(ch);
//        }

        for(String tree: skill_trees) {

            // 선행스킬에 맞는지에 대한 여부
            boolean flag = false;

            // 선행스킬 문자분할해 큐에 넣어준다.
            for(char ch: skill.toCharArray()) {
                preSkill.offer(ch);
            }

            // 스킬트리를 문자분할
            List<Character> treeToChars = new ArrayList<Character>();
            for(char ch: tree.toCharArray()) {
                treeToChars.add(ch);
            }

            boolean failFlag = false;

            while(!preSkill.isEmpty()) {
                // 스킬트리에 큐의 맨앞에 꺼낸 문자에 대한 인덱스를 찾는다.
                char criteria = preSkill.poll();
                int criteriaIndex = treeToChars.indexOf(criteria);
                // 선행스킬 큐 사이즈만큼의 루프를 도는데
                for(int i = 0; i < preSkill.size(); i++) {
                    char poll = preSkill.poll();
                    preSkill.offer(poll);
                    int index = treeToChars.indexOf(poll);
                    if(index < criteriaIndex && index >= 0) {
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
