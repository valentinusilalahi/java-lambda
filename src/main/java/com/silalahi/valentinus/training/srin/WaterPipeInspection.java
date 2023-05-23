package com.silalahi.valentinus.training.srin;

import java.util.Scanner;

public class WaterPipeInspection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Membaca jumlah kasus uji

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(); // Membaca tinggi peta pipa air
            int M = sc.nextInt(); // Membaca lebar peta pipa air
            int R = sc.nextInt(); // Membaca lokasi vertikal endoskop
            int C = sc.nextInt(); // Membaca lokasi horizontal endoskop
            int L = sc.nextInt(); // Membaca panjang endoskop

            int[][] pipeMap = new int[N][M]; // Matriks untuk menyimpan peta pipa air

            // Membaca peta pipa air
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    pipeMap[i][j] = sc.nextInt();
                }
            }

            int count = countAccessiblePipes(pipeMap, R, C, L); // Menghitung jumlah pipa yang dapat diamati

            System.out.println("#" + testCase + " " + count);
        }

        sc.close(); // Menutup Scanner setelah selesai membaca input
    }

    // Fungsi untuk menghitung jumlah pipa yang dapat diamati menggunakan endoskop
    public static int countAccessiblePipes(int[][] pipeMap, int row, int col, int length) {
        int N = pipeMap.length;
        int M = pipeMap[0].length;
        boolean[][] visited = new boolean[N][M]; // Matriks untuk melacak pipa yang sudah dikunjungi

        return dfs(pipeMap, visited, row, col, length);
    }

    // Fungsi rekursif untuk DFS (Depth-First Search)
    public static int dfs(int[][] pipeMap, boolean[][] visited, int row, int col, int length) {
        int N = pipeMap.length;
        int M = pipeMap[0].length;

        // Jika posisi saat ini di luar batas atau sudah dikunjungi atau panjang endoskop habis, kembalikan 0
        if (row < 0 || row >= N || col < 0 || col >= M || visited[row][col] || length == 0) {
            return 0;
        }

        visited[row][col] = true; // Tandai pipa saat ini sebagai sudah dikunjungi
        int count = 1; // Inisialisasi jumlah pipa yang dapat diamati dengan 1

        // Melakukan DFS ke pipa-pipa terhubung yang dapat dijangkau oleh endoskop
        if (pipeMap[row][col] == 1) {
            count += dfs(pipeMap, visited, row - 1, col, length - 1); // Pipa ke atas
            count += dfs(pipeMap, visited, row + 1, col, length - 1); // Pipa ke bawah
            count += dfs(pipeMap, visited, row, col - 1, length - 1); // Pipa ke kiri
            count += dfs(pipeMap, visited, row, col + 1, length - 1); // Pipa ke kanan
        } else if (pipeMap[row][col] == 2) {
            count += dfs(pipeMap, visited, row - 1, col, length - 1); // Pipa ke atas
            count += dfs(pipeMap, visited, row + 1, col, length - 1); // Pipa ke bawah
        } else if (pipeMap[row][col] == 3) {
            count += dfs(pipeMap, visited, row, col - 1, length - 1); // Pipa ke kiri
            count += dfs(pipeMap, visited, row, col + 1, length - 1); // Pipa ke kanan
        } else if (pipeMap[row][col] == 4) {
            count += dfs(pipeMap, visited, row - 1, col, length - 1); // Pipa ke atas
            count += dfs(pipeMap, visited, row, col + 1, length - 1); // Pipa ke kanan
        } else if (pipeMap[row][col] == 5) {
            count += dfs(pipeMap, visited, row + 1, col, length - 1); // Pipa ke bawah
            count += dfs(pipeMap, visited, row, col + 1, length - 1); // Pipa ke kanan
        } else if (pipeMap[row][col] == 6) {
            count += dfs(pipeMap, visited, row + 1, col, length - 1); // Pipa ke bawah
            count += dfs(pipeMap, visited, row, col - 1, length - 1); // Pipa ke kiri
        } else if (pipeMap[row][col] == 7) {
            count += dfs(pipeMap, visited, row - 1, col, length - 1); // Pipa ke atas
            count += dfs(pipeMap, visited, row, col - 1, length - 1); // Pipa ke kiri
        }

        return count;
    }
}
