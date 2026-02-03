package Algorithm_Study.daily.PJE.D202602;
import java.util.*;

public class D20260203 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> list = new ArrayList<>();
        // data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후 저장 
        for(int[] d : data){
            switch (ext){
                case "code" :
                    if(d[0] < val_ext)
                        list.add(d);
                    break;
                case "date" :
                    if(d[1] < val_ext) 
                        list.add(d);
                    break;
                case "maximum" :
                    if(d[2] < val_ext) 
                        list.add(d);
                    break;
                case "remain" :
                    if(d[3] < val_ext)
                        list.add(d);
                    break;
            }
        }
        // sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
        switch (sort_by){
                case "code" :
                    list.sort((a, b) -> Integer.compare(a[0], b[0]));
                    break;
                case "date" :
                    list.sort((a, b) -> Integer.compare(a[1], b[1]));
                    break;
                case "maximum" :
                    list.sort((a, b) -> Integer.compare(a[2], b[2]));
                    break;
                case "remain" :
                    list.sort((a, b) -> Integer.compare(a[3], b[3]));
                    break;
            }
        // int[][] 배열로 옮겨담기
        int[][] answer = new int[list.size()][4];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
