package edu.ufp.inf.mul2.lzf;

/**
 * <p>
 * Title: Multimedia II - LZF</p>
 * <p>
 * Description: LZF Compression / Decompression GUI</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Tiago Cardoso <tiagocardosoweb@gmail.com>
 * @author André Nogueira <andreedsnogueira@gmail.com>
 * @author Filipe Teixeira <lipe_teixeira_ft@hotmail.com>
 * @author Hugo Ramalho <hugo_ramalho9@gmail.com>
 * 
 * @version 1.0
 */
public class Debug {

    // If you want to see some debug messages, tweak here
    public static boolean DEBUG = false;

    /**
     * Debug Message method for debuging
     * 
     * @param string 
     */
    public static void debugMessage(String string) {
        if (DEBUG) {
            System.out.println(string);
        }
    }
}
