/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author fermat
 */
public class FiltroBrillo {
    
     private BufferedImage imageActual;
     
    //Método que devuelve una imagen abierta desde archivo
    //Retorna un objeto BufferedImagen
    public void abrirImagen(File file){
        //Creamos la variable que será devuelta (la creamos como null)
        BufferedImage bmp=null;
        try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=file;
                //Asignamos a la variable bmp la imagen leida
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                  
        
        //Asignamos la imagen cargada a la propiedad imageActual
        imageActual=bmp;
        //Retornamos el valor
       
    }
     
      public BufferedImage Brillo(int brillo){
        //Variables que almacenarán los píxeles
        
        
        int colorSRGB,red,green,blue,rojoRGB,verdeRGB,azulRGB;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                rojoRGB = (int)(colorAux.getRed());
                verdeRGB =(int)(colorAux.getGreen());
                azulRGB =(int)(colorAux.getBlue());
                //Brillo = color + constanteBrillo.
                
                
                 red = rojoRGB+brillo;
                green = verdeRGB+brillo;
                blue = azulRGB+brillo;
                
                
                red = Math.min(Math.max(red, 0), 255);
                green = Math.min(Math.max(green, 0), 255);
                blue = Math.min(Math.max(blue, 0), 255); 
                
                
                colorSRGB=(red << 16) | (green << 8) | blue;
                    imageActual.setRGB(i, j,colorSRGB);
          
    
            }
        }
      return imageActual;
    }
      
      
      
}
