package leetcode;

public class Spreadsheet {
    public String spreadSheet(int n) {
        int first = (n - 1) / 702 + 1;
        StringBuilder sb = new StringBuilder();

        int reminder = n % 702 == 0 ? 702 : n % 702;
        if (reminder < 27) {
            char c = (char) (reminder + 64);
            sb.append(c);
        } else {
            float dfloat = (float) (reminder) / (float) (26);
            int dint = dfloat == reminder / 26 ? (reminder / 26) - 1 : (int) (reminder / 26);
            int r = reminder % 26 == 0 ? 26 : reminder % 26;
            sb.append((char) (dint + 64));
            sb.append((char) (r + 64));
        }
        return first + sb.toString();
    }
}
