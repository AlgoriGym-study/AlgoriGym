package Algorithm_Study.daily.CSY.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D20250411_암호만들기 {

        static int L, C;
        static char[] data;
        static char[] result;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st= new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            String[] str = br.readLine().split(" ");
            data = new char[C];

            result = new char[L];

            for(int c = 0 ; c < C; c++) {
                data[c] = str[c].charAt(0);
            }
            Arrays.sort(data);

            // perm(0);
            recur(0, 0);
        }

        private static void recur(int start, int depth) {
            if(depth == L) {
                if(isValid(result)) {
                    System.out.println(new String(result));
                }
                return;
            }

            for(int i = start; i < C; i++) {
                result[depth] = data[i];

                recur(i+1, depth+1);

            }
        }

        private static boolean isValid(char[] arr) {
            int mo = 0, ja = 0;
            for(int a : arr) {
                if("aeiou".indexOf(a) != -1) mo++;
                else ja++;
            }

            return mo >=1 && ja >= 2;
        }

//	private static void perm(int idx) {
//		if(idx == L) {
//			// 조건 1. 모음최소 하나
//			// 조건 2. 자음 최소 2개
//			int cnt = 0;
//			for(int i : result) {
//				if(i == 'a' || i == 'e' ||i == 'i' ||i == 'o' ||i == 'u')
//					cnt++;
//			}
//			if(cnt < 1 || cnt > 2) return;
//			// 정렬조건을 넘어서면..
//			if(!check(result)) return;
//			System.out.println(Arrays.toString(result));
//			return;
//		}
//
//		for(int i = 0; i < C; i++) {
//			if(visited[i]) continue;
//			result[idx] = data[i];
//			visited[i] = true;
//
//			perm(idx+1);
//
//			visited[i] = false;
//		}
//
//	}

        private static boolean check(char[] arr) {
            for(int i = 0; i < arr.length-1; i++) {
                for(int j = i+1; j < arr.length; j++) {
                    if(arr[i] > arr[j]) return false;
                }
            }

            return true;
        }

    }


