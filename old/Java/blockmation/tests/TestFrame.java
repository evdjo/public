package tests;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import blockmation.FrameModel;
public class TestFrame {
	FrameModel asd= new FrameModel(20,20);
	@Before
	public void setUp() {
		
		asd.clear();
	}
    @Test
	public void checkCheckCharMethod() {
		assertEquals(asd.checkChar(0,0),'b');
		assertEquals(asd.checkChar(19, 19),'b');
	}
    @Test
    public void checkSetChar() {
    	asd.setChar(1, 5, 'r');
    	assertEquals(asd.checkChar(1, 5),'r');
    	
    	
    	asd.setChar(2, 5, 'c');
    	assertEquals(asd.checkChar(2, 5),'c');
    	
    	
    	asd.setChar(7, 5, 'k');
    	assertEquals(asd.checkChar(7, 5),'k');
    	
    	
    	asd.setChar(3, 5, 'g');
    	assertEquals(asd.checkChar(3, 5),'g');
    	
    	
    	asd.setChar(8, 10, 'f');
    	assertEquals(asd.checkChar(8, 10),'f');
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testConstructor() {
    	
    	FrameModel bob = new FrameModel(-100,-100);
    	
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testConstructor1() {
    	
    	FrameModel bob = new FrameModel(0,0);
    	
    }
    
    @Test 
    public void setTheGrid() {
    	char[][] asd2=new char[2][2];
    	asd2[0][0]='a';
    	asd2[0][1]='b';
    	asd2[1][0]='c';
    	asd2[1][1]='d';
    	asd.setGrid(asd2);
    	assertEquals(asd2[0][0],asd.checkChar(0, 0));
    	assertEquals(asd2[0][1],asd.checkChar(0,1));
    	assertEquals(asd2[1][0],asd.checkChar(1, 0));
    	assertEquals(asd2[1][1],asd.checkChar(1,1));
    	
    }
    @Test 
    public void copyAndGive () {
    	FrameModel x= new FrameModel(2,2);
    	char[][] y = new char[2][2];
    	y[0][0]='t';
    	y[0][1]='t';
    	y[1][0]='t';
    	y[1][1]='t';
    	x.setGrid(y);
    	char[][] h=x.copyAndGive();
    	assertArrayEquals(h, y);
    	
    }
    
    

}
