import javax.swing.JOptionPane;

public class Menu
{
	public static void main (String []args)
	{
		Agenda age = new Agenda();
		Contacto contA = new Contacto();
		String nom, telS, dir, ema, bus, busA;
		int ind;

		String [] opciones = {"Agregar Contacto", "Mostrar Contactos", "Elegir Contacto", "Salir"};
		String [] opcionesM = {"Nombre", "Telefono", "Direccion", "Correo Electronico", "Regresar"};
		String [] opcionesE = {"< Prev", "Sig >", "Editar", "Eliminar", "Regresar"};
    	Object [] botones = {"Agregar Contacto", "Mostrar Contactos", "Elegir Contacto", "Salir"};
    	Object [] botonesM = {"Nombre", "Telefono", "Direccion", "Correo Electronico", "Regresar"};
    	String [] botonesE = {"< Prev", "Sig >", "Editar", "Eliminar", "Regresar"};
    	int opc, opcM, opcE, opcEd;
    	do
    	{
    		opc = -1;
    		opc = JOptionPane.showOptionDialog (null, "Que accion desea realizar?", "Agenda", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, opciones, botones[0]);
			switch (opc)
	        {
	            case 0:
	            {
	            	nom = null; telS =null; dir = null; ema=null; 
	            	nom = JOptionPane.showInputDialog(null, "Ingrese el Nombre del nuevo contacto");
	            	if (nom != null)
	            	{
	            		do
	            		{
	            			telS = JOptionPane.showInputDialog(null, "Ingrese el Telefono del nuevo contacto");
	            			if (telS != null)
	            			{
	            				try
			            		{
			            			Integer.parseInt(telS);
			            		}
		            			catch(NumberFormatException nfe)
		            			{
		            				JOptionPane.showMessageDialog(null, "Telefono Invalido");
		            				telS="TelInv";
		            			}
	            			}
	            		}while(telS=="TelInv");
	            	}
	            	if (nom != null && telS != null)
	            		dir = JOptionPane.showInputDialog(null, "Ingrese la Direccion del nuevo contacto");
	            	if (nom != null && telS != null && dir != null)
	            		ema = JOptionPane.showInputDialog(null, "Ingrese el Correo Electronico del nuevo contacto");
	            	if (nom != null && telS != null && dir != null && ema != null)
            		{
            			Contacto cont = new Contacto();
            			cont.GetDatos(nom, telS, dir, ema);
            			age.Agregar(cont);
            			JOptionPane.showMessageDialog(null, "Contacto Agregado");
            		}
	            }
	            break;
	            case 1:
	            {
	            	do
	            	{
	            		opcM = -1;
						opcM = JOptionPane.showOptionDialog (null, "Buscar por:", "Buscar Contacto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, opcionesM, botonesM[0]);
						if(opcM >= 0 && opcM <= 3)
						{
							busA = (opcM==2)?"la":"el";
							bus = JOptionPane.showInputDialog(null, "Ingrese "+busA+" "+opcionesM[opcM]+" del contacto a buscar");
							if(bus != null)
							{
								ind = age.Buscar(bus, opcM);
								if(ind != -1)
								{
									contA = age.SetCont(ind);
									JOptionPane.showMessageDialog(null, "Contacto "+ind+":\nNombre: "+contA.SetNom()+"\nTelefono: "+contA.SetTel()+"\nDireccion: "+contA.SetDir()+"\nCorreo Electronico: "+contA.SetEma());
								}
								else
									JOptionPane.showMessageDialog(null, "Contacto Inexistente");

							}
						}
	            	}while(opcM >=0 && opcM<=3);
	            }
	            break;
	            case 2:
	            {
	            	ind=0;
	            	do
	            	{
	            		opcE = -1;
	            		contA = age.SetCont(ind);
	            		opcE = JOptionPane.showOptionDialog (null, "Contacto "+ind+":\nNombre: "+contA.SetNom()+"\nTelefono: "+contA.SetTel()+"\nDireccion: "+contA.SetDir()+"\nCorreo Electronico: "+contA.SetEma(), "Elegir Contacto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, opcionesE, botonesE[0]);
	            		if(opcE == 0)
	            			ind--;
	            		else if (opcE== 1)
	            			ind++;
	            		else if(opcE == 2)
	            		{
	            			nom = null; telS =null; dir = null; ema=null; 
			            	nom = JOptionPane.showInputDialog(null, "Ingrese el Nombre del nuevo contacto");
			            	if (nom != null)
			            	{
			            		do
			            		{
			            			telS = JOptionPane.showInputDialog(null, "Ingrese el Telefono del nuevo contacto");
			            			if (telS != null)
			            			{
			            				try
					            		{
					            			Integer.parseInt(telS);
					            		}
				            			catch(NumberFormatException nfe)
				            			{
				            				JOptionPane.showMessageDialog(null, "Telefono Invalido");
				            				telS="TelInv";
				            			}
			            			}
			            		}while(telS=="TelInv");
			            	}
			            	if (nom != null && telS != null)
			            		dir = JOptionPane.showInputDialog(null, "Ingrese la Direccion del nuevo contacto");
			            	if (nom != null && telS != null && dir != null)
			            		ema = JOptionPane.showInputDialog(null, "Ingrese el Correo Electronico del nuevo contacto");
			            	if (nom != null && telS != null && dir != null && ema != null)
		            		{
		            			contA.GetDatos(nom, telS, dir, ema);
		            			JOptionPane.showMessageDialog(null, "Contacto Editado");
		            		}
	            		}
	            		else if (opcE == 3)
	            		{
	            			if((JOptionPane.showConfirmDialog(null, "Eliminar Contacto "+ind+": "+contA.SetNom()+"?", "Eliminar Contacto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) == 0)
	            				age.Eliminar(contA);
	            		}
	            		if(ind == -1)
	            			ind = (age.Tam())-1;
	            		if(ind == age.Tam())
	            			ind = 0;
	            	}while(opcE >=0 && opcE<=3);
	            }
	            break;
	        }
        }while(opc >=0 && opc<=2);
	}
}