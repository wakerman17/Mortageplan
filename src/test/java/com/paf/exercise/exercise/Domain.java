package com.paf.exercise.exercise;

import static org.junit.Assert.*;
import org.junit.Test;
import com.framtiden.domain.MortageplanCalculation;

public class Domain {
	@Test
	public void test() {
		assertEquals(MortageplanCalculation.mortageplanCalculation(1000.0, 5.0, 2), 43.87, 0.001);
	}

}
