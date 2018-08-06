// 423. Reconstruct Original Digits from English

public class ReconstructOriginalDigitsFromEnglish {

    public void run() {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }

    /*
    423. Reconstruct Original Digits from English
    * zero : count[z]
    * one:   count[o] - count[zero] - count[two] - count[four]
    * two:   count[w]
    * three: count[h] - count[eight]
    * four:  count[u]
    * five:  count[f] - count[four];
    * six:   count[x]
    * seven: count[s] - count[six]
    * eight: count[g]
    * nine:  count[i] - count[eight] - count[six] - count[five]
    */
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c : s.toCharArray()) {
            switch(c) {
                case 'z':
                    count[0]++;
                    break;
                case 'o':
                    count[1]++;
                    break;
                case 'w':
                    count[2]++;
                    break;
                case 'h':
                    count[3]++;
                    break;
                case 'u':
                    count[4]++;
                    break;
                case 'f':
                    count[5]++;
                    break;
                case 'x':
                    count[6]++;
                    break;
                case 's':
                    count[7]++;
                    break;
                case 'g':
                    count[8]++;
                    break;
                case 'i':
                    count[9]++;
                    break;
            }
        }

        count[1] = count[1] - count[0] - count[2] - count[4];
        count[3] = count[3] - count[8];
        count[5] = count[5] - count[4];
        count[7] = count[7] - count[6];
        count[9] = count[9] - count[8] - count[6] - count[5];

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<10; i++) {
            for(int j=0; j<count[i];j++){
                builder.append(i);
            }
        }
        return builder.toString();
    }

}