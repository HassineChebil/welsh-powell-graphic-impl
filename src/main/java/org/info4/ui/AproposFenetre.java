
/*
 * Copyright (C) 2014 Nabil Andriantomanga et Tiouajni Noureddine 

 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Remarque :
 * ----------------
 * 
 * Ce projet a été réalisé dans le cadre d'un petit TP du module 
 * Algorithme Numérique.
 * 
 * Faculté des Sciences de Tunis - Département des sciences de l'Informatique
 * Cycle d'ingénieur en informatique . 2 eme année
 */
package org.info4.ui;

import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class AproposFenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructeur de la classe {@link org.info4.ui.AproposFenetre}
	 * @throws HeadlessException
	 */
	public AproposFenetre() throws HeadlessException {

		setTitle("Welsh & Powell Algorithme");

		setSize(400, 250);

		setLocationRelativeTo(null);

		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().add(buildContentPane());
	}
	

	/**
	 * Construit les composants à mettre dans la fenêtre 
	 * @return
	 */
	private Component buildContentPane() {

		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("AUTEURS");
		
		l1.setBounds(30, 30, 300, 20);
		
		panel.add(l1);
		
		JLabel l2 = new JLabel("TIOUAJNI Noureddine, IF4 GROUPE B1");
		
		l2.setBounds(30, 70, 300, 20);
		
		panel.add(l2);
		
		JLabel l3 = new JLabel("NABIL Andriantomanga, IF4 GROUPE B1");
		
		l3.setBounds(30, 100, 300, 20);
		
		panel.add(l3);
		
		JLabel l4 = new JLabel("FST. A.U 2012 - 2013");
		
		l4.setBounds(30, 150, 300, 20);
		
		panel.add(l4);
		
		return panel;

	}
}
