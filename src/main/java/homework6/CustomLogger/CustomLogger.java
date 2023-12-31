package homework6.CustomLogger;

import homework6.family.Family;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.RandomAccess;

public class CustomLogger {
    public void info(String message) {
        saveLogs(message, " [DEBUG] ");
    }

    public void error(String message) {
        saveLogs(message, " [ERROR] ");
    }

    public void saveLogs(String message, String mode) {
        LocalDateTime logtime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        StringBuffer sb = new StringBuffer();
        String timeStr = logtime.format(dateFormatter);
        sb.append("\n").append(timeStr).append(mode).append(message);
        try (RandomAccessFile file = new RandomAccessFile("application.log", "rw");
             FileChannel channel = file.getChannel();) {
            System.out.println("Good");
            file.seek(file.length() - 1);
            ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes());
            channel.write(buffer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
