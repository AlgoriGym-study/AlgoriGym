package Algorithm_Study.common.C202509.C20250910;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG0042 {
    static final String underBar = "____";
    static final String startStr = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static final String queStr = "\"재귀함수가 뭔가요?\"";
    static final String storyStr = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static final String storyStr2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static final String storyStr3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static final String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static final String endStr = "라고 답변하였지.";
    
    static int N;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        recur(0);
        System.out.print(sb);
        br.close();
    }
    
    private static void recur(int count) {
        if(count == N) {
            printQuestion(count);
            printAnswer(count);
            printEnd(count);
            return;
        }
        
        if(count == 0) sb.append(startStr).append("\n");
        
        printQuestion(count);
        printStory(count);
        recur(count + 1);
        printEnd(count);
    }
    
    private static void printUnderBar(int count) {
        sb.append(underBar.repeat(count));
    }
    
    private static void printQuestion(int count) {
        printUnderBar(count);
        sb.append(queStr).append("\n");
    }
    
    private static void printStory(int count) {
        printUnderBar(count);
        sb.append(storyStr).append("\n");
        printUnderBar(count);
        sb.append(storyStr2).append("\n");
        printUnderBar(count);
        sb.append(storyStr3).append("\n");
    }
    
    private static void printAnswer(int count) {
        printUnderBar(count);
        sb.append(answer).append("\n");
    }
    
    private static void printEnd(int count) {
        printUnderBar(count);
        sb.append(endStr).append("\n");
    }
}
