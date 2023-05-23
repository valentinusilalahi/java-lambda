package com.silalahi.valentinus.training.srin;

import java.util.Scanner;

class EndoScope {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        int T = scn.nextInt();
        while (T-- > 0) {
            int N = scn.nextInt();
            int M = scn.nextInt();
            int R = scn.nextInt();
            int C = scn.nextInt();
            int L = scn.nextInt();

            int[][] Maze = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    Maze[i][j] = scn.nextInt();
                }
            }
            boolean[][] visit = new boolean[N][M];
            int[][] dist = new int[N][M];

            int[] up = {0, 1, 1, 0, 1, 0, 0, 1};
            int[] down = {0, 1, 1, 0, 0, 1, 1, 0};
            int[] left = {0, 1, 0, 1, 0, 0, 1, 1};
            int[] right = {0, 1, 0, 1, 1, 1, 0, 0};

            myQueue Q = new myQueue();
            if (Maze[R][C] != 0) {
                Q.add(new Pair(R, C));
                visit[R][C] = true;
                dist[R][C] = 1;
            }

            while (!Q.isEmpty()) {
                Pair elem = Q.remove();

                int x = elem.x;
                int y = elem.y;

                if (x - 1 >= 0 && up[Maze[x][y]] == 1 && down[Maze[x - 1][y]] == 1 && !visit[x - 1][y]) {
                    int d = dist[x][y] + 1;
                    if (d <= L) {
                        Q.add(new Pair(x - 1, y));
                        visit[x - 1][y] = true;
                        dist[x - 1][y] = d;
                    }
                }

                if (x + 1 < N && down[Maze[x][y]] == 1 && up[Maze[x + 1][y]] == 1 && !visit[x + 1][y]) {
                    int d = dist[x][y] + 1;
                    if (d <= L) {
                        Q.add(new Pair(x + 1, y));
                        visit[x + 1][y] = true;
                        dist[x + 1][y] = d;
                    }
                }

                if (y - 1 >= 0 && left[Maze[x][y]] == 1 && right[Maze[x][y - 1]] == 1 && !visit[x][y - 1]) {
                    int d = dist[x][y] + 1;
                    if (d <= L) {
                        Q.add(new Pair(x, y - 1));
                        visit[x][y - 1] = true;
                        dist[x][y - 1] = d;
                    }
                }

                if (y + 1 < M && right[Maze[x][y]] == 1 && left[Maze[x][y + 1]] == 1 && !visit[x][y + 1]) {
                    int d = dist[x][y] + 1;
                    if (d <= L) {
                        Q.add(new Pair(x, y + 1));
                        visit[x][y + 1] = true;
                        dist[x][y + 1] = d;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dist[i][j] > 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static class myQueue {
        Pair[] Q = new Pair[1000000];
        int front;
        int rear;

        myQueue() {
            front = 0;
            rear = 0;
        }

        public void add(Pair el) {
            Q[rear++] = el;
        }

        public Pair remove() {
            return Q[front++];
        }

        public boolean isEmpty() {
            return front == rear;
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x1, int y1) {
            this.x = x1;
            this.y = y1;
        }
    }
}
