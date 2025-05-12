package com.github.jbreno.factory_method_impl;

import com.github.jbreno.factory_method_impl.csv.DirectMailCSV;
import com.github.jbreno.factory_method_impl.directMail.DirectMail;
import com.github.jbreno.factory_method_impl.xml.DirectMailXML;

import javax.swing.*;

public class NewClient {
    public static void main(String[] args) {
        DirectMail directMail = new DirectMailXML("contatos.xml");
        String message = JOptionPane.showInputDialog(null,
                "Informe a menssagem de novo cliente");
        boolean status = directMail.sendEmail(message);
        JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso:" + status);
    }
}
