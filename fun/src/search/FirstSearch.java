package search;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstSearch {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1}, {1, 0, 1, 0}, {0, 0, 0, 1}};

        FirstSearch solution = new FirstSearch();   // 객체 생성
        int result = solution.countIsIsland(grid);  // 메서드 호출
        System.out.println("섬 개수: " + result);   // 결과 출력
    }

    /*
    격자 형태의 지역에 땅과 바다가 있을때 섬은 몇개인지 구하시오.
     */
    private int countIsIsland(int[][] grid) {
        // 격자는 직사각형 형태라고 가정하겠습니다.
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        // 상하좌우를 정의합니다.
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 격자의 크기만큼 2중 for문을 진행합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문한적이 없으며 땅인 경우를 분기합니다.
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
//                    bfs(grid, visited, i, j, dx, dy); // bfs 너비 우선탐색을 이용합니다.
                    dfs(grid, visited, i, j, dx, dy); // dfs 너비 우선탐색을 이용합니다.

                }

            }
        }
        return count;
    }

    private void bfs(int[][] grid, boolean[][] visited, int startX, int startY, int[] dx, int[] dy) {
        int n = grid.length, m = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>(); // 우선 너비 탐색은 Queue를 사용해서 해결합니다.

        // 현재 좌표를 큐에 담습니다.
        dq.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        // bfs는 연결된곳으로 퍼져 나가는거이기 때문에 큐가 빌때까지 상하좌우로 퍼져 나갑니다.
        while (!dq.isEmpty()) {
            // 현재 좌표
            int[] current = dq.poll();
            int x = current[0], y = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k]; // 상하좌우 좌표

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
                    dq.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private void dfs(int[][] grid, boolean[][] visited, int startX, int startY, int[] dx, int[] dy) {
        int n = grid.length, m = grid[0].length;
        //dfs는 스택 혹은 재귀적으로 해결 합니다.

        // 이미 방문한 곳이거나 바다 혹은 그리드 영역 밖이라면 return
        if (startX < 0 || startX >= n || startY < 0 || startY >= m) return;
        if (visited[startX][startY] || grid[startX][startY] == 0) return;

        visited[startX][startY] = true; // 방문을 표시합니다.

        // 상하좌우를 탐색합니다.
        dfs(grid, visited, startX + dx[0], startY + dy[0], dx, dy);
        dfs(grid, visited, startX + dx[1], startY + dy[1], dx, dy);
        dfs(grid, visited, startX + dx[2], startY + dy[2], dx, dy);
        dfs(grid, visited, startX + dx[3], startY + dy[3], dx, dy);
    }
}
