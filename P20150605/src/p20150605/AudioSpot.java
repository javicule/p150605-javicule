package p20150605;

import java.io.File;

/**
 * Representa anuncios publicitarios en la radio.
 * 
 * Además de almacenar datos sobre el anuncio y su audio, permite poner el anuncio sobre una secuencia de clips y
 * exportarlo todo en formato daf.
 * 
 * @author Francisco Javier Jiménez Paredes
 * @version 1.0.1
 */
public class AudioSpot
{
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * Contiene mensajes de error diferentes, que se corresponden con los valores devueltos por algunos métodos.
     * (-1) No se ha establecido duración alguna.
     * (-2) No se ha indicado el nombre del producto anunciado.
     * (-3) No se ha indicado el nombre de la empresa anunciante.
     * (-4) No se ha establecido el archivo de audio.
     */
    public String lasterrormsg;
    
    /**
     * Establece los valores iniciales de un anuncio vacío.
     */
    public AudioSpot ()
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
    
    /**
     * Establece la duración que tendrá el anuncio.
     * @param duracion Tiempo en segundos que durará el anuncio.
     * @throws IllegalArgumentException Cuando el tiempo del anuncio es mayor de 120 segundos. 
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
    
    /**
     * Vincula el archivo de audio al anuncio.
     * @param nombre_archivo Ruta absoluta o relativa al fichero de audio.
     * @return True, si el archivo existe, false si no existe.
     */
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    
    /**
     * Coloca el anuncio en la cola de anuncios que aparecerá en la radio.
     * @param cola_reproduccion Cola de anuncios donde poner el nuevo anuncio.
     * @return Código que indica si todo ha salido bien o si ha habido algún problema, 0 - Éxito, -1 - Falta duración, -2 - Falta nombre del producto, -3 - Falta nombre de la empresa, -4 - Falta archivo de audio, -5 - Fallo al añadirlo a la cola.
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
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
        
        // si todo va bien, programamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
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
    
    /**
     * Convierte el anuncio y el audio a un archivo DAW.
     * @param objeto_daw Archivo DAW donde se exportará el anuncio.
     * @return Código que indica si todo ha salido bien o si ha habido algún problema, 0 - Éxito, -1 - Falta duración, -2 - Falta nombre del producto, -3 - Falta nombre de la empresa, -4 - Falta archivo de audio, -5 - Fallo al añadirlo a la cola.
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
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
