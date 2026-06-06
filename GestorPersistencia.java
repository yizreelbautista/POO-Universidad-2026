package sistema.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {

    public static void guardarObjetos(String rutaArchivo, List<Estudiante> estudiantes) {

        try (FileOutputStream fos = new FileOutputStream(rutaArchivo);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) { 
            
            oos.writeObject(estudiantes); 
            System.out.println("-> Flujo de Salida exitoso: " + estudiantes.size() + " objetos guardados en " + rutaArchivo);
            
        } catch (IOException e) {
            System.out.println("Error crítico en el flujo de salida: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    public static List<Estudiante> recuperarObjetos(String rutaArchivo) {
        List<Estudiante> listaRecuperada = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             BufferedInputStream bis = new BufferedInputStream(fis); // Búfer de lectura
             ObjectInputStream ois = new ObjectInputStream(bis)) {   // Reconstructor de objetos
            
            // Rehidratación del objeto en memoria RAM
            listaRecuperada = (List<Estudiante>) ois.readObject();
            System.out.println("-> Flujo de Entrada exitoso: Datos extraídos del archivo binario.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Aviso: El archivo no existe aún. Se creará una base de datos nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error crítico en el flujo de entrada: " + e.getMessage());
        }
        
        return listaRecuperada;
    }
}

