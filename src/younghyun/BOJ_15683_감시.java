package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
class BOJ_15683_감시 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] temp;
    static ArrayList<Dot> list;
    static int size;
    static int[] output;
    static int count;
    static int result;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = str.charAt(0)-'0';
        M = str.charAt(2)-'0';
        arr = new int[N][M];
        temp = new int[N][M];
        list = new ArrayList<Dot>();
        count = 0;
        result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0, Idx = 0; j < M; j++, Idx+=2) {
                arr[i][j] = str.charAt(Idx);
                temp[i][j] = arr[i][j];
                if (arr[i][j] != 6 && arr[i][j] != 0) {
                    //cctv 일때 리스트에 저장한다.
                    list.add(new Dot(i, j));
                }
 
            }
        }
        
        //------입력부------//
        size = list.size();    //cctv 갯수
        output = new int[size];    //모든 조합을 만들어줄 배열
        
        //cctv가 존재하지 않을때
        if (size == 0) {
            Check();
            result = count;
        }
        //cctv가 존재할때
        else {
            for (int i = 0; i < 4; i++) {
                //cctv 전부 모든 방향 계산을 해준다.
                output[0] = i + 1;
                allCase(i, 0);
            }
        }
        System.out.println(result);
 
    }
    //allCase 함수는 cctv가 감시하는 모든 경우의 수를 만들기 위해 사용한다.
    public static void allCase(int start, int depth) {
        if (depth == size - 1) {
            for (int i = 0; i < size; i++) {
                Dot d = list.get(i);
                // 1부터 N개의 cctv를 모두 돌린다.
                Watch(d, arr[d.x][d.y], output[i]);
 
            }
            Check(); //사각지대가 얼마나 있는지 체크
            result = Math.min(result, count);    //사각지대가 최소일때 저장
            Reset();    //감시하는 장소 초기화
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            //조합을 만들기 위해 사용
            output[depth + 1] = i + 1;
            allCase(i, depth + 1);
        }
 
    }
    
    //Wacth 함수는 cctv의 종류와 방향을 따라 감시하는 위치를 정해준다.
    public static void Watch(Dot d, int num, int dir) {
        if (num == 1) {
            if (dir == 1) {
                Move(d, 1);
            } else if (dir == 2) {
                Move(d, 2);
            } else if (dir == 3) {
                Move(d, 3);
            } else if (dir == 4) {
                Move(d, 4);
            }
 
        } else if (num == 2) {
            if (dir == 1) {
                Move(d, 1);
                Move(d, 3);
            } else if (dir == 2) {
                Move(d, 2);
                Move(d, 4);
            } else if (dir == 3) {
                Move(d, 1);
                Move(d, 3);
            } else if (dir == 4) {
                Move(d, 2);
                Move(d, 4);
            }
        } else if (num == 3) {
            if (dir == 1) {
                Move(d, 1);
                Move(d, 2);
            } else if (dir == 2) {
                Move(d, 2);
                Move(d, 3);
            } else if (dir == 3) {
                Move(d, 3);
                Move(d, 4);
            } else if (dir == 4) {
                Move(d, 4);
                Move(d, 1);
            }
        } else if (num == 4) {
            if (dir == 1) {
                Move(d, 1);
                Move(d, 2);
                Move(d, 3);
            } else if (dir == 2) {
                Move(d, 2);
                Move(d, 3);
                Move(d, 4);
            } else if (dir == 3) {
                Move(d, 3);
                Move(d, 4);
                Move(d, 1);
            } else if (dir == 4) {
                Move(d, 4);
                Move(d, 1);
                Move(d, 2);
            }
        } else if (num == 5) {
            Move(d, 1);
            Move(d, 2);
            Move(d, 3);
            Move(d, 4);
        }
 
    }
    
    
    //Move 함수는 DFS를 통해 한 방향을 감시한다.
    //2차원 배열의 값을 바꿔준다.
    public static void Move(Dot d, int dir) {
 
        int currentX = d.x;
        int currentY = d.y;
        int nextX = currentX;
        int nextY = currentY;
 
        if (dir == 1) {
            nextX = currentX - 1;
            nextY = currentY;
        } else if (dir == 2) {
            nextX = currentX;
            nextY = currentY + 1;
        } else if (dir == 3) {
            nextX = currentX + 1;
            nextY = currentY;
        } else if (dir == 4) {
            nextX = currentX;
            nextY = currentY - 1;
        }
        //다음 위치가 범위 밖일 때는 종료
        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
            return;
        }
        //다음 위치가 벽이라면 종료
        if (arr[nextX][nextY] == 6) {
            return;
        }
        //다음 위치가 0일때는 1로 바꾸지만 나머지 숫자는 바꾸지 않고 넘어간다.
        //숫자를 바꾸게 되면 다음 list를 사용할때 문제가 생긴다.
        //정확히는 Move 함수의 num값이 바뀌므로 바꾸지 않고 넘어간다.
        if (arr[nextX][nextY] == 0) {
            arr[nextX][nextY] = 1;
        }
        Move(new Dot(nextX, nextY), dir);
 
    }
    
    //사각지대가 얼마나 있는지 체크하는 함수
    public static void Check() {
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }
    }
    //2차원 배열을 초기화 하는 함수
    public static void Reset() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}
 
class Dot {
    int x;
    int y;
 
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
