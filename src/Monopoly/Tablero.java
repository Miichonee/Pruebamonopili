package Monopoly;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Tablero extends JPanel
{
    private ArrayList<Cuadrantes> allCuadrantes = new ArrayList<Cuadrantes>();
    private ArrayList<Cuadrantes> Cuadrantesincomprables = new ArrayList<Cuadrantes>(); // Cuadrantes que ya se compraron o como el cuadrante00

    public ArrayList<Cuadrantes> getCuadrantesincomprables() {
        return Cuadrantesincomprables;
    }

    public ArrayList<Cuadrantes> getAllCuadrantes() {
        return allCuadrantes;
    }

    public Cuadrantes getCuadrantealinicio(int location) {
        return allCuadrantes.get(location);
    }

    public Tablero(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 612, 612);
        this.setLayout(null);
        iniciarCuadrantes();
    }

    private void iniciarCuadrantes()
    {
        //Aca se cargan todos los nombres de los cuadrantes vendrian a ser la residencia y avenidas todo el desastre

        String[] NombreCuadran =
                {
                "Avenida Artrosis",
                "Avenida Gastritis",
                "Edificio Globant",
                "UTN",
                "Calle Shrek",
                "Calle Shrek 2",
                "Plaza Springboot",
                "Avenida Walter White",
                "Maxikiosco 'EL ESCOCES'",
                "Libreria Roberto",
                "Gotham City",
                "Torre Osama",
                "Maxikiosco de Seba",
                "Club Nocturno LIV",
                "Plaza ZinjaI",
                "Heladeria Ujujuy esta fria la taza",
                "Avenida El Bromas",
                "Calle Probabilidades Thales",
                "Puente Resistencia-Vilelas",
                "La casa del alfajor"
        };

        // Cuadrantes de Arriba vendria a ser toda la hilera de cuadros de arriba
        Cuadrantes cuadro00 = new Cuadrantes(6,6,100,100,NombreCuadran[0],135);
        this.add(cuadro00);
        allCuadrantes.add(cuadro00);
        Cuadrantesincomprables.add(cuadro00);

        // Primer cuadro que vendria a ser Avenida gastritis
        Cuadrantes cuadro01 = new Cuadrantes(106,6,100,100,NombreCuadran[1],180);
        this.add(cuadro01);
        allCuadrantes.add(cuadro01);

        //Seteo de los precios de las propiedades
        cuadro01.setPrecio(100);
        // Y asi con las demas

        //Seteo de los precios de las rentas
        cuadro01.setRentPrecio(10);
        // Y seguimos con cuadro 1 y 2 seteando

        // Aca creamos el tablero en si y dividimos las hileras para que quede de forma cuadrada
        JLabel lblMonopoly = new JLabel("MEMEPOLY"){

            protected void paintComponent(Graphics g)
            {
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                AffineTransform ahr = g2.getTransform();
                Shape formavieja = g2.getClip();
                double x = getWidth()/2.0;
                double y = getHeight()/2.0;
                ahr.rotate(Math.toRadians(-35), x, y);
                g2.setTransform(ahr);
                g2.setClip(formavieja);
                super.paintComponent(g);
            }
        };
        // Aca le metemos los colorsitos y too el desastre
        lblMonopoly.setForeground(Color.WHITE);
        lblMonopoly.setBackground(Color.RED);
        lblMonopoly.setOpaque(true);
        lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonopoly.setFont(new Font("Arial", Font.PLAIN, 40));
        lblMonopoly.setBounds(179, 277, 263, 55);
        this.add(lblMonopoly);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    }
