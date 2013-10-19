package br.com.cadoresistemas.williamcadore.Utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class Centraliza
{

    private static Dimension ds = null;

    private static Dimension dx = null;

    /**
     * Centraliza JDialog
     * @param com
     * @param menosX
     * @param menosY
     */

    public static void setCentro ( JFrame com , int menosX , int menosY )
    {
        dx = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        ds = com.getSize ( );
        com.setLocation ( ( ( dx.width - ds.width ) / 2 ) - menosX , ( ( dx.height - ds.height ) / 2 ) - menosY );
    }

    /**
     * Centraliza JDialog
     * @param com
     * @param menosX
     * @param menosY
     */

    public static void setCentro ( JInternalFrame com , JDesktopPane desktop, int menosX , int menosY )
    {
        dx = desktop.getSize();
        ds = com.getSize ( );
        com.setLocation ( ( ( dx.width - ds.width ) / 2 ) - menosX , ( ( dx.height - ds.height ) / 2 ) - menosY );
    }
    
    /**
     * Centraliza JDialog
     * @param com
     * @param menosX
     * @param menosY
     */

    public static void setCentro ( JDialog com , int menosX , int menosY )
    {
        dx = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        ds = com.getSize ( );
        com.setLocation ( ( ( dx.width - ds.width ) / 2 ) - menosX , ( ( dx.height - ds.height ) / 2 ) - menosY );
    }
}
