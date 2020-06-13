/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Prageeth
 */
public class StdServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket sk = new ServerSocket(1342);
        while (true) {

            Socket ss = sk.accept();
            Scanner sc = new Scanner(ss.getInputStream());

            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();
            String s4 = sc.next();

            s1 = calcGrade(s1);
            s2 = calcGrade(s2);
            s3 = calcGrade(s3);
            s4 = calcGrade(s4);

            PrintStream pp = new PrintStream(ss.getOutputStream());
            pp.println(s1);
            pp.println(s2);
            pp.println(s3);
            pp.println(s4);

        }
    }

    public static String calcGrade(String res) {
        double res1 = Double.parseDouble(res);
        if (res1 > 50) {

            return "pass";
        } else {

            return "fail";
        }

    }

}
