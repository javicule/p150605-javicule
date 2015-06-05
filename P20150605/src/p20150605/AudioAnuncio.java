package p20150605;

import java.io.File;
import java.util.Date;

/**
 * Representa anuncios publicitarios en la radio.
 * 
 * Además de almacenar datos sobre el anuncio y su audio, permite poner el anuncio sobre una secuencia de clips y
 * exportarlo todo en formato daf.
 * 
 * @author Francisco Javier Jiménez Paredes
 * @version 1.0.1
 */
public class AudioAnuncio extends AudioPista
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * Establece los valores iniciales de un anuncio vacío.
     */
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    
    /**
     * Establece los metadatos del anuncio.
     * @param producto Nombre que recibirá el producto en venta.
     * @param anunciante Nombre de la empresa o persona que vende el producto.
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    

    protected int ComprobarMetadatos(int resultado) {
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
    
    /**
     * Convierte el anuncio y el audio a un archivo DAW.
     * @param objeto_daw Archivo DAW donde se exportará el anuncio.
     * @return Código que indica si todo ha salido bien o si ha habido algún problema, 0 - Éxito, -1 - Falta duración, -2 - Falta nombre del producto, -3 - Falta nombre de la empresa, -4 - Falta archivo de audio, -5 - Fallo al añadirlo a la cola.
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        resultado = ComprobarMetadatos(resultado);
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
