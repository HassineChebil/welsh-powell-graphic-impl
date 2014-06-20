
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
package org.info4;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.info4.events.EcouteurEvenement;
import org.info4.ui.Fenetre;
import org.info4.ui.Surface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WelshPowell {

	private static final Logger LOG = LoggerFactory.getLogger(WelshPowell.class);
	
	
	public static void main(String[] args) {
		
		LOG.debug("Lancement de la simulation en cours ...");
		
		LookAndFeelInfo[] lafs 	= UIManager.getInstalledLookAndFeels();
		LookAndFeelInfo laf 	= lafs[1];
		
		try {
			
			LOG.debug("Changement du design de l'interface homme-machine ...");
			
			UIManager.setLookAndFeel(laf.getClassName());
			Surface surface = new Surface();
			
			new EcouteurEvenement(surface);
			new Fenetre("Welsh Powell", surface).setVisible(true);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
