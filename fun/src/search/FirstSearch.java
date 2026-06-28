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

    private int bfsShortest(int[][] maze) {
        int n = maze.length, m = maze[0].length;
        int[][] dist = new int[n][m]; // 거리및 방문을 기록할 배열
        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0}); // 시작 지점
        dist[0][0] = 1;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0], y = cur[1];

            if (x == n - 1 && y == m - 1) {
                return dist[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < n
                        && ny >= 0 && ny < m
                        && dist[nx][ny] == 0
                        && maze[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1; // 1칸 거리 증가
                    dq.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }

    /**
     * 응용 — 가장 큰 섬의 크기문제
     * 1은 땅, 0은 바다인 격자에서, 상하좌우로 연결된 가장 큰 섬이 몇 칸인지 구하세요.
     * 1 1 0 0
     * 1 0 0 1
     * 0 0 1 1
     * <p>
     * 섬1: (0,0),(0,1),(1,0) → 3칸
     * 섬2: (1,3),(2,3),(2,2) → 3칸
     * <p>
     * → 가장 큰 섬 = 3칸
     */
    private int largestIslandSize(int[][] grid) {
        int maxSize = 0; // 현재 가장 큰 섬의 크기
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int size = findDfs(grid, visited, i, j);
                maxSize = Math.max(size, maxSize);
            }
        }
        return maxSize;
    }

    private int findDfs(int[][] grid, boolean[][] visited, int x, int y) {
        int n = grid.length, m = grid[0].length;

        // 현재 지점이 격자 안에 있는지 확인.
        if (x < 0 || x >= n || y < 0 || y >= m) return 0;
        // 현재 지점을 방문했거나 땅이 맞는지 확인.
        if (grid[x][y] == 0 || visited[x][y]) return 0;

        // 현재지점 방문 표시
        visited[x][y] = true;

        int size = 1; // 나 자신 크기 1
        size += findDfs(grid, visited, x, y - 1); // 좌
        size += findDfs(grid, visited, x, y + 1); // 우
        size += findDfs(grid, visited, x - 1, y); // 상
        size += findDfs(grid, visited, x + 1, y); // 하

        return size;
    }

    /**
     * 응용 — 토마토 익히기 (여러 시작점 BFS)
     * 문제
     * 격자 상자에 토마토가 있어요. 1은 익은 토마토, 0은 안 익은 토마토, -1은 빈 칸이에요.
     * 익은 토마토는 하루가 지나면 상하좌우의 안 익은 토마토를 익혀요.
     * 모든 토마토가 익는 데 며칠 걸리는지 구하세요. 다 못 익으면 -1.
     * 1 0 0
     * 0 0 0
     * 0 0 1
     * 익은 토마토가 (0,0)과 (2,2) 두 군데. 둘에서 동시에 퍼져나가요.
     */
    private int ripenTomatoes(int[][] box) {
        int n = box.length, m = box[0].length;
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
        Deque<int[]> dq = new ArrayDeque<>();

        // 1) 익은 토마토(1)를 전부 큐에 넣기 — 여러 시작점!
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (box[i][j] == 1)
                    dq.offer(new int[]{i, j});
        // (1은 이미 익었으니 따로 방문배열 없이 box값 자체로 방문 판단 가능)

        int days = 0;

        // 2) BFS — 익은 것들에서 동시에 퍼짐
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0], y = cur[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && box[nx][ny] == 0) {            // 안 익은 토마토만
                    box[nx][ny] = box[x][y] + 1;       // 익히면서 "날짜+1" 기록
                    dq.offer(new int[]{nx, ny});
                }
            }
        }

        // 3) 답 구하기: 직접 채워보세요
        //    - 격자를 다 훑으면서
        //    - 아직 0인 칸이 있으면 → return -1 (못 익음)
        //    - 최댓값(가장 큰 box값)을 찾아서, 거기서 1을 빼면 날짜
        //    (1부터 셌으니 최종 최댓값 - 1이 걸린 날)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) return -1;

                days = Math.max(days, box[i][j] - 1);
            }
        }

        return days;
    }

}
