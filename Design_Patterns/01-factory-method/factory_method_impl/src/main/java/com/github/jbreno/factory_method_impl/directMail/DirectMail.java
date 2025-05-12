package com.github.jbreno.factory_method_impl.directMail;

import com.github.jbreno.factory_method_impl.contact.Contact;
import com.github.jbreno.factory_method_impl.contact.Contacts;

import java.util.ArrayList;
import java.util.List;

public abstract class DirectMail {

    protected abstract Contacts createContacts();

    public boolean sendEmail(String message) {
        List<Contact> contacts = createContacts().all();

        System.out.println("Conectando com servidor SMTP...");
        System.out.println("Mensagem a ser enviada: " + message);
        System.out.println();

        for(Contact contact : contacts) {
            System.out.println("From: <contato@breno.com>");
            System.out.printf("To: [%s] <%s>\n>", contact.getName(), contact.getEmail());
            System.out.println(message);
            System.out.println();
        }

        return true;
    }
}
