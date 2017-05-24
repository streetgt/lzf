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
public class Utils {
    
    /**
     * Converts bytes[] into a Binary represented String
     * 
     * @param bytes
     * @return 
     */
    public static String bytesToBinaryString( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }
    
    /**
     * Converts bytes[] into a String
     * 
     * @param bytes
     * @return 
     */
    public static String bytesToString(byte[] bytes)
    {
        String s = new String(bytes); // possibly with a charset
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        return sb.append(chars).toString();
    }
    
    /**
     * Format Binary represented String into Octects
     * 
     * @param binary
     * @return 
     */
    public static String formatOctetBinary(String binary)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i = i + 8) {
            String octet = binary.substring(i, i+8);
            int j = Integer.parseInt(octet, 2);
            if(j < 65) {
                j+=48;
            }
            System.out.println(j);
            sb.append(octet).append(" - ").append((char)j).append('\n');
        }
        
        return sb.toString();
    }
}
