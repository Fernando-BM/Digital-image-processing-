package javaapplication1;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FiltroMosaico {
    
     private BufferedImage imageActual;
     
    //Método que devuelve una imagen abierta desde archivo
    //Retorna un objeto BufferedImagen
    public BufferedImage abrirImagen(File file){
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
        return bmp;
       
    }

        public BufferedImage mosaico(BufferedImage imagen, int b, int h) {

                final int X = imagen.getWidth();
                final int Y = imagen.getHeight();

                BufferedImage nueva_Imagen = new BufferedImage(X, Y, BufferedImage.TYPE_INT_RGB);

                int t=(X / b) + ((X % b == 0) ? 0 : 1);
                int r=(Y / h) + ((Y % h == 0) ? 0 : 1);

                int area=b * h;
                int area_YReducida=b * (Y % h);
                int area_XReducida=h * (X % b);
                int area_XYReducida=(X % b) * (Y % h);

                int [][] rojos=new int[t][r];
                int [][] verdes=new int[t][r];
                int [][] azules=new int[t][r];

                int rgb_Pixel;

                for(int i=0, o=0; i<X; i++) {
                        if(i % b == 0 && i>0) { o++; }

                        for(int j=0, p=0; j<Y; j++) {

                                if (j % h == 0 && j>0) { p++; }
                                rgb_Pixel = imagen.getRGB(i, j);

                                rojos[o][p] = rojos[o][p] + ((rgb_Pixel >> 16) & 0xFF);
                                verdes[o][p] = verdes[o][p] + ((rgb_Pixel >> 8) & 0xFF);
                                azules[o][p] = azules[o][p] + (rgb_Pixel & 0xFF);

                                if (i % b == b-1 && j % h == h-1) {
                                        rojos[o][p] = rojos[o][p] / area;
                                        verdes[o][p] = verdes[o][p] / area;
                                        azules[o][p] = azules[o][p] / area;
                                } else if (i % b == b-1 && j == Y-1) {
                                        rojos[o][p] = rojos[o][p] / area_YReducida;
                                        verdes[o][p] = verdes[o][p] / area_YReducida;
                                        azules[o][p] = azules[o][p] / area_YReducida;
                                } else if (j % h == h-1 && i == X-1) {
                                        rojos[o][p] = rojos[o][p] / area_XReducida;
                                        verdes[o][p] = verdes[o][p] / area_XReducida;
                                        azules[o][p] = azules[o][p] / area_XReducida;
                                } else if (i == X-1 && j == Y-1) {
                                        rojos[o][p] = rojos[o][p] / area_XYReducida;
                                        verdes[o][p] = verdes[o][p] / area_XYReducida;
                                        azules[o][p] = azules[o][p] / area_XYReducida;
                                }
                        }
                }

                for(int i=0, o=0; i < X; i++){
                        if (i % b == 0 && i>0) o++;
                        for(int j=0, p=0; j<Y; j++) {
                                if(j % h == 0 && j>0) p++;
                                nueva_Imagen.setRGB(i, j, (rojos[o][p] << 16) | (verdes[o][p] << 8) | azules[o][p]);
                        }
                }

                try {
                        ImageIO.write(nueva_Imagen, "BMP", new File("mosaico.bmp"));
                } catch (IOException ie) {
                        System.err.println("I/O Error");
                        ie.printStackTrace(System.err);
                }
                return nueva_Imagen;
        }

       
}