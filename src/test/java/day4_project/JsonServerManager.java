package day4_project;

import org.testng.annotations.Test;

public class JsonServerManager {

	private static Process process;

    public static void startServer() {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "C:\\Users\\dvrki\\AppData\\Roaming\\npm\\json-server.cmd", "BookStore.json", "--port", "3000"
            );

            builder.redirectErrorStream(true);
            process = builder.start();

            // Give the server a moment to spin up
            Thread.sleep(2000);

            System.out.println("JSON Server started on port 3000");

        } catch (Exception e) {
            throw new RuntimeException("Failed to start JSON Server", e);
        }
    }

    public static void stopServer() {
        try {
            if (process != null) {
                process.destroy();
                System.out.println("JSON Server stopped");
            }
        } catch (Exception ignored) {
        }
    }
}