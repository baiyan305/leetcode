// 158. Read N Characters Given Read4 II - Call multiple

public class ReadNCharactersGivenRead4II {

    public class Solution extends Reader4 {

        // Read4方法的buffer
        char[] buf4 = new char[4];

        // lastR是上一次read4方法读取了多少字符
        // buf4Idx是目前buf4的指针，表示读到了哪一位
        int buf4Idx = 0, lastR = 0;
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int idx = 0;

            // 先检查buf4里面是否还有没读取的字符
            // 有的话，要先读取
            while(n>0 && buf4Idx<lastR) {
                n--;
                buf[idx++] = buf4[buf4Idx++];
            }

            // 如果还需要更多的字符的话，再继续调用read4
            while(n>0 && (lastR=read4(buf4))>0)
                for(buf4Idx=0; buf4Idx<lastR && n>0; n--)
                    buf[idx++] = buf4[buf4Idx++];

            return idx;
        }
    }

}
