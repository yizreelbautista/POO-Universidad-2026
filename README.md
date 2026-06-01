# Sistema de Nomina con Herencia en Java

## Descripcion
Proyecto que demuestra herencia de tres niveles:
Persona -> Empleado -> Gerente, mas una clase Main orquestadora.

## Estructura del Proyecto
- Persona.java   (Nivel 1)  -> Superclase base con datos civiles
- Empleado.java  (Nivel 2)  -> Hereda de Persona, agrega datos laborales
- Gerente.java   (Nivel 3)  -> Hereda de Empleado, agrega datos estrategicos
- Main.java      (Orquestador) -> Programa de prueba

## Explicacion tecnica de super.calcularSalarioNeto()
En la clase Gerente, el metodo calcularSalarioNeto() esta sobrescrito (@Override).
La instruccion:

    double salarioEmpleado = super.calcularSalarioNeto();

invoca la implementacion de la clase padre (Empleado), la cual aplica el 10%
de retencion sobre el salario base. De esta forma NO se duplica la formula:
se reutiliza la logica existente en Empleado y al resultado se le suma el
bonoEstrategico propio del Gerente.

Esto evidencia dos principios clave de la herencia:
1. Reutilizacion de codigo (no se reescribe la formula de retencion).
2. Enlace dinamico, ya que cada nivel complementa el comportamiento del padre.

## Compilacion y Ejecucion
javac *.java
java Main

## Output Esperado
===== EMPLEADO =====
Nombre: Ana Torres
Edad: 30 anios
ID Empleado: E-001
Salario Base: $20000.0
Salario Neto: $18000.0
Nomina Neta Estimada: $18000.0

===== GERENTE =====
Nombre: Luis Perez
Edad: 45 anios
ID Empleado: G-010
Salario Base: $40000.0
Salario Neto: $36000.0
Departamento: Operaciones
Bono Estrategico: $8000.0
Ingreso Neto Total: $44000.0
Nomina Neta Estimada: $44000.0
