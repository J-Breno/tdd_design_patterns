package com.github.jbreno.factory_method.contato;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import com.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Contacts {
    public List<Contact> recoverContactsCSV(String fileName) {
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

    @SuppressWarnings("unchecked")
    public List<Contact> recoverContactsXML(String fileName) {
        XStream xstream = new XStream();
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contact.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<Contact>) xstream.fromXML(file);
    }
}
