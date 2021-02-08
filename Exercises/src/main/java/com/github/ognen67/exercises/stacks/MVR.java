package com.github.ognen67.exercises.stacks;

import java.util.Scanner;


class Gragjanin {
    public String imePrezime;
    public int lKarta, pasos, vozacka;

    public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        super();
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        ArrayQueue<Gragjanin> redicaLkarti = new ArrayQueue<Gragjanin>(10);
        ArrayQueue<Gragjanin> redicaPasos = new ArrayQueue<Gragjanin>(10);
        ArrayQueue<Gragjanin> redicaVozacka = new ArrayQueue<Gragjanin>(10);

        int N = Integer.parseInt(br.nextLine());
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if (lKarta == 1) {
                redicaLkarti.enqueue(covek);
            } else if (pasos == 1)
                redicaPasos.enqueue(covek);
            else
                redicaVozacka.enqueue(covek);
        }

        while(!redicaLkarti.isEmpty()) {
            System.out.println(redicaLkarti.peek().imePrezime);
            redicaLkarti.dequeue();
        }
        System.out.println("----");
        while(!redicaPasos.isEmpty()) {
            System.out.println(redicaPasos.peek().imePrezime);
            redicaPasos.dequeue();
        }
        System.out.println("----");
        while(!redicaVozacka.isEmpty()) {
            System.out.println(redicaVozacka.peek().imePrezime);
            redicaVozacka.dequeue();
        }

//        otvoriShalter(redicaLkarti, redicaPasos, redicaVozacka);
    }
}
