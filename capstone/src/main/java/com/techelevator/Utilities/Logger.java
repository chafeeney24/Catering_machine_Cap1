package com.techelevator.Utilities;

import java.io.*;

public class Logger {
    private File logFile;
    private PrintWriter writer;


    public Logger(String pathName) {
        this.logFile = new File(pathName);

        if (!logFile.exists()) {
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String logMessage) {                          //We could put date time formatter in this class, and then
        this.writer.println(logMessage);                            //have the (logMessage) be (formatDateTime + " " + logMessage)
        this.writer.flush();

    }

    public void close() throws IOException {
        this.writer.close();
    }

}


