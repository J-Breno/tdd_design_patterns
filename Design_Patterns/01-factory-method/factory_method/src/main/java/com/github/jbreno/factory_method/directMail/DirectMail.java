package com.github.jbreno.factory_method.directMail;

import com.github.jbreno.factory_method.contato.Contact;
import com.github.jbreno.factory_method.contato.Contacts;

import java.util.List;

public class DirectMail {
    public boolean sendEmail(String fileName, String message) {
        Contacts contactsRepository = new Contacts();
        List<Contact> contacts = contactsRepository.recoverContactsCSV(fileName);

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
