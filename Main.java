package sistema.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String ARCHIVO_DATOS = "datos_estudiantes.dat";

        System.out.println("=== SISTEMA DE PERSISTENCIA DIGITAL DE OBJETOS V1.0 ===\n");

        List<Estudiante> registrosAcademicos = new ArrayList<>();

        registrosAcademicos.add(
                new Estudiante("S2101023", "Marco Mendoza", 9.5));

        registrosAcademicos.add(
                new Estudiante("S2101024", "Ana Mendoza", 9.8));

        registrosAcademicos.add(
                new Estudiante("S2101025", "Luis Mendoza", 8.9));

        System.out.println(
                "--- 1. Estado Inicial en la Memoria RAM Volátil ---");

        registrosAcademicos.forEach(System.out::println);

        System.out.println();

        System.out.println(
                "--- 2. Iniciando Flujo de Datos hacia Almacenamiento Secundario ---");

        GestorPersistencia.guardarObjetos(
                ARCHIVO_DATOS,
                registrosAcademicos);

        System.out.println();

        registrosAcademicos = null;

        System.out.println(
                "--- 3. Simulación de Apagado: Datos de la RAM eliminados (Lista = null) ---\n");

        System.out.println(
                "--- 4. Leyendo Flujo de Entrada desde el Archivo Binario ---");

        List<Estudiante> datosRecuperados =
                GestorPersistencia.recuperarObjetos(ARCHIVO_DATOS);

        System.out.println();

        System.out.println(
                "--- 5. Datos Rehidratados Exitosamente en Memoria RAM ---");

        datosRecuperados.forEach(System.out::println);

        System.out.println(
                "\nConclusión: Los objetos sobrevivieron al ciclo de vida del programa.");
    }
}
