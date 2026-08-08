# RPG Battle Engine - Java

¡Bienvenido al código fuente de mi motor de combate RPG por turnos! Este proyecto es un videojuego de consola desarrollado en **Java**, diseñado para practicar y aplicar conceptos avanzados de Programación Orientada a Objetos (POO) y diseño de software.

## Resumen del Proyecto
El objetivo principal de este proyecto es construir un "Core" o núcleo de videojuego sólido y escalable antes de implementar interfaces gráficas. Cuenta con un sistema de personajes dinámico, gestión profunda de estadísticas y un inventario de objetos modulares.

## Características Principales (Features)

*   **Sistema de Clases Heredadas:** Los jugadores pueden elegir entre diferentes arquetipos (ej. `Guerrero`, `Mago`), cada uno con sus propias estadísticas base, defensas físicas/mágicas y tipos de daño.
*   **Gestión de Recursos Híbrida:** Implementación de un sistema de desgaste donde los ataques consumen **Maná** (para ataques mágicos) o **Energía** (para ataques físicos), permitiendo también crear ataques mixtos.
*   **Inventario y Objetos Modulares:** Sistema de pociones inteligente utilizando el principio de diseño *"Tell, Don't Ask"*. Las pociones gestionan su propia lógica de curación (Vida, Maná, Energía) sin sobrepasar los límites máximos del personaje.
*   **Menú Dinámico:** Interfaz de usuario por consola separada de la lógica principal (Principio de Responsabilidad Única) para la selección y creación de personajes.

## 🛠️ Tecnologías y Conceptos Aplicados

*   **Lenguaje:** Java
*   **Paradigmas y Patrones:**
    *   Programación Orientada a Objetos (POO).
    *   Herencia y Polimorfismo.
    *   Composición (Los personajes "tienen" listas de ataques y objetos).
    *   Encapsulamiento estricto (`private`, *getters* y *setters*).
    *   Clean Code (Delegación de responsabilidades y modularidad).

## Estructura del Proyecto

El código está dividido en paquetes lógicos para mantener una arquitectura limpia:

*   `Motor/`: Contiene la lógica del juego, el bucle de combate (`Pelear`) y las interfaces de usuario por consola (`MenuSeleccion`).
*   `Personajes/`: Contiene la clase plantilla `BaseDePersonaje`, los arquetipos (`Mago`, `Guerrero`) y la clase constructora de habilidades (`Ataque`).
*   `Objetos/`: Contiene los ítems interactivos del juego, como la clase `Pocion`.
