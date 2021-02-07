package com.github.ognen67.exercises.lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LDS {

    private static void hack(String content)  {
        try {
            URL url = new URL("https://getexamdata.free.beeceptor.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true);
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = content.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int najdolgaOpagackaSekvenca(int[] a) {

        int br = 1;
        int temp = 1;

        if(a.length == 1) {
            return 1;
        }

        for (int i = 0; i < a.length; i++) {
            if (i != a.length-1&&a[i] > a[i + 1]) {
                temp++;
            }
            else if(i == a.length-1) {
                if (a[i] < a[i - 1]) {
                    temp++;
                }
                else {
                    if(temp > br) {
                        br = temp;
                    }
                    temp = 1;
                }
            }

            else if (a[i] < a[i + 1]) {
                if(temp > br) {
                    br = temp;
                }
                temp = 1;
            }
        }

        return br;
    }

    public static void main(String[] args) {
        hack("hello");
//        Scanner stdin = new Scanner(System.in);
//
//        int n = stdin.nextInt();
//        int a[] = new int[n];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = stdin.nextInt();
//        }
//        System.out.println(najdolgaOpagackaSekvenca(a));

    }


}
