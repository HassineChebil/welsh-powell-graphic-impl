
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

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class AbstractForm implements Forme {

	
	protected Rectangle rectangle;
	
	
	public static final int cote = 50;
	
	
	public AbstractForm(Rectangle rectangle) {
		super();
		this.rectangle = rectangle;
	}

	
	public AbstractForm() {
		this(new Rectangle(100,100,cote,cote));
	}
	
	@Override
	public Point getPosition() {
		Point point = new Point();
		point.x = rectangle.x + rectangle.width / 2;
		point.y = rectangle.y + rectangle.height / 2;
		return point;
	}
	
	@Override
	public Rectangle getRectangle() {
		return (Rectangle) rectangle.clone();
	}

	
	@Override
	public void setPosition(Point point) {
		rectangle.x = point.x - rectangle.width / 2;
		rectangle.y = point.y - rectangle.height / 2;
	}

	
	@Override
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	
	@Override
	public abstract void dessiner(Graphics g);

}
