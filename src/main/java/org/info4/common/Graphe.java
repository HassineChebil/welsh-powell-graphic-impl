


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
package org.info4.common;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Graphe {

	/** Les sommets du graphe */
	private List<Sommet> sommets = new ArrayList<Sommet>();
	private List<String> messages = new ArrayList<String>();
	private static int etiquetteGen = 1;

	public Graphe() {
		super();
		initialiser();
	}

	
	/**
	 * @description : ajoute le nouveau sommet au graphe
	 * @param sommet
	 */
	public void addSommet(Sommet sommet) {
		sommets.add(sommet);
	}

	public void addSommet() {
		Sommet sommet = new Sommet();
		sommet.setEtiquette("e" + getEtiquetteGen());
		addSommet(sommet);
	}

	/**
	 * @description : supprime le sommet du graphe
	 * @param sommet
	 */
	public void removeSommet(Sommet sommet) {
		sommets.remove(sommet);
	}

	/**
	 * @description : initialise le graphe
	 */
	public void initialiser() {
		sommets.clear();
		etiquetteGen = 1;
		Sommet sommet = new Sommet();
		sommet.setEtiquette("e" + etiquetteGen);
		addSommet(sommet);
	}

	/**
	 * @description : permet de générér la prochaine etiquette
	 * @return
	 */
	public static int getEtiquetteGen() {
		return ++etiquetteGen;
	}

	/**
	 * @description : permet de connaître le nombre de sommets du graphe
	 * @return
	 */
	public int getNombreSommet() {
		return sommets.size();
	}

	/**
	 * @description : permet de récupérer les sommets du graphe
	 * @return
	 */
	public List<Sommet> getSommets() {
		return sommets;
	}

	/**
	 * @description : dessiner le graphe dans l'interface utilisateur
	 * @param g
	 */
	public void dessiner(java.awt.Graphics g) {
		g.setColor(Color.darkGray);

		/** Tracer les liens entre les sommets */
		for (Iterator<Sommet> iter = sommets.iterator(); iter.hasNext();) {

			Sommet sommet = iter.next();
			Point source = sommet.getPosition();

			for (Iterator<Sommet> itera = sommet.getSommetsAdjacents()
					.iterator(); itera.hasNext();) {
				Point target = itera.next().getPosition();
				g.drawLine(source.x, source.y, target.x, target.y);
			}

		}
		/** Dessiner les sommets */
		for (Iterator<Sommet> iter = sommets.iterator(); iter.hasNext();) {
			iter.next().dessiner(g);
		}
	}

	private boolean isAdjacentsNonColores(Sommet sommet, int couleur) {
		List<Sommet> adj = sommet.getSommetsAdjacents();
		for (Iterator<Sommet> iter = adj.iterator(); iter.hasNext();) {
			if (iter.next().getCouleur() == couleur)
				return false;
		}
		return true;
	}

	public int getNombreChromatique() {
		int nombreChromatique = 0;

		Object[] s = sommets.toArray();
		/** Tri décroissant des sommets en fonction de leur degré */
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				Sommet si = (Sommet) s[i];
				Sommet sj = (Sommet) s[j];
				if (sj.getDegre() > si.getDegre()) {
					Object temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
		messages.clear();
		for (int i = 0; i < s.length; i++) {
			Sommet sommet = (Sommet) s[i];
			messages.add(sommet.getEtiquette() + " => degré : "
					+ sommet.getDegre());
			sommet.setCouleur(0); /* Initialiser : aucune couleur a tous les */
			sommet.setRang(i);
		}

		Sommet sommetNonColore = null;
		int i = 0;
		boolean boucler = true;
		while (i < s.length && boucler) {
			/** recherche d'un sommet non coloré */
			do {
				sommetNonColore = (Sommet) s[i++];
			} while (i < s.length && sommetNonColore.getCouleur() != 0);

			/**
			 * attribuant une couleur non encore utilisée, au premier sommet non
			 * encore coloré
			 */
			int nouvelleCouleur = 0;
			if (sommetNonColore != null) {
				if (sommetNonColore.getCouleur() == 0) {
					nouvelleCouleur = ++nombreChromatique;
					sommetNonColore.setCouleur(nouvelleCouleur);
				} else {
					boucler = false;
				}
			}

			/**
			 * Attribuer cette même couleur à chaque sommet non encore coloré et
			 * non adjacent à un sommet de cette couleur
			 */
			if (i < s.length && boucler) {
				for (int j = 0; j < s.length; j++) {
					Sommet autreSommet = (Sommet) s[j];
					if (autreSommet != sommetNonColore
							&& autreSommet.getCouleur() == 0
							&& !sommetNonColore.isAdjacent(autreSommet)
							&& isAdjacentsNonColores(autreSommet,
									nouvelleCouleur)) {
						autreSommet.setCouleur(nouvelleCouleur);
					}
				}
			}
		}
		return nombreChromatique;
	}

	public List<String> getMessages() {
		return messages;
	}
}
