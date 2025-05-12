package com.github.jbreno.factory_method_impl.xml;

import com.github.jbreno.factory_method_impl.contact.Contacts;
import com.github.jbreno.factory_method_impl.directMail.DirectMail;

public class DirectMailXML extends DirectMail {
    private String fileName;

    public DirectMailXML(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected Contacts createContacts() {
        return new ContactsXML(fileName);
    }
}
