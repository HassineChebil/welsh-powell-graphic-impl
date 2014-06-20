
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
 * Ce projet a �t� r�alis� dans le cadre d'un petit TP du module 
 * Algorithme Num�rique.
 * 
 * Facult� des Sciences de Tunis - D�partement des sciences de l'Informatique
 * Cycle d'ing�nieur en informatique . 2 eme ann�e
 */
package org.info4.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class Sommet extends AbstractForm {

	/** Etiquette relative � ce sommet et visible � l'utilisateur */
	private String etiquette;

	/**
	 * Rang qu'occupe ce sommet apr�s le tri par rapport au nombre de sommets
	 * adjacents
	 */
	private int rang;

	/** Couleur avec laquelle ce sommet est color�e */
	private int couleur = 0; /* 0 => non encore color� */

	/** Liste des sommets adjacents � ce sommet */
	private List<Sommet> sommetsAdjacents = new ArrayList<Sommet>();

	/** Est le point d'entr�e du graphe ? (source) */
	// private boolean source = false;
	/** Est ce sommet selectionn� ? */
	private boolean actif = false;

	/**
	 * @description : ajoute un nouveau sommet adjacent � ce sommet
	 * @param sommet
	 */
	public void addSommetAdjacent(Sommet sommet) {
		sommetsAdjacents.add(sommet);
	}

	/**
	 * @description : supprime un sommet adjacent � ce sommet
	 * @param sommet
	 */
	public void removeSommetAdjacent(Sommet sommet) {
		sommetsAdjacents.remove(sommet);
	}

	/**
	 * @description : v�rifie si le sommet fourni est adjacent � ce sommet
	 * @param sommet
	 * @return
	 */
	public boolean isAdjacent(Sommet sommet) {
		return sommetsAdjacents.contains(sommet);
	}

	/**
	 * @description : permet de savoir le degr� du sommet
	 * @return
	 */
	public int getDegre() {
		return sommetsAdjacents.size();
	}

	/**
	 * @description : dessine ce sommet dans l'interface
	 */
	@Override
	public void dessiner(Graphics g) {

		Color ancienneCouleur = g.getColor();
		Point source = getPosition();

		g.setColor(Color.blue);
		if (actif) {
			g.fillRect(rectangle.x, rectangle.y, rectangle.width,
					rectangle.height);
		}
		g.setColor(Color.darkGray);
		g.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

		g.setColor(new Color(247, 247, 247));
		g.fillOval(rectangle.x + 2, rectangle.y + 2, rectangle.width - 4,
				rectangle.height - 4);

		g.setColor(Color.darkGray);
		g.setFont(new Font("Verdana", Font.BOLD, 13));
		g.drawString(getEtiquette(), source.x - getEtiquette().length() * 3,
				source.y + 4);

		if (couleur > 0) {
			g.setColor(Color.red);
			g.drawString("C" + couleur, source.x - getEtiquette().length() * 3,
					rectangle.y + rectangle.height + 20);
		}
		g.setColor(ancienneCouleur);
	}

	/** Getters and Setters */
	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public List<Sommet> getSommetsAdjacents() {
		return sommetsAdjacents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((etiquette == null) ? 0 : etiquette.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sommet other = (Sommet) obj;
		if (etiquette == null) {
			if (other.etiquette != null)
				return false;
		} else if (!etiquette.equals(other.etiquette))
			return false;
		return true;
	}

}
