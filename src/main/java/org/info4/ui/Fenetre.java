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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public final class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	
/** Création des composants de base de l'interface utilisateur */
	private JPanel conteneur;
	
	private JPanel menu;
	
	private Surface surface;
	
	private JScrollPane scroller;
	
/** Création de la barre de menu pour l'utilisateur */
	private JMenuBar menuBar;
	
	private JMenu fichier, aide;
	
	private JMenuItem quitter;
	
	private JMenuItem apropos;
	
/** Les boutons de l'interface graphique de l'utilisateur */
	private JButton nouveauBt;
	
	private JButton addSommetBt;
	
	private JButton rmvSommetBt;
	
	private JButton nbChromatBt;
	
	public Fenetre(String title, Surface surface) throws HeadlessException {
		super(title);
		
		this.surface = surface;
		
		setSize(1100,700);
		
		setResizable(false);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(buildContentPane());
	}

	private Component buildContentPane() {
		conteneur = new JPanel();
		conteneur.setLayout(new BorderLayout());
		
		menu = new JPanel();
		menu.setPreferredSize(new Dimension(200,700));
		menu.setBackground(new Color(247,247,247));
		
		conteneur.add(menu, BorderLayout.WEST);
		
		menu.setLayout(null);
		
		nouveauBt = new JButton("Nouveau graphe");
		nouveauBt.addActionListener(new Ecouteur());
		nouveauBt.setBounds(20, 100, 170, 40);
		
		menu.add(nouveauBt);
		
		addSommetBt = new JButton("Ajouter un sommet");
		addSommetBt.addActionListener(new Ecouteur());
		addSommetBt.setBounds(20, 200, 170, 40);
		
		menu.add(addSommetBt);
		
		rmvSommetBt = new JButton("Supprimer un sommet");
		rmvSommetBt.addActionListener(new Ecouteur());
		rmvSommetBt.setBounds(20, 300, 170, 40);
		
		menu.add(rmvSommetBt);
		
		nbChromatBt = new JButton("Nombre chromatique");
		nbChromatBt.addActionListener(new Ecouteur());
		nbChromatBt.setBounds(20, 400, 170, 40);
		
		menu.add(nbChromatBt);
		
		if(surface == null)
			surface = new Surface();
		
		surface.initialiserTout();
		surface.setPreferredSize(new Dimension(3500,3500));
		
		scroller = new JScrollPane(surface);
		scroller.setPreferredSize(new Dimension(880,700));
		
		conteneur.add(scroller, BorderLayout.EAST);
		
		menuBar = new JMenuBar();
		
		fichier = new JMenu("Fichier");
		
		quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new Ecouteur());
		
		fichier.add(quitter);
		
		aide 	= new JMenu("Aide");
		
		apropos = new JMenuItem("A propos");
		apropos.addActionListener(new Ecouteur());
		
		aide.add(apropos);
		
		menuBar.add(fichier);
		menuBar.add(aide);
		
		setJMenuBar(menuBar);
		
		return conteneur;
	}

	private class Ecouteur implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == nouveauBt) {
				surface.initialiserTout();
			} else
			if(e.getSource() == addSommetBt) {
				surface.addSommet();
			} else
			if(e.getSource() == rmvSommetBt) {
				surface.removeSommet();
			} else
			if(e.getSource() == nbChromatBt) {
				surface.showNombreChromatique();
			} else
			if(e.getSource() == apropos) {
				new AproposFenetre().setVisible(true);
			} else
			if(e.getSource() == quitter) {
				System.exit(0);
			} 
		}
	}
}
