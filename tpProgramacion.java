package tpProgramacion;

import javax.swing.JOptionPane;

public class tpProgramacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * El juego tiene que tener los temas que vamos a ver en la cursada. Los temas
		 * son if, if anidados, for, while y arrays El tema es que no se puede usar
		 * programación orientada a objetos El tiempo depende de vos Cuando quieras dar
		 * el final el juego tiene que estar listo
		 */

		/*
		 * NOTAS
		 * 
		 * puedo setear un ARRAY de 10 como mapa determinado en cada espacio tiro un
		 * DadoGeneral, si el numero sale par sucede un evento si el numero sale impar
		 * se pasa al siguiente array. Si el evento sucede, se tira DadoEvento, el
		 * dadoEvento es random / 3 SI el resto de dadoEvento es 1 aparece un combate,
		 * SI el resto de dadoEvento es 2 aparece un buff, SI el resto de dadoEvento es
		 * 3 aparece una debuff SI el resto del dado es 4 tenes un bono de oro +30
		 * 
		 * Los buff son aumento de HP +10 aumento de daño +10 aumento de armadura +5
		 * 
		 * 
		 * Las penalizacion son disminucion de HP -10 disminucion de daño -10
		 * disminucion de armadura -5
		 * 
		 * se tira devuelta el dadoEvento
		 * 
		 * 
		 * combate los personajes estan preseteadoss con hp daño y armaduras, combate de
		 * desgaste heroe empieza con 100 de hp 25 de daño y 2 de armadura el enemigo
		 * 100hp 12 de daño 0 armadura tu daño - su armadura >>> hp tu armadura - su
		 * daño <<<< hp el primero que llega a 0 pierde
		 * 
		 * heroe atacar X 1.5 daño 1 X armor / atacar X 0.5 defender X2 armor / huir
		 * -10% hp
		 * 
		 * enemigo daño base / armadura base / no puede huir
		 * 
		 * 
		 * previo array 5 recompensa +hp +daño + armadura + 50 de oro
		 * 
		 * si pierdo GAME OVER
		 * 
		 * 
		 * PENSAR EN UN MODO DE COMBATE PASABLE PARA LLEGAR AL ARRAY 5
		 * 
		 * en el array numero 5 va a a estar la tienda +hp + daño + armadura
		 * 
		 * A PARTIR DE ACA SE COMPLICA EL COMBATE
		 * 
		 * en la casilla 10 esta el jefe
		 * 
		 * 
		 * PERSONAJE
		 * 
		 * array de 4 [HP/ DAÑO/ ARMADURA/ ORO]
		 * 
		 * 
		 * 
		 * ///////////////////////////////////
		 * 
		 * otra forma de combate puede ser usar un dadoHeroe y un dadoEnemigo y el
		 * numero mas alto gana con los enemigos basicos se tira 3 veces con el jefe se
		 * tira 5
		 * 
		 * 
		 */
		// variables globales
		int juego = 0; // variable que termina el juego
		int combate = 0; // variable que setea el combate
		int rondaCombate = 1; // variable que setea las rondas
		double dadoGeneral; // tiene 2 entradas par o impar (1 o 2)
		double dadoHeroe;
		double dadoEnemigo;
		double dadoRetirada;
		int contadorCombate = 0;
		int combateGanado = 0, combatePerdido = 0;
		double mundoArray[] = new double[5]; // mapa del juego
		int variableMundo; // variable del for
		int seleccionHeroe = 0;
		// LA VARIABLE JUEGO MIENTRAS SEA 0 SE PUEDE JUGAR CUANDO SE DERROTE AL BOSS VA
		// A CAMBIAR A 1 Y EL WHILE SE VA A CERRAR
		/*
		 * ******************************************** seleccion de personaje
		 * ?conveniente un ARRAY? *******************************************
		 */
		// falta variable heroes
		// array Xin
		// array rubick

		String inicioJuego, introGuerrero, introHechicero, mensajeCombate, decisionCombate;
		String seleccionPersonaje;

		inicioJuego = "Bienvenido al reino del Grimstroke, el cual es desolado por el dragon Jakiro";
		introGuerrero = "Xin es el guerrero mas famoso de estas tierras gracias a su gran armadura y su escudo capaz de bloquear las feroces combinaciones de hielo y fuego";
		introHechicero = "Rubick es el mago mas poderoso de estas tierras capaz de arrojar los hechizos arcanos jamas perfeccionados por humanos ";
		mensajeCombate = "Entraste en combate.¿Quieres escapar o pelear?";

		// revisar texto de salida para una version mas fluida

		JOptionPane.showMessageDialog(null,
				inicioJuego + "podras elegir a " + introGuerrero + "o al " + introHechicero);

		seleccionPersonaje = JOptionPane.showInputDialog(
				"Selecciona tu personaje: el hechicero Rubick o el guerrero Xin. (escribe su nombre porfavor) ");

		// puedo clavar un DO/WHILE para que se repita
		// mejor con switch

		do {
			if (seleccionPersonaje.equalsIgnoreCase("Rubick")) {
				// Array con stats de rubick en el dado
				seleccionHeroe++;
			} else {
				if (seleccionPersonaje.equalsIgnoreCase("Xin")) {
					// array con stats xin en el dado
					seleccionHeroe++;
				} else {
					JOptionPane.showMessageDialog(null, "Tenes que elegir entre Xin o Rubick");
					// bugeado
				}

			}
		} while (seleccionHeroe == 0);

		// inicio mundo
		for (variableMundo = 0; variableMundo < mundoArray.length; variableMundo++) {
			if (variableMundo < 6) {
				mundoArray[variableMundo] = Math.floor(Math.random() * 2 + 1);
				combate = 0;
				do {
					if (mundoArray[variableMundo] == 1) {
						// entra en combate
						decisionCombate = JOptionPane.showInputDialog(null, mensajeCombate);
						do {
							if (decisionCombate.equalsIgnoreCase("pelear")) {
								// tirar dadoHeroe y dadoEnemigo
								do {
									JOptionPane.showMessageDialog(null, "Inicia la ronda " + rondaCombate);
									dadoHeroe = Math.floor(Math.random() * 10 + 2); // modificar para que tomes los
																					// valores del array
									dadoEnemigo = Math.floor(Math.random() * 8 + 1);
									if (dadoHeroe > dadoEnemigo) {
										rondaCombate++;
										combateGanado++;
										JOptionPane.showMessageDialog(null,
												"Ganaste la ronda "  + rondaCombate + " - " + dadoHeroe + " vs " + dadoEnemigo);
									} else {
										combatePerdido++;
										JOptionPane.showMessageDialog(null,
												"Perdiste la ronda " + rondaCombate + " - " + dadoHeroe + " vs " + dadoEnemigo);
									}

								} while (combateGanado == 3);

								combate++;

							} else if (decisionCombate.equalsIgnoreCase("escapar")) {
								dadoRetirada = Math.floor(Math.random() * 100 + 1);
								if (dadoRetirada == 500) {
									JOptionPane.showMessageDialog(null, "pudiste escaparte con exito");
								} else {
									JOptionPane.showMessageDialog(null, "no pudiste escaparte");
								}
							}

						} while (combate == 1);

						
					} else {

					}

				} while (juego == 1);
			}

		}

		/*
		 * do { // ejemplo de combate
		 * 
		 * if (true) { // condicion de combate JOptionPane.showMessageDialog(null,
		 * mensajeCombate); if (mensajeCombate.equalsIgnoreCase("si")) { // tirar
		 * dadoHeroe y dadoEnemigo dadoHeroe = Math.floor(Math.random() * 10 + 2);
		 * dadoEnemigo = Math.floor(Math.random() * 8 + 1); if (dadoHeroe > dadoEnemigo)
		 * { contadorCombate++; JOptionPane.showMessageDialog(null, "Ganaste la ronda "
		 * + contadorCombate + "/3");
		 * 
		 * } else { JOptionPane.showMessageDialog(null, "Perdiste la ronda");
		 * 
		 * } } else { JOptionPane.showMessageDialog(null,
		 * "Para derrotar al jakiro tenes que tirar el dedo"); }
		 * 
		 * } else {
		 * 
		 * }
		 * 
		 * /* ******************************************* seleccion de eventos
		 * *******************************************
		 */

		/*
		 * ***************************************** combate con FOR
		 * *****************************************
		 */

		/*
		 * 
		 * 
		 * 
		 *  
		 */

		
	}

}
