package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class D20250916 {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int N = Integer.parseInt(br.readLine());
      
      CStack stack = new CStack();
      for(int i = 0; i < N; i++) {
          String[] input = br.readLine().split(" ");
          switch(input[0]) {
              case "push":
                  stack.push(Integer.parseInt(input[1]));
                  break;
              case "top":
                  sb.append(stack.getTop()).append("\n");
                  break;
              case "size":
                  sb.append(stack.getSize()).append("\n");
                  break;
              case "pop":
                  sb.append(stack.pop()).append("\n");
                  break;
              case "empty":
                  sb.append(stack.isEmpty()).append("\n");
                  break;
          }
      }
          
      br.close();
      System.out.print(sb);
  }
  
  public static class CStack {
      int data;
      int size;
      private List<Integer> list = new LinkedList<>();
      
      public CStack() {
      	this.size = 0;
      }

      public void push(int n) {
          list.add(n);
          size++;
      }
      
      public int pop() {
          if(isEmpty() == 1) return -1;
          int data = list.get(size - 1);
          list.remove(--size);
          return data; 
      }
      
      public int getTop() {
      	if(isEmpty() == 1) return -1;
          return list.get(size - 1);
      }
      
      public int getSize() {
          return size;
      }
      
      public int isEmpty() {
          if(size == 0) return 1;
          return 0;
      }
  }
}
