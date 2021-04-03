package no.hvl.dat109.tester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.regler.EttPar;
import no.hvl.dat109.regler.IRegel;
import no.hvl.dat109.regler.TotalPoengsum;

public class RegelTester {

IRegel bonuspoeng= new no.hvl.dat109.regler.Bonuspoeng();
ArrayList<Integer> mindreEnn41 = new ArrayList<Integer>(Arrays.asList(7,2,3,4,5,6));
ArrayList<Integer> storreEnn41 = new ArrayList<Integer>(Arrays.asList(13,12,8,7,6,9));
ArrayList<Integer> lik41 = new ArrayList<Integer>(Arrays.asList(3,12,6,7,6,7));
@Test
public void testBonuspoeng() {
	assertEquals(0,bonuspoeng.resolve(mindreEnn41));
	assertEquals(50,bonuspoeng.resolve(storreEnn41));
	assertEquals(50,bonuspoeng.resolve(lik41));
}
//comiit test vilde-26/3
IRegel ettpar= new EttPar();
ArrayList<Integer> ettPar = new ArrayList<Integer>(Arrays.asList(6,2,4,4,5));
ArrayList<Integer> toPar = new ArrayList<Integer>(Arrays.asList(3,3,4,6,6));
ArrayList<Integer> ingenPar = new ArrayList<Integer>(Arrays.asList(3,4,6,2,1));

@Test 
public void testEttPar() {
	assertEquals(8,ettpar.resolve(ettPar));
	assertEquals(12,ettpar.resolve(toPar));
	assertEquals(0,ettpar.resolve(ingenPar));
}
IRegel totalPoengsum= new TotalPoengsum();
ArrayList<Integer> sum1 = new ArrayList<Integer>(Arrays.asList(4,2,3,4,5,6));
ArrayList<Integer> sum2 = new ArrayList<Integer>(Arrays.asList(3,3,4));
ArrayList<Integer> sum3 = new ArrayList<Integer>(Arrays.asList(6));
 @Test
 public void testTotalPoengsum() {
	 assertEquals(24,totalPoengsum.resolve(sum1));
	 assertEquals(10,totalPoengsum.resolve(sum2));
	 assertEquals(6,totalPoengsum.resolve(sum3));
 }

}
