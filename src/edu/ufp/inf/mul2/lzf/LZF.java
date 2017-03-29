package edu.ufp.inf.mul2.lzf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Simple command-line utility that can be used for testing LZF compression.
 *
 */
public class LZF {

    final static String SUFFIX = ".lzf";

    void process(String[] args) throws IOException {
        if (args.length == 2) {
            String oper = args[0];
            boolean compress = "-c".equals(oper);
            if (compress || "-d".equals(oper)) {
                String filename = args[1];
                File src = new File(filename);
                if (!src.exists()) {
                    System.err.println("File '" + filename + "' does not exist.");
                    System.exit(1);
                }
                if (!compress && !filename.endsWith(SUFFIX)) {
                    System.err.println("File '" + filename + "' does end with expected suffix ('"
                            + SUFFIX + "', won't decompress.");
                    System.exit(1);
                }
                byte[] data = readData(src);
                Debug.debugMessage("Read " + data.length + " bytes.");
                Debug.debugMessage("Original Text Binary: \n" + Utils.formatOctetBinary(Utils.bytesToBinaryString(data)));
                byte[] result = null;
                if (compress) {
                    result = LZFEncoder.encode(data);
                    Debug.debugMessage("Compressed Text Binary: \n" + Utils.formatOctetBinary(Utils.bytesToBinaryString(result)));
                } else {
                    result = LZFDecoder.decode(data);
                }
                Debug.debugMessage("Processed into " + result.length + " bytes.");
                File resultFile = null;

                if (compress) {
                    resultFile = new File(filename + SUFFIX);
                } else {
                    resultFile = new File(filename.substring(0, filename.length() - SUFFIX.length()));
                }
                FileOutputStream out = new FileOutputStream(resultFile);
                out.write(result);
                out.close();
                Debug.debugMessage("Wrote in file '" + resultFile.getAbsolutePath() + "'.");
                return;
            }
        }
        System.err.println("Usage: java " + getClass().getName() + " -c/-d file");
        System.exit(1);
    }

    private byte[] readData(File in) throws IOException {
        int len = (int) in.length();
        Debug.debugMessage("readDates in.length = " + len);
        byte[] result = new byte[len];
        int offset = 0;
        FileInputStream fis = new FileInputStream(in);

        while (len > 0) {
            int count = fis.read(result, offset, len);
            if (count < 0) {
                break;
            }
            len -= count;
            offset += count;
        }
        fis.close();
        if (len > 0) { // should never occur...
            throw new IOException("Could not read the whole file -- received EOF when there was "
                    + len + " bytes left to read");
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] cargs = new String[2];
        cargs[0] = "-c";
        cargs[1] = "data/71kchars.txt";
        new LZF().process(cargs);
        //new LZF().process(args);
    }
}
