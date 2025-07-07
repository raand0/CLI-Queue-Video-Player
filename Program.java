import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private static ArrayList<String> videoQueue = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String QUEUE_FILE = "video_queue.txt"; // File to save the queue

    public static void main(String[] args) {
        loadQueue(); // Load the queue at startup
        String command;
        System.out.println("YouTube Queue Tool - Commands: add [url], play, remove [index], view, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = sc.nextLine().trim();

            if (command.startsWith("add")) {
                String videoUrl = command.substring(4).trim();
                if (!videoUrl.isEmpty()) {
                    videoQueue.add(videoUrl);
                    System.out.println("Added to queue: " + videoUrl);
                } else {
                    System.out.println("Please provide a valid URL.");
                }

            } else if (command.equals("play")) {
                if (!videoQueue.isEmpty()) {
                    String videoUrl = videoQueue.get(0);
                    openVideoInChrome(videoUrl);
                    System.out.println("Playing: " + videoUrl);
                } else {
                    System.out.println("The queue is empty.");
                }

            } else if (command.startsWith("remove")) {
                try {
                    int index = Integer.parseInt(command.substring(7).trim());
                    if (index >= 0 && index < videoQueue.size()) {
                        String removedVideo = videoQueue.remove(index);
                        System.out.println("Removed from queue: " + removedVideo);
                    } else {
                        System.out.println("Invalid index. Please provide a valid index between 0 and " + (videoQueue.size() - 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a valid number for the index.");
                }

            } else if (command.equals("view")) {
                System.out.println("Current Queue:");
                for (int i = 0; i < videoQueue.size(); i++) {
                    System.out.println(i + ": " + videoQueue.get(i));
                }

            } else if (command.equals("exit")) {
                saveQueue(); // Save the queue before exiting
                System.out.println("Exiting the tool...");
                break;

            } else {
                System.out.println("Invalid command. Use: add [url], play, remove [index], view, exit.");
            }
        }
    }

    private static void loadQueue() {
        try (BufferedReader br = new BufferedReader(new FileReader(QUEUE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                videoQueue.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("No previous queue found, starting fresh.");
        }
    }

    private static void saveQueue() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(QUEUE_FILE))) {
            for (String videoUrl : videoQueue) {
                bw.write(videoUrl);
                bw.newLine();
            }
            System.out.println("Queue saved.");
        } catch (IOException e) {
            System.out.println("Error saving queue.");
        }
    }

    private static void openVideoInChrome(String videoUrl) {
        try {
            // Open the video URL directly in the Chrome browser
            String[] command = {
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
                videoUrl
            };
    
            Runtime.getRuntime().exec(command);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }       
}
