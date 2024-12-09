import java.util.Scanner;
import java.util.Random;

// TRABAJO HECHO POR LAURA DANIELA VELASQUEZ MARIN Y WILLIAM FABIAN PARRA

public class SimuladorViajeInterplanetario {

    // Constantes
    private static final String[] PLANETAS = {"Marte", "Jupiter", "Saturno"};
    private static final int[] DISTANCIAS = {225, 778, 1430};
    private static final String[] DESCRIPCIONES_PLANETAS = {
        "El Planeta Rojo y vecino curioso de la Tierra. Es frio, polvoriento. Si te gustan las aventuras extremas y los atardeceres rojos, Marte te espera.",
        "El rey del sistema solar con una gran mancha roja que es una tormenta gigante. Es tan grande que podrias meter 1,300 Tierras dentro",
        "El elegante del sistema solar con sus espectaculares anillos de hielo y roca. Es el planeta que usa joyeria como ningun otro. Si te gustan los accesorios extravagantes, Saturno es tu eleccion"
    };

    private static final String[] NAVES = {"Halcon Milenario", "SpaceX Dragon", "Apollo 11"};
    private static final String[] DESCRIPCIONES_NAVES = {
        "La chatarra mas rapida de la galaxia. Parece un monton de piezas viejas pegadas con cinta. Ideal para contrabandistas con suerte",
        "El Tesla del espacio, elegante y tecnologico. Viaja al espacio con estilo.",
        "El abuelo aventurero de las naves espaciales. Viejo y sin muchas comodidades. Fue el primero en llevar humanos a la Luna."
    };

    private static final int[] CAPACIDADES_NAVES = {50, 60, 40};
    private static final int[] VELOCIDADES_NAVES = {68000, 28000, 39000}; 
    private static final int[] COMBUSTIBLES_NAVES = {43000, 65000, 55000}; 
    private static final int[] OXIGENOS_NAVES = {14000, 30000, 25000};  

    private static String naveSeleccionada;
    private static int velocidadSeleccionada;
    private static int distanciaSeleccionada;
    private static int pasajeros;
    private static int combustibleRestante;
    private static int oxigenoRestante;

    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== BIENVENIDOS A LAU & WILL INTERGALACTICS ===");
            System.out.println("1. Seleccionar un planeta de destino");
            System.out.println("2. Seleccionar una nave espacial");
            System.out.println("3. Iniciar la simulacion del viaje");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> seleccionarPlaneta();
                case 2 -> seleccionarNave();
                case 3 -> iniciarSimulacion();
                case 4 -> System.out.println("Gracias por usar el simulador. Hasta pronto.");
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    public static void seleccionarPlaneta() {
        System.out.println("\n=== SELECCIONAR PLANETA ===");
        for (int i = 0; i < PLANETAS.length; i++) {
            System.out.printf("%d. %s - Distancia: %d millones de km\n", i + 1, PLANETAS[i], DISTANCIAS[i]);
            System.out.println("   Descripcion: " + DESCRIPCIONES_PLANETAS[i]);
        }
        System.out.print("Seleccione un planeta: ");
        int opcionPlaneta = sc.nextInt() - 1;

        if (opcionPlaneta >= 0 && opcionPlaneta < PLANETAS.length) {
            System.out.printf("Has seleccionado %s.\n", PLANETAS[opcionPlaneta]);
            distanciaSeleccionada = DISTANCIAS[opcionPlaneta];
        } else {
            System.out.println("Seleccion invalida.");
        }
    }

