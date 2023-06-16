import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Agenda
{
	private ArrayList<Contacto> cts = new ArrayList<Contacto>();

	public void Agregar(Contacto cont)
	{
		cts.add(cont);
	}

	public void Eliminar(Contacto cont)
	{
		cts.remove(cont);
	}

	public int Buscar(String bus, int ter)
	{
		int i;
		for(i=0; i<cts.size(); i++)
		{
			if (ter == 0)
			{
				if(bus.equals((cts.get(i)).SetNom()))
					return i;
			}
			else if (ter == 1)
			{
				if(bus.equals((cts.get(i)).SetTel()))
					return i;
			}
			else if (ter == 2)
			{
				if(bus.equals((cts.get(i)).SetDir()))
					return i;
			}
			else if (ter == 3)
			{
				if(bus.equals((cts.get(i)).SetEma()))
					return i;
			}
		}
		i=-1;
		return i;
	}

	public Contacto SetCont(int ind)
	{
		return cts.get(ind);
	}

	public int Tam()
	{
		return cts.size();
	}
}