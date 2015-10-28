package fr.eni.ressources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import fr.eni.bean.Theme;
import fr.eni.services.ThemeService;

@Path("/themes")
public class ThemesRessource {

	@GET
	@Produces("application/json")
	public List<Theme> getThemes() throws SQLException
	{
		return ThemeService.getListThemes();
	}	
}