    public static void seleccionarNave() {
        System.out.println("\n=== SELECCIONAR NAVE ESPACIAL ===");
        for (int i = 0; i < NAVES.length; i++) {
            System.out.printf("%d. %s\n", i + 1, NAVES[i]);
            System.out.println("   Descripcion: " + DESCRIPCIONES_NAVES[i]);
            System.out.printf("   Capacidad de Pasajeros: %d\n", CAPACIDADES_NAVES[i]);
            System.out.printf("   Velocidad Maxima: %d km/h\n", VELOCIDADES_NAVES[i]);
            System.out.printf("   Combustible Total: %d litros\n", COMBUSTIBLES_NAVES[i]);
            System.out.printf("   Oxigeno Total: %d kg\n\n", OXIGENOS_NAVES[i]);
        }
        System.out.print("Seleccione una nave: ");
        int opcionNave = sc.nextInt() - 1;

        if (opcionNave >= 0 && opcionNave < NAVES.length) {
            naveSeleccionada = NAVES[opcionNave];
            velocidadSeleccionada = VELOCIDADES_NAVES[opcionNave];
            combustibleRestante = COMBUSTIBLES_NAVES[opcionNave];
            oxigenoRestante = OXIGENOS_NAVES[opcionNave];
            System.out.printf("Has seleccionado %s.\n", naveSeleccionada);

            System.out.print("Ingrese la cantidad de pasajeros: ");
            pasajeros = sc.nextInt();
            while (pasajeros <= 0) {
                System.out.println("Numero invalido. Ingrese un numero positivo.");
                pasajeros = sc.nextInt();
            }
        } else {
            System.out.println("Seleccion invalida.");
        }
    }

    public static void iniciarSimulacion() {
        if (naveSeleccionada == null || distanciaSeleccionada == 0) {
            System.out.println("Primero debe seleccionar un planeta y una nave.");
            return;
        }

        double duracionViaje = (distanciaSeleccionada * 1_000_000) / (velocidadSeleccionada * 24); // TEST
        System.out.printf("\nDuracion estimada del viaje: %.2f dias.%n", duracionViaje);

        System.out.println("\n=== INICIANDO SIMULACION DE VIAJE ===");
        System.out.println("Inicio del viaje: Motores encendidos, cinturones abrochados... Adios Tierra");

        for (int i = 0; i <= 100; i += 25) {
            System.out.printf("Progreso del viaje: %d%% completado.\n", i);

            if (i == 50) {
                System.out.println("Mitad del camino: Mitad del viaje completado, aun no hay rastros de alienigenas...");
            }

            if (i == 75 || i == 50) {
                if (ocurreEventoAleatorio()) {
                    manejarEventoAleatorio();
                }
            }
            esperar(1000); 
        }
        System.out.println("Llegada al destino: Mision cumplida, aterrizamos con estilo...");
    }

    public static boolean ocurreEventoAleatorio() {
        return random.nextInt(100) < 60;
    }

    public static void manejarEventoAleatorio() {
        int evento = random.nextInt(3);

        switch (evento) {
            case 0 -> {
                System.out.println("ATENCION: Encuentro con aliens curiosos. Que deseas hacer:");
                System.out.println("1. Ignorarlos y continuar el viaje.");
                System.out.println("2. Intercambiar memes y obtener frutas intergalacticas.");
                int opcion = sc.nextInt();
                System.out.println(opcion == 2 ? "Has obtenido frutas intergalacticas" : "Has continuado tu viaje.");
            }
            case 1 -> {
                System.out.println("ATENCION: Lluvia de meteoritos. La nave ha sufrido fallas tecnicas.");
                System.out.println("1. Volver a la Tierra.");
                System.out.println("2. Reparar la nave y continuar.");
                int opcion = sc.nextInt();
                if (opcion == 1) {
                    System.out.println("Regresando a la Tierra... Viaje finalizado.");
                    System.exit(0);
                }
            }
            case 2 -> {
                System.out.println("ATENCION: Interferencia de radiacion cosmica.");
                System.out.println("1. Volver a la Tierra.");
                System.out.println("2. Continuar y esperar la reparacion automatica.");
                int opcion = sc.nextInt();
                if (opcion == 1) {
                    System.out.println("Regresando a la Tierra... Viaje finalizado.");
                    System.exit(0);
                }
            }
        }
    }

    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Error en la simulacion.");
        }
    }
}
