package org.acg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.acg.entities.Palette;
import org.acg.entities.PaletteShow;
import org.acg.entities.PaletteType;
import org.acg.service.main.PaletteService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 画板单元测试类
 * @author lizhen
 */
public class PaletteTest {
	private ApplicationContext applicationContext = null;
	private PaletteService paletteService;
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		paletteService = applicationContext.getBean(PaletteService.class);
	}
	
	@Test
	public void testGetAllPaletteShow(){
		ArrayList<PaletteShow> paletteShows = paletteService.getAllPaletteShow();
		System.out.println("* paletteShows size : "+paletteShows.size());
		
	}
	
	@Test
	public void testGetAllPaletteType(){
		ArrayList<PaletteType> paletteTypes = paletteService.getAllPaletteType();
		System.out.println("* paletteType size : "+paletteTypes.size());
	}
	
	@Test
	public void testGetAllPalette(){
		ArrayList<Palette> palettes = paletteService.getAllPalette();
		System.out.println("* palette size : "+palettes.size());
	}
	
	@Test
	public void testGerPaletteById(){
		Palette palette = paletteService.getPaletteById(1);
		System.out.println("* palette :"+palette);
		
	}
	

}
