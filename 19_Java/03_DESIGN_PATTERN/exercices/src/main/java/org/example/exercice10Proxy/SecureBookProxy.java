package org.example.exercice10Proxy;

public class SecureBookProxy implements Book{
    private RealBook book;
    private boolean isUserPrenium;

    public SecureBookProxy(boolean isUserPrenium) {
        this.isUserPrenium = isUserPrenium;
        this.book = new RealBook("La guerre des Gaules", "Gallis est omnis diuisa in partes tres, " +
                "quarum unam incolunt Belgae, aliam Aquitani, tertiam qui ipsorum lingua Celtae, ...");

    }

    @Override
    public void readBook() {
        if (isUserPrenium) {
            book.readBook();
        } else {
            throw new RuntimeException("Not Allowed to read this book");
        }

    }
}
