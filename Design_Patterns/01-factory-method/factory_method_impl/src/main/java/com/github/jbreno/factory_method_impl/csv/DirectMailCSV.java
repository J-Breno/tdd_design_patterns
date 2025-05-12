package com.github.jbreno.factory_method_impl.csv;

import com.github.jbreno.factory_method_impl.contact.Contacts;
import com.github.jbreno.factory_method_impl.directMail.DirectMail;

public class DirectMailCSV extends DirectMail {
    private String fileName;

    public DirectMailCSV(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected Contacts createContacts() {
        return new ContactsCSV(fileName);
    }
}
