package no.hvl.dat109.tester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import regler.Bonuspoeng;
import regler.IRegel;

public class RegelTester {

IRegel bonuspoeng= new Bonuspoeng();
ArrayList<Integer> mindreEnn41 = new ArrayList<Integer>(Arrays.asList(7,2,3,4,5,6));
ArrayList<Integer> størreEnn41 = new ArrayList<Integer>(Arrays.asList(13,12,8,7,6,9));
ArrayList<Integer> lik41 = new ArrayList<Integer>(Arrays.asList(3,12,6,7,6,7));
@Test
public void testBonuspoeng() {
	assertEquals(0,bonuspoeng.resolve(mindreEnn41, 6));
	assertEquals(50,bonuspoeng.resolve(størreEnn41,6));
	assertEquals(50,bonuspoeng.resolve(lik41, 6));
}
//comiit test vilde

}
