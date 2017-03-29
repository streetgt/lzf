package edu.ufp.inf.mul2.lzf;

/**
 * Encoder that handles splitting of input into chunks to encode, calls
 * {@link ChunkEncoder} to compress individual chunks and combines resulting
 * chunks into contiguous output byte array.
 * <p>
 * Code adapted from H2 project (http://www.h2database.com) Java LZF
 * implementation by Thomas (which itself was inspired by original C code by
 * Marc A Lehmann)
 *
 */
public class LZFEncoder {

    // Static methods only, no point in instantiating
    private LZFEncoder() {
    }

    /**
     * Method for compressing given input data using LZF encoding and block
     * structure (compatible with lzf command line utility). Result consists of
     * a sequence of chunks.
     */
    public static byte[] encode(byte[] data) {
        Debug.debugMessage("encode()" + Utils.bytesToString(data));
        int left = data.length;
        Debug.debugMessage("encode.lenght = " + left);
        ChunkEncoder enc = new ChunkEncoder(left);
        int chunkLen = Math.min(LZFChunk.MAX_CHUNK_LEN, left);
        Debug.debugMessage("chunkLen = " + chunkLen + " ("+ LZFChunk.MAX_CHUNK_LEN + " "+ left+")");
        LZFChunk first = enc.encodeChunk(data, 0, chunkLen);
        Debug.debugMessage("encodeChunk("+Utils.bytesToBinaryString(data)+", 0, "+chunkLen);
        left -= chunkLen;
        // shortcut: if it all fit in, no need to coalesce:
        if (left < 1) {
            Debug.debugMessage("returned left < 1: output:" + Utils.bytesToString(first.getData()));
            return first.getData();
        }
        // otherwise need to get other chunks:
        int resultBytes = first.length();
        int inputOffset = chunkLen;
        LZFChunk last = first;

        do {
            chunkLen = Math.min(left, LZFChunk.MAX_CHUNK_LEN);
            LZFChunk chunk = enc.encodeChunk(data, inputOffset, chunkLen);
            inputOffset += chunkLen;
            left -= chunkLen;
            resultBytes += chunk.length();
            
            last.setNext(chunk);
            last = chunk;
            System.out.println("encode2()");
        } while (left > 0);
        // and then coalesce returns into single contiguous byte array
        byte[] result = new byte[resultBytes];
        int ptr = 0;
        for (; first != null; first = first.next()) {
            ptr = first.copyTo(result, ptr);
        }
        return result;
    }
}
