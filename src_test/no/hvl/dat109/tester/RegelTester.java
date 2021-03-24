package no.hvl.dat109.tester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.regler.IRegel;

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
//comiit test vilde

}
