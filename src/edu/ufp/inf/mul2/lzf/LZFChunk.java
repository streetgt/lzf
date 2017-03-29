package edu.ufp.inf.mul2.lzf;

/**
 * Helper class used to store LZF encoded segments (compressed and
 * non-compressed) that can be sequenced to produce LZF files/streams.
 *
 */
public class LZFChunk {

    /**
     * Maximum length of literal run for LZF encoding.
     */
    public static final int MAX_LITERAL = 1 << 5; // 32

    // Chunk length is limited by 2-byte length indicator, to 64k = int 65535
    public static final int MAX_CHUNK_LEN = 0xFFFF;

    public final static byte BYTE_Z = 'Z';
    public final static byte BYTE_V = 'V';

    public final static int BLOCK_TYPE_NON_COMPRESSED = 0;
    public final static int BLOCK_TYPE_COMPRESSED = 1;

    final byte[] _data;
    LZFChunk _next;

    private LZFChunk(byte[] data) {
        _data = data;
    }

    /**
     * Factory method for constructing compressed chunk
     */
    public static LZFChunk createCompressed(int origLen, byte[] encData, int encPtr, int encLen) {
        byte[] result = new byte[encLen + 7];
        result[0] = BYTE_Z;
        result[1] = BYTE_V;
        result[2] = BLOCK_TYPE_COMPRESSED;
        result[3] = (byte) (encLen >> 8);
        Debug.debugMessage("createCompressed: encLen >> 8 " + (byte) (encLen >> 8));
        result[4] = (byte) encLen;
        Debug.debugMessage("createCompressed: encLen" + (byte) (encLen));
        result[5] = (byte) (origLen >> 8);
        Debug.debugMessage("createCompressed: origLen >> 8 " + (byte) (origLen >> 8));
        result[6] = (byte) origLen;
        Debug.debugMessage("createCompressed: origLen" + (byte) (origLen));
        System.arraycopy(encData, encPtr, result, 7, encLen);
        return new LZFChunk(result);
    }

    /**
     * Factory method for constructing compressed chunk
     */
    public static LZFChunk createNonCompressed(byte[] plainData, int ptr, int len) {
        byte[] result = new byte[len + 5];
        result[0] = BYTE_Z;
        result[1] = BYTE_V;
        result[2] = BLOCK_TYPE_NON_COMPRESSED;
        result[3] = (byte) (len >> 8);
        Debug.debugMessage("createNonCompressed: LEN >> 8 " + (byte) (len >> 8));
        result[4] = (byte) len;
        Debug.debugMessage("createNonCompressed: LEN " + result[4]);
        System.arraycopy(plainData, ptr, result, 5, len);
        return new LZFChunk(result);
    }

    public void setNext(LZFChunk next) {
        _next = next;
    }

    public LZFChunk next() {
        return _next;
    }

    public int length() {
        return _data.length;
    }

    public byte[] getData() {
        return _data;
    }

    public int copyTo(byte[] dst, int ptr) {
        int len = _data.length;
        System.arraycopy(_data, 0, dst, ptr, len);
        return ptr + len;
    }
}
