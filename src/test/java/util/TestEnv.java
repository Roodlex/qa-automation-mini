package util;

public final class TestEnv {
    private TestEnv() {}

    /** True when running on GitHub Actions. */
    public static boolean isCi() {
        String ci = System.getenv("CI");
        return ci != null && ci.equalsIgnoreCase("true");
    }
}
