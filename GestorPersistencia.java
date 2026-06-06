package sistema.persistencia;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {

    public static void guardarObjetos(String archivo,
                                      List<Estudiante> registros) {

        try (ObjectOutputStream salida =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(archivo)))) {

            salida.writeObject(registros);

            System.out.println(
                    "-> Flujo de Salida exitoso: "
                            + registros.size()
                            + " objetos guardados en "
                            + archivo);

        } catch (IOException ex) {

            System.out.println(
                    "Error crítico en el flujo de salida: "
                            + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Estudiante> recuperarObjetos(String archivo) {

        List<Estudiante> estudiantes = new ArrayList<>();

        try (ObjectInputStream entrada =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(archivo)))) {

            estudiantes = (List<Estudiante>) entrada.readObject();

            System.out.println(
                    "-> Flujo de Entrada exitoso: Datos extraídos del archivo binario.");

        } catch (FileNotFoundException ex) {

            System.out.println(
                    "Aviso: El archivo no existe aún. Se creará una base de datos nueva.");

        } catch (IOException | ClassNotFoundException ex) {

            System.out.println(
                    "Error crítico en el flujo de entrada: "
                            + ex.getMessage());
        }

        return estudiantes;
    }
}
