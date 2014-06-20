
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
package org.info4.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import java.util.List;

import org.info4.common.Sommet;
import org.info4.ui.Surface;

public class EcouteurEvenement extends MouseAdapter implements MouseMotionListener {

	private Surface surface;
	private Sommet sommetActif = null;
	
	
	public EcouteurEvenement(Surface surface) {
		super();
		this.surface = surface;
		surface.addMouseListener(this);
		surface.addMouseMotionListener(this);
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(surface != null && sommetActif != null) {
			sommetActif.setPosition(e.getPoint());
			surface.repaint(); /* Redessiner la surface */
		}
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		List<Sommet> sommets = surface.getSommets(e.getPoint());
		if(sommets.size() > 0) { 
			
			Sommet sommet = surface.getSommetSelectionne();
			Sommet newSommet = sommets.get(0);
			
			if(sommet == null) { // Pas de sommet séléctionné
				surface.setSommetSelectionne(newSommet);
				sommetActif = newSommet; // sommet pouvant bouger 
			} else { // Il faut lier les deux sommets
				
				if(!sommet.equals(newSommet)) {
					if(!sommet.isAdjacent(newSommet))
					{
						sommet.addSommetAdjacent(newSommet);
						newSommet.addSommetAdjacent(sommet);
					}
					surface.setSommetSelectionne(null);
				} else {
					sommetActif = newSommet;
				}
			} 
		} else {
			surface.setSommetSelectionne(null);
		}
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(sommetActif != null) {
			sommetActif = null;
			surface.repaint();
		}
	}
	
}
