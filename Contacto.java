public class Contacto
{
	private String nom;
	private String tel;
	private String dir;
	private String ema;

	public void GetDatos(String Nnom, String Ntel, String Ndir, String Nema)
	{
		nom=Nnom;
		tel=Ntel;
		dir=Ndir;
		ema=Nema;
	}

	public String SetNom()
	{
		return nom;
	}

	public String SetTel()
	{
		return tel;
	}

	public String SetDir()
	{
		return dir;
	}

	public String SetEma()
	{
		return ema;
	}
}