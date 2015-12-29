package eu.shiny.Textkernel;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Monitor {

    private final String url;

    private final int timeout;

    //In milliseconds
    private final long frequency;

    public Monitor(String url, int timeout, long frequency) {
        this.url = url;
        this.timeout = timeout;
        this.frequency = frequency;
    }

    public void startMonitor(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setConnectTimeout(timeout);
                    connection.setReadTimeout(timeout);
                    connection.setRequestMethod("GET");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    if(responseCode >= 200 || responseCode < 400 ){
                        System.out.println("Health check for host " + url + " is successful");
                    } else {
                        System.out.println("Health check for host " + url + " is failed");
                    }
                } catch (Exception exception) {
                    System.out.println("Health check for host " + url + " is failed");
                }
            }
        }, 0, frequency);

    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor("http://amsxpress01.fnfis.com:9084/xpress/", 1000, 3000);
        monitor.startMonitor();
    }
}
