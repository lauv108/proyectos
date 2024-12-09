Simulador de Viaje Interplanetario
Proyecto en Java que simula un viaje interplanetario, permitiendo al usuario seleccionar planetas, naves espaciales y enfrentarse a eventos aleatorios durante el trayecto. El sistema calcula la duración del viaje, controla recursos y proporciona una experiencia interactiva desde la consola.

Características Principales:
1. Selección de Planeta de Destino: El usuario puede elegir entre Marte, Jupiter y Saturno. Se muestran descripciones detalladas y distancias en millones de km desde la Tierra.

2. Selección de Nave Espacial: El usuario selecciona una nave con diferentes capacidades:
Halcón Milenario: Capacidad: 50 pasajeros, Velocidad Máxima: 68,000 km/h.
SpaceX Dragon: Capacidad: 60 pasajeros, Velocidad Máxima: 28,000 km/h.
Apollo 11: Capacidad: 40 pasajeros, Velocidad Máxima: 39,000 km/h.

3. Gestión de Recursos:
Combustible Total: Calculado según la distancia.
Oxígeno Disponible: Monitoreado durante el viaje.

4. Simulación del Viaje:
El viaje simula el progreso en intervalos del 25% usando un bucle for.
Mensajes Dinámicos: Etapas del viaje impresas en consola.

5. Eventos Aleatorios:
Probabilidad del 60% de que ocurra un evento durante el viaje:
Aliens Curiosos: Intercambiar memes terrícolas por combustible.
Lluvia de Meteoritos: Reparar la nave o volver a la Tierra.
Antena Descompuesta: Esperar 5 horas o continuar el viaje.

REQUISITOS DEL SISTEMA: 
Java Development Kit (JDK) 8 o superior.
Visual Studio Code (opcional, cualquier IDE compatible con Java).
Git para control de versiones y subir el proyecto a GitHub.

Instalación y Uso
1. Clonar el Repositorio: https://github.com/lauv108/proyectos.git

2. Abrir el Proyecto: Abre el proyecto en Visual Studio Code o tu IDE de preferencia.

3. Compilar el Proyecto: Copiar y pegar javac SimuladorViajeInterplanetario.java

4. Ejecutar el Programa: Copiar y pegar java SimuladorViajeInterplanetario

   
Estructura del Proyecto

/SimuladorViajeInterplanetario
|── SimuladorViajeInterplanetario.java  // Código fuente principal
|── README.md                            // Documento del proyecto
|── .gitignore                           // Archivos ignorados por Git

Funcionalidades Futuras
Planetas: Añadir más planetas con descripciones y distancias desde la tierra. 
Más Eventos: Simulación de recursos adicionales.
Registro de Viajes: Almacenar viajes en un archivo de registro.


Autores
Laura Daniela Velasquez Marin y William Fabian Parra. Desarrolladores principales y creadores del proyecto.
