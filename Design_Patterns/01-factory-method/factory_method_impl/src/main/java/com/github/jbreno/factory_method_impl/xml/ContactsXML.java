package com.github.jbreno.factory_method_impl.xml;

import com.github.jbreno.factory_method_impl.contact.Contact;
import com.github.jbreno.factory_method_impl.contact.Contacts;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

public class ContactsXML implements Contacts {
    private String fileName;

    public ContactsXML(String filename) {
        this.fileName = fileName;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> all() {
        XStream xstream = new XStream();
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contact.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<Contact>) xstream.fromXML(file);
    }
}
