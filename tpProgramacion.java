package tpProgramacion;

import javax.swing.JOptionPane;

import java.util.Random;

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
		 * NOTAS idea original
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
		/*
		 * IDEA BASICA
		 * 
		 * hacer un array de 6 posiciones en donde 5 van a enbcontrarse enemigo o no se
		 * va a ingresar en un combate en donde se puede retirar o pelear en caso de
		 * pelear va a ver 3 rondas en donde se pasa al siguiente caso si se gana con el
		 * dado 2 veces en caso de perder GAME OVER en la casilla 6 va a estar el boss
		 * final que para ganar se va a tirar el dado 5 veces
		 * 
		 * se va a elegir entre 2 personajes en donde dependendiendo la seleccion se va
		 * a modificar los valores del dado (numero minimo, mayor y diferencia entre
		 * estos ej. dado de 10 caras 1-10 es el base pj 1 va a ser +2 >>> 3-13 )
		 *
		 * 
		 * 
		 */
		// Ashkavor

		// ESTO ES UN COMENTARIO RANDOM PARA JUGAR CON EL GITHUB DESKTOP

		// variables globales
		Random rnd = new Random();
		int finJuego = 0; // variable que termina el juego
		int mundoArray[] = new int[6]; // mapa del juego
		int casilleroMundo; // variable del for
		int seleccionHeroe = 0;
		int heroeStats[] = new int[2]; // [0] >>> numero maximo de dado [1] >>>> numero minimo de dado
		int finCasillero = 0;
		// combates
		int combate = 0; // variable que setea el combate
		int numeroRonda = 1; // setea la ronda de combate
		int rondaGanada, rondaPerdida = 0, salirCombate = 0;


		// dados
		int dadoGeneral; // tiene 2 entradas par o impar (1 o 2)
		int dadoHeroe;
		int dadoEnemigo;
		int dadoRetirada;

		// LA VARIABLE JUEGO MIENTRAS SEA 0 SE PUEDE JUGAR CUANDO SE DERROTE AL BOSS VA
		// A CAMBIAR A 1 Y EL WHILE SE VA A CERRAR
		/*
		 * ******************************************** seleccion de personaje
		 * ?conveniente un ARRAY? *******************************************
		 */

		String inicioJuego, introGuerrero, introHechicero, mensajeCombate, decisionCombate;
		String seleccionPersonaje;

		inicioJuego = "Bienvenido al reino del Grimstroke, el cual es desolado por el dragon Jakiro";
		introGuerrero = "Xin es el guerrero mas famoso de estas tierras gracias a su gran armadura y su escudo capaz de bloquear las feroces combinaciones de hielo y fuego";
		introHechicero = "Rubick es el mago mas poderoso de estas tierras capaz de arrojar los hechizos arcanos jamas perfeccionados por humanos ";
		mensajeCombate = "Entraste en combate.¿Quieres escapar o pelear?";

		// revisar texto de salida para una version mas fluida

		JOptionPane.showMessageDialog(null,
				inicioJuego + "podras elegir a " + introGuerrero + "o al " + introHechicero);

		// puedo clavar un DO/WHILE para que se repita
		// mejor con switch
		/*
		 * do { if (seleccionPersonaje.equalsIgnoreCase("Rubick")) { // Array con stats
		 * de rubick en el dado seleccionHeroe++; } else { if
		 * (seleccionPersonaje.equalsIgnoreCase("Xin")) { // array con stats xin en el
		 * dado seleccionHeroe++; } else { JOptionPane.showMessageDialog(null,
		 * "Tenes que elegir entre Xin o Rubick"); // bugeado }
		 * 
		 * } } while (seleccionHeroe == 0);
		 * 
		 */
		// refactor seleccion pj

		do {
			seleccionPersonaje = JOptionPane
					.showInputDialog("Selecciona tu personaje: el hechicero Rubick o el guerrero Xin.");

			if (seleccionPersonaje.equalsIgnoreCase("rubick")) {
				seleccionHeroe++;
				heroeStats[0] = 10;
				heroeStats[1] = 1;
				// array con stats
				System.out.print("rubivc");
			} else if (seleccionPersonaje.equalsIgnoreCase("xin")) {
				seleccionHeroe++;
				heroeStats[0] = 8;
				heroeStats[1] = 3;
				// array con stats
				System.out.print("xin");
			} else {
				JOptionPane.showMessageDialog(null, "tenes que seleccionar 1 personaje");

			}

		} while (seleccionHeroe == 0);

		System.out.print("salida del pj");

		// inicio mundo

		for (casilleroMundo = 0; casilleroMundo < mundoArray.length; casilleroMundo++) {
			if (casilleroMundo < 6) {

				while (finJuego == 0) {

					mundoArray[casilleroMundo] = rnd.nextInt(2) + 1;

					combate = 0;
					// check

					System.out.print(" / " + mundoArray[casilleroMundo] + " / ");

					finCasillero = 0;

					while (finCasillero == 0) {

						if (mundoArray[casilleroMundo] == 1) {

							// entra en combate
							JOptionPane.showMessageDialog(null, "te encontraste un enemigo");

							decisionCombate = JOptionPane.showInputDialog(null, mensajeCombate);


							while (combate == 0) {

								if (decisionCombate.equalsIgnoreCase("pelear")) {
									
									salirCombate = 0;
									numeroRonda = 1;
									rondaGanada = 0;
									rondaPerdida = 0;
									
									while (salirCombate != 0) {

										JOptionPane.showMessageDialog(null, "inicia la ronda " + numeroRonda);

										dadoHeroe = rnd.nextInt(heroeStats[0]) + heroeStats[1];
										dadoEnemigo = rnd.nextInt(7) + 2;

										if (dadoHeroe > dadoEnemigo) {
											// combate ganado

											JOptionPane.showMessageDialog(null, "ganaste la ronda  " + numeroRonda
													+ " - " + dadoHeroe + " vs " + dadoEnemigo);

											rondaGanada++;
											numeroRonda++;

										} else {
											// combate perdido
											JOptionPane.showMessageDialog(null, "perdiste la ronda " + numeroRonda
													+ " - " + dadoHeroe + " vs " + dadoEnemigo);

											rondaPerdida++;

										}

										numeroRonda++;
										
										if (rondaGanada == 3) {
											salirCombate++;
										}else if(rondaPerdida == 3) {
											salirCombate++;
											finJuego++;
										}
										
										
									}

								} else {
									// escapar
									dadoRetirada = rnd.nextInt(1000) + 1;
									if (dadoRetirada >= 500 && dadoRetirada <= 550) {
										JOptionPane.showMessageDialog(null, "pudiste escaparte con exito");
										combate++;
									} else {
										JOptionPane.showMessageDialog(null, "no pudiste escaparte");
									}

								}

								finCasillero++;

							} // fin combate

						} else {
							JOptionPane.showMessageDialog(null, "no encontraste un enemigo");
							finCasillero++;
						}

					}
					
					if (rondaPerdida == 3) {
						finJuego++;
						
					}
				}

			}

		}
	}
}
		/*
								
								// tirar dadoHeroe y dadoEnemigo
								do {
									JOptionPane.showMessageDialog(null, "Inicia la ronda " + rondaCombate);
									
									dadoHeroe = rnd.nextInt(heroeStats[0]) + heroeStats[1] ; 
									dadoEnemigo =rnd.nextInt(7) + 2;
									
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

								if (combateGanado == 3 ) {
									combate++;
								}
								// bugeado>>> revisar como hacer para que salte 1 sola vez y en caso de no poder salte 
								// al combate
							} else if (decisionCombate.equalsIgnoreCase("escapar")) {
								dadoRetirada = rnd.nextInt(1000) + 1;
								if (dadoRetirada >= 500 && dadoRetirada <= 550) {
									JOptionPane.showMessageDialog(null, "pudiste escaparte con exito");
									combate++;
								} else {
									JOptionPane.showMessageDialog(null, "no pudiste escaparte");
								}
							}

						}

						
					} else {

					}

				} 
			}

		}
*/
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

		
	


				
