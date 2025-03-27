package com.example.viikko11;

import java.util.ArrayList;

public class ContactStorage {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private static ContactStorage contactStorage = null;

    private ContactStorage(){ //LISÄTTY
    }


    public static ContactStorage getInstance() {
        if(contactStorage == null){
            contactStorage = new ContactStorage();
        }
        return contactStorage;
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);

    }
    public void removeContact(int puhNumber) {
     int i = 0;
     String puhNumberString = String.valueOf(puhNumber);
     for(Contact r : contacts) {
         if(r.getNumber().equals(puhNumberString)){
             break;
         }
         i++;
     }
     contacts.remove(i);
    }
}
