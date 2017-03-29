/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufp.inf.mul2.lzf;

/**
 *
 * @author tiagocardoso
 */
public class Debug {

    public static boolean DEBUG = true;

    public static void debugMessage(String string) {
        if (!DEBUG) {
            return;
        }
        System.out.println(string);
    }
}
