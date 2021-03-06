package gui.main.workspace.mouse;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;
import gui.main.brush.Brush;
import gui.main.workspace.Workspace;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import position.Position;

public class Line implements MouseListener, MouseMotionListener {

	private Controller main;
	private Workspace workspace;
	private boolean state;
	private Position posStart;
	private Position posEnd;

	public Line(Controller main, Workspace workspace) {
		super();
		this.main = main;
		this.workspace = workspace;
		this.state = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (main.getBrush().getState() != Brush.LINE)
			return;

		if (!state) {
			this.posStart = new Position(e.getX(), e.getY());
		} else {
			this.posEnd = new Position(e.getX(), e.getY());

			this.workspace.addBrush(new graphic.Line(this.main.getColor().getState(), this.posStart, this.posEnd));

			this.workspace.clearTempBrushes();
			this.posStart = this.posEnd = null;
		}

		// Cambiar el estado
		state = !state;

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// si aun no indica el primer click
		if (!this.state || this.posStart == null)
			return;

		// Si cambio de pincel
		if (main.getBrush().getState() != Brush.LINE) {
			this.state = false;
			this.workspace.clearTempBrushes();
			return;
		}

		// Dibujar una forma temporal
		this.workspace.clearTempBrushes();
		this.workspace.addTempBrush(new graphic.Line(this.main.getColor().getState(), this.posStart, new Position(e.getX(), e.getY())));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
