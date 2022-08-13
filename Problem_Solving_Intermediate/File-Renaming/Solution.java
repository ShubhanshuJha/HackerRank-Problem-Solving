class Result {
    final static int M = 1000000007;
    public static int renameFile(String newName, String oldName) {
        int n = oldName.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= newName.length(); i++) {
            int[] dp2 = new int[n + 1];
            for (int j = i; j <= n; j++) {
                dp2[j] = dp2[j - 1];
                if (newName.charAt(i - 1) == oldName.charAt(j - 1))
                    dp2[j] = ((dp2[j] % M) + (dp[j - 1] % M)) % M;
            }
            dp = dp2;
        }
        return dp[n] % M;
    }
}