class Result {
    public static String decryptPassword(String s) {
        char[] seq = s.toCharArray();
        int n = seq.length;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(seq[i]) && seq[i] != '0') {
                int j = n - 1;
                while (j >= 0) {
                    if (seq[j] == '0') {
                        seq[j] = seq[i];
                        seq[i] = '_';
                        break;
                    }
                    j--;
                }
            }
            if (seq[i] == '*') {
                swap(seq, i - 2, i - 1);
                seq[i] = '_';
            }
        }
        String decryptedPassword = String.valueOf(seq);
        decryptedPassword = decryptedPassword.replace("_", "");
        return decryptedPassword;
    }
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
