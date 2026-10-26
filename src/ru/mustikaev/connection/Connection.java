package ru.mustikaev.connection;

public class Connection {
    private boolean isOpened;
    private String targetAddress;

    public Connection(String targetAddress) {
        this.targetAddress = targetAddress;
        this.isOpened = true;
    }
    
    public String getData() throws LostConnectionException, ClosedResourceException {
        if (!isOpened) {
            throw new LostConnectionException("Соединение с " + targetAddress + " закрыто");
        }
        
        if (Math.random() < 0.5) {
            throw new ClosedResourceException();
        } else {
            return "test connection";
        }
    }

    public void close() {
        isOpened = false;
    }
}
