package com.gofdemo.simplefactory;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        do {
            System.out.println("请输入披萨种类：");
            InputStream in = System.in;

            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedInputStream = new BufferedReader(reader);
            try {
                String type = bufferedInputStream.readLine();
                Pizza pizza = PizzaFactory.createPizza(type);
                if (pizza == null) {
                    System.out.println("披萨种类不存在");
                    break;
                }
                pizza.prepare();
                pizza.bak();
                pizza.cut();
                pizza.box();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);

    }
}
