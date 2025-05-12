package com.github.jbreno.factory_method_impl.csv;

import com.github.jbreno.factory_method_impl.contact.Contact;
import com.github.jbreno.factory_method_impl.contact.Contacts;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ContactsCSV implements Contacts {
    private String fileName;

    public ContactsCSV(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Contact> all() {
        List<Contact> contacts = new ArrayList<Contact>();
        CSVReader csvReader = null;

        try {
            URI uri = this.getClass().getResource("/" + fileName).toURI();
            File fileCSV = new File(uri);
            FileReader fileReader = new FileReader(fileCSV);
            csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contacts.add(new Contact(nextLine[0].trim(), nextLine[1].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro lendo arquivo csv", e);
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {}
        }
        return contacts;
    }
}
