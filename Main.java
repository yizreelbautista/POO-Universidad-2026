package sistema.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE PERSISTENCIA DIGITAL DE OBJETOS V1.0 ===\n");

        String nombreArchivo = "datos_estudiantes.dat";

        // 1. Creación e inserción inicial de datos en memoria RAM
        List<Estudiante> listaOriginal = new ArrayList<>();

        listaOriginal.add(new Estudiante("S2101023", "Marco Mendoza", 9.5));
        listaOriginal.add(new Estudiante("S2101024", "Ana Mendoza", 9.8));
        listaOriginal.add(new Estudiante("S2101025", "Luis Mendoza", 8.9));

        System.out.println("--- 1. Estado Inicial en la Memoria RAM Volátil ---");

        for (Estudiante e : listaOriginal) {
            System.out.println(e);
        }

        System.out.println();

        // 2. Proceso de serialización
        System.out.println("--- 2. Iniciando Flujo de Datos hacia Almacenamiento Secundario ---");
        GestorPersistencia.guardarObjetos(nombreArchivo, listaOriginal);

        System.out.println();

        // 3. Simulación de apagado del sistema
        listaOriginal = null;

        System.out.println("--- 3. Simulación de Apagado: Datos de la RAM eliminados (Lista = null) ---\n");

        // 4. Recuperación de los datos desde el archivo binario
        System.out.println("--- 4. Leyendo Flujo de Entrada desde el Archivo Binario ---");

        List<Estudiante> listaRestaurada =
                GestorPersistencia.recuperarObjetos(nombreArchivo);

        System.out.println();

        // 5. Verificación de la persistencia
        System.out.println("--- 5. Datos Rehidratados Exitosamente en Memoria RAM ---");

        for (Estudiante e : listaRestaurada) {
            System.out.println(e);
        }

        System.out.println("\nConclusión: Los objetos sobrevivieron al ciclo de vida del programa.");
    }
}