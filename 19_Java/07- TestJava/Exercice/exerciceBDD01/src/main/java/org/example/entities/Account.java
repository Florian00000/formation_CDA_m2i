package org.example.entities;

import org.example.error.AccountAlreadyExist;
import org.example.error.ExceptionConnection;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String email;
    private String name;
    private String password;
    private static List<Account> listAccount = new ArrayList<>();

    public Account(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public static boolean verifyAccount(Account account){
        for(Account a : listAccount){
            if(a.name.equals(account.getName())) throw new AccountAlreadyExist("Nom d'utilisateur déjà utilisé");
        }
        listAccount.add(account);
        return true;
    }

    public static boolean login(String name, String password){
        for (Account a : listAccount) {
            if (a.name.equals(name) && a.password.equals(password)) {
                return true;
            }
        }
        throw new ExceptionConnection("Erreur lors de la connexion");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
