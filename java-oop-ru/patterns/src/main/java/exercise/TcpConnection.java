package exercise;

import java.util.List;
import java.util.ArrayList;

// BEGIN
class TcpConnection {
    private String ip;
    private Integer port;
    private boolean state;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect() {
        if (this.state) {
            System.out.println("Error! Connection already connected");
        } else {
            this.state = true;
        }
    }

    public void disconnect() {
        if (!this.state) {
            System.out.println("Error! Connection already disconnected");
        } else {
            this.state = false;
        }
    }

    public String getCurrentState() {
        return this.state? "connected":"disconnected";
    }

    public void write(String content) {
        if (!this.state) {
            System.out.println("Error! System is not connected");
        } else {
            this.buffer.add(content);
        }
    }
}
// END
