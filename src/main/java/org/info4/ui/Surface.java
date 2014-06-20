
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


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import org.info4.common.Graphe;
import org.info4.common.Sommet;


public class Surface extends JPanel {

	private static final long serialVersionUID = 1L;
	private Graphe graphe;
	private Sommet sommetSelectionne = null;
	private String message = "";
	private String reponse = "";

	public Surface() {
		super();
		graphe = new Graphe();
	}

	/** Initialise les elements sur la surface vue par l'utilisateur */
	public void initialiserTout() {
		graphe.initialiser();
		sommetSelectionne = null;
		message = "Veuillez créer le graphe en vue de calculer le nombre chromatique qui lui est associé.";
		repaint();
	}

	
	/** Retourne la liste des sommets sous ce point */
	public List<Sommet> getSommets(Point point) {
		
		List<Sommet> sommets 		= new ArrayList<Sommet>();
		List<Sommet> sommetsGraphe 	= graphe.getSommets();
		
		for (Iterator<Sommet> iter 	= sommetsGraphe.iterator(); iter.hasNext();) {
			
			Sommet unSommet 		= iter.next();
			
			if (unSommet.getRectangle().contains(point)) {
				sommets.add(unSommet);
			}
		}
		return sommets;
	}

	
	/**
	 * Vérifie si le sommet est seul a cet emplacement Utile pour éviter de
	 * mettre un sommet au dessus d'un autre
	 */
	public boolean isSommetSeul(Sommet sommet) {
		
		List<Sommet> sommetsGraphe 	= graphe.getSommets();
		
		for (Iterator<Sommet> iter 	= sommetsGraphe.iterator(); iter.hasNext();) {
			
			Sommet unSommet 		= iter.next();
			
			if (unSommet.getRectangle().intersects(sommet.getRectangle())) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Color ancienneCouleur 		= g.getColor();
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		graphe.dessiner(g);
		g.setColor(Color.black);
		g.drawString(message, 20, 20);

		List<String> degres 		= graphe.getMessages();
		int dy = 400;
		
		for (Iterator<String> iter 	= degres.iterator(); iter.hasNext();) {
			g.drawString(iter.next(), 20, dy);
			dy += 20;
		}
		if (degres.size() > 0) {
			g.drawString("RESULTAT DU TRI", 20, 370);
			g.drawString("--------------------------", 18, 380);
		}
		
		g.setFont(new Font("Verdana", Font.BOLD, 15));
		g.drawString(reponse, 20, 50);
		g.setColor(ancienneCouleur);
	}

	public Graphe getGraphe() {
		return graphe;
	}

	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}

	public Sommet getSommetSelectionne() {
		return sommetSelectionne;
	}

	public void setSommetSelectionne(Sommet sommetSelectionne) {
		
		if (sommetSelectionne == null) {
			
			if (this.sommetSelectionne != null) {
				
				this.sommetSelectionne.setActif(false);
			}
			
			this.sommetSelectionne = null;
			repaint();
			
		} else {
			this.sommetSelectionne = sommetSelectionne;
			this.sommetSelectionne.setActif(true);
		}
	}

	public void addSommet() {
		graphe.addSommet();
		repaint();
	}

	public void removeSommet() {
		if (sommetSelectionne 		   != null) {
			
			List<Sommet> adjacents 		= sommetSelectionne.getSommetsAdjacents();
			
			for (Iterator<Sommet> iter 	= adjacents.iterator(); iter.hasNext();) {
				iter.next().removeSommetAdjacent(sommetSelectionne);
			}
			graphe.removeSommet(sommetSelectionne);
			sommetSelectionne 			= null;
			repaint();
		} else {
			message 					= "Il faut sélectionner le sommet à supprimer";
		}
	}

	public void showNombreChromatique() {
		reponse = "Nombre chromatique : " + graphe.getNombreChromatique();
		repaint();
	}
}
