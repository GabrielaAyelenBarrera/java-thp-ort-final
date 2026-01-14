# Examen Final – Asociación Nacional de Fútbol (ANF) ⚽  
## Taller de Herramientas de Programación (THP) – ORT Argentina

Este repositorio contiene la resolución del **Examen Final** de la materia **Taller de Herramientas de Programación**, desarrollada en **Java**, aplicando los conceptos de **programación orientada a objetos**, encapsulamiento, uso de enumerados, colecciones y corrección/extensión de un sistema preexistente, respetando estrictamente el diseño provisto.

---

## 📄 Enunciado del ejercicio

La **Asociación Nacional de Fútbol (ANF)** administra una plataforma que permite gestionar partidos amistosos previos al próximo Mundial y una **plantilla de jugadores** registrados en el sistema.

Para cada partido, el sistema genera una **preselección de 23 jugadores**, respetando reglas específicas de cupos por posición, condición física mínima y obligatoriedad de contar con **3 arqueros** en cada convocatoria.

El objetivo del ejercicio es **corregir errores existentes, completar funcionalidades faltantes y extender el sistema** con nuevos mecanismos de análisis y reporte, sin modificar las reglas de selección ya implementadas.

---

## 🧩 Clases que componen el sistema

- **ANF**  
  Clase principal del sistema. Coordina la gestión de partidos, la plantilla de jugadores, la generación de preselecciones y los reportes solicitados.

- **Partido**  
  Representa un partido amistoso. Define las condiciones que deben cumplirse para la preselección, pero **no arma la preselección**.

- **Jugador**  
  Representa a un jugador registrado, identificado por nombre único, posición, condición física y estado de lesión.

- **Convocado**  
  Estructura auxiliar utilizada para registrar cuántas veces fue convocado un jugador.

- **Posicion (enum)**  
  Define las posiciones posibles: ARQUERO, DEFENSOR, MEDIOCAMPISTA, DELANTERO.

---

## 🛠️ Tareas realizadas sobre el proyecto base

La solución provista incluía errores de compilación y fallas de lógica que impedían su correcto funcionamiento.

### 🔧 Corrección de errores de compilación
- Se corrigieron los errores que impedían ejecutar el programa.

### 🐞 Corrección de bugs
- Se resolvió el `NullPointerException` al registrar el primer jugador.
- Se corrigió el loop que impedía mostrar correctamente el partido contra Inglaterra.
- Se ajustó la lógica de creación de partidos para que respete los valores recibidos en `gestionarPartido`, evitando que se asignen siempre los valores por defecto.

> Para la detección de errores se utilizó el **depurador** y la consola de **Eclipse**, analizando el flujo de ejecución del programa.

---

## ✨ Funcionalidades incorporadas

### 📌 Registro de convocatorias
- Se incorporó la clase **Convocado**, que asocia un jugador con la cantidad de convocatorias.
- El registro:
  - Se genera dinámicamente a partir de los partidos gestionados.
  - Incluye únicamente jugadores convocados al menos una vez.
  - No modifica la clase `Jugador` ni su información.
- El registro puede visualizarse por consola.

---

### 📊 Reporte de jugadores más convocados
- A partir del registro de convocatorias, se genera un reporte que:
  - Identifica la **cantidad máxima de convocatorias**.
  - Muestra todos los jugadores que alcanzan dicho máximo.
  - Informa nombre y condición física de cada jugador.
- El reporte:
  - No modifica la información del sistema.
  - Contempla el caso de registro vacío.
  - Permite empates entre varios jugadores.

Ejemplo de salida:
> Salida obtenida a partir de la ejecución de la clase Test, sin lógica de negocio.


Partido [fecha=20250101, rival=Brasil, condicionMinima=70, cantDefensa=8, cantMediocampo=8, cantDelantera=4]
Partido [fecha=20250201, rival=Argelia, condicionMinima=70, cantDefensa=8, cantMediocampo=8, cantDelantera=4]
Partido [fecha=20250301, rival=Inglaterra, condicionMinima=70, cantDefensa=8, cantMediocampo=8, cantDelantera=4]

=========================== JUGADORES MAS CONVOCADOS ===========================
Cantidad máxima de convocatorias: 3
Jugadores:

ARQUERO 1 | Condición física: 90

ARQUERO 2 | Condición física: 90

ARQUERO 3 | Condición física: 90

DEFENSOR 1 | Condición física: 90

DEFENSOR 2 | Condición física: 90

DEFENSOR 3 | Condición física: 90

DEFENSOR 4 | Condición física: 90

DEFENSOR 5 | Condición física: 90

DEFENSOR 6 | Condición física: 90

DEFENSOR 7 | Condición física: 90

DEFENSOR 8 | Condición física: 90

MEDIOCAMPISTA 1 | Condición física: 90

MEDIOCAMPISTA 2 | Condición física: 90

MEDIOCAMPISTA 3 | Condición física: 90

MEDIOCAMPISTA 4 | Condición física: 90

MEDIOCAMPISTA 5 | Condición física: 90

MEDIOCAMPISTA 6 | Condición física: 90

MEDIOCAMPISTA 7 | Condición física: 90

MEDIOCAMPISTA 8 | Condición física: 90

DELANTERO 1 | Condición física: 90

DELANTERO 2 | Condición física: 90

DELANTERO 3 | Condición física: 90

DELANTERO 4 | Condición física: 90

---

## 🧪 Pruebas realizadas

Se actualizó la clase **Test** respetando las restricciones indicadas:

- La clase Test no contiene lógica de negocio.
- Solo invoca métodos públicos de la clase ANF.

Casos probados:
- Registro de convocatorias vacío.
- Jugadores convocados una o varias veces.
- Jugadores no convocados que no aparecen en el registro.
- Reporte sin convocados.
- Reporte con un único jugador más convocado.
- Reporte con múltiples jugadores empatados en el máximo.

Todos los mensajes por consola indican claramente:
- El caso evaluado.
- El resultado esperado.
- La información solicitada de forma ordenada y legible.

---

## 💻 Implementación en Java

La solución fue desarrollada respetando:

- Encapsulamiento y ocultamiento de información.
- Correcta asignación de responsabilidades entre clases.
- Uso adecuado de enumerados y colecciones.
- Separación clara entre lógica de negocio y pruebas.
- Buenas prácticas de diseño enseñadas durante la cursada.

---

## 🧩 Diagrama UML

El diseño del sistema se basa en el **diagrama UML provisto**, el cual fue respetado durante toda la implementación.
<img width="660" height="450" alt="image" src="https://github.com/user-attachments/assets/8df21454-a386-4386-a7f3-7491624627bc" />

---

## 👩‍💻 Autora

**Gabriela Ayelén Barrera**  
Estudiante de Analista de Sistemas – ORT Argentina
