
import java.util.*;

public class ahorcado {

	//Intentos y max Intentos del jugador
	private static int intentos = 0;
	private static int maxIntentos = 6;
	private static Random random;
	private static Scanner sc;
	//Categoria de Palabras
	static int Seccion = 1;
	//Palabras para elegir
	static String [] palabrasFaciles = {"gato","perro","pera","libro"};
	static String [] palabrasIntermedias = {"cazador","ventilador","computadora","fresca","bebida"};
	static String [] palabrasDificiles = {"dimetilnitrosamina","homocedasticidad","fenilisopropilamina","electroencefalograma","neurofibromatosis"};
	//Manejador de dificultad
	static int dificultad = 1;
	//Palabra elegida del arreglo
	static String palabraElegida = "";
	//Palabra elegida ocultada
	static String palabraOcultada = "";
	//Letra introducida por jugador
	static char letra;
	//Seleccionador del menu
	static int seleccionadorMenu;
	
	static boolean jugando = false;
	
	public static void main(String[] args) 
	{
		
		random = new Random();
		sc = new Scanner(System.in);
		
		menu();
		
	}
	
	static void iniciar()
	{
		//Creando el juego
		elegirPalabra();
		mensajeInicial();
		ocultarPalabra();
		jugando = true;
	}
	
	static void menu()
	{
		System.out.println("Ahorcado v1.0");
		System.out.println("Eliga una opcion");
		
		System.out.println("1) Jugar");
		System.out.println("2) Cambiar Dificultad");
		System.out.println("3) Contactar al devs");
		System.out.println("4) Salir");
		
		seleccionadorMenu = sc.nextInt();
		
		switch(seleccionadorMenu)
		{
		case 1:
			jugar();
			break;
		case 2:
			cambiarDificultad();
			break;
		case 3:
			System.out.println("///////////");
			System.out.println("Nombre: Miguel Sabillon (AKA Mike Sabillon)");
			System.out.println("Email: mikesabillon2014@gmail.com");
			System.out.println("Nombre: Jimmy Dunaway ");
			System.out.println("Email: jdunaway@unitec.edu");
			System.out.println("Nombre: Kevin Inestroza");
			System.out.println("Email: kevininestroza@unitec.edu");
			System.out.println("///////////");
			menu();
			break;
		case 4:
			System.out.println("///////////");
			System.out.println("Saliendo del juego!");
			System.out.println("///////////");
			break;
		default:
			System.out.println("Debe elegir una opcion del menu!");
			menu();
			break;
		}
	}
	
	static void jugar()
	{
		iniciar();
		while(jugando)
		{
			System.out.println("Introduzca una letra");
			letra = sc.next().charAt(0);
			buscarLetra(letra);
			statusJugador();
		}
	}
	
	//Cambiar dificultad del juego
	static void cambiarDificultad()
	{
		System.out.println("///////////");
		System.out.println("Dificultad seleccionada: "+dificultadSeleccionada(dificultad));
		System.out.println("Eliga la dificultad");
		System.out.println("///////////");
		
		System.out.println("1) Facil");
		System.out.println("2) Intermedio");
		System.out.println("3) Dificil");
		
		dificultad = sc.nextInt();
		
		System.out.println("///////////");
		System.out.println("La dificultad ha sido cambiada a: "+ dificultadSeleccionada(dificultad));
		System.out.println("///////////");
		menu();
	}
	
	//Devolver en string dificultad
	static String dificultadSeleccionada(int a)
	{
		if(a == 1)
		{
			return "Facil";
		}
		else if(a == 2)
		{
			return "Intermedio";
		}
		else
		{
			return "Dificil";
		}
	}
	
	//Sacar palabra aleatoria del arreglo
	static void elegirPalabra()
	{
		switch(dificultad)
		{
		case 1:
			palabraElegida = palabrasFaciles[random.nextInt(palabrasFaciles.length)];
			break;
		case 2:
			palabraElegida = palabrasIntermedias[random.nextInt(palabrasIntermedias.length)];
			break;
		case 3:
			palabraElegida = palabrasDificiles[random.nextInt(palabrasDificiles.length)];
			break;
		}
		
	}
	
	//Ocultar palabra elegida para el juego
	static void ocultarPalabra()
	{
		for(int x = 0; x < palabraElegida.length(); x++)
		{
			palabraOcultada += "_";	
		}
		System.out.println(palabraOcultada);
	}
	
	//Mensaje inicial del juego
	static void mensajeInicial()
	{
		System.out.println("Su palabra contiene: "+ palabraElegida.length()+ " letras");
		System.out.println("Tiene de intentos: "+ maxIntentos);
	}
	
	//Chequear letra introducida
	static void buscarLetra(char letra)
	{
		//Guardando palabra oculatada para despues utilizarla
		String sol1 = palabraOcultada;
		palabraOcultada = "";
		
		for(int x = 0; x < palabraElegida.length(); x++)
		{
			if(letra == palabraElegida.charAt(x))
			{
				palabraOcultada += letra;
			}
			else
			{			
				palabraOcultada += sol1.charAt(x);
			}
		}
		
		//Agregar intento si letra no es correcta
		if(sol1.compareTo(palabraOcultada) == 0)
		{
			intentos++;
		}
		
		System.out.println(palabraOcultada);
	}
	
	//Status del jugador
	static void statusJugador()
	{
		System.out.println("Intentos: "+intentos+"/"+maxIntentos);
		
		if(palabraOcultada.compareTo(palabraElegida) == 0)
		{
			System.out.println("///////////");
			System.out.println("HA GANADO!");
			System.out.println("///////////");
			jugando = false;
			menu();
		}
		else if(intentos >= maxIntentos)
		{
			System.out.println("///////////");
			System.out.println("HA PERDIDO!");
			System.out.println("///////////");
			jugando = false;
			menu();
		}
	}

}
