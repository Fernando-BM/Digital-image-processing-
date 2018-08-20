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
public class FiltroGrises {
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
     
    
     public BufferedImage GrisPromedio(){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imageActual.setRGB(i, j,colorSRGB);
            }
        }
        //Retornamos la imagen
        return imageActual;
    }
    

     
     
    public BufferedImage grisValor(){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                 mediaPixel=(int)((colorAux.getRed()*.3)+(colorAux.getGreen()*.59)+(colorAux.getBlue()*.11));
                //Cambiamos a formato sRGB
                colorSRGB=mediaPixel << 16 | mediaPixel << 8 | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imageActual.setRGB(i, j,colorSRGB);
            }
        }   
        //Retornamos la imagen
        return imageActual;
    } 
     
    
      
    public BufferedImage grisDeSaturacion(){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, r,g,b;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                 r=colorAux.getRed();
                 g=colorAux.getGreen();
                 b=colorAux.getBlue();
                         
                mediaPixel=(int)((Math.max(Math.max(r, g),b)+Math.min(Math.min(r, g),b))/2);
                //Cambiamos a formato sRGB
                colorSRGB=mediaPixel << 16 | mediaPixel << 8 | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imageActual.setRGB(i, j,colorSRGB);
            }
        }   
        //Retornamos la imagen
        return imageActual;
    } 
    
    
    
    
    
    public BufferedImage grisDescomposicion(boolean max){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, r,g,b;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                 r=colorAux.getRed();
                 g=colorAux.getGreen();
                 b=colorAux.getBlue();
                         //Aquí toma el más grande de todos.
                if(max){
                    mediaPixel = Math.max(Math.max(r, g),b);
                }else{
                    mediaPixel = Math.min(Math.min(r, g),b);
}
               
                //Cambiamos a formato sRGB
                colorSRGB=mediaPixel << 16 | mediaPixel << 8 | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imageActual.setRGB(i, j,colorSRGB);
            }
        }   
        //Retornamos la imagen
        return imageActual;
    } 

    
    
    public BufferedImage grisPorColor(int numColor){
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB, r,g,b;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                 r=colorAux.getRed();
                 g=colorAux.getGreen();
                 b=colorAux.getBlue();
                         //Aquí toma el más grande de todos.
                 if(numColor == 0){
                    mediaPixel = r;
                }else if(numColor == 2){
                    mediaPixel= g;
                }else{
                    mediaPixel = b;
}
               
                //Cambiamos a formato sRGB
                colorSRGB=mediaPixel << 16 | mediaPixel << 8 | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                imageActual.setRGB(i, j,colorSRGB);
            }
        }   
        //Retornamos la imagen
        return imageActual;
    } 
    
    
}
