

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

import java.awt.Point;
import java.awt.Rectangle;


public interface Forme {

	/**
	 * @param g permet de dessiner la forme 
	 */
	public void dessiner(java.awt.Graphics g);
	
	
	/**
	 * @return la position de la forme sur l'interface
	 */
	public Point getPosition();
	
	
	/**
	 * @param point nouvelle position de la forme
	 */
	public void setPosition(Point point);
	
	
	/**
	 * @return la surface relative à la forme
	 */
	public Rectangle getRectangle();
	
	
	/**
	 * @param rectangle nouvelle surface pour la forme
	 */
	public void setRectangle(Rectangle rectangle);
}
