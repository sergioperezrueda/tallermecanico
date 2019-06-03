package com.proyectoFinal.tallerMecanico.utilidades;

import java.util.Date;
import java.util.GregorianCalendar;

public class fechasUtilidades {
	private static GregorianCalendar calendar = new GregorianCalendar();
	   
	   public static Date restarDias(Date date,int dias){
	      calendar.setGregorianChange(date);
	      calendar.set(GregorianCalendar.DAY_OF_YEAR, calendar.get(GregorianCalendar.DAY_OF_YEAR)-dias);
	      
	      return calendar.getTime();
	   }
}
