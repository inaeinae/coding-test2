package inaeinae.studycodingtest.Doit;

import java.io.*;

public class No20_P2751 {
    public int[] arr, temp;
    public long result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Scanner
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //System.out.println

        int end = Integer.parseInt(br.readLine()) - 1;
        arr = new int[end + 1];
        temp = new int[end + 1];

        for (int i = 0; i <= end; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, end);

        for (int i = 0; i <= end; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private void merge_sort(int start, int end) {
        int middle = (start + end) / 2;
        if (end - start <= 0) return;

        merge_sort(start, middle);
        merge_sort(middle + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int roopIndex = start;
        int leftIndex = start;
        int rightIndex = middle + 1;

        // merge
        while (leftIndex <= middle && rightIndex <= end) {
            if (temp[leftIndex] > temp[rightIndex]) {
                arr[roopIndex] = temp[rightIndex];
                roopIndex++;
                rightIndex++;
            } else {
                arr[roopIndex] = temp[leftIndex];
                roopIndex++;
                leftIndex++;
            }
        }

        while (leftIndex <= middle) {
            arr[roopIndex] = temp[leftIndex];
            roopIndex++;
            leftIndex++;
        }

        while (rightIndex <= end) {
            arr[roopIndex] = temp[rightIndex];
            roopIndex++;
            rightIndex++;
        }
    }
}
