import javax.swing.JOptionPane;

/*
 * Haga un algoritmo que solicite el nombre y edad de n estudiantes y realice lo siguiente:
*Imprima la lista de estudiantes con su edad
*Indique el promedio de edades de estudiantes
*Indique cual o cuales son los estudiantes de mayor edad de todo el grupo
*Indique cual o cuales son los estudiantes de menor edad de todo el grupo
*Indique cuantos estudiantes son mayores de edad, siendo mayor con una edad igual o superior a 18 años
*Permita realizar la busqueda por nombre, indicando cuales el estudiante encontrado y cual es su edad.
*Permita realizar la busqueda por edades, indicando todos estudiantes con la edad ingresada
 */

public class Procesos {

	String menu = "";
	String nombresEstudiantes[];
	int edades[];
	int estudiantes =0;

	public void iniciar() {
		obtenerMenu();
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarOpcion(opcion);
		} while (opcion != 9);
		
		

	}

	private void obtenerMenu() {
		menu += "-------¡Bienvenido al menu!------- \n\n";
		menu += "Seleccione un opción\n";
		menu += "1- Registrar nombre y edad de los estudiantes\n";
		menu += "2- Imprimir lista de estudiantes con su edad\n";
		menu += "3- Imprimir promedio de edad de los estudiantes\n";
		menu += "4- Imprimir cuales estudiantes son mayores de edad del grupo\n";
		menu += "5- Imprimir cuales estudiantes son menores de edad del grupo\n";
		menu += "6- Imprimir cuales estudiantes son mayores de edad\n";
		menu += "7- Busqueda de nombre y edad de un estudiande ingresado\n";
		menu += "8- Busqueda de estudiantes por un edad ingresada\n";
		menu += "9- Salir\n";
	}

	private void validarOpcion(int opcion) {
		switch (opcion) {
		
		case 1:
			System.out.println("Registrar nombre y edad de los estudiantes");
			registrarEstudiantes();
			
			break;
		case 2:
			System.out.println("Imprimir lista de estudiantes con su edad");
			
			if (nombresEstudiantes != null && edades != null) {
				imprimirInformacion();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			
			break;
		case 3:
			System.out.println("Imprimir promedio de edad de los estudiantes");
	
			if (nombresEstudiantes != null && edades != null) {
				calcularPromedio();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			
			break;
		case 4:
			System.out.println("Imprimir cuales estudiantes son mayores de edad del grupo");
			
			if (nombresEstudiantes != null && edades != null) {
				validarMayoresEdad();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			
			break;
		case 5:
			System.out.println("Imprimir cuales estudiantes son menores de edad del grupo");
			
			if (nombresEstudiantes != null && edades != null) {
				validarMenoresEdad();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			
			break;
		case 6:
			System.out.println("Imprimir cuales estudiantes son mayores de edad");
			
			if (nombresEstudiantes != null && edades != null) {
				cantidadMayoresEdad();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			
			break;
		case 7:
			System.out.println("Busqueda de nombre y edad de un estudiande ingresado");

			if (nombresEstudiantes != null && edades != null) {
				buscarPorNombre();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			
			break;
		case 8:
			System.out.println("Busqueda de estudiantes por un edad ingresada");
	
			if (nombresEstudiantes != null && edades != null) {
				buscarPorEdad();
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos ingresados");
			}
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "¡Gracias por usar el programa!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "El codigo ingresado no existe");
			break;
		}
		
	}
	
	private void registrarEstudiantes() {
		
		do {
			estudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
		} while (estudiantes < 0);
		
		nombresEstudiantes = new String[estudiantes];
		edades = new int [estudiantes];
		
		for (int i = 0; i < estudiantes; i++) {
			nombresEstudiantes[i] = JOptionPane.showInputDialog("Ingrese el nombre del estudiante #"+(i+1));
			edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante #"+(i+1))); 
		}
		
	}
	
	private void imprimirInformacion () {
		for (int i = 0; i < estudiantes; i++) {
			JOptionPane.showMessageDialog(null, "El dato en posición #"+i+"\n"+"El nombre es: "+nombresEstudiantes[i]+"\n"+"La edad del estudiante es: "+edades[i]);
		}
	}
	
	private void calcularPromedio () {
		int suma =0;
		int promedio =0;
		
		for (int i = 0; i < edades.length; i++) {
		suma += edades[i];
		}
		promedio = suma/estudiantes;
		JOptionPane.showMessageDialog(null, "El promedio de edad de los estudiantes es: " + promedio);
	}
	
	
	private void validarMayoresEdad() {
		boolean hayMayores = false;
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] >= 18) {
				JOptionPane.showMessageDialog(null, "Los mayores de edad son: "+nombresEstudiantes[i]+"\n"+"Cuya edad del estudiante es: "+edades[i]);
				hayMayores = true;
			}
 		}
		
		if (hayMayores == false) {
			JOptionPane.showMessageDialog(null, "No existen estudiantes mayores de edad");
		}
		
	}
	
	private void validarMenoresEdad() {
		boolean hayMenores = false;
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] < 18) {
				JOptionPane.showMessageDialog(null, "Los menores de edad son: "+nombresEstudiantes[i]+"\n"+"Cuya edad del estudiante es: "+edades[i]);
				hayMenores = true;
			}
 		}
		if (hayMenores == false) {
			JOptionPane.showMessageDialog(null, "No existen estudiantes menores de edad");
		}
	}
	
	private void cantidadMayoresEdad() {
		int cantidad = 0;
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] >= 18) {
				cantidad++;
			}
 		}
		JOptionPane.showMessageDialog(null, "La cantidad de mayores de edad son: "+cantidad);
	}
	
	private void buscarPorNombre() {
		String nombre;
		int cantidadEncontrado = 0;
		nombre=JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		for (int i = 0; i < nombresEstudiantes.length; i++) {
			if (nombre.equalsIgnoreCase(nombresEstudiantes[i])) {
				JOptionPane.showMessageDialog(null, "El estudiante con nombre:"+nombre+"se encontro en la posicion: #"+nombresEstudiantes[i]);
				cantidadEncontrado++;
			} else {
				JOptionPane.showMessageDialog(null, "No existe el" +nombre+ "del estudiante ingresado");
			}
			
		}
		JOptionPane.showMessageDialog(null, "Se encontro el "+nombre+" con una cantidad de veses: "+cantidadEncontrado);
		
	}
	
	private void buscarPorEdad () {
		int edad =0;
		int cantidadEncontrado =0;
		edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad a buscar"));
		
		for (int i = 0; i < edades.length; i++) {
			
			if (edad == edades[i]) {
				JOptionPane.showMessageDialog(null, "Se encontro que el estudiante "+nombresEstudiantes[i]+"tiene una edad de "+edades[i]+"años");
				cantidadEncontrado++;
			} else {
				JOptionPane.showMessageDialog(null, "Se encontro estudiantes con "+edades[i]+" años");
			}
			
		}
		JOptionPane.showMessageDialog(null, "En total se encontraron "+ cantidadEncontrado +" estudiantes con edad de "+ edad + "años");
	}

}
