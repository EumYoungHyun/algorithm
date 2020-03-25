package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16985_Maaaaaaaaaze {
	private static int min = Integer.MAX_VALUE;
	private static int[] arr;
	private static boolean[][][] copy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		copy = new boolean[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				String str = br.readLine();
				for (int k = 0, index =0 ; k < 5; k++, index +=2) {
					if(str.charAt(index)-'0' == 1) copy[i][j][k] = true;
				}
			}
		}
		arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = i;
		}
		comb(5, 0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	public static int[][] dirs = {{0,1,0},{1,0,0},{-1,0,0},{0,-1,0},{0,0,1},{0,0,-1}};
	public static void comb(int n, int cc) {
		if(n == cc) {
			boolean[][][] cube = new boolean[5][5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						cube[arr[i]][j][k] = copy[i][j][k];
					}
				}
			}
			//r, c, z, count
			Queue<Integer[]> queue = new LinkedList<Integer[]>();
			for (int t1 = 0; t1 < 4; t1++) {
				for (int t2 = 0; t2 < 4; t2++) {
					for (int t3 = 0; t3 < 4; t3++) {
						for (int t4 = 0; t4 < 4; t4++) {
							for (int t5 = 0; t5 < 4; t5++) {
								if(cube[0][0][0])	queue.add(new Integer[] {0, 0, 0, 0});
								// bfs
								boolean[][][] check = new boolean[5][5][5];
								while(!queue.isEmpty()) {
									Integer[] temp = queue.poll();
									int r = temp[0];
									int c = temp[1];
									int z = temp[2];
									int count = temp[3];
									if(r == 4 && c == 4 && z == 4) {
										if(min > count) min = count;
										continue;
									}
									if(count > min) return;
									if(check[r][c][z]) continue;
									check[r][c][z] = true;
									for (int i = 0; i < 6; i++) {
										int nr = r + dirs[i][0];
										int nc = c + dirs[i][1];
										int nz = z + dirs[i][2];
										if(nr >=0 && nr <5 && nc >=0 && nc <5 && nz>=0 && nz<5
												&&cube[nr][nc][nz] && !check[nr][nc][nz]) {
											queue.add(new Integer[] {nr, nc, nz, count+1});
										}
									}
								}
								// t5 회전
								boolean[][] temp = new boolean[5][5];
								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {
										temp[i][j] = cube[4][i][j];
									}
								}
								for (int i = 0; i < 5; i++) {
									for (int j = 0; j <5 ; j++) {
										cube[4][i][j] = temp[j][4-i];
									}
								}
							}// end of t5
							//t4 회전
							boolean[][] temp = new boolean[5][5];
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 5; j++) {
									temp[i][j] = cube[3][i][j];
								}
							}
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j <5 ; j++) {
									cube[3][i][j] = temp[j][4-i];
								}
							}
						}// end of t4
						//t3 회전
						boolean[][] temp = new boolean[5][5];
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								temp[i][j] = cube[2][i][j];
							}
						}
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j <5 ; j++) {
								cube[2][i][j] = temp[j][4-i];
							}
						}
					}// end of t3
					// t2 회전
					boolean[][] temp = new boolean[5][5];
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							temp[i][j] = cube[1][i][j];
						}
					}
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j <5 ; j++) {
							cube[1][i][j] = temp[j][4-i];
						}
					}
				}// end of t2
				// t1 회전
				boolean[][] temp = new boolean[5][5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						temp[i][j] = cube[0][i][j];
					}
				}
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j <5 ; j++) {
						cube[0][i][j] = temp[j][4-i];
					}
				}
			}// end of t1
			return;}
		for (int i = cc; i < arr.length; i++) {
			int temp = arr[i];
			arr[i] = arr[cc];
			arr[cc] = temp;
			comb(n, cc+1);
			temp = arr[i];
			arr[i] = arr[cc];
			arr[cc] = temp;
		}
		
	}
}
