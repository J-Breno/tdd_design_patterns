package com.github.jbreno.factory_method;

import com.github.jbreno.factory_method.directMail.DirectMail;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		DirectMail directMail = new DirectMail();
		String message = JOptionPane.showInputDialog(null, "Informe a Mensagem para o e-mail");

		boolean status = directMail.sendEmail("contatos.csv", message);
		System.out.println(status);
	}
}