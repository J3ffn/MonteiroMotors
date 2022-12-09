package eduardo.Ouvintes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OuvinteDoTecladoParaApenasNumerico implements KeyListener{
	
		public void keyTyped(KeyEvent e) {
			if(!(Character.isDigit(e.getKeyChar()))) {
				e.consume();
			}
		}
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
}
