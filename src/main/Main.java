package main;

import genetics.Genome;
import genetics.AllelePair;

import horses.HorseGenome;
import horses.HealthPair;
import horses.HealthAllele;
import horses.JumpPair;
import horses.SpeedPair;

import horses.JumpAllele;
import horses.SpeedAllele;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// horses ();
		breedHorses ();
		// testHealthAllele ();
	}

	public static void horses () {

		HealthPair healthF = HealthPair.newRandom ();
		JumpPair jumpF = new JumpPair (JumpAllele.Exelent, JumpAllele.Exelent);
		SpeedPair speedF = SpeedPair.newRandom ();
		Genome f = new HorseGenome (healthF, jumpF, speedF);

		HealthPair healthG = HealthPair.newRandom ();
		JumpPair jumpG = new JumpPair (JumpAllele.Exelent, JumpAllele.Average);
		SpeedPair speedG = SpeedPair.newRandom ();
		Genome g = new HorseGenome (healthG, jumpG, speedG);

		System.out.println("Parents");
		System.out.println(g);
		System.out.println(f);
		System.out.println();
		
		System.out.println("Children");
		for ( int i = 0; i < 15; i++ ) { System.out.println (g.breed (f)); }

		System.out.println();
		System.out.println("Random horse");

		for ( int i = 0; i < 15; i++ ) {
			Map<String, AllelePair> pairs = new HashMap ();
			pairs.put ("health", HealthPair.newRandom ());
			pairs.put ("speed", SpeedPair.newRandom ());
			pairs.put ("jump", JumpPair.newRandom ());
			Genome nh = new HorseGenome (pairs);
			System.out.println(nh);
		}

		System.out.println();
		System.out.println("Listing JumpProps");
		for ( JumpAllele first : JumpAllele.values ()) {
			for ( JumpAllele second : JumpAllele.values () ) {
				JumpPair pair = new JumpPair (first, second);
				SpeedPair speed = SpeedPair.newRandom ();
				HealthPair health = HealthPair.newRandom ();
				Genome h = new HorseGenome (health, pair, speed);
				System.out.println(h);
			}
		}
	}

	private static void testHealthAllele () {
		for ( int i = 0; i < 100; i++ ) {
			HealthAllele a = HealthAllele.getRandom ();
			System.out.println(a);
			if (a == HealthAllele.Twenty) { break; }
		}
	}

	private static void breedHorses () {

		int horsesBreed = 0;

		HealthPair healthF = new HealthPair (HealthAllele.Ten, HealthAllele.Ten);
		JumpPair jumpF = new JumpPair (JumpAllele.Poor, JumpAllele.Poor);
		SpeedPair speedF = new SpeedPair (SpeedAllele.Slow, SpeedAllele.Slow);
		HorseGenome f = new HorseGenome (healthF, jumpF, speedF);
		int generationF = 0;

		HealthPair healthG = new HealthPair (HealthAllele.Ten, HealthAllele.Ten);
		JumpPair jumpG = new JumpPair (JumpAllele.Poor, JumpAllele.Poor);
		SpeedPair speedG = new SpeedPair (SpeedAllele.Slow, SpeedAllele.Slow);
		HorseGenome g = new HorseGenome (healthG, jumpG, speedG);
		int generationG = 0;

		HorseGenome h = null;

		String s = "";
		Scanner scan = new Scanner (System.in);
		
		while ( ! "s".equals (s) && ! "S".equals (s) ) {
			if ( "".equals (s) || "c".equals (s) ) {
				h = (HorseGenome) f.breed (g);
				horsesBreed += 1;
			}

			System.out.println (horsesBreed);
			String fs = String.format ("F) %3d %s", generationF, f.toString ());
			System.out.println (fs);
			String gs = String.format ("M) %3d %s", generationG, g.toString ());
			System.out.println (gs);
			String hs = String.format ("C) --- %s", h.toString ());
			System.out.println (hs);

			System.out.print ("> ");
			s = scan.nextLine ();
			if ( "1".equals (s) ) {
				f = h;
				generationF += 1;
			} else if ( "2".equals (s) ) {
				g = h;
				generationG += 1;
			} else if ( "cheat".equals (s) ) {
				System.out.println("F) " + f.extraInfo ());
				System.out.println("M) " + g.extraInfo ());
				System.out.println("C) " + h.extraInfo ());
			}
			else {}
		}
	}

}
