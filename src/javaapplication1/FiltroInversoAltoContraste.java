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

/**
 *
 * @author fermat
 */
public class FiltroInversoAltoContraste {
    //Imagen actual que se ha cargado
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
     
      public BufferedImage Inverso(){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB,rojoRGB,verdeRGB,azulRGB;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                rojoRGB = (int)(colorAux.getRed()*255);
                verdeRGB =(int)(colorAux.getGreen()*255);
                azulRGB =(int)(colorAux.getBlue()*255);
                
                if( ((rojoRGB + verdeRGB + azulRGB)/3) < 127 ){
                    mediaPixel=255;
                    colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                    imageActual.setRGB(i, j,colorSRGB);
                }else{
                    mediaPixel=0;
                    colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                    imageActual.setRGB(i, j,colorSRGB);
                    }
    
            }
        }
      return imageActual;
    }
      
      
      
      
      
      public BufferedImage AltoContraste(){
          
          
          
          
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB,rojoRGB,verdeRGB,azulRGB;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                rojoRGB = (int)(colorAux.getRed()*255);
                verdeRGB =(int)(colorAux.getGreen()*255);
                azulRGB =(int)(colorAux.getBlue()*255);
                
                if( ((rojoRGB + verdeRGB + azulRGB)/3) > 127 ){
                    mediaPixel=255;
                    colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                    imageActual.setRGB(i, j,colorSRGB);
                }else{
                    mediaPixel=0;
                    colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                    imageActual.setRGB(i, j,colorSRGB);
                    }
    
            }
        }
      return imageActual;
    }
}
