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
public class Utils {
    public static String bytesToBinaryString( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }
    
    public static String bytesToString(byte[] bytes)
    {
        String s = new String(bytes); // possibly with a charset
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        return sb.append(chars).toString();
    }
    
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
