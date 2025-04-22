package com.course;

import java.util.Scanner;

public class Tamgiac {
    public static void main(String[] args) {
        int a, b, c;
        float p, s, cv;

        a = nhapSoNguyen("Nhap canh a: ");
        b = nhapSoNguyen("Nhap canh b: ");
        c = nhapSoNguyen("Nhap canh c: ");
        p = nuaChuVi(a, b, c);
        s = dienTich(a, b, c);
        cv = chuVi(a, b, c);
        System.out.println("Nua chu vi tam giac la: " + p);
        System.out.println("Chu vi tam giac la: " + cv);
        System.out.println("Dien tich tam giac la: " + s);
    }

    public static int nhapSoNguyen(String str) {
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        x = sc.nextInt();
        return x;
    }

    public static float nuaChuVi(int a, int b, int c) {
        return (float) (a + b + c) / 2;
    }

    public static float chuVi(int a, int b, int c) {
        return a + b + c;
    }

    public static float dienTich(int a, int b, int c) {
        float p = (float) (a + b + c) / 2;
        float sd;
        sd = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return sd;
    }
}